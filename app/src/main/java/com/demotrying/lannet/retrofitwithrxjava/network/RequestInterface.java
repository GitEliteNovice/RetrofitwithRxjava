package com.demotrying.lannet.retrofitwithrxjava.network;

import com.demotrying.lannet.retrofitwithrxjava.model.Fixtures;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RequestInterface {
    @GET("v1/fixtures")
    Observable<List<Fixtures>> fixtures();
}
