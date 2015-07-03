package com.inagata.appsm;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by mnafian on 7/2/15.
 */
public class DragRelativeLayout extends RelativeLayout {
    public DragRelativeLayout(Context context) {
        super(context);
    }
    public DragRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public DragRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return true; // Tell children not to use this event
    }
}
