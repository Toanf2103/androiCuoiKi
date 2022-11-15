package com.example.cuoi_ki.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.cuoi_ki.Model.Police;
import com.example.cuoi_ki.R;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    private List<Police> list;
    private Context context;
    private int layout;


    public ListViewAdapter(List<Police> list, Context context, int layout) {
        this.list = list;
        this.context = context;
        this.layout = layout;

    }

    public ListViewAdapter(List<Police> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId();
    }
    private class ViewHolder{
        TextView nameTv,levelTv,addressTv,countryTv;
        ImageView singerImg;
        RatingBar rating;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout,null);
            holder = new ViewHolder();
            holder.nameTv = convertView.findViewById(R.id.nameTv);
            holder.levelTv = convertView.findViewById(R.id.levelTv);
            holder.addressTv=convertView.findViewById(R.id.adrressTv);
            holder.countryTv = convertView.findViewById(R.id.countryTv);
            holder.singerImg = convertView.findViewById(R.id.imageSinger);
            holder.rating = convertView.findViewById(R.id.rating);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Police pl = list.get(position);
        holder.nameTv.setText("Tên: "+pl.getName());
        holder.levelTv.setText("Cấp bậc: "+ pl.getLevel());
        holder.countryTv.setText("Quốc gia: "+pl.getCountry());
        holder.addressTv.setText("Địa chỉ: "+pl.getAdrress());
        holder.singerImg.setImageResource(pl.getImage());
        holder.rating.setNumStars(5);
        holder.rating.setRating(pl.getRate());



        return convertView;
    }


}
