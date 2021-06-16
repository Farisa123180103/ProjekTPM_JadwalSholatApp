package com.example.jadwalsholat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.example.jadwalsholat.R;
import com.example.jadwalsholat.database.DatabaseSaran;
import com.example.jadwalsholat.database.SaranModel;

public class SaranAdapter extends RecyclerView.Adapter<SaranAdapter.ViewHolder> {


    private Context context;
    private ArrayList<SaranModel> saranItems = new ArrayList<>();
    private DatabaseSaran databaseSaran;

    public SaranAdapter(Context context){
        this.context = context;
        databaseSaran = DatabaseSaran.initDbs(this.context);
    }

    public void setData(ArrayList<SaranModel> items){
        saranItems.clear();
        saranItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SaranAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist_saran,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SaranAdapter.ViewHolder holder, final int position) {

        holder.tvNama.setText(saranItems.get(position).getNama());
        holder.tvSaran.setText(saranItems.get(position).getSaran());
    }

    @Override
    public int getItemCount() {
        return saranItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama,tvSaran;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            tvNama = itemView.findViewById(R.id.itemlist_saran_tv_nama);
            tvSaran = itemView.findViewById(R.id.itemlist_saran_tv_saran);

        }
    }
}
