package com.example.music.interactor.impl;

import android.content.Context;

import com.example.music.interactor.MainInteractor;
import com.example.music.model.Song;

import java.util.ArrayList;

import javax.inject.Inject;

/*
 *- Lớp M: xử lý dữ liệu -> Trả dữ liệu về P thông qua callback
 * */

public class MainInteractorImpl {

    @Inject
    public MainInteractorImpl() {
    }
    private MainInteractor mainInteractor;
     Context context;

    public MainInteractorImpl(MainInteractor mainInteractor){
        this.mainInteractor = mainInteractor;
    }


    public void createData(){
      ArrayList<Song> songs = new ArrayList<>();
        mainInteractor.onLoadSongSuccess(songs);
    }

}
