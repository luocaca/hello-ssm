package luocaca.photoview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/2/26 0026.
 */

public class MyButton extends View {
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //测量
    //onMeasure()方法顾名思义就是用于测量视图的大小的
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //EXACTLY----指定大小
        //精确地
        int  measuredHeight = measureHeight(heightMeasureSpec);
        //AT_MOST    ---- 最多屏幕大
        //表示子视图最多只能是specSize中指定的大小，开发人员应该尽可能小得去设置这个视图，并且保证不会超过specSize。
        // 系统默认会按照这个规则来设置子视图的大小，开发人员当然也可以按照自己的意愿设置成任意的大小。
//        3. UNSPECIFIED
//        表示开发人员可以将视图按照自己的意愿设置成任意的大小，没有任何限制。这种情况比较少见，不太会用到
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    private int measureHeight(int measureSpec) {
        return 1;
    }


    private
    int measureWidth(int measureSpec) {
        return 1;
    }




    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }



}
