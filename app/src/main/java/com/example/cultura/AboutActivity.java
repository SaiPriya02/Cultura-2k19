package com.example.cultura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class AboutActivity extends AppCompatActivity {



    int[] imageArray = {R.drawable.cultura18,
            R.drawable.ravecopy,
            R.drawable.tcopy,
            R.drawable.registernowcopy};

    Timer _t;
    public static int count = 0;


    ImageView imageView;
    TextView about;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        imageView = findViewById (R.id.imageViewActivityMain);
        about = findViewById (R.id.about_text_view_activity_main);
        scrollView = findViewById (R.id.scroll_view_activity_main);
        imageView.setImageResource (R.drawable.cultura18);


        _t = new Timer ( );
        _t.scheduleAtFixedRate (new TimerTask ( )
        {
            @Override
            public void run()
            {

                runOnUiThread (new Runnable ( )
                {
                    @Override
                    public void run()
                    {

                        if (count < imageArray.length)
                        {
                            imageView.setImageResource (imageArray[count]);

                            count = (count + 1) % imageArray.length;
                        }
                    }
                });
            }
        }, 10, 2000);



    }
}
