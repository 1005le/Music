package com.example.music.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.music.R;
import com.example.music.model.Song;
import com.example.music.view.impl.SongFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static butterknife.ButterKnife.bind;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {
    Context context;
    ArrayList<Song> songList;

    private ItemClickListener itemClickListener;

    public SongAdapter(Context context, ArrayList<Song> songList) {
        this.context = context;
        this.songList = songList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_song, viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder,final int i) {

   //  final Song song = songList.get(i);
        final Song song = SongFragment.songList.get(i);
        //  Log.d("hello3",songList.size()+"\n"+songList.get(3).getName()+"\n"+song.getNameArtist());
        viewHolder.tvNameSong.setText(song.getName());
        viewHolder.tvNameArtist.setText(song.getNameArtist());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(song, i);
                }
                Log.d("hello",song.getName()+"-" +song.getNameArtist());
               // Toast.makeText(context, "hello", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(context, PlayActivity.class);
//                    intent.putExtra("song", songList.get(getPosition()));
//                    context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }
    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(Song song, int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tvName)
        TextView tvNameSong;

        @BindView(R.id.tvNameArtist)
        TextView tvNameArtist;

        @BindView(R.id.imgSong)
        ImageView imgSong;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bind(this, itemView);

        }
    }

    public void getFilte(List<Song> listItem){
        songList = new ArrayList<>();
        songList.addAll(listItem);
        notifyDataSetChanged();
    }

//    public class ViewHolder extends RecyclerView.ViewHolder {
//        ImageView imgRecycle;
//        TextView tvName;
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            imgRecycle = itemView.findViewById(R.id.imgDauPhu);
//            tvName = itemView.findViewById(R.id.tvNameDauPhu);
//
//        }
//    }
}
