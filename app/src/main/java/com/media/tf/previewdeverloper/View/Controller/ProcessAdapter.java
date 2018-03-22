package com.media.tf.previewdeverloper.View.Controller;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.media.tf.previewdeverloper.R;
import com.media.tf.previewdeverloper.View.Model.ClassProcess;

import java.util.List;

import static com.media.tf.previewdeverloper.View.Model.Config.setFont_Item;

/**
 * Created by VP-T on 4/5/2017.
 */

public class ProcessAdapter extends BaseAdapter{

    private Context context;
    private int layout;
    private List<ClassProcess> List;
    Typeface typeface;
    public ProcessAdapter(Context context, int layout, List<ClassProcess> list) {
        this.context = context;
        this.layout = layout;
        List = list;
        typeface = setFont_Item(context, typeface);
    }

    @Override
    public int getCount() {
        return List.size(); // hay quên
    }

    @Override
    public Object getItem(int position) { // hay quên
        return List.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class viewHolder
    {
        TextView txtTen, textMota;
        ImageView hinhanh;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        viewHolder viewHolder;
        // sử dụng viewHolder để set layout (không cần ánh xạ lại...tiết kiệm)
        if (convertView == null)
        {
            viewHolder = new viewHolder();
           LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = inflater.inflate(layout,null);
            convertView = inflater.inflate(layout,parent,false);


            // ánh xạ view hiển thị trên list từ dòng
             viewHolder.txtTen = (TextView) convertView.findViewById(R.id.textViewten);
             viewHolder.textMota = (TextView) convertView.findViewById(R.id.textViewmota);
            viewHolder.txtTen.setTypeface(typeface);
            viewHolder.textMota.setTypeface(typeface);
             viewHolder.hinhanh = (ImageView)convertView.findViewById(R.id.imageViewpicture);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (viewHolder) convertView.getTag();
        }


        // gán dữ liệu lên view
        ClassProcess process = (ClassProcess) getItem(position);
        viewHolder.txtTen.setText(process.getTitle());
        viewHolder.textMota.setText(process.getDricption());
        viewHolder.hinhanh.setImageResource(process.getLinkimg());

        // gan hieu ung
        //Animation animAlpha = AnimationUtils.loadAnimation(context,R.anim.demo_scale);
        //Animation animAlpha = AnimationUtils.loadAnimation(context,R.anim.demo_rotate);
        //convertView.startAnimation(animAlpha);
        return convertView;
    }
}
