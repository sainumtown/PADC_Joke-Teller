package xz.sainumtown.joke.components.buttons;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import xz.sainumtown.joke.utils.MMFontUtils;

/**
 * Created by asus on 6/26/2016.
 */
public class MMbutton extends Button {
    public MMbutton(Context context) {
        super(context);
        if (!isInEditMode()) {
            MMFontUtils.setMMFont(this);
        }
    }

    public MMbutton(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            MMFontUtils.setMMFont(this);
        }
    }

    public MMbutton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode()) {
            MMFontUtils.setMMFont(this);
        }
    }
}
