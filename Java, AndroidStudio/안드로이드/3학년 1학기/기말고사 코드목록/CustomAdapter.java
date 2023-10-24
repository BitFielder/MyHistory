package com.example.imagejson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Sawon> {
    private Context context;
    private ArrayList<Sawon> sawons;

    public CustomAdapter(Context context, ArrayList<Sawon> sawons) {
        super(context, R.layout.item, sawons);
        this.context = context;
        this.sawons = sawons;
    }

    @Override
    public Sawon getItem(int position) {
        return sawons.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Sawon sawon = getItem(position);
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.image);
            holder.id = convertView.findViewById(R.id.id);
            holder.name = convertView.findViewById(R.id.name);
            holder.salary = convertView.findViewById(R.id.salary);
            holder.gender = convertView.findViewById(R.id.gender);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.id.setText(sawon.getId());
        holder.name.setText(sawon.getName());
        holder.salary.setText(String.valueOf(sawon.getSalary()));
        holder.gender.setText(sawon.getGender());

        Glide.with(context).load(sawon.getImage()).into(holder.imageView);

        return convertView;
    }

    private static class ViewHolder {
        ImageView imageView;
        TextView id;
        TextView name;
        TextView salary;
        TextView gender;
    }
}

