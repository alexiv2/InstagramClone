package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("TDgIi5RQS96JQvJMpGSxh2gXef8v3zv9YAvDTREj")
                .clientKey("9EcnN3cjXfO9QBJJ7YfPGHS1rYpVF32ODmiAFPVN")
                .server("https://parseapi.back4app.com").build());
    }
}
