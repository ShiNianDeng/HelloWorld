package lxc.com.example.helloworld.activity;

import androidx.annotation.Nullable;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import lxc.com.example.helloworld.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    public static final String TAG = "MainActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        fd(R.id.btn_timer).setOnClickListener(this);
        fd(R.id.btn_two).setOnClickListener(this);
        fd(R.id.btn_glide_transformations).setOnClickListener(this);
        fd(R.id.btn_animation).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_timer:
                Log.e(TAG, "onClick: 跳转到TimerDemoActivity ");
                intent = new Intent(this,TimerDemoActivity.class);

                break;
            case R.id.btn_two:
                Log.e(TAG, "onClick: 跳转到RecyclerViewActivity" );
                intent = new Intent(this, RecyclerViewDemoActivity.class);
                break;
            case R.id.btn_glide_transformations:
                Log.e(TAG, "onClick: 跳转到Glide-TransformationsActivity" );
                intent = new Intent(this, GlideTransformationsActivity.class);
                break;
            case R.id.btn_animation:
                Log.e(TAG, "onClick: 跳转到AnimationActivity" );
                intent = new Intent(this, AnimationActivity.class);
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}