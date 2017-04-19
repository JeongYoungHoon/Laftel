package com.jey_dev.laftel.work3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.jey_dev.laftel.R;
import com.jey_dev.laftel.Work;
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
        String str1="";
        String str2="";
        switch (viewId){
            case R.id.work3_1:
                str1="As 8d Ad 8c 5d";
                str2="Qh Qs Jd Kd Jc";
                break;
            case R.id.work3_2:
                str1="Ks Kc Jd Kd Jc";
                str2="Jh Js Jd Kd Jc";
                break;
            case R.id.work3_3:
                str1="Ad Kh Ac 7h 7d";
                str2="Ah Kh Ac 7h 7d";
                break;
        }
        setResult(Work.Work3.playPoker(str1,str2));
    }
}
