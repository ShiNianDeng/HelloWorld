package lxc.com.example.helloworld.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import lxc.com.example.helloworld.R;

public class TweenAnimationActivity extends BaseActivity implements View.OnClickListener {

    private ImageView ivCourier;
    private Animation anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);
        initView();
    }

    private void initView() {
        fd(R.id.btn_alpha_animation).setOnClickListener(this);
        fd(R.id.btn_rotate_animation).setOnClickListener(this);
        fd(R.id.btn_translate_animation).setOnClickListener(this);
        fd(R.id.btn_set_animation).setOnClickListener(this);
        fd(R.id.btn_scale_animation).setOnClickListener(this);
        ivCourier = fd(R.id.iv_img);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_alpha_animation:
                anim = AnimationUtils.loadAnimation(this,R.anim.courier_aptha_anim);
                break;
            case R.id.btn_rotate_animation:
                anim = AnimationUtils.loadAnimation(this,R.anim.courier_rotate_anim);
                break;
            case R.id.btn_translate_animation:
                anim = AnimationUtils.loadAnimation(this,R.anim.courier_translate_anim);
                break;
            case R.id.btn_scale_animation:
                anim = AnimationUtils.loadAnimation(this,R.anim.courier_scale_anim);
                break;
            case R.id.btn_set_animation:
                anim = AnimationUtils.loadAnimation(this,R.anim.courier_set_anim);
                break;
            default:
                break;
        }anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        ivCourier.startAnimation(anim);
    }
}