package com.jey_dev.laftel.work3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.jey_dev.laftel.R;
import com.jey_dev.lib.based.JActivity;

/**
 * Created by JeyHoon on 2017. 4. 18..
 */

public class ActWork3 extends JActivity {
    private TextView titleView=null;
    private TextView resultView = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work3);
        titleView=(TextView)findViewById(R.id.toolbar_works_title);
        resultView = (TextView) findViewById(R.id.work3_result);
        setWorkTitle(R.string.work3);
    }

    private void setTitle(final String title){
        titleView.setText(title);
    }
    private void setWorkTitle(final int resId){
        setTitle(getResources().getString(resId));
    }
    private void setResult(final String str) {
        resultView.setText(str);
    }
    public void goWork(View v) {
        final int viewId=v.getId();
        String result="";
        switch (viewId){
            case R.id.work3_1:
                PokerData pData1_1=new PokerData("As 8d Ad 8c 5d");
                PokerData pData1_2=new PokerData("Qh Qs Jd Kd Jc");
                result=Work3.playPoker(pData1_1,pData1_2);
                break;
            case R.id.work3_2:
                PokerData pData2_1=new PokerData("Ks Kc Jd Kd Jc");
                PokerData pData2_2=new PokerData("Jh Js Jd Kd Jc");
                result=Work3.playPoker(pData2_1,pData2_2);
                break;
            case R.id.work3_3:
                PokerData pData3_1=new PokerData("Ad Kh Ac 7h 7d");
                PokerData pData3_2=new PokerData("Ah Kh Ac 7h 7d");
                result=Work3.playPoker(pData3_1,pData3_2);
                break;
        }
        setResult(result);
    }
}
