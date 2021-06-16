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

public class JadwalSholatAdapter extends RecyclerView.Adapter<JadwalSholatAdapter.viewHolder> {

    private ArrayList<DataItem> data = new ArrayList<>();
    private Context context;


    public JadwalSholatAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<DataItem> items){
        data.clear();
        data.addAll(items);
        notifyDataSetChanged();

    }


    @NonNull
    @Override
    public JadwalSholatAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalSholatAdapter.viewHolder holder, final int position) {

        holder.tv_tanggal_value.setText(data.get(position).getDate().getReadable());
        CardView cardView = holder.cv_item;

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent = new Intent(context, JadwalSholatDetail.class);

                intent.putExtra("tvFajr", data.get(position).getTimings().getFajr());
                intent.putExtra("tvDhuhr",data.get(position).getTimings().getDhuhr());
                intent.putExtra("tvAsr",data.get(position).getTimings().getAsr());
                intent.putExtra("tvMaghrib",data.get(position).getTimings().getMaghrib());
                intent.putExtra("tvIsha",data.get(position).getTimings().getIsha());
                intent.putExtra("tvImsak",data.get(position).getTimings().getImsak());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { return data.size(); }



    public class viewHolder extends RecyclerView.ViewHolder {

        TextView   tv_tanggal_value;
        CardView cv_item;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            cv_item = itemView.findViewById(R.id.itemlist_cv);
            tv_tanggal_value= itemView.findViewById(R.id.tv_tanggal_value);
        }
    }
}
