package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<com.example.android.miwok.Word> {

    private int mColorResourceId ;
    public WordAdapter(Activity context, ArrayList<com.example.android.miwok.Word> words , int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId ;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView ;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        final com.example.android.miwok.Word currentWord = getItem(position) ;
        TextView miwokTextView = (TextView)listItemView.findViewById(R.id.miwok_text_view) ;
        miwokTextView.setText(currentWord.getMiwokTranslation());

        TextView defaultTextView = (TextView)listItemView.findViewById(R.id.default_text_view) ;
        defaultTextView.setText(currentWord.getDefaultTranslation());

        ImageView imageView = (ImageView)listItemView.findViewById(R.id.image)  ;
        imageView.setImageResource(currentWord.getImageResourceId());

        View textContainer = listItemView.findViewById(R.id.text_container) ;
        int color = ContextCompat.getColor(getContext() , mColorResourceId) ;
        textContainer.setBackgroundColor(color);


        return listItemView ;
    }
}
