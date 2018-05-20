package com.media.tf.previewdeverloper.View.View;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.media.tf.previewdeverloper.R;
import com.media.tf.previewdeverloper.View.Controller.ProcessAdapter;
import com.media.tf.previewdeverloper.View.Model.ClassProcess;

import java.util.ArrayList;

import static com.media.tf.previewdeverloper.View.Model.Config.setFont;
import static com.media.tf.previewdeverloper.View.Model.Config.setFont_Bold;

public class DevelopProcessActivity extends Activity {
    private Window window;
    // View top
    TextView txt_APP_DEV_PROCESS, txt_BACKEND_DEV, txt_FRONTEND_DEV;
    Typeface typeface_Bold, typeface;
    ListView lvAppDevProcess, lvBackEnd, lvFrontEnd;
    // Layout main Process
    LinearLayout layout_app_dev_process;

    ArrayList<ClassProcess> arrayList_dev_pro, arrayList_back_end, arrayList_front_end;
    ProcessAdapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_develop_process);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.bg_blue));
        }
        typeface = setFont(this, typeface);
        typeface_Bold = setFont_Bold(this, typeface_Bold);
        InitView();
        addArray();
        adapter = new ProcessAdapter(this,R.layout.custom_item_list_process, arrayList_dev_pro);
        lvAppDevProcess.setAdapter(adapter);
        adapter = new ProcessAdapter(this,R.layout.custom_item_list_process, arrayList_back_end);
        lvBackEnd.setAdapter(adapter);
        adapter = new ProcessAdapter(this,R.layout.custom_item_list_process, arrayList_front_end);
        lvFrontEnd.setAdapter(adapter);
    }
    private void InitView() {
        txt_APP_DEV_PROCESS = (TextView) findViewById(R.id.txt_APP_DEV_PROCESS);
        txt_BACKEND_DEV = (TextView) findViewById(R.id.txt_BACKEND_DEV);
        txt_FRONTEND_DEV = (TextView) findViewById(R.id.txt_FRONTEND_DEV);
        lvAppDevProcess = (ListView) findViewById(R.id.list_item_top);
        lvBackEnd = (ListView) findViewById(R.id.list_item_back_end);
        lvFrontEnd = (ListView) findViewById(R.id.list_item_front_end);

        txt_APP_DEV_PROCESS.setTypeface(typeface);
        txt_BACKEND_DEV.setTypeface(typeface);
        txt_FRONTEND_DEV.setTypeface(typeface);

    }
    public void addArray()
    {
        arrayList_dev_pro = new ArrayList<>();
        arrayList_back_end = new ArrayList<>();
        arrayList_front_end = new ArrayList<>();

        arrayList_dev_pro.add(new ClassProcess("Defining a clear goal", "You must clearlu define the purpose and mission ò your mobile app", R.drawable.ic_goal));
        arrayList_dev_pro.add(new ClassProcess("Wireframe creation of the app", "You ideas and features takes a clearer picture with wirefrane creation(mokup or prototype)", R.drawable.browser));

        arrayList_back_end.add(new ClassProcess("Defining the back-end tructure", "Setting up the back-end & creation of building bloack of an app", R.drawable.ic_hierarchy));
        arrayList_back_end.add(new ClassProcess("Management of users", "Managing user account and their authentication", R.drawable.ic_group));
        arrayList_back_end.add(new ClassProcess("Server side logic", "A server sude logic is developed that is use to create the back end of the app", R.drawable.puzzle));
        arrayList_back_end.add(new ClassProcess("Customization of user experience", "The customization of user experience decides how a user goes through the entire application", R.drawable.settings));
        arrayList_back_end.add(new ClassProcess("Data integration", "It allows users to access and share infomation to 3rd party website such as social networking site", R.drawable.ic_database));
        arrayList_back_end.add(new ClassProcess("Push notification services", "Development of push notification services that engage the user with the app", R.drawable.notifications));

        arrayList_front_end.add(new ClassProcess("Caching of Data", "Creation of services that stores the data locally to improve the speed of the app", R.drawable.credit_card));
        arrayList_front_end.add(new ClassProcess("Synchronization of app data", "This phase brings the data together so that it can be accessed offline", R.drawable.ic_analyze));
        arrayList_front_end.add(new ClassProcess("Mock ups and wire-framing", "Mock-up and wire-framing is developed that clear up the picture of the user inreface of the app", R.drawable.browser));
        arrayList_front_end.add(new ClassProcess("UI Design and Development", "UI is designed and then translated into fuctioning user interface tat is ready to be implated", R.drawable.ic_art_palette));
        arrayList_front_end.add(new ClassProcess("UI Improvements", "The improvements in UI are done (if needed)", R.drawable.ic_symbol));
        arrayList_front_end.add(new ClassProcess("Testing", "Quality assurance phase finds out the bugs and remove them to make the perfect app.", R.drawable.tube));
        arrayList_front_end.add(new ClassProcess("Deployment", "After a detailed testing the app is finally deployed", R.drawable.ic_rocket_fill));

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
//      set anim for activity on change
//        YoYo.with(Techniques.SlideOutRight)
//                .duration(350)
//                .withListener(new Animator.AnimatorListener() {
//                    @Override
//                    public void onAnimationStart(Animator animation) {
//
//                    }
//
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//                        //finish();
//                        startActivity(new Intent(DevelopProcessActivity.this, MainActivity.class));
//                        DevelopProcessActivity.this.finish();
//
//                    }
//
//                    @Override
//                    public void onAnimationCancel(Animator animation) {
//                    }
//
//                    @Override
//                    public void onAnimationRepeat(Animator animation) {
//
//                    }
//                })
//                .playOn(findViewById(R.id.layout_app_dev_process));

    }
}
