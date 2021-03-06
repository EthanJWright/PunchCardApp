package com.example.ethanwright.javapunchcard;

/**
 * Created by ethanwright on 5/28/17.
 */

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ChartsAdapter extends ArrayAdapter<CurrentReportView>{
    private int layoutResource;


    public ChartsAdapter(Context context, int layoutResource, ArrayList<CurrentReportView> report) {
        super(context, layoutResource, report);
        this.layoutResource = layoutResource;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //4
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.list_item_punch, null);
        }

        final CurrentReportView p = getItem(position);

        if (p != null) {
            int initial_color = Colors.light_color;
            v.setBackgroundColor(initial_color);
            Typeface roboto_thin = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Thin.ttf");
            TextView tt1 = (TextView) v.findViewById(R.id.list_title);
            TextView tt2 = (TextView) v.findViewById(R.id.list_subtitle);
            TextView tt3 = (TextView) v.findViewById(R.id.list_detail);
            tt1.setTypeface(roboto_thin);
            tt2.setTypeface(roboto_thin);
            tt3.setTypeface(roboto_thin);




            if (tt1 != null) {
                String results = "Start Time: \n" + p.getStartTime().toString();
                tt1.setText(results);
            }
            if(tt2 != null){
                String results = "End Time: \n" + p.getEndTime().toString();
                tt2.setText(results);
            }
            if(tt3 != null){
                FormatTime ftime = new FormatTime();
                long time = p.getTotalTime();
                tt3.setText("Worked: " + ftime.getTime(time));
            }


        }

        return v;
    }

}

