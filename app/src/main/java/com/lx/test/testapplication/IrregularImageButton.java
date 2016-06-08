package com.lx.test.testapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageButton;

/**
 * @Title: com.lx.test.testapplication
 * @Description: <请描述此文件是做什么的>
 * @author: 廖轩
 * @data: 2016 2016/6/8 16:03
 * @version: V1.0
 */
public class IrregularImageButton extends ImageButton {
    public IrregularImageButton(Context context) {
        super(context);
    }

    public IrregularImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IrregularImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action != MotionEvent.ACTION_DOWN) {
            return super.onTouchEvent(event);
        }
        int x = (int) event.getX();
        int y = (int) event.getY();
        int width = -1;
        int height = -1;
        Bitmap bitmap = null;

        if (width == -1 || height == -1) {
            Drawable drawable = ((BitmapDrawable) (this.getBackground())).getCurrent();
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            width = getWidth();
            height = getHeight();
        }

        Log.d("MyImageButton", "width=" + width + ";height=" + height + ";x=" + x + ";y=" + y);
        if (null == bitmap || x < 0 || y < 0 || x >= width || y >= height) {
            return false;
        }

        int pixel = bitmap.getPixel(x, y);
        if (Color.TRANSPARENT == pixel) {
            return false;
        }
        return super.onTouchEvent(event);
    }
}
