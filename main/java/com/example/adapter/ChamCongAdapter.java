package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.demoquanlychamcong.R;
import com.example.model.ChamCong;

import java.util.List;

public class ChamCongAdapter extends ArrayAdapter<ChamCong> {
    Activity context;
    int resource;
    List<ChamCong> objects;

    public StationaryAdapter(@NonNull Activity context, int resource, @NonNull List<ChamCong> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects.size();
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource, null);

        ImageView imageView = row.findViewById(R.id.iv);
        TextView tvDay = row.findViewById(R.id.tvDay);
        TextView tvSL = row.findViewById(R.id.tvSL);

        final Phieu p = this.objects.get(position);
        tvDay.setText("Ngày chấm công: " + p.getDay());
        tvSL.setText("Số lượng sp: " + p.getSl());

        return row;
    }
}
