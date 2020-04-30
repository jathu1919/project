package com.example.pohs.DashBoard;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.pohs.DashBoard.Adepters.femaleItemAdepter;
import com.example.pohs.DashBoard.Modals.UploadModal;
import com.example.pohs.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FemaleItems extends Fragment {


    public FemaleItems() {
        // Required empty public constructor
    }
    ArrayList<UploadModal> femaleitem = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_female_items, container, false);

        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("UploadItems");
        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.hasChildren()){
                    femaleitem.clear();

                    for (DataSnapshot ds : dataSnapshot.getChildren())
                    {
                        UploadModal spacecraft=ds.getValue(UploadModal.class);
                        assert spacecraft != null;
                        if("Girls Items".equals(spacecraft.getProductType()))
                            femaleitem.add(spacecraft);
                    }

                    femaleItemAdepter listAdapter = new femaleItemAdepter(FemaleItems.this.getContext(), R.id.female_listview,femaleitem );
                    ListView list=(ListView)view.findViewById(R.id.female_listview);
                    list.setAdapter(listAdapter);


//                    vegetables.add((Vegetables) dataSnapshot.getValue());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return view;
    }

}
