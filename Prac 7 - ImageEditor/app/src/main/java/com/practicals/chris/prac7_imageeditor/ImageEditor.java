package com.practicals.chris.prac7_imageeditor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;


public class ImageEditor extends android.support.v7.widget.AppCompatImageView {

    Paint paint = new Paint();
    PointF points[];

    public ImageEditor(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint.setColor(Color.BLACK);

    }

    public void setPoint(PointF[] points) {
        this.points = points;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        if (points == null) return;
        for (int i = 0; i<points.length; i++) {
            RectF rect = new RectF(points[i].x, points[i].y, points[i].x + 10, points[i].y + 10);
            canvas.drawRect(rect, paint);
        }

    }
}
