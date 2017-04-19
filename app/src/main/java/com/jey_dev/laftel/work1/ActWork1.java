package com.jey_dev.laftel.work1;

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

public class ActWork1 extends JActivity {
    private TextView titleView=null;
    private TextView resultView=null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work1);
        titleView=(TextView)findViewById(R.id.toolbar_works_title);
        resultView=(TextView)findViewById(R.id.work1_result);
        setWorkTitle(R.string.work1);
    }

    public void goWork(View v){
        final int viewId=v.getId();
        switch (viewId){
            case R.id.work1_1:
                setResult(Work.Work1.read(new int[]{}));
                break;
            case R.id.work1_2:
                setResult(Work.Work1.read(new int[]{1}));
                break;
            case R.id.work1_3:
                setResult(Work.Work1.read(new int[]{1,3}));
                break;
            case R.id.work1_4:
                setResult(Work.Work1.read(new int[]{1,2,3}));
                break;
            case R.id.work1_5:
                setResult(Work.Work1.read(new int[]{1,2,3,6,8,9,10}));
                break;
            case R.id.work1_6:
                setResult(Work.Work1.read(new int[]{13, 14, 15, 16, 20, 23, 24, 25, 100}));
                break;
        }
    }

    private void setTitle(final String title){
        titleView.setText(title);
    }
    private void setWorkTitle(final int resId){
        setTitle(getResources().getString(resId));
    }
    private void setResult(final String str){
        resultView.setText(str);
    }

}
