package com.example.administrator.attime;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private int clo = 0;
    private Handler handler=new Handler();
    private SpannableStringBuilder ssb;
    private Runnable runnable=new Runnable() {
    @Override
    public void run() {

//        tv_dian.setVisibility(View.GONE);
        atPortrait();
        handler.postDelayed(runnable,1000);
        if(null !=tv_dian){
            tv_dian.setTextColor(Color.TRANSPARENT);
        }

//        ssb.setSpan(new ForegroundColorSpan(Color.GREEN),0,1, Color.TRANSPARENT);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(null !=tv_dian){
                    tv_dian.setTextColor(Color.GRAY);
                }
//                ssb.setSpan(new ForegroundColorSpan(Color.GREEN),0,1, Color.WHITE);
            }
        },300);
    }
};
    private Configuration mConfiguration;
    private TextView tv_dian;
    ;
    private String ss;
    private TextView tv_time1;
    private TextView tv_time2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取设置的配置信息
        mConfiguration = this.getResources().getConfiguration();
        atPortrait();
        handler.postDelayed(runnable,1000);

    }

    private void atPortrait() {
        int ori = mConfiguration.orientation; //获取屏幕方向
        if (ori == mConfiguration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.layout_heng);
            SimpleDateFormat dff = new SimpleDateFormat("HH");
            SimpleDateFormat dff2 = new SimpleDateFormat("mm");
            dff.setTimeZone(TimeZone.getTimeZone("GMT+08"));
            dff2.setTimeZone(TimeZone.getTimeZone("GMT+08"));
            tv_dian = findViewById(R.id.tv_dian);
            String ee1 = dff.format(new Date());
            String ee2 =dff2.format(new Date());
            tv_time1 = findViewById(R.id.tv_time1);
            tv_time2 = findViewById(R.id.tv_time2);
            tv_time1.setText(ee1);
            tv_time2.setText(ee2);
            //横屏
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//强制为竖屏
//            setTime();

        } else if (ori == mConfiguration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_main);
            tv_dian = findViewById(R.id.tv_dian);
//            spark();
//            setTime();

            //竖屏
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//强制为横屏
            //            SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat dff = new SimpleDateFormat("HH mm");
//            SimpleDateFormat dff2 = new SimpleDateFormat("");
            dff.setTimeZone(TimeZone.getTimeZone("GMT+08"));
//            dff2.setTimeZone(TimeZone.getTimeZone("GMT+08"));
            String ee = dff.format(new Date());
//            String ee2 = dff2.format(new Date());
//            String ss=ee+ee2;
//            Log.e(ee,ee);
            TextView tv_time=findViewById(R.id.tv_time);
            tv_time.setText(ee);
        }
    }

    private void setTime() {
        //            SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dff = new SimpleDateFormat("HH");
        SimpleDateFormat dff2 = new SimpleDateFormat("mm");
        dff.setTimeZone(TimeZone.getTimeZone("GMT+08"));
        dff2.setTimeZone(TimeZone.getTimeZone("GMT+08"));
        tv_dian = findViewById(R.id.tv_dian);
        String ee1 = dff.format(new Date());
        String ee2 =dff2.format(new Date());
        tv_time1 = findViewById(R.id.tv_time1);
        tv_time2 = findViewById(R.id.tv_time2);
        tv_time1.setText(ee1);
        tv_time2.setText(ee2);


    }
}
