package com.jey_dev.laftel.work3;

/**
 * Created by JeyHoon on 2017. 4. 19..
 */

public class CardData {

    public static final int SHAPE_S=0;
    public static final int SHAPE_D=1;
    public static final int SHAPE_H=2;
    public static final int SHAPE_C=3;

    public static final String getCardNo(final String card){
        if(card.length()>1)
            return String.valueOf(card.charAt(0));
        else return "";
    }
    public static final int getCardNoInt(final String card){
        String cardNoStr=getCardNo(card);
        if(cardNoStr.equals("A")){
            return 14;
        }else if(cardNoStr.equals("K")){
            return 13;
        }else if(cardNoStr.equals("Q")){
            return 12;
        }else if(cardNoStr.equals("J")){
            return 11;
        }else if(cardNoStr.equals("T")){
            return 10;
        }else{
            try{
                return Integer.parseInt(cardNoStr);
            }catch(NumberFormatException nfe){
                nfe.printStackTrace();
                return -1;
            }
        }
    }
    public static final String getCardShape(final String card){
        if(card.length()>1)
            return String.valueOf(card.charAt(1));
        else return "";
    }
    public static final int getCardShapeInt(final String card){
        String shape=getCardShape(card);
        if(shape.equals("c")){
            return SHAPE_C;
        }else if(shape.equals("s")){
            return SHAPE_S;
        }else if(shape.equals("d")){
            return SHAPE_D;
        }else if(shape.equals("h")){
            return SHAPE_H;
        }else{
            return -1;
        }
    }

    public static final int[] getCardShapes(final String[] cards){
        int[] result=new int[5];
        for(int i=0; i<5; i++){
            result[i]=getCardShapeInt(cards[i]);
        }
        return result;
    }
    public static final int[] getCardNos(final String[] cards){
        int[] result=new int[5];
        for(int i=0; i<5; i++){
            result[i]=getCardNoInt(cards[i]);
        }
        return result;
    }
}
