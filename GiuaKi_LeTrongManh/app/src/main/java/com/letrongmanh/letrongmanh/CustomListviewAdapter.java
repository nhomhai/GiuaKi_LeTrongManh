package com.letrongmanh.letrongmanh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomListviewAdapter extends BaseAdapter {
    private List<Coin> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListviewAdapter(Context aContext,  List<Coin> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.custom_coin, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.textView_name);
            holder.price = (TextView) convertView.findViewById(R.id.textView_price);
            holder.delete = (Button) convertView.findViewById(R.id.button_delete);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Coin coin = this.listData.get(position);
        holder.delete.setTag((Integer)position);
        holder.name.setText(coin.getName());
        holder.price.setText(coin.getPrice());

        return convertView;
    }
    static class ViewHolder {
        TextView name;
        TextView price;
        Button delete;
    }
}
