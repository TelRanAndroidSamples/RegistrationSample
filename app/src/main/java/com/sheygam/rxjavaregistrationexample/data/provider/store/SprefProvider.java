package com.sheygam.rxjavaregistrationexample.data.provider.store;

import android.content.Context;

public class SprefProvider {
    private Context context;

    public SprefProvider(Context context) {
        this.context = context;
    }

    public void saveToken(String token){
        context.getSharedPreferences("AUTH",Context.MODE_PRIVATE)
                .edit()
                .putString("TOKEN",token)
                .apply();
    }
}
