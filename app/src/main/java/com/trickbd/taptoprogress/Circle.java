package com.trickbd.taptoprogress;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class Circle extends View {
    private final Paint paint = new Paint();
    private final RectF rectf = new RectF();
    private float angle;
    private int endangle;

    public Circle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        float dimensionPixelSize = (float) context.getResources().getDimensionPixelSize(R.dimen.curve_width);
        float dimensionPixelSize2 = ((float) context.getResources().getDimensionPixelSize(R.dimen.curve_radius)) - (4.0f * dimensionPixelSize);
        Point screenSize = getScreenSize(context);
        float f = dimensionPixelSize / 2.0f;
        float f2 = (((float) (screenSize.x / 2)) - dimensionPixelSize) - dimensionPixelSize2;
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Style.STROKE);
        this.paint.setStrokeWidth(dimensionPixelSize);
        this.endangle = (int) (((float) (screenSize.x / 2)) - dimensionPixelSize);
        this.rectf.set(f2, f, (dimensionPixelSize2 * 2.0f) + f2, (dimensionPixelSize2 * 2.0f) + f);
        this.angle = 54.5f;
    }

    public static Point getScreenSize(@NonNull Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }

    public void setCurveColor(int i, int i2) {
        this.paint.setShader(new LinearGradient(0.0f, 0.0f, (float) this.endangle, (float) this.endangle, i, i2, TileMode.MIRROR));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.rectf, 180.0f, this.angle, false, this.paint);
    }

    public float getAngle() {
        return this.angle;
    }

    public void setAngle(float f) {
        this.angle = f;
    }
}
