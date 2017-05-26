package com.demotrying.lannet.retrofitwithrxjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.demotrying.lannet.retrofitwithrxjava.R;
import com.demotrying.lannet.retrofitwithrxjava.model.Fixtures;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pooja on 12/15/2016.
 */

public class MyReportAdapter extends ArrayAdapter {
    List list = new ArrayList();
    public MyReportAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class DataHolder {
        TextView homeTeamName, goalsHomeTeam,awayTeamName,goalsAwayTeam,matchday;

    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public void clear() {
        list.clear();
        super.clear();
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        final MyReportAdapter.DataHolder dataHolder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.fixturelayout, parent, false);
            dataHolder = new MyReportAdapter.DataHolder();
            dataHolder.homeTeamName=(TextView)row.findViewById(R.id.homeTeamName);
            dataHolder.goalsHomeTeam=(TextView)row.findViewById(R.id.goalsHomeTeam);
            dataHolder.awayTeamName=(TextView)row.findViewById(R.id.awayTeamName);
            dataHolder.goalsAwayTeam=(TextView)row.findViewById(R.id.goalsAwayTeam);
            dataHolder.matchday=(TextView)row.findViewById(R.id.matchday);
            row.setTag(dataHolder);

        } else {
            dataHolder = (MyReportAdapter.DataHolder) row.getTag();

            //  ((DataHolder) row.getTag()).hit.setTag(list.get(position));
        }

        Fixtures model = (Fixtures) this.getItem(position);
       /*// dataHolder.serial_name.setText(model.getName());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            dataHolder.hit.setBackgroundDrawable(model.getResource());

        }*/

        dataHolder.homeTeamName.setText(model.getHomeTeamName());
        dataHolder.goalsHomeTeam.setText(model.getGoalsHomeTeam());
        dataHolder.awayTeamName.setText(model.getAwayTeamName());
        dataHolder.goalsAwayTeam.setText(model.getGoalsAwayTeam());
dataHolder.matchday.setText(model.getMatchday());
        //dataHolder.hit.setPadding(padding, padding, padding, padding);
      /*  dataHolder.hit.setScaleType(ImageView.ScaleType.FIT_XY);
        dataHolder.hit.setImageResource(R.drawable.food);
        new LoadImage(dataHolder.hit).execute(model.getImgurl());*/
        return row;
    }
}
