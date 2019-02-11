package com.example.music.interactor.impl;

import android.content.Context;
import android.os.Handler;

import com.example.music.interactor.MainInteractor;
import com.example.music.model.Song;
import com.example.music.view.impl.SongFragment;

import java.util.ArrayList;
import java.util.List;

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

    private  ArrayList<Song> createArrayList() {
        ArrayList<Song> songs = SongFragment.songList;
       // mainInteractor.onLoadSongSuccess(songs);
        return songs;
    }

    public void getSongCategories(final MainInteractor mainInteractor) {

                mainInteractor.onLoadSongSuccess(createArrayList());
    }

    public void createData(){
        ArrayList<Song> songs = new ArrayList<>();
        mainInteractor.onLoadSongSuccess(songs);
    }

}
