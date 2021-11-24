package lxc.com.example.helloworld.activity;


import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import lxc.com.example.helloworld.R;

public class PropertyAnimationActivity extends BaseActivity {
    private TextView tvTXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        initView();

    }

    private void initView() {
        tvTXT = fd(R.id.tv_txt);
    }


    /**
     * Start Animator点击事件
     *
     *
     */
    public void startAnimator(View view) {
        //使用代码动态为view开始属性动画
        //为tvTxt实现属性动画（Property Animation）：从左边屏幕外面进来后，360度旋转，同时淡入和淡出
//        ObjectAnimator moveTo = ObjectAnimator.ofFloat(tvTXT, "translationX", -1000f, 0f);
//        ObjectAnimator rotate = ObjectAnimator.ofFloat(tvTXT,"rotation",0f,360f);
//        ObjectAnimator alpha = ObjectAnimator.ofFloat(tvTXT,"alpha",1f,0f,1f);
//        AnimatorSet animSet = new AnimatorSet();
//        animSet.play(rotate).with(alpha).after(moveTo);
//        animSet.setDuration(5000);
//        animSet.addListener(new AnimatorListenerAdapter() {});
//
//        animSet.start();



        //使用XMl文件加载动画，为view使用属性动画，使用XML实现属性动画的优势在于代码的可复用性高
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.anim_file);
        animator.setTarget(tvTXT);
        animator.start();
    }
}