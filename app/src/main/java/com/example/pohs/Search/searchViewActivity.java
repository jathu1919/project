package com.example.pohs.Search;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pohs.R;
import com.example.pohs.Search.Adepter.searchItemAdepter;
import com.example.pohs.Search.Modal.searchItemModal;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class searchViewActivity extends AppCompatActivity {

    ArrayList<searchItemModal> searchitem = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);

        Intent intent = getIntent();
        final String searchText = intent.getExtras().getString("searchText");


        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("UploadItems");
        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.hasChildren()){
                    searchitem.clear();

                    for (DataSnapshot ds : dataSnapshot.getChildren())
                    {
                        searchItemModal spacecraft=ds.getValue(searchItemModal.class);
                        assert spacecraft != null;
                        if(searchText.equals(spacecraft.getProductName()))
                            searchitem.add(spacecraft);
                    }

                    searchItemAdepter listAdapter = new searchItemAdepter(searchViewActivity.this, R.id.searchLV,searchitem);
                    ListView list=(ListView)findViewById(R.id.searchLV);
                    list.setAdapter(listAdapter);


//                    vegetables.add((Vegetables) dataSnapshot.getValue());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }
}
