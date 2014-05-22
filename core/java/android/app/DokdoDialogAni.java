package android.app;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.accessibility.AccessibilityEvent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.internal.R;

public class DokdoDialogAni extends Dialog {
    private TextView mMessage;

    public DokdoDialogAni(Context context) {
        this(context, android.R.style.Theme_Holo_Dialog);
    }

    public DokdoDialogAni(Context context, int i) {
        super(context, i);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.dokdo_dialog, null);
        mMessage = (TextView)v.findViewById(R.id.dokdo_dialog_title);
        ImageView img = (ImageView)v.findViewById(R.id.dokdo_dialog_animation);
        AnimationDrawable frameAnimation = (AnimationDrawable)img.getDrawable();
        frameAnimation.setCallback(img);
        frameAnimation.setVisible(true, true);
        frameAnimation.start();
        this.setContentView(v);
    }

    public void setMessage(final CharSequence msg) {
        mMessage.setText(msg);
    }

    @Override
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return true;
    }

    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return true;
    }

    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return true;
    }
}

