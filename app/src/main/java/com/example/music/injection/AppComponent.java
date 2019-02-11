package com.example.music.injection;

import com.example.music.MusicApplication;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { AppModule.class})
public interface AppComponent {

    void inject(MusicApplication musicApplication);
}
