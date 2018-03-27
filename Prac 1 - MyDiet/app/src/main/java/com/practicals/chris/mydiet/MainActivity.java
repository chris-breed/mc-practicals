package com.practicals.chris.mydiet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView image = findViewById(R.id.imageView);
        TextView quote = findViewById(R.id.textView);

        Random rand = new Random();
        int number = rand.nextInt(3);

        String id = "food_" + number;
        int ImageID = getResources().getIdentifier(id, "mipmap", getPackageName());
        int QuoteID = getResources().getIdentifier(id, "string", getPackageName());

        image.setImageResource(ImageID);
        quote.setText(QuoteID);
    }
}
