package com.example.jadwalsholat.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DataSaranDAO {

    @Insert
    long insertSaran(SaranModel saranModel);

    @Delete
    int deleteSaran(SaranModel saranModel);

    @Query("SELECT * FROM data_saran")
    List<SaranModel> getSaransaran();


}