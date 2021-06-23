package com.example.jadwalsholat.view.fragmen;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jadwalsholat.R;
import com.example.jadwalsholat.adapter.JadwalSholatAdapter;
import com.example.jadwalsholat.adapter.SaranAdapter;
import com.example.jadwalsholat.database.DatabaseSaran;
import com.example.jadwalsholat.database.SaranModel;
import com.example.jadwalsholat.view.activity.MainActivity;
import com.example.jadwalsholat.view.viewmodel.JadwalViewModel;

import java.util.ArrayList;
import java.util.List;

public class SaranFragment extends Fragment {
    private RecyclerView rvSaran;
    private SaranAdapter saranAdapter;
    private DatabaseSaran databaseSaran;
    private ArrayList<SaranModel> listSaran = new ArrayList<>();

    Button submit;
    EditText etNama, etSaran;

    public SaranFragment() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        submit = view.findViewById(R.id.activitykritik_btn_simpan);
        etNama = view.findViewById(R.id.activitykritik_et_nama);
        etSaran = view.findViewById(R.id.activitykritik_et_nama);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    SaranModel saranModel = new SaranModel();
                    saranModel.setNama(etNama.getText().toString());
                    saranModel.setSaran(etSaran.getText().toString());

                    databaseSaran.saranDAO().insertSaran(saranModel);

                    Log.d("SaranActivity" , "sukses ");
                    Toast.makeText(getContext(),"Tersimpan", Toast.LENGTH_SHORT).show();

                }catch (Exception ex){
                    Log.e("SaranActivity" , "gagal menyimpan , msg : "+ex.getMessage());
                    Toast.makeText(getContext(),"Gagal Menyimpan", Toast.LENGTH_SHORT).show();
                }
            }
        });

        rvSaran = view.findViewById(R.id.rv_saran);
        saranAdapter = new SaranAdapter(getContext());
        saranAdapter.notifyDataSetChanged();

        if (databaseSaran == null){
            databaseSaran = DatabaseSaran.initDbs(getContext());
        }

        listSaran.addAll(databaseSaran.saranDAO().getSaransaran());
        saranAdapter.setData(listSaran);

        rvSaran.setLayoutManager(new LinearLayoutManager(getContext()));
        rvSaran.setAdapter(saranAdapter);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_saran, container, false);
    }

}