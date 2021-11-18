package lxc.com.example.helloworld.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

import lxc.com.example.helloworld.R;

public class TimerDemoActivity extends AppCompatActivity {

    private static final String TAG = "TimerDemoActivity";
    private Timer timer;

    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            Log.e(TAG, "run: 延迟0秒，每隔5秒发送一次。" );
        }
    };

    private TimerTask t = new TimerTask() {
        @Override
        public void run() {
            Log.e(TAG, "run: 延迟2秒发送。" );
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_demo);
    }

    public void startTimer(View view) {
        timer = new Timer();
        timer.schedule(t,2*1000);//schedule(需要执行的操作，多久之后执行)
//        timer.schedule(task,0,5*1000);//schedule(延时器需要执行的操作，多久之后执行，每隔多久执行一次);
    }

    public void stopTimer(View view) {
        timer.cancel();
        Log.e(TAG, "stopTimer: 停止延时器，防止内存溢出。");
    }

}