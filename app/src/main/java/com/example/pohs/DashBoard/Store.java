package com.example.pohs.DashBoard;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.pohs.DashBoard.Adepters.storeItemAdepter;
import com.example.pohs.DashBoard.Modals.UploadModal;
import com.example.pohs.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Store extends Fragment {

    public Store() {
        // Required empty public constructor
    }

    private ListView storeList ;
    ArrayList<UploadModal> storeitem = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_store, container, false);

        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("UploadItems");
        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.hasChildren()){
                    storeitem.clear();

                    for (DataSnapshot ds : dataSnapshot.getChildren())
                    {
                        UploadModal spacecraft=ds.getValue(UploadModal.class);
                        storeitem.add(spacecraft);
                    }

                    storeItemAdepter listAdapter = new storeItemAdepter(Store.this.getContext(), R.id.listview_storeItems, storeitem);
                    ListView list=(ListView)view.findViewById(R.id.listview_storeItems);
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
