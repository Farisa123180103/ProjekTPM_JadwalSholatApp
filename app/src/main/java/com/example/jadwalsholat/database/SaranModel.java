package com.example.jadwalsholat.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "data_saran")
public class SaranModel {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "nama")
    private String nama;

    @ColumnInfo(name = "saran")
    private String saran;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {

        return nama;
    }

    public void setNama(String nama) {

        this.nama = nama;
    }


    public String getSaran() {
        return saran;}

    public void setSaran(String saran){
        this.saran = saran;}




}