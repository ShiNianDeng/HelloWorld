package lxc.com.example.helloworld.evaluator;

import android.animation.TypeEvaluator;

import lxc.com.example.helloworld.model.Point;

public class PointEvaluator implements TypeEvaluator<Point> {

    /**
     * @param fraction 可以理解成为一个随时间而不断变化的分数，例如动画总时间为5秒钟，则次fraction就是一个1/5000,其中1随着时间
     *                 变化不断增加，2/5000,3/5000，直到5000/5000动画完成，则计算结束
     * @param o        开始值
     * @param t1       结束值
     * @return 动画过程中每时每刻的point对象
     */
    @Override
    public Point evaluate(float fraction, Point o, Point t1) {
        float x = ((t1).getX() - (o).getX()) * fraction + (o).getX();
        float y = ((t1).getY() - (o).getY()) * fraction + (o).getY();
        return new Point(x, y);
    }
}
