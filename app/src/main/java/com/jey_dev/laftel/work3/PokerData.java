package com.jey_dev.laftel.work3;

/**
 * Created by JeyHoon on 2017. 4. 19..
 */

public class PokerData {

    /*

    - High Card
    - One Pair
    - Two Pairs
    - Three of a Kind
    - Straight
    - Flush
    - Full House
    - Four of a Kind
    - Straight Flush
    - Royal Flush
    : 특별한 패가 없으면 높은 카드 순으로 비교.
    : 한 쌍이 같은 카드.
    : 서로 다른 두 쌍이 같은 카드.
    : 세 장이 같은 카드.
    : 모든 카드가 연속된 숫자. (A는 1도 되고, K 뒤에 올 수 있음)
    : 모든 카드의 무늬가 같음.
    : 세 장이 같고, 또 한 쌍이 같음 (Three of a Kind+OnePair).
    : 네 장이 같은 카드.
    : 모든 카드가 연속된 숫자이면서 무늬도 같음.
    :10,J,Q,K,A가 무늬도 같음.

     */

    public static final int ROYAL_FLUSH=0;
    public static final int STRAIGHT_FLUSH=1;
    public static final int FOUR_OF_A_KIND=2;
    public static final int FULL_HOUSE=3;
    public static final int FLUSH=4;
    public static final int STRAIGHT=5;
    public static final int THREE_OF_A_KIND=6;
    public static final int TWO_PAIRS=7;
    public static final int ONE_PAIR=8;
    public static final int HIGH_CARD=9;

    public static final int CARDS_COUNT=5;

    private String[] cards=null;
    private int highCardNo=-1;
    private boolean aceIsHigh=true;
    private int combination=-1;

    public PokerData(String[] cards) throws IllegalArgumentException{
        if(cards.length!=CARDS_COUNT)
            throw new IllegalArgumentException("Cards count must five.");
        this.cards = cards;
        init();
    }

    public PokerData(String cardStr) throws IllegalArgumentException{
        this(cardStr.split(" "));
    }

    private void init(){
        if(null==cards&&cards.length!=CARDS_COUNT)
            return;
        sortCard();
        pickHighCardNo();
        checkCombination();
    }

    private void sortCard(){
        String[] chnCards=new String[]{"","","","",""};
        for(int i=0; i<CARDS_COUNT; i++){

            int nowCard=CardData.getCardNoInt(cards[i]);
            int idx=0;
            int overCnt=0;
            for(int j=0; j<CARDS_COUNT;j++){
                if(i==j)
                    continue;
                if(nowCard>CardData.getCardNoInt(cards[j])){
                    idx++;
                }else if(nowCard==CardData.getCardNoInt(cards[j])){
                    overCnt++;
                }
            }
            if(overCnt==0){
                chnCards[idx]=cards[i];
            }else{
                for(int j=idx; j<idx+overCnt+1;j++){
                    if(chnCards[j].length()==0) {
                        chnCards[j] = cards[i];
                        break;
                    }
                }
            }
        }
        for(int i=0; i<CARDS_COUNT;i++){
            cards[i]=chnCards[i];
//            Log.d("Test,sortCard","chnCard["+i+"] : "+chnCards[i]);
        }
    }

    private void pickHighCardNo(){
        highCardNo=CardData.getCardNoInt(cards[CARDS_COUNT-1]);;
    }

    private void checkCombination(){
        final int[] shapes=CardData.getCardShapes(this.cards);
        final int[] nos=CardData.getCardNos(this.cards);
        if(shapes[0]==shapes[1]
                &&shapes[0]==shapes[2]
                &&shapes[0]==shapes[3]
                &&shapes[0]==shapes[4]){    // Shape All Same Check
            if(nos[4]==14
                    &&nos[3]==13
                    &&nos[2]==12
                    &&nos[1]==11
                    &&nos[0]==10){           // Royal Flush Check
                combination=ROYAL_FLUSH;
            }else if(nos[4]==nos[3]+1
                    &&nos[4]==nos[2]+2
                    &&nos[4]==nos[1]+3
                    &&nos[4]==nos[0]+4) {    // Straight Flush Check
                aceIsHigh=true;
                combination = STRAIGHT_FLUSH;
            }else if(nos[4]==14
                    &&nos[0]==2
                    &&nos[1]==3
                    &&nos[2]==4
                    &&nos[3]==5){
                aceIsHigh=false;
                combination = STRAIGHT_FLUSH;
            }else{                          // Flush Check
                combination=FLUSH;
            }
        }else if(checkFour(nos)){           // Four of a Kind Check
            combination=FOUR_OF_A_KIND;
        }else if(checkThree(nos)){          // Three cards same Check
            int firstIdx=getFirstSameIdx(2,nos);
            if((firstIdx==0&&nos[3]==nos[4])
                    ||(firstIdx==2&&nos[0]==nos[1])){
                combination=FULL_HOUSE;
            }else{
                combination=THREE_OF_A_KIND;
            }
        }else if(nos[4]==nos[3]+1
                &&nos[4]==nos[2]+2
                &&nos[4]==nos[1]+3
                &&nos[4]==nos[0]+4){         // Straight Flush Check
            aceIsHigh=true;
            combination=STRAIGHT;
        }else if(nos[4]==14
                &&nos[0]==2
                &&nos[1]==3
                &&nos[2]==4
                &&nos[3]==5){
            aceIsHigh=false;
            combination = STRAIGHT;
        }else if(getTwoFirstIdx(nos)!=-1){      // Two Cards same Check
            int firstIdx=getTwoFirstIdx(nos);
            if(firstIdx>=2){
                combination=ONE_PAIR;
            }else{                              // Two Pairs Check
                combination=checkOver(2,3,nos)?TWO_PAIRS:ONE_PAIR;
            }
        }else{
            combination=HIGH_CARD;
        }
    }

    private boolean checkFour(final int[] nos){
        return checkOver(4,2,nos);
    }
    private boolean checkThree(final int[] nos){
        return checkOver(3,2,nos);
    }
    private int getTwoFirstIdx(final int[] nos){
        for(int i=0; i<nos.length;i++){
            int c=0;
            for(int j=0; j<nos.length;j++){
                if(nos[i]==nos[j])
                    c++;
            }
            if(c==2)
                return i;

        }
        return -1;
    }

    private boolean checkOver(int cnt,int idx,final int[] nos){
        int c=0;
        for(int i=0; i<nos.length;i++){
            if(nos[i]==nos[idx])
                c++;
        }
        return c==cnt;
    }
    private int getFirstSameIdx(int idx,final int[] nos){
//        int result=0;
        for(int i=0; i<nos.length;i++){
            if(nos[i]==nos[idx])
                return i;
        }
        return 0;
    }

    public int getHighCardNo() {
        return highCardNo;
    }

    public int getCombination() {
        return combination;
    }
    public boolean aceIsHight(){
        return aceIsHigh;
    }
}
