package com.jey_dev.laftel;

import com.jey_dev.laftel.work2.NewWordData;
import com.jey_dev.laftel.work3.PokerData;

/**
 * Created by JeyHoon on 2017. 4. 19..
 */

public class Work {
    public static class Work1 {
        private static final String CH_CON="~";
        private static final String CH_DIV=", ";
        public static final String read(final int[] arr){
            String result="";
            if(arr.length==0){
                return "";
            }else{
                boolean isCon=false;
                int preNo=arr[0];
                result=String.valueOf(arr[0]);
                for(int i=1; i<arr.length; i++){
                    int no=arr[i];
                    isCon=(no==preNo+1);
                    if(isCon){
                        if(result.substring(result.length()-1).equals(CH_CON)){
                            if(i+1<arr.length&&arr[i+1]==no+1){
                                preNo=no;
                                continue;
                            }else{
                                result=result+String.valueOf(no);
                            }
                        }else{
                            result=result+CH_CON;
                        }
                    }else{
                        result=result+CH_DIV+String.valueOf(no);
                    }
                    preNo=no;
//                if(no==preNo+1){
//                    isCon=true;
//                }else{
//
//                }
                }
            }
            return result;

        }
    }
    public static class Work2 {
        public static final String reverse(String str) {
            return new NewWordData(str).getResult();
        }
    }
    public static class Work3 {
        private static final String PLAYER1 = "Player 1 win";
        private static final String PLAYER2 = "Player 2 win";
        private static final String DRAW = "Draw";

        public static final String playPoker(String str1,String str2){
            return playPoker(new PokerData(str1),new PokerData(str2));
        }

        public static final String playPoker(PokerData data1, PokerData data2) {
            int com1=data1.getCombination();
            int com2=data2.getCombination();
            if (com1 > com2) {
                return PLAYER2;
            } else if (com1 == com2) {
                int high1 = data1.getHighCardNo();
                int high2 = data2.getHighCardNo();
                if (com1 == PokerData.STRAIGHT || com1 == PokerData.STRAIGHT_FLUSH) {
                    if (high1 == 14 && !data1.aceIsHight())
                        high1 = 1;
                    if (high2 == 14 && !data2.aceIsHight())
                        high2 = 1;
                }
                if (high1 > high2) {
                    return PLAYER1;
                } else if (high1 == high2) {
                    return DRAW;
                } else {
                    return PLAYER2;
                }

            } else {
                return PLAYER1;
            }
        }

    }
}
