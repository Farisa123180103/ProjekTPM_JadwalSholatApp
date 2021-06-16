package com.example.jadwalsholat.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {SaranModel.class}, version = 1)
public abstract class DatabaseSaran extends RoomDatabase {

    private static DatabaseSaran databaseSaran;

    public abstract DataSaranDAO saranDAO();

    public static DatabaseSaran initDbs(Context context){
        if (databaseSaran == null){
            databaseSaran = Room.databaseBuilder(
                    context,
                    DatabaseSaran.class,
                    "saran"
            ).allowMainThreadQueries().build();
        }

        return databaseSaran;
    }

}


