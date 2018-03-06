package com.zhuandian.circlepercentview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PercentCircle percentCircle = (PercentCircle) findViewById(R.id.pc);
        percentCircle.setTargetPercent(39);
    }
}
