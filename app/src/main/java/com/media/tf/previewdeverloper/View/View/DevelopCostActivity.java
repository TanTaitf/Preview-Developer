package com.media.tf.previewdeverloper.View.View;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import com.media.tf.previewdeverloper.R;

import static com.media.tf.previewdeverloper.View.Model.Config.setFont;
import static com.media.tf.previewdeverloper.View.Model.Config.setFont_Bold;
import static com.media.tf.previewdeverloper.View.Model.Config.setFont_TextView;

public class DevelopCostActivity extends Activity {

    TextView txt_APP_COST_DEV,txt_Cost_App,txtFeature_Rate;
    TextView txt_small_app,txt_small_app_cost,txt_Complex_App,txt_Complex_App_Cost,txt_Gaming_App,txt_Gaming_App_Cost;
    Typeface typeface_Bold, typeface, typeface_item;

    // View Available App
    TextView txt_AVAILIABLE_APP,txt_Available_App_Developement,txt_Available_App,txt_milion_android,txt_ANDROID,
            txt_milion_ios,txt_IOS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_develop_cost);
        typeface = setFont(this, typeface);
        typeface_Bold = setFont_Bold(this, typeface_Bold);
        typeface_item = setFont_TextView(this, typeface_item);
        InitView();

    }
    private void InitView() {
        txt_APP_COST_DEV = findViewById(R.id.txt_APP_COST_DEV);
        txt_Cost_App = findViewById(R.id.txt_Cost_App);
        txtFeature_Rate = findViewById(R.id.txtFeature_Rate);
        txt_small_app = findViewById(R.id.txt_small_app);
        txt_small_app_cost = findViewById(R.id.txt_small_app_cost);
        txt_Complex_App = findViewById(R.id.txt_Complex_App);
        txt_Complex_App_Cost = findViewById(R.id.txt_Complex_App_Cost);
        txt_Gaming_App = findViewById(R.id.txt_Gaming_App);
        txt_Gaming_App_Cost = findViewById(R.id.txt_Gaming_App_Cost);


        txt_APP_COST_DEV.setTypeface(typeface);
        txt_Cost_App.setTypeface(typeface);
        txtFeature_Rate.setTypeface(typeface_item);
        txt_small_app.setTypeface(typeface_item);
        txt_small_app_cost.setTypeface(typeface_item);

        txt_Complex_App.setTypeface(typeface_item);
        txt_Complex_App_Cost.setTypeface(typeface_item);
        txt_Gaming_App.setTypeface(typeface_item);
        txt_Gaming_App_Cost.setTypeface(typeface_item);

        // View Available App
        txt_AVAILIABLE_APP = findViewById(R.id.txt_AVAILIABLE_APP);
        txt_Available_App_Developement = findViewById(R.id.txt_Available_App_Developement);
        txt_Available_App = findViewById(R.id.txt_Available_App);
        txt_milion_android = findViewById(R.id.txt_milion_android);
        txt_ANDROID = findViewById(R.id.txt_ANDROID);
        txt_milion_ios = findViewById(R.id.txt_milion_ios);
        txt_IOS = findViewById(R.id.txt_IOS);

        txt_AVAILIABLE_APP.setTypeface(typeface);
        txt_Available_App_Developement.setTypeface(typeface_item);
        txt_Available_App.setTypeface(typeface_item);
        txt_ANDROID.setTypeface(typeface_item);

        txt_IOS.setTypeface(typeface_item);
        txt_milion_android.setTypeface(typeface_item);
        txt_milion_ios.setTypeface(typeface_item);
    }
}
