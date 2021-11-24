package lxc.com.example.helloworld.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import lxc.com.example.helloworld.R;

public class AnimationActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "AnimationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        fd(R.id.btn_frame_animation).setOnClickListener(this);
        fd(R.id.btn_tweened_animation).setOnClickListener(this);
        fd(R.id.btn_property_animation).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = null;
        if(view.getId()==R.id.btn_frame_animation) {
            Log.e(TAG, "onClick: 跳转到FrameAnimationActivity");
            i = new Intent(this, FrameAnimationActivity.class);
        }else if(view.getId()==R.id.btn_tweened_animation) {
            Log.e(TAG, "onClick: 跳转到TweenAnimationActivity");
            i = new Intent(this,TweenAnimationActivity.class);
        }else if(view.getId()==R.id.btn_property_animation) {
            Log.e(TAG, "onClick: 跳转到PropertyAnimationActivity");
            i = new Intent(this,PropertyAnimationActivity.class);
        }
        startActivity(i);
    }
}