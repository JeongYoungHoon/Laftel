package com.jey_dev.laftel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.jey_dev.laftel.work1.ActWork1;
import com.jey_dev.laftel.work2.ActWork2;
import com.jey_dev.laftel.work3.ActWork3;
import com.jey_dev.lib.based.JActivity;

/**
 * Created by JeyHoon on 2017. 4. 18..
 */

public class Main extends JActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void goWork1(View v){
        startAct(ActWork1.class);
    }
    public void goWork2(View v){
        startAct(ActWork2.class);
    }
    public void goWork3(View v){
        startAct(ActWork3.class);
    }
}
