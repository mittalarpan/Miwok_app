package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.media.AudioManager.AUDIOFOCUS_GAIN_TRANSIENT;
import static android.media.AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE;

public class NumbersActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";
    private MediaPlayer mediaplayer  ;
    private AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mediaplayer.pause();
                mediaplayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mediaplayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                   releaseMediaPlayer();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        Log.v(TAG , "ACT CREATED") ;
        final ArrayList<com.example.android.miwok.Word> words = new ArrayList<com.example.android.miwok.Word>();
        words.add(new com.example.android.miwok.Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new com.example.android.miwok.Word("two", "ottiko", R.drawable.number_two, R.raw.number_two));
        words.add(new com.example.android.miwok.Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new com.example.android.miwok.Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new com.example.android.miwok.Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new com.example.android.miwok.Word("six", "temmoka", R.drawable.number_six, R.raw.number_six));
        words.add(new com.example.android.miwok.Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new com.example.android.miwok.Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new com.example.android.miwok.Word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new com.example.android.miwok.Word("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);
        ListView listview = (ListView) findViewById(R.id.list);
        listview.setAdapter(adapter);
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        ListView lv = (ListView) findViewById(R.id.list);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                com.example.android.miwok.Word curr = words.get(i);
                int idx = curr.getAudioId() ;
                releaseMediaPlayer();
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AUDIOFOCUS_GAIN_TRANSIENT);
               if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                mediaplayer = MediaPlayer.create(NumbersActivity.this, idx);
                mediaplayer.start() ;
                mediaplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        releaseMediaPlayer();
                    }
                });}

            }
        });
    }

   /* @Override
   protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }*/

    private void releaseMediaPlayer() {
            // If the media player is not null, then it may be currently playing a sound.
            if (mediaplayer != null) {
                // Regardless of the current state of the media player, release its resources
                // because we no longer need it.
                mediaplayer.release();

                // Set the media player back to null. For our code, we've decided that
                // setting the media player to null is an easy way to tell that the media player
                // is not configured to play an audio file at the moment.
                mediaplayer = null;
               mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
            }
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
     @Override
    protected void onPause()
     {
         super.onPause();
         Log.v(TAG , "Pause") ;
     }
}
