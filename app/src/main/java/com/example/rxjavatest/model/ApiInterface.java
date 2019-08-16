package com.example.rxjavatest.model;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    //http://api.duckduckgo.com/?q=simpsons+characters&format=json
    @GET("?")
    Observable<SimpsonResult>
        getSimpsonResult(
                @Query("q") String queryParam,
                @Query("format") String formatParam);
}
