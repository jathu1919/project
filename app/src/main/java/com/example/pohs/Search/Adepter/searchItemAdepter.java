package com.example.pohs.Search.Adepter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pohs.R;
import com.example.pohs.Search.Modal.searchItemModal;

import java.util.ArrayList;

public class searchItemAdepter extends ArrayAdapter<searchItemModal> {

    private ArrayList<searchItemModal> searchItem;
    private LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    public searchItemAdepter(Context context, int resource, ArrayList<searchItemModal> searchItem) {
        super(context, resource,searchItem);
        this.searchItem = searchItem;
    }

    public View getView(int position, View view, ViewGroup parent) {

        View rowView= inflater.inflate(R.layout.maleitemlayout, null, true);

        TextView productName = (TextView) rowView.findViewById(R.id.pname);
        productName.setText(searchItem.get(position).getProductName());

        TextView productID = (TextView) rowView.findViewById(R.id.pid);
        productID.setText(searchItem.get(position).getProductPrice());

        TextView price = (TextView) rowView.findViewById(R.id.price);
        price.setText(searchItem.get(position).getProductSize());

        TextView productType = (TextView) rowView.findViewById(R.id.type);
        productType.setText(searchItem.get(position).getProductType());

        TextView productDisc = (TextView) rowView.findViewById(R.id.des);
        productDisc.setText(searchItem.get(position).getDescreption());

        return rowView;
    }
}
