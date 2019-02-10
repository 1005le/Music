package com.example.music.presenter.impl;

import android.widget.Toast;

import com.example.music.interactor.MainInteractor;
import com.example.music.interactor.impl.MainInteractorImpl;
import com.example.music.model.Song;
import com.example.music.presenter.MainPresenter;
import com.example.music.view.MainView;

import java.util.ArrayList;

/**
  * - Presenter: xử lý logic từ dữ liệu nhận được.
  * - Nhận dữ liệu từ lớp Model
  * - Đẩy dữ liệu lên lớp V.
 */
public class MainPresenterImpl implements MainInteractor, MainPresenter {
    private MainInteractorImpl mainInteractorImpl;
    private MainView mainView;

    public MainPresenterImpl(MainInteractorImpl mainInteractorImpl, MainView mainView) {
        this.mainInteractorImpl = mainInteractorImpl;
        this.mainView = mainView;
    }

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
        mainInteractorImpl = new MainInteractorImpl(this);
    }

    @Override
    public void onLoadSongSuccess(ArrayList<Song> songs) {
        mainView.showSong(songs);
    }

    @Override
    public void onLoadSongFailue(String message) {
    }

    @Override
    public void loadData() {
        mainInteractorImpl.createData();
    }

    @Override
    public void onItemSelected(Song song, int position) {
        mainView.showMessage(String.format(song.getName() + " ->" + " Position %d clicked", position));
    }
}
