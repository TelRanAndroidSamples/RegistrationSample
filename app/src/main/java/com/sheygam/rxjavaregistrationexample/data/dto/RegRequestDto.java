package com.sheygam.rxjavaregistrationexample.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegRequestDto {
    @SerializedName("email")
    @Expose
    private String email;

    private String password;

    public RegRequestDto() {
    }

    public RegRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
