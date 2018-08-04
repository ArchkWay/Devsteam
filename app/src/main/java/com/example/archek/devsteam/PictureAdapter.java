package com.example.archek.devsteam;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.archek.devsteam.Network.UnsplashObjectResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.ViewHolder> {
    private List<UnsplashObjectResponse> pictures =  new ArrayList <>(  );

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from( parent.getContext() );
        View itemView = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolder( itemView );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UnsplashObjectResponse prePicture = pictures.get(position);
        Picasso.get().load( prePicture.getImage().getSmallUrl()).into(holder.ivMiniPicture);
        holder.tvNamePic.setText( prePicture.getName() );
        holder.tvAuthor.setText( prePicture.getAuthor() );
    }

    @Override
    public int getItemCount() {

        return pictures.size();
    }
    public void addAll(List<UnsplashObjectResponse> picturesToAdd){
        pictures.addAll( picturesToAdd );
        notifyDataSetChanged();
    }

    public void replaceAll(List<UnsplashObjectResponse> picturesToReplace){
        pictures.clear();
        pictures.addAll(picturesToReplace );
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivMiniPicture;
        TextView tvNamePic;
        TextView tvAuthor;

        public ViewHolder(View itemView) {
            super( itemView );
            ivMiniPicture = itemView.findViewById( R.id.ivMiniPicture );
            tvNamePic = itemView.findViewById( R.id.tvNamePic );
            tvAuthor = itemView.findViewById( R.id.tvAuthor );
        }
    }

}
