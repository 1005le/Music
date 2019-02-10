package com.example.music.view.impl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.music.MusicApplication;
import com.example.music.injection.AppComponent;

public abstract class BaseActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent((AppComponent) MusicApplication.get(this).component());
    }

    protected abstract void setupComponent(AppComponent appComponent);
}
