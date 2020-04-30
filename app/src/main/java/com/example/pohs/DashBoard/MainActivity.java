package com.example.pohs.DashBoard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pohs.Login_register_profile.FirstPage;
import com.example.pohs.R;

public class MainActivity extends AppCompatActivity {

    private Button mgetstartBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mgetstartBtn = (Button)findViewById(R.id.firstBtn);

        mgetstartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent intent = new Intent(MainActivity.this, FirstPage.class);
                startActivity(intent);
            }
        });
    }
}
