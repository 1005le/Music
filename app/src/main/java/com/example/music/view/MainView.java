package com.example.music.view;

import com.example.music.model.Song;

import java.util.ArrayList;

public interface MainView {
     void showSong(ArrayList<Song> songs);
     void showMessage(String message);
}
