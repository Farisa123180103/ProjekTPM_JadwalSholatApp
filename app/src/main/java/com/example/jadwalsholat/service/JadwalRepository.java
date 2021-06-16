package com.example.jadwalsholat.service;

import com.example.jadwalsholat.model.jadwal.JadwalSholatResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JadwalRepository {
    @GET("v1/calendarByAddress?address=sukoharjo&method=2&month=juni&year=2021")
    Call<JadwalSholatResponse> getJadwalSholat();

}
