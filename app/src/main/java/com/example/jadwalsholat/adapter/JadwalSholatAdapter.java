package com.example.jadwalsholat.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jadwalsholat.R;
import com.example.jadwalsholat.model.jadwal.DataItem;
import com.example.jadwalsholat.view.activity.JadwalSholatDetail;

import java.util.ArrayList;

public class JadwalSholatAdapter extends RecyclerView.Adapter<JadwalSholatAdapter.ViewHolder>{

    private ArrayList<DataItem> dataItems = new ArrayList<>();
    private Context context;

    public JadwalSholatAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<DataItem> items){
        dataItems.clear();
        dataItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public JadwalSholatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.jadwal_solat,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalSholatAdapter.ViewHolder holder, int position) {
        holder.tgl.setText(dataItems.get(position).getDate().getReadable());

        holder.cv_tgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, JadwalSholatDetail.class);

                intent.putExtra("terbit", dataItems.get(position).getTimings().getSunrise());
                intent.putExtra("imsak", dataItems.get(position).getTimings().getImsak());
                intent.putExtra("subuh", dataItems.get(position).getTimings().getFajr());
                intent.putExtra("duhur", dataItems.get(position).getTimings().getDhuhr());
                intent.putExtra("asar", dataItems.get(position).getTimings().getAsr());
                intent.putExtra("magrib", dataItems.get(position).getTimings().getMaghrib());
                intent.putExtra("isya", dataItems.get(position).getTimings().getIsha());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tgl;
        CardView cv_tgl;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cv_tgl = itemView.findViewById(R.id.cv);
            tgl = itemView.findViewById(R.id.tv_tgl);

        }
    }
}
