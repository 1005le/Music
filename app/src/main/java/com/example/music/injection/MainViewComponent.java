package com.example.music.injection;

import com.example.music.presenter.MainPresenter;
import com.example.music.view.impl.MainActivity;
import com.example.music.view.impl.SongFragment;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = MainViewModule.class)
public interface MainViewComponent {

     void inject(MainActivity activity);
     void inject(SongFragment songFragment);

   //  MainPresenter getMainPresenter();

}
