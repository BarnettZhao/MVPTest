package com.example.zww.mvptest;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.Locale;

/**
 * Created by zww on 2017/7/4.
 */

public class DownTimeUtil {
    private Context context;
    public CountDownTimer countDownTimer;

    public DownTimeUtil(Context context) {
        this.context = context;
    }

    public void initCountDownTime(final TextView textView) {
        countDownTimer = new CountDownTimer(60000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                textView.setEnabled(false);
                textView.setText(String.format(Locale.CHINA, context.getString(R.string.login_count_down_text), millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                textView.setEnabled(true);
                textView.setText("获取验证码");
                cancel();
            }
        };
    }
}
