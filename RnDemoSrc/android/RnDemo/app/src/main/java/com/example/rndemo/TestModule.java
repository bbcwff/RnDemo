package com.example.rndemo;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Time: 2023/3/6
 * Author: think
 * Description:创建模块
 */
public class TestModule extends ReactContextBaseJavaModule {

    private static ReactApplicationContext reactContext;

    public TestModule(@Nullable ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext=reactContext;
    }

    @NonNull
    @Override
    public String getName() {//你想要调用的那个模块的名称，实际上就是当前的这个对象
        return "TestExample";
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        HashMap<String,Object> constants = new HashMap<>();
        constants.put("systemN","android"); //带上一些参数
        return constants;
    }

    @ReactMethod
    public void show(String message, int duration) {
        Toast.makeText(getReactApplicationContext(), message, duration).show();
    }

    @ReactMethod
    public void startActivityFromRnZ(String data, Promise promise, Callback callback){//我们想要调用的原生的android方法，这个方法可以打开一个activity，同时还可以传递参数过来
        Activity currentActivity=getCurrentActivity();
        if (currentActivity!=null){
            Intent intent=new Intent(currentActivity,SecondActivity.class);
            intent.putExtra("params",data);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//在react native 打开activity
            currentActivity.startActivity(intent);
        }
    }


}
