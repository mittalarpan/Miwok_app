/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG , "MAIN ACT CREATED") ;
        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);
        TextView numbers = (TextView)findViewById(R.id.numbers) ;
        numbers.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent inum = new Intent(MainActivity.this , NumbersActivity.class) ;
                startActivity(inum) ;
            }
        });

        TextView family = (TextView)findViewById(R.id.family) ;
        family.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent ifam = new Intent(MainActivity.this , FamilyMembers.class) ;
                startActivity(ifam) ;
            }
        });

        TextView colors = (TextView)findViewById(R.id.colors) ;
        colors.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent icolors = new Intent(MainActivity.this , ColorsActivity.class) ;
                startActivity(icolors) ;
            }
        });

        TextView phrases = (TextView)findViewById(R.id.phrases) ;
        phrases.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent iphrases = new Intent(MainActivity.this , PhrasesActivity.class) ;
                startActivity(iphrases) ;
            }
        });
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        Log.v(TAG  ,"ACTIVITY PAUSED") ;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG , "ACT RESTART") ;
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.v(TAG , "ACT START") ;
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG , "ACTIVITY RESUME");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG , "ACTIVITY DESTROY") ;
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG , "Activity STOP");
    }
}
