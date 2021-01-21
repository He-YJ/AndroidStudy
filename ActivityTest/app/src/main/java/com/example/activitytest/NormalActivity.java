package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class NormalActivity extends BaseActivity {

    public static void actionStart(Context context, String datal, String data2) {
        Intent intent = new Intent(context, NormalActivity.class);
        intent.putExtra("param1", datal);
        intent.putExtra("param2", data2);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
    }
}