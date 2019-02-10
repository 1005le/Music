package com.example.music.injection;

import com.example.music.interactor.impl.MainInteractorImpl;
import com.example.music.presenter.impl.MainPresenterImpl;
import com.example.music.view.MainView;

import dagger.Module;
import dagger.Provides;

@Module
public class MainViewModule {

    private MainView mainView;
    public MainViewModule(MainView view) {
        this.mainView = view;
    }

    @Provides
    public MainView provideView() {
        return mainView;
    }

    @Provides
    public MainPresenterImpl providePresenter(MainView mainView, MainInteractorImpl mainInteractorImpl) {
        return new MainPresenterImpl(mainInteractorImpl, mainView);
    }
}
