package lxc.com.example.helloworld.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import lxc.com.example.helloworld.R;

public class FrameAnimationActivity extends BaseActivity implements View.OnClickListener {

    private ImageView ivJD;
    private AnimationDrawable anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);
        initView();

//如果没有在xml文件中设置ImageView的src，则动态指定ImageView需要显示的Drawable，如果设置了src属性，则直接ivJD.getDrawable()即可
//        ivJD.setImageResource(R.drawable.courier_frame_anim);
        anim = (AnimationDrawable) ivJD.getDrawable();
    }

    private void initView() {
        ivJD = fd(R.id.iv_jd);
        fd(R.id.btn_start).setOnClickListener(this);
        fd(R.id.btn_stop).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                anim.start();
                break;
            case R.id.btn_stop:
                anim.stop();
                break;
            default:
                break;
        }
    }
}