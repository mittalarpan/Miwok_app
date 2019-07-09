package com.example.android.miwok ;

public class Word {
   private String mMiwokTranslation  , mDefaultTranslation ;
   private int mImageResourceId , mAudioId ;

   public Word(String defaultTranslation , String miwokTranslation )
   {
       mMiwokTranslation = miwokTranslation ;
       mDefaultTranslation = defaultTranslation ;
   }

    public Word(String a , String b , int x )
    {
        mMiwokTranslation = b ;
        mDefaultTranslation = a ;
        mImageResourceId = x ;

    }
   public Word(String a , String b , int x ,  int audioId)
   {
       mMiwokTranslation = b ;
       mDefaultTranslation = a ;
       mImageResourceId = x ;
       mAudioId = audioId ;
   }
   public String getDefaultTranslation()
   {
       return mDefaultTranslation ;
   }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceId()
    {
        return mImageResourceId ;
    }

    public int getAudioId(){
       return mAudioId ;
    }
}
