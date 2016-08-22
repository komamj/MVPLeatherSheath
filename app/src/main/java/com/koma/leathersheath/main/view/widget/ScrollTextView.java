package com.koma.leathersheath.main.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by koma on 2016/8/22.
 */
public class ScrollTextView extends TextView {
    public ScrollTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // TODO Auto-generated constructor stub
    }

    public ScrollTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public ScrollTextView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}
