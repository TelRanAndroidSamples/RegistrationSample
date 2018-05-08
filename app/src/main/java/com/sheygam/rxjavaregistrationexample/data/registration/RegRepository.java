package com.sheygam.rxjavaregistrationexample.data.registration;

import com.sheygam.rxjavaregistrationexample.data.dto.RegRequestDto;
import com.sheygam.rxjavaregistrationexample.data.dto.RegResponseDto;
import com.sheygam.rxjavaregistrationexample.data.provider.store.SprefProvider;
import com.sheygam.rxjavaregistrationexample.data.provider.web.Api;

import io.reactivex.Completable;
import retrofit2.Response;

public class RegRepository implements IRegRepository {
    private Api api;
    private SprefProvider storeProvider;

    public RegRepository(Api api, SprefProvider storeProvider) {
        this.api = api;
        this.storeProvider = storeProvider;
    }

    @Override
    public Completable registration(String email, String password) {
        RegRequestDto requestDto = new RegRequestDto(email,password);
        return Completable.fromSingle(api.registration(requestDto)
                .doOnSuccess(this::saveToken));

    }

    private void saveToken(Response<RegResponseDto> response) throws Exception {
        if(response.isSuccessful()){
            storeProvider.saveToken(response.body().getToken());
        }else if(response.code() == 409){
            throw new Exception("User already exist");
        }else{
            throw new Exception("Server error");
        }
    }
}
