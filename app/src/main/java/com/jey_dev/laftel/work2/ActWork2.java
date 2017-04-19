package com.jey_dev.laftel.work2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.jey_dev.laftel.R;
import com.jey_dev.lib.based.JActivity;

/**
 * Created by JeyHoon on 2017. 4. 18..
 */

public class ActWork2 extends JActivity {
    private TextView titleView = null;
    private TextView resultView = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work2);
        titleView = (TextView) findViewById(R.id.toolbar_works_title);
        resultView = (TextView) findViewById(R.id.work2_result);
        setWorkTitle(R.string.work2);
    }

    public void goWork(View v) {
//        setResult(Work2.reverse("The quick <font color=\"brown\">br<b>ow</b>n</font> fox jumps over the <i>lazy</i> dog"));
//        setResult(Work2.reverse("The quick <font color=\"brown\">brown</font> fox jumps over the <i>lazy</i> dog"));
//        setResult(Work2.reverse("ab<tr>cd<i>ef<b>gh</b><b>ij</b></i>kl</tr>mn<b>op</b>"));
//        setResult(new WordData("ab<tr>cd<i>ef<b>gh</b><b>ij</b></i>kl</tr>mn<b>op</b>").getResult());
        setResult(Work2.reverse("ab<tr>cd<i>ef<b>g<br>h</b><b>ij</b></i>kl</tr>mn<b>op</b>"));
    }

    private void setTitle(final String title) {
        titleView.setText(title);
    }

    private void setWorkTitle(final int resId) {
        setTitle(getResources().getString(resId));
    }

    private void setResult(final String str) {
        resultView.setText(str);
    }
}
