package com.example.cultura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button_head, button_event, button_spon, button_about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_head=findViewById(R.id.button1);
        button_event=findViewById(R.id.button2);
        button_spon=findViewById(R.id.button4);
        button_about=findViewById(R.id.button5);

        button_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
