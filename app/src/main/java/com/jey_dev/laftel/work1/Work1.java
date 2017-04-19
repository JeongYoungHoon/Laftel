package com.jey_dev.laftel.work1;

/**
 * Created by JeyHoon on 2017. 4. 18..
 */

public class Work1 {
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
