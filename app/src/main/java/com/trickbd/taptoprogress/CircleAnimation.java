package com.trickbd.taptoprogress;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public class CircleAnimation extends Animation {
    private Circle circle;
    private float angle;
    private float endangle;

    public CircleAnimation(Circle circle, float endangle) {
        this.angle = circle.getAngle();
        this.endangle = endangle;
        this.circle = circle;
    }


    protected void applyTransformation(float f, Transformation transformation) {
        this.circle.setAngle(this.angle + ((this.endangle - this.angle) * f));
        this.circle.requestLayout();
    }
}
