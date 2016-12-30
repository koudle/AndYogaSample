package com.koudle.andyogaexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

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

    private TextView mYogaText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);
        mYogaText = (TextView) findViewById(R.id.yogaText);

        initYoga();
    }

    private void initYoga(){

        SoLoader.init(YogaActivity.this,false);


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

        StringBuffer buffer = new StringBuffer();
        buffer.append("text,layout X:").append(text.getLayoutX())
                .append(" layout Y:").append(text.getLayoutY()).append("\n")
                .append("image,layout X:").append(image.getLayoutX())
                .append(" layout Y:").append(image.getLayoutY());

        mYogaText.setText(buffer.toString());

    }
}
