package com.koudle.andyogaexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.facebook.soloader.SoLoader;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaLogLevel;
import com.facebook.yoga.YogaLogger;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaPositionType;

public class YogaActivity extends AppCompatActivity {

    private static final String TAG = YogaActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);
        System.loadLibrary("gnustl_shared");
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoLoader.init(YogaActivity.this,false);
                initYoga();
            }
        });
    }

    private void initYoga(){
        try {
            YogaNode root = new YogaNode();
            root.setWidth(500);
            root.setHeight(300);
            root.setAlignItems(YogaAlign.CENTER);
            root.setJustifyContent(YogaJustify.CENTER);
            root.setPadding(YogaEdge.ALL, 20);

            YogaNode text = new YogaNode();
            text.setWidth(200);
            text.setHeight(25);

            YogaNode image = new YogaNode();
            image.setWidth(50);
            image.setHeight(50);
            image.setPositionType(YogaPositionType.ABSOLUTE);
            image.setPosition(YogaEdge.END, 20);
            image.setPosition(YogaEdge.TOP, 20);

            root.addChildAt(text, 0);
            root.addChildAt(image, 1);

            root.calculateLayout();

            Log.d(TAG,"text,layout X:"+text.getLayoutX()+" layout Y:"+text.getLayoutY());
            Log.d(TAG,"image,layout X:"+image.getLayoutX()+" layout Y:"+image.getLayoutY());

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
