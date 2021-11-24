package lxc.com.example.helloworld.evaluator;

import android.animation.TypeEvaluator;

public class ColorEvaluator implements TypeEvaluator<String> {
    private int mCurrentRed = -1;
    private int mCurrentGreen = -1;
    private int mCurrentBlue = -1;
    @Override
    public String evaluate(float v, String o, String t1) {
        int startRed = Integer.parseInt(o.substring(1, 3), 16);
        int startGreen = Integer.parseInt(o.substring(3, 5), 16);
        int startBlue = Integer.parseInt(o.substring(5, 7), 16);
        int endRed = Integer.parseInt(t1.substring(1, 3), 16);
        int endGreen = Integer.parseInt(t1.substring(3, 5), 16);
        int endBlue = Integer.parseInt(t1.substring(5, 7), 16);

        //必要要初始化三原色，否则这个方法返回的十六进制的颜色错误。例如（194，-1，-1）,而不是(194,0,0)
        if (mCurrentRed == -1) {
            mCurrentRed = startRed;
        }
        if (mCurrentGreen == -1) {
            mCurrentGreen = startGreen;
        }
        if (mCurrentBlue == -1) {
            mCurrentBlue = startBlue;
        }
        int redDiff = Math.abs(startRed - endRed);
        int greenDiff = Math.abs(startGreen - endGreen);
        int blueDiff = Math.abs(startBlue - endBlue);
        int colorDiff = redDiff + greenDiff + blueDiff;

        if (mCurrentRed != endRed) {
            mCurrentRed = getCurrentColor(startRed, endRed, colorDiff, 0, v);
        } else if (mCurrentGreen != endGreen) {
            mCurrentGreen = getCurrentColor(startGreen, endGreen, colorDiff, redDiff, v);
        } else if (mCurrentBlue != endBlue) {
            mCurrentBlue = getCurrentColor(startBlue, endBlue, colorDiff, redDiff + greenDiff, v);
        }
        return "#" + getHexString(mCurrentRed) + getHexString(mCurrentGreen) + getHexString(mCurrentBlue);
    }

    private String getHexString(int value) {
        String hexString = Integer.toHexString(value);
        if (hexString.length() == 1) {
            hexString = "0" + hexString;
        }
        return hexString;
    }

    private int getCurrentColor(int startColor, int endColor, int colorDiff, int offset, float fraction) {
        int color ;
        if (startColor > endColor) {
            color = (int) (startColor - (fraction * colorDiff - offset));
            if (color < endColor) {
                color = endColor;
            }
        } else {
            color = (int) (startColor + (fraction * colorDiff - offset));
            if (color > endColor) {
                color = endColor;
            }
        }
        return color;
    }

}
