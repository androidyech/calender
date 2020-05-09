package com.atuan.datepickerlibrary;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;



/**
 * Created by yecj on 2020/5/8.
 */
public class StateTextView extends AppCompatTextView {
    private int bg_type=0;//1 开始 2 中间 3结束
    private Paint mPaint,mPaint2;

    public StateTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public StateTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public StateTextView(Context context) {
        super(context);
        init();
    }
    /**
     * 初始化画笔
     */
    private void init() {
        //实例化画笔
        mPaint = new Paint();
        //设置画笔颜色
        mPaint.setColor(Color.parseColor("#6C8BE2"));
        //设置它的填充方法，用的多的是FILL 和 STORKE
        mPaint.setStyle(Paint.Style.FILL);
        mPaint2 = new Paint();
        mPaint2.setColor(Color.parseColor("#3A5FC8"));
        mPaint2.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(bg_type==1){
            int w = getMeasuredWidth();
            int h = getMeasuredHeight();
            canvas.drawRect(w/2, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
            canvas.drawCircle(h/2+(w-h)/2,h/2,h/2,mPaint2);
        }else if(bg_type==2){
            canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
        }else if(bg_type==3){
            int w = getMeasuredWidth();
            int h = getMeasuredHeight();
            canvas.drawRect(0, 0, getMeasuredWidth()/2, getMeasuredHeight(), mPaint);
            canvas.drawCircle(h/2+(w-h)/2,h/2,h/2,mPaint2);
        }
        super.onDraw(canvas);
        //绘制文本之后
    }

    public void setBg_type(int bg_type) {
        this.bg_type = bg_type;
        invalidate();
    }

    public void setmPaintColor(String color){
        mPaint.setColor(Color.parseColor(color));
    }

    public void setmPaint2Color(String color){
        mPaint2.setColor(Color.parseColor(color));
    }
}
