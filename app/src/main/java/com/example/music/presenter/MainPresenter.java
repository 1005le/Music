package com.example.music.presenter;

import com.example.music.model.Song;


public interface MainPresenter {
    void loadData();
    void onItemSelected(Song song, int position);
}
