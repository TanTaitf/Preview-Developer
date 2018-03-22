package com.media.tf.previewdeverloper.View.View;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.media.tf.previewdeverloper.R;

public class TimeTraningActivity extends Activity {

    ImageView img_build, img_chart;
    ScaleGestureDetector gestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_traning);
        InitView();
        gestureDetector = new ScaleGestureDetector(this,new MyGesture());
        img_build.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                gestureDetector.onTouchEvent(motionEvent);
                return false;
            }
        });
        img_chart.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                gestureDetector.onTouchEvent(motionEvent);
                return false;
            }
        });
    }
    class  MyGesture extends ScaleGestureDetector.SimpleOnScaleGestureListener{
        float scale = 1.0F, onScaleStart = 0, onScaleEnd = 0;
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale += detector.getScaleFactor();
            img_build.setScaleX(scale);
            img_build.setScaleY(scale);

            Toast.makeText(getApplicationContext(),"OnScale",Toast.LENGTH_SHORT).show();
            return super.onScale(detector);
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            onScaleStart = scale;
            Toast.makeText(getApplicationContext(),"OnScaleBegin",Toast.LENGTH_SHORT).show();
            return super.onScaleBegin(detector);
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {
            onScaleEnd = scale;
            Toast.makeText(getApplicationContext(),"OnScaleEnd",Toast.LENGTH_SHORT).show();
            super.onScaleEnd(detector);
        }
    }
    private void InitView() {
        img_build = findViewById(R.id.img_build);
        img_chart = findViewById(R.id.img_chart);
    }
}
