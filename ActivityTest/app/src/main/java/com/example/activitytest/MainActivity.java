package com.example.activitytest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");

        //加载布局
        setContentView(R.layout.activity_main);

        // 恢复临时数据
        if (savedInstanceState != null) {
            String data = savedInstanceState.getString("data_key");
            Log.d("TAG",data);
        }

        //获取按钮的实体对象
        Button startNormalActivity = (Button) findViewById(R.id.start_normal_button);
        Button startDialogActivity = (Button) findViewById(R.id.start_dialog_button);
        Button finish = (Button) findViewById(R.id.finish_button);

        //定义按钮点击事件
        startNormalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                startActivity(intent);*/
               NormalActivity.actionStart(MainActivity.this,"data1","data2");
            }
        });

        startDialogActivity.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View view){
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });


        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCollector.finishAll();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
    }


    /**
     * 活动由不可见到可见
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    /**
     * 活动准备好和用户开始交互
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    /**
     * 系统准备去启动或者恢复另一个活动
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    /**
     * 活动完全不可见
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    /**
     * 活动被销毁
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    /**
     * 活动由停止状态变为运行状态
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    /**
     * 保存临时数据
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        String tempData = "Something you just typed";
        outState.putString("data_key", tempData);
    }
}