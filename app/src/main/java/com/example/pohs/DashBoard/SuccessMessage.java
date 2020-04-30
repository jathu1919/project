package com.example.pohs.DashBoard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pohs.R;

public class SuccessMessage extends AppCompatActivity {
    Button success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_message);



        success = (Button)findViewById(R.id.successok);

       success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SuccessMessage.this,ShopDashBoard.class);
                startActivity(intent);
            }
        });
    }
}
