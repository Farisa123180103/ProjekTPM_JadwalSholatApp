package com.example.jadwalsholat.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
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

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(context);
                }
                builder.setTitle("Menghapus Data")
                        .setMessage("Anda yakin ingin menghapus data ini?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                SaranModel saranModel = new SaranModel();

                                saranModel.setId(saranItems.get(position).getId());
                                saranModel.setNama(saranItems.get(position).getNama());
                                saranModel.setSaran(saranItems.get(position).getSaran());

                                databaseSaran.saranDAO().deleteSaran(saranModel);

                                Log.d("SaranAdapter", "Sukses Dihapus");
                                Toast.makeText(context, "Data Sukses Dihapus", Toast.LENGTH_SHORT).show();

                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return saranItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama,tvSaran;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.itemlist_saran_tv_nama);
            tvSaran = itemView.findViewById(R.id.itemlist_saran_tv_saran);
            cardView = itemView.findViewById(R.id.cv_saran);
        }
    }

}
