package lxc.com.example.helloworld.customview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import lxc.com.example.helloworld.evaluator.ColorEvaluator;
import lxc.com.example.helloworld.evaluator.PointEvaluator;
import lxc.com.example.helloworld.model.Point;

public class MyAnimView extends View {
    public static final float RADIUS = 150f;
    private Point currentPoint;
    private Paint mPaint;
    private String color;
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        mPaint.setColor(Color.parseColor(color));
        invalidate();
    }

    public MyAnimView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (currentPoint == null) {
            //初始化Poing在屏幕的左上角：圆的半径为50，则圆心的位置为屏幕的x=50,y=50
            currentPoint = new Point(RADIUS, RADIUS);

            drawCircle(canvas);
            startAnimation();

        } else {
            drawCircle(canvas);
        }
    }

    private void startAnimation() {
        float x = getWidth() - RADIUS;
        float y = getHeight() - RADIUS;
        ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluator(), currentPoint, new Point(x, y));
        anim.addUpdateListener(valueAnimator -> {
            //当new PointEvaluator()对象中返回的Point对象的值改变时调用该方法
            currentPoint = (Point) anim.getAnimatedValue();
            invalidate();
        });
        ObjectAnimator animator = ObjectAnimator.ofObject(this,"color",new ColorEvaluator(),"#0000FF","#FF0000");
        AnimatorSet animSet =new AnimatorSet();
        animSet.play(anim).with(animator);
        animSet.setDuration(5000);
        animSet.start();
    }

    /**
     * 画圆
     *
     */
    private void drawCircle(Canvas canvas) {
        float x = currentPoint.getX();
        float y = currentPoint.getY();
        canvas.drawCircle(x, y, RADIUS, mPaint);
    }
}
