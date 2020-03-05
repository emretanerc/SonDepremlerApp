package com.etcmobileapps.sondepremlerapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static com.etcmobileapps.sondepremlerapi.R.drawable.*;

public class CustomListViewAdapter extends ArrayAdapter<Repo> {

    private final LayoutInflater inflater;
    private final Context context;
    private ViewHolder holder;
    private final ArrayList<Repo> depremler;



    public CustomListViewAdapter(Context context, ArrayList<Repo> depremler) {
        super(context,0, depremler);
        this.context = context;
        this.depremler = depremler;
        inflater = LayoutInflater.from(context);


    }

    @Override
    public int getCount() {
        return depremler.size();
    }

    @Override
    public Repo getItem(int position) {
        return depremler.get(position);
    }

    @Override
    public long getItemId(int position) {
        return depremler.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.row_layout, null);

            holder = new ViewHolder();

            holder.depremTarihi = (TextView) convertView.findViewById(R.id.tarihTv);
            holder.depremBuyukluk =  (TextView) convertView.findViewById(R.id.derinlikTV);
            holder.depremSehri = (TextView) convertView.findViewById(R.id.depremYeriTV);
            holder.depremSaati = (TextView) convertView.findViewById(R.id.saatTV);
            holder.depremGorsel = (TextView) convertView.findViewById(R.id.depremGorseli);
            holder.depremDerinlik = (TextView) convertView.findViewById(R.id.derinlikTV);
            convertView.setTag(holder);

        }
        else{

            holder = (ViewHolder)convertView.getTag();
        }

        Repo value = depremler.get(position);
        if(value != null){


            holder.depremBuyukluk.setText(value.buyukluk);
            holder.depremSehri.setText(value.sehir + " " + value.yer);
            holder.depremTarihi.setText(value.tarih);
            holder.depremSaati.setText(value.saat);
            holder.depremDerinlik.setText(value.derinlik + " KM");


            holder.depremGorsel.setText(value.buyukluk);
            double siddet = Double.parseDouble(value.buyukluk);
            if (siddet <= 3.0) {
holder.depremGorsel.setBackgroundResource(circle_deprem_yesil);
            } else if (siddet >= 3.0 & siddet <= 5.0)
            {
                holder.depremGorsel.setBackgroundResource(circle_deprem_turuncu);

            }
            else
            {
                holder.depremGorsel.setBackgroundResource(circle_deprem_kirmizi);
            }
        }
        return convertView;
    }

    //View Holder Pattern for better performance
    private static class ViewHolder {
        TextView depremTarihi;
        TextView depremBuyukluk;
        TextView depremSehri;
        TextView depremSaati;
        TextView depremGorsel;
        TextView depremDerinlik;

    }


}