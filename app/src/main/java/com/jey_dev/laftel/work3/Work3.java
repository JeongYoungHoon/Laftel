package com.jey_dev.laftel.work3;

/**
 * Created by JeyHoon on 2017. 4. 19..
 */

public class Work3 {
    private static final String PLAYER1 = "Player 1 win";
    private static final String PLAYER2 = "Player 2 win";
    private static final String DRAW = "Draw";

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
