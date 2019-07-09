package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<com.example.android.miwok.Word> words = new ArrayList<com.example.android.miwok.Word>() ;
        words.add(new com.example.android.miwok.Word("red" , "wetteti" , R.drawable.color_red)) ;
        words.add(new com.example.android.miwok.Word("green" , "chokkoki" , R.drawable.color_green)) ;
        words.add(new com.example.android.miwok.Word("brown" , "takaki" , R.drawable.color_brown)) ;
        words.add(new com.example.android.miwok.Word("gray" , "topopi" , R.drawable.color_gray)) ;


        WordAdapter adapter = new WordAdapter(this , words , R.color.category_colors) ;
        ListView listview = (ListView)findViewById(R.id.list) ;
        listview.setAdapter(adapter) ;
    }
}
