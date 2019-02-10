package com.example.music.interactor;

import com.example.music.model.Song;

import java.util.ArrayList;

public interface MainInteractor {

    void onLoadSongSuccess(ArrayList<Song> songs);
    void onLoadSongFailue(String message);

}
