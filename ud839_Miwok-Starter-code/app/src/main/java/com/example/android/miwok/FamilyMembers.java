package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<com.example.android.miwok.Word> words = new ArrayList<com.example.android.miwok.Word>() ;
        words.add(new com.example.android.miwok.Word("father" , "apa" , R.drawable.family_father)) ;
        words.add(new com.example.android.miwok.Word("mother" , "ata" , R.drawable.family_mother)) ;
        words.add(new com.example.android.miwok.Word("son" , "angsi" , R.drawable.family_son)) ;
        words.add(new com.example.android.miwok.Word("daughter" , "tune" , R.drawable.family_daughter)) ;
        words.add(new com.example.android.miwok.Word("older brother" , "taachi" , R.drawable.family_older_brother)) ;
        words.add(new com.example.android.miwok.Word("younger brother" , "chaliti" , R.drawable.family_younger_brother)) ;
        words.add(new com.example.android.miwok.Word("older sister" , "tete" , R.drawable.family_older_sister)) ;
        words.add(new com.example.android.miwok.Word("younger sister" , "kolitti" , R.drawable.family_younger_sister)) ;
        words.add(new com.example.android.miwok.Word("grandfather" , "paapa" , R.drawable.family_grandfather)) ;

        WordAdapter adapter = new WordAdapter(this , words , R.color.category_family) ;
        ListView listview = (ListView)findViewById(R.id.list) ;
        listview.setAdapter(adapter) ;
    }
}
