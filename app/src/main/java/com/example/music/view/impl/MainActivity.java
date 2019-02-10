package com.example.music.view.impl;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.music.R;
import com.example.music.adapter.MainViewAdapter;
import com.example.music.injection.AppComponent;
import com.example.music.injection.DaggerMainViewComponent;
import com.example.music.injection.MainViewModule;
import com.example.music.model.Song;
import com.example.music.view.MainView;

import java.util.ArrayList;
import java.util.List;

import static com.example.music.view.impl.SongFragment.songAdapter;
import static com.example.music.view.impl.SongFragment.songList;

public class MainActivity extends BaseActivity implements MainView{

    TabLayout tabLayout;
    ViewPager viewPager;
    DrawerLayout drawerLayout;
    Toolbar toolbarMainActivity;
    LinearLayout linearLayoutBottom;
    TextView tvNameSong;
    TextView tvNameArtist;
    ImageButton imgPause;
    public static Song song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        init();
        initTab();
        act();
    }

    @Override
    protected void setupComponent(AppComponent appComponent) {
        DaggerMainViewComponent.builder()
                .appComponent(appComponent)
                .mainViewModule(new MainViewModule(this))
                .build()
                .inject(this);
    }

    private void act() {
        setSupportActionBar(toolbarMainActivity);
        getSupportActionBar().setTitle(getString(R.string.beauty));
    }
    /**
     * Khai báo các Tab
     */
    private void initTab() {
        MainViewAdapter mainViewAdapter = new MainViewAdapter(getSupportFragmentManager());

        mainViewAdapter.addFragment(new SongFragment(),getString(R.string.song));
        mainViewAdapter.addFragment(new AlbumFragment(),getString(R.string.album));
        mainViewAdapter.addFragment(new ArtistFragment(), getString(R.string.artist));
        viewPager.setAdapter(mainViewAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void init() {
        tabLayout = findViewById(R.id.myTabLayout);
        drawerLayout = findViewById(R.id.drawerLayout);
        toolbarMainActivity = findViewById(R.id.toolBarMainActivity);
        viewPager = findViewById(R.id.myViewPager);

        //Khởi tạo layout bottom
        linearLayoutBottom = findViewById(R.id.linearBottom);
        tvNameSong = findViewById(R.id.tvNameSong);
        tvNameArtist = findViewById(R.id.tvNameArtist);
        imgPause = findViewById(R.id.imgButtonPause);
    }
    private void getDataBottom() {
     /*   tvNameSong.setText(PlayActivity.song.getName());
        tvNameArtist.setText(PlayActivity.song.getNameArtist());
        imgPause.setImageResource(R.drawable.ic_pause);*/

//        if(song.getName().length() > 0 && song.getNameArtist().length() >0) {
//            linearLayoutBottom.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(MainActivity.this, PlayActivity.class);
//                    intent.putExtra("song", song);
//                    startActivity(intent);
//                }
//            });
//        }
    }

    /**
     * khoi tao search
     */
    @Override
    public boolean onCreateOptionsMenu( Menu menu) {
        getMenuInflater().inflate( R.menu.search_view, menu);

        final MenuItem myActionMenuItem = menu.findItem( R.id.menu_search);
        final SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(!searchView.isIconified()){
                    searchView.setIconified(true);
                }
                myActionMenuItem.collapseActionView();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String searchQuery) {
                final List<Song>filterModel = filter(songList, searchQuery);
                songAdapter.getFilte(filterModel);
                return true;

            }
        });
        return true;
    }

    @Override
    public void showSong(ArrayList<Song> songs) {
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private List<Song> filter(List<Song>listItem, String query){

        query = query.toLowerCase();
        final List<Song>filterModel = new ArrayList<>();

        for( Song item :listItem){
            final String text = item.getName().toLowerCase();
            if( text.startsWith(query)){
                filterModel.add(item);
            }
        }
        return filterModel;
    }
}
