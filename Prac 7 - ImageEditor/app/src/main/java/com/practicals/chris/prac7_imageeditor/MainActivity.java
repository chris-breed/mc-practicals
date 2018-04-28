package com.practicals.chris.prac7_imageeditor;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static final int SELECT_IMAGE = 1;
    private Button selectButton;
    private ImageEditor image;
    private FloatingActionButton fab;

    private PointF[] allPoints;

    private int total;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectButton = findViewById(R.id.select_image_button);
        image = findViewById(R.id.ImageView);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearPoints();
            }
        });


        allPoints = new PointF[1000];
        for (int i = 0; i < allPoints.length; i++) {
            allPoints[i] = new PointF();
        }

        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, SELECT_IMAGE);
            }
        });


        image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

//                Log.i("ImageEditor", String.valueOf(event.getX() + "  <X, Y>  " + event.getY()));

                for (int i = 1; i < allPoints.length; i++) {
                    allPoints[i - 1].x = allPoints[i].x;
                    allPoints[i - 1].y = allPoints[i].y;
                }
//                System.arraycopy(allPoints, 0, allPoints, -1, allPoints.length);
                allPoints[allPoints.length - 1].x = event.getX();
                allPoints[allPoints.length - 1].y = event.getY();
                image.setPoint(allPoints);

//                total++;
//                Log.i("ImageEditor", String.format("%d", total));
                image.invalidate();
                return true;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SELECT_IMAGE && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            try {
                Bitmap BM = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                image.setImageBitmap(BM);
                clearPoints();
            } catch (IOException e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }

    private void clearPoints() {
        for (int i = 0; i < allPoints.length; i++) {
            allPoints[i] = new PointF(0, 0);
        }
        total = 0;
        image.invalidate();
    }
}
