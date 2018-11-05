package com.bwie.dell.xiongjinmeng20181105;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class CustomDisk extends View {
    private final int certenX;
    private final int certenY;
    private final int[] colors;
    private String[] data = new String[]{"一等奖","二等奖","三等奖","四等奖","参与奖","谢谢惠顾"};
    private Paint paint;

    public CustomDisk(Context context) {
        this(context,null);
    }

    public CustomDisk(Context context, AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public CustomDisk(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //屏幕宽高
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int widthPixels = displayMetrics.widthPixels;
        int heightPixels = displayMetrics.heightPixels;
        certenX = widthPixels / 2;
        certenY = heightPixels/2;
        //初始化画笔
        initPaint();
        //颜色
        colors = new int[]{Color.CYAN,Color.GREEN,Color.GRAY,Color.DKGRAY,Color.BLUE,Color.BLACK};
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(certenX,certenY);
        //绘制圆弧
        RectF rectF = new RectF(-250, -250, 250, 250);
        float start = 60;
        for (int i = 0; i < 6; i++){
            paint.setColor(colors[i]);
            canvas.drawArc(rectF,start*i,60,true,paint);
        }
        //内圆
        paint.setColor(Color.RED);
        canvas.drawCircle(0,0,100,paint);
        //字
        paint.setColor(Color.WHITE);
        paint.setTextSize(30);
        Rect rect = new Rect();
        //字的大小
        paint.getTextBounds("start",0,5,rect);
        int width = rect.width();
        int height = rect.height();
        canvas.drawText("start",-width/2,height/2,paint);
        RectF rectF1 = new RectF(-160, -160, 160, 160);
        for (int i = 0; i < 6; i++){
            paint.setColor(Color.WHITE);
            Path path = new Path();
            path.addArc(rectF1,start*i+10,60);
            canvas.drawTextOnPath(data[i],path,0,0,paint);
        }
    }
    private void initPaint() {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5);
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
    }


}
