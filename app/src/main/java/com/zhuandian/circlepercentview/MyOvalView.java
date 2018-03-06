package com.zhuandian.circlepercentview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * desc :自定义View绘制圆弧
 * author：xiedong
 * data：2018/3/2
 */

public class MyOvalView extends View {
    public MyOvalView(Context context) {
        super(context, null);

    }

    public MyOvalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        Paint paint = new Paint();
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        //画一个圆
//        canvas.drawCircle(300, 300, 200, paint);


        //画一个矩形
//        RectF rectF = new RectF(0,0,100,100);
//        canvas.drawRect(rectF,paint);

        //画一个圆弧
        float x = (getWidth() - getHeight() / 2) / 2;
        float y = getHeight() / 4;

        RectF oval = new RectF(x, y,
                getWidth() - x, getHeight() - y);

        Paint ovalPaint = new Paint();
        ovalPaint.setColor(Color.BLUE);
        // 当然也可以设置为"实心"(Paint.Style.FILL)
        ovalPaint.setStyle(Paint.Style.STROKE);
        ovalPaint.setStrokeWidth(5);

        canvas.drawRect(oval, paint);


//        oval :指定圆弧的外轮廓矩形区域。
//        startAngle: 圆弧起始角度，单位为度。
//        sweepAngle: 圆弧扫过的角度，顺时针方向，单位为度,从右中间开始为零度。
//        useCenter: 如果为True时，在绘制圆弧时将圆心包括在内，通常用来绘制扇形。关键是这个变量，下面将会详细介绍。
//        paint: 绘制圆弧的画板属性，如颜色，是否填充等。
        canvas.drawArc(oval, -90, 60, false, ovalPaint);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measure(widthMeasureSpec), measure(widthMeasureSpec));

    }

    private int measure(int widthMeasureSpec) {
        int result = 0;
        //1、先获取测量模式 和 测量大小
        //2、如果测量模式是MatchParent 或者精确值，则宽为测量的宽
        //3、如果测量模式是WrapContent ，则宽为 直径值 与 测量宽中的较小值；否则当直径大于测量宽时，会绘制到屏幕之外；
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        System.out.println(specMode + "---------------" + specSize);
//
//       1.UNSPECIFIED
//　　   这说明parent没有对child强加任何限制，child可以是它想要的任何尺寸。

//　　   2.EXACTLY  ==>当设置width或height为match_parent时，模式为EXACTLY
//　　   Parent为child决定了一个绝对尺寸，child将会被赋予这些边界限制，不管child自己想要多大。
//　　
//       3.AT_MOST  -==>当设置为wrap_content时，模式为AT_MOST
//　　   hild可以是自己任意的大小，但是有个绝对尺寸的上限。
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = 300;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }
}
