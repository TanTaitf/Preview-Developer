package com.media.tf.previewdeverloper.View.View;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.media.tf.previewdeverloper.R;

import static com.media.tf.previewdeverloper.View.Model.Config.setFont;
import static com.media.tf.previewdeverloper.View.Model.Config.setFont_Bold;

public class MainActivity extends Activity {
    // View top
    TextView txtInside, txtProcess, txtMobile, txtDevelop, txtBut, txtLooking,txtDoyouknow;
    Typeface typeface_Bold, typeface;
    // View center
    ImageView img_report,img_setting,img_suitace,img_brush,img_rocket;
    // View bottom
    // View Native Mobile App
    TextView txtIt_takes_amost_native,txt18weeks_native,txt_todevelop_native,txt_native_mobile_app;
    TextView txt_IT_ALSO_TAKES, txt_18_WEEKS_NATIVE_APP;
    ImageView img_NATIVE_APP;
    // View Back End
    TextView txtIt_takes_backend,txt_10_weeks_backend,txt_build_the_backend,txt_Back_end;
    TextView txt_TO_PRODUCE,txt_168_NORMAL_CARS;
    ImageView img_BACK_END;
    // View Front End
    TextView txt_And_front_end,txt_08_week_front_end,txt_build_the_front_end,txt_Front_end;
    TextView txt_TO_BIULD_FRONT_END,txt_CONCRETE_POOLS;
    ImageView img_FRONT_END;

    // Layout main
    LinearLayout layout_main;
    private Window window;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        typeface = setFont(this, typeface);
        typeface_Bold = setFont_Bold(this, typeface_Bold);
        // set color status
        if (Build.VERSION.SDK_INT >= 21) {
            window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.bg_item_green));
        }
        InitView();
        img_brush.setVisibility(View.INVISIBLE);
        img_rocket.setVisibility(View.INVISIBLE);
        YoYo.with(Techniques.BounceInLeft)
                .duration(1100)
                .withListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        img_brush.setVisibility(View.VISIBLE);
                        img_rocket.setVisibility(View.VISIBLE);
                        YoYo.with(Techniques.FadeInRight)
                                .duration(800)
                                .playOn(findViewById(R.id.img_rocket));
                        YoYo.with(Techniques.FadeInLeft)
                                .duration(800)
                                .playOn(findViewById(R.id.img_brush));

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                })
                .playOn(findViewById(R.id.img_report));
        YoYo.with(Techniques.BounceInRight)
                .duration(1100)
                .playOn(findViewById(R.id.img_suitace));
        Animation animAlpha = AnimationUtils.loadAnimation(MainActivity.this,R.anim.demo_rotate);
        img_setting.startAnimation(animAlpha);

        img_rocket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,DevelopCostActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
        img_brush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,TimeTraningActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        img_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,DevelopProcessActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

//                YoYo.with(Techniques.SlideOutLeft)
//                        .duration(350)
//                        .withListener(new Animator.AnimatorListener() {
//                            @Override
//                            public void onAnimationStart(Animator animation) {
//
//                            }
//
//                            @Override
//                            public void onAnimationEnd(Animator animation) {
//                               startActivity(new Intent(MainActivity.this,DevelopProcessActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
//                                //finish();
//                            }
//
//                            @Override
//                            public void onAnimationCancel(Animator animation) {
//                            }
//
//                            @Override
//                            public void onAnimationRepeat(Animator animation) {
//
//                            }
//                        })
//                        .playOn(findViewById(R.id.layout_main));
            }
        });

//        YoYo.with(Techniques.FlipOutY)
//                .duration(1200)
//                .repeat(YoYo.INFINITE)
//                .pivot(YoYo.CENTER_PIVOT, YoYo.CENTER_PIVOT)
//                .interpolate(new AccelerateDecelerateInterpolator())
//                .playOn(findViewById(R.id.img_setting));



    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void InitView() {
        txtBut = findViewById(R.id.txtBut);
        txtDevelop = findViewById(R.id.txtDevelop);
        txtDoyouknow = findViewById(R.id.txtDoyouKnow);
        txtInside = findViewById(R.id.txtInside);
        txtLooking = findViewById(R.id.txtLooking);
        txtMobile = findViewById(R.id.txtMobileapp);
        txtProcess = findViewById(R.id.txtProcess);
        layout_main = findViewById(R.id.layout_main);

        txtInside.setTypeface(typeface);
        txtMobile.setTypeface(typeface_Bold);
        txtDevelop.setTypeface(typeface_Bold);
        txtProcess.setTypeface(typeface);
        txtLooking.setTypeface(typeface);
        txtBut.setTypeface(typeface_Bold);
        txtDoyouknow.setTypeface(typeface);

        // View Img Center
        img_report = findViewById(R.id.img_report);
        img_setting = findViewById(R.id.img_setting);
        img_suitace = findViewById(R.id.img_suitace);
        img_brush = findViewById(R.id.img_brush);
        img_rocket = findViewById(R.id.img_rocket);

        // View Native App
        txtIt_takes_amost_native = findViewById(R.id.txtIt_takes_amost_native);
                txt18weeks_native =  findViewById(R.id.txt18weeks_native);
                txt_todevelop_native = findViewById(R.id.txt_todevelop_native);
                txt_native_mobile_app = findViewById(R.id.txt_native_mobile_app);
        txt_IT_ALSO_TAKES =  findViewById(R.id.txt_IT_ALSO_TAKES);
                txt_18_WEEKS_NATIVE_APP =  findViewById(R.id.txt_18_WEEKS_NATIVE_APP);
        img_NATIVE_APP = findViewById(R.id.img_native_app);

        //txtIt_takes_amost_native.setTypeface(typeface);
        txt18weeks_native.setTypeface(typeface_Bold);
        //txt_todevelop_native.setTypeface(typeface);
        txt_native_mobile_app.setTypeface(typeface_Bold);
        txt_IT_ALSO_TAKES.setTypeface(typeface_Bold);
        txt_18_WEEKS_NATIVE_APP.setTypeface(typeface);



        // View Back End
        txtIt_takes_backend = findViewById(R.id.txtIt_takes_backend);
        txt_10_weeks_backend =  findViewById(R.id.txt_10_weeks_backend);
        txt_build_the_backend = findViewById(R.id.txt_build_the_backend);
        txt_Back_end = findViewById(R.id.txt_Back_end);
        txt_TO_PRODUCE =  findViewById(R.id.txt_TO_PRODUCE);
        txt_168_NORMAL_CARS =  findViewById(R.id.txt_168_NORMAL_CARS);
        img_BACK_END = findViewById(R.id.img_BACK_END);

        //txtIt_takes_backend.setTypeface(typeface);
        txt_10_weeks_backend.setTypeface(typeface_Bold);
        //txt_build_the_backend.setTypeface(typeface);
        txt_Back_end.setTypeface(typeface_Bold);
        txt_TO_PRODUCE.setTypeface(typeface_Bold);
        txt_168_NORMAL_CARS.setTypeface(typeface);

        // View Front End
        txt_And_front_end = findViewById(R.id.txt_And_front_end);
        txt_08_week_front_end =  findViewById(R.id.txt_08_week_front_end);
        txt_build_the_front_end = findViewById(R.id.txt_build_the_front_end);
        txt_Front_end = findViewById(R.id.txt_Front_end);
        txt_TO_BIULD_FRONT_END =  findViewById(R.id.txt_TO_BIULD_FRONT_END);
        txt_CONCRETE_POOLS =  findViewById(R.id.txt_CONCRETE_POOLS);
        img_FRONT_END = findViewById(R.id.img_FRONT_END);

        //txt_And_front_end.setTypeface(typeface);
        txt_08_week_front_end.setTypeface(typeface_Bold);
        //txt_build_the_front_end.setTypeface(typeface);
        txt_Front_end.setTypeface(typeface_Bold);
        txt_TO_BIULD_FRONT_END.setTypeface(typeface_Bold);
        txt_CONCRETE_POOLS.setTypeface(typeface);
    }
}
