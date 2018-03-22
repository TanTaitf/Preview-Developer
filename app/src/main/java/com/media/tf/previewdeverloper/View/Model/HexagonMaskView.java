package com.media.tf.previewdeverloper.View.Model;

/**
 * Created by Windows 8.1 Ultimate on 16/03/2018.
 */

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;

import com.media.tf.previewdeverloper.R;

public class HexagonMaskView extends android.support.v7.widget.AppCompatImageView {

    private Path hexagonPath;
    private Path hexagonBorderPath;
    private float radius;
    private Bitmap image;
    private int viewWidth;
    private int viewHeight;
    private Paint paint;
    private BitmapShader shader;
    private Paint paintBorder;
    private int borderWidth = 4;

    public HexagonMaskView(Context context) {
        super(context);
        setup();
    }

    public HexagonMaskView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public HexagonMaskView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    private void setup() {
        paint = new Paint();
        paint.setAntiAlias(true);

        paintBorder = new Paint();
        setBorderColor(getResources().getColor(R.color.bg_item_green));
        paintBorder.setAntiAlias(true);
        this.setLayerType(LAYER_TYPE_SOFTWARE, paintBorder);
        paintBorder.setShadowLayer(4.0f, 1.0f, 1.0f, Color.TRANSPARENT);

        hexagonPath = new Path();
        hexagonBorderPath = new Path();
    }

    public void setRadius(float r) {
        this.radius = r;
        calculatePath();
    }

    public void setBorderWidth(int borderWidth)  {
        this.borderWidth = borderWidth;
        this.invalidate();
    }

    public void setBorderColor(int borderColor)  {
        if (paintBorder != null)
            paintBorder.setColor(borderColor);

        this.invalidate();
    }

    private void calculatePath() {

        float triangleHeight = (float) (Math.sqrt(3) * radius / 2);
        float centerX = viewWidth/2;
        float centerY = viewHeight/2;

        hexagonBorderPath.moveTo(centerX, centerY + radius);
        hexagonBorderPath.lineTo(centerX - triangleHeight, centerY + radius/2);
        hexagonBorderPath.lineTo(centerX - triangleHeight, centerY - radius/2);
        hexagonBorderPath.lineTo(centerX, centerY - radius);
        hexagonBorderPath.lineTo(centerX + triangleHeight, centerY - radius/2);
        hexagonBorderPath.lineTo(centerX + triangleHeight, centerY + radius/2);
        hexagonBorderPath.moveTo(centerX, centerY + radius);

        float radiusBorder = radius - borderWidth;
        float triangleBorderHeight = (float) (Math.sqrt(3) * radiusBorder / 2);

        hexagonPath.moveTo(centerX, centerY + radiusBorder);
        hexagonPath.lineTo(centerX - triangleBorderHeight, centerY + radiusBorder/2);
        hexagonPath.lineTo(centerX - triangleBorderHeight, centerY - radiusBorder/2);
        hexagonPath.lineTo(centerX, centerY - radiusBorder);
        hexagonPath.lineTo(centerX + triangleBorderHeight, centerY - radiusBorder/2);
        hexagonPath.lineTo(centerX + triangleBorderHeight, centerY + radiusBorder/2);
        hexagonPath.moveTo(centerX, centerY + radiusBorder);

        invalidate();
    }

    private void loadBitmap()  {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) this.getDrawable();

        if (bitmapDrawable != null)
            image = bitmapDrawable.getBitmap();
    }

    @SuppressLint("DrawAllocation")
    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);

        loadBitmap();

        // init shader
        if (image != null) {

            canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

            shader = new BitmapShader(Bitmap.createScaledBitmap(image, canvas.getWidth(), canvas.getHeight(), false), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            paint.setShader(shader);

            canvas.drawPath(hexagonBorderPath, paintBorder);
            canvas.drawPath(hexagonPath, paint);
        }

    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = measureWidth(widthMeasureSpec);
        int height = measureHeight(heightMeasureSpec, widthMeasureSpec);

        viewWidth = width - (borderWidth * 2);
        viewHeight = height - (borderWidth * 2);


        radius = height / 2 - borderWidth;

        calculatePath();

        setMeasuredDimension(width, height);
    }

    private int measureWidth(int measureSpec)   {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY)  {
            result = specSize;
        }
        else {
            result = viewWidth;
        }

        return result;
    }

    private int measureHeight(int measureSpecHeight, int measureSpecWidth)  {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpecHeight);
        int specSize = MeasureSpec.getSize(measureSpecHeight);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        }
        else {
            result = viewHeight;
        }

        return (result + 2);
    }


}



//import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Path;
//import android.graphics.Region;
//import android.util.AttributeSet;
//import android.view.View;
//
//public class HexagonMaskView extends View {
//    private Path hexagonPath;
//    private Path hexagonBorderPath;
//    private float radius;
//    private float width, height;
//    private int maskColor;
//
//    public HexagonMaskView(Context context) {
//        super(context);
//        init();
//    }
//
//    public HexagonMaskView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        init();
//    }
//
//    public HexagonMaskView(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        init();
//    }
//
//    private void init() {
//        hexagonPath = new Path();
//        hexagonBorderPath = new Path();
//        maskColor = 0xFF01FF77;
//    }
//
//    public void setRadius(float r) {
//        this.radius = r;
//        calculatePath();
//    }
//
//    public void setMaskColor(int color) {
//        this.maskColor = color;
//        invalidate();
//    }
//
//    private void calculatePath() {
//        float triangleHeight = (float) (Math.sqrt(3) * radius / 2);
//        float centerX = width/2;
//        float centerY = height/2;
//        hexagonPath.moveTo(centerX, centerY + radius);
//        hexagonPath.lineTo(centerX - triangleHeight, centerY + radius/2);
//        hexagonPath.lineTo(centerX - triangleHeight, centerY - radius/2);
//        hexagonPath.lineTo(centerX, centerY - radius);
//        hexagonPath.lineTo(centerX + triangleHeight, centerY - radius/2);
//        hexagonPath.lineTo(centerX + triangleHeight, centerY + radius/2);
//        hexagonPath.moveTo(centerX, centerY + radius);
//
//        float radiusBorder = radius - 5;
//        float triangleBorderHeight = (float) (Math.sqrt(3) * radiusBorder / 2);
//        hexagonBorderPath.moveTo(centerX, centerY + radiusBorder);
//        hexagonBorderPath.lineTo(centerX - triangleBorderHeight, centerY + radiusBorder/2);
//        hexagonBorderPath.lineTo(centerX - triangleBorderHeight, centerY - radiusBorder/2);
//        hexagonBorderPath.lineTo(centerX, centerY - radiusBorder);
//        hexagonBorderPath.lineTo(centerX + triangleBorderHeight, centerY - radiusBorder/2);
//        hexagonBorderPath.lineTo(centerX + triangleBorderHeight, centerY + radiusBorder/2);
//        hexagonBorderPath.moveTo(centerX, centerY + radiusBorder);
//        invalidate();
//    }
//
//    @Override
//    public void onDraw(Canvas c){
//        super.onDraw(c);
//        c.clipPath(hexagonBorderPath, Region.Op.DIFFERENCE);
//        c.drawColor(Color.WHITE);
//        c.save();
//        c.clipPath(hexagonPath, Region.Op.DIFFERENCE);
//        c.drawColor(maskColor);
//        c.save();
//    }
//
//    // getting the view size and default radius
//    @Override
//    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        width = MeasureSpec.getSize(widthMeasureSpec);
//        height =  MeasureSpec.getSize(heightMeasureSpec);
//        radius = height / 2 - 10;
//        calculatePath();
//    }
//}


//import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.graphics.Path;
//import android.graphics.PorterDuff;
//import android.graphics.Region;
//import android.util.AttributeSet;
//
//public class HexagonMaskView extends android.support.v7.widget.AppCompatImageView {
//    private Path hexagonPath;
//    private Path hexagonBorderPath;
//    private Paint mBorderPaint;
//
//    public HexagonMaskView(Context context) {
//        super(context);
//        init();
//    }
//
//    public HexagonMaskView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        init();
//    }
//
//    public HexagonMaskView(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        init();
//    }
//
//    private void init() {
//        this.hexagonPath = new Path();
//        this.hexagonBorderPath = new Path();
//
//        this.mBorderPaint = new Paint();
//        this.mBorderPaint.setColor(Color.WHITE);
//        this.mBorderPaint.setStrokeCap(Paint.Cap.ROUND);
//        this.mBorderPaint.setStrokeWidth(50f);
//        this.mBorderPaint.setStyle(Paint.Style.STROKE);
//    }
//
//    public void setRadius(float radius) {
//        calculatePath(radius);
//    }
//
//    public void setBorderColor(int color) {
//        this.mBorderPaint.setColor(color);
//        invalidate();
//    }
//
//    private void calculatePath(float radius) {
//        float halfRadius = radius / 2f;
//        float triangleHeight = (float) (Math.sqrt(3.0) * halfRadius);
//        float centerX = getMeasuredWidth() / 2f;
//        float centerY = getMeasuredHeight() / 2f;
//
//        this.hexagonPath.reset();
//        this.hexagonPath.moveTo(centerX, centerY + radius);
//        this.hexagonPath.lineTo(centerX - triangleHeight, centerY + halfRadius);
//        this.hexagonPath.lineTo(centerX - triangleHeight, centerY - halfRadius);
//        this.hexagonPath.lineTo(centerX, centerY - radius);
//        this.hexagonPath.lineTo(centerX + triangleHeight, centerY - halfRadius);
//        this.hexagonPath.lineTo(centerX + triangleHeight, centerY + halfRadius);
//        this.hexagonPath.close();
//
//        float radiusBorder = radius - 5f;
//        float halfRadiusBorder = radiusBorder / 2f;
//        float triangleBorderHeight = (float) (Math.sqrt(3.0) * halfRadiusBorder);
//
//        this.hexagonBorderPath.reset();
//        this.hexagonBorderPath.moveTo(centerX, centerY + radiusBorder);
//        this.hexagonBorderPath.lineTo(centerX - triangleBorderHeight, centerY + halfRadiusBorder);
//        this.hexagonBorderPath.lineTo(centerX - triangleBorderHeight, centerY - halfRadiusBorder);
//        this.hexagonBorderPath.lineTo(centerX, centerY - radiusBorder);
//        this.hexagonBorderPath.lineTo(centerX + triangleBorderHeight, centerY - halfRadiusBorder);
//        this.hexagonBorderPath.lineTo(centerX + triangleBorderHeight, centerY + halfRadiusBorder);
//        this.hexagonBorderPath.close();
//        invalidate();
//    }
//
//    @Override
//    public void onDraw(Canvas c) {
//        c.drawPath(hexagonBorderPath, mBorderPaint);
//        c.clipPath(hexagonPath, Region.Op.INTERSECT);
//        c.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
//        super.onDraw(c);
//    }
//
//    @Override
//    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int width = MeasureSpec.getSize(widthMeasureSpec);
//        int height = MeasureSpec.getSize(heightMeasureSpec);
//        setMeasuredDimension(width, height);
//        calculatePath(Math.min(width / 2f, height / 2f) - 10f);
//    }
//}