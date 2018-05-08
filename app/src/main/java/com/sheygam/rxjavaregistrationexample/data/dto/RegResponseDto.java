package com.sheygam.rxjavaregistrationexample.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegResponseDto {
    @SerializedName("token")
    @Expose
    private String token;

    public RegResponseDto() {
    }

    public RegResponseDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
