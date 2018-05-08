package com.sheygam.rxjavaregistrationexample.data.provider.web;

import com.sheygam.rxjavaregistrationexample.data.dto.RegRequestDto;
import com.sheygam.rxjavaregistrationexample.data.dto.RegResponseDto;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {
    @POST("_ah/api/contactsApi/v1/registration")
    Single<Response<RegResponseDto>> registration(@Body RegRequestDto body);
}
