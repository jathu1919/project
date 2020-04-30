package com.example.pohs.DashBoard.Adepters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pohs.DashBoard.Modals.UploadModal;
import com.example.pohs.R;

import java.util.ArrayList;

public class maleItemAdepter extends ArrayAdapter<UploadModal> {

    private ArrayList<UploadModal> maleItem;
    private LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    public maleItemAdepter(Context context, int resource, ArrayList<UploadModal> storeItem) {
        super(context, resource,storeItem);
        this.maleItem = storeItem;
    }

    public View getView(int position, View view, ViewGroup parent) {

        View rowView= inflater.inflate(R.layout.maleitemlayout, null, true);

        TextView productName = (TextView) rowView.findViewById(R.id.pname);
        productName.setText(maleItem.get(position).getProductName());

        TextView productID = (TextView) rowView.findViewById(R.id.pid);
        productID.setText(maleItem.get(position).getProductPrice());

        TextView price = (TextView) rowView.findViewById(R.id.price);
        price.setText(maleItem.get(position).getProductSize());

        TextView productType = (TextView) rowView.findViewById(R.id.type);
        productType.setText(maleItem.get(position).getProductType());

        TextView productDisc = (TextView) rowView.findViewById(R.id.des);
        productDisc.setText(maleItem.get(position).getDescreption());

        ImageView image = (ImageView) rowView.findViewById(R.id.image);
        image.setImageBitmap(StringToBitMap(maleItem.get(position).getImage()));

        return rowView;
    }

    public Bitmap StringToBitMap(String image){
        try{
            byte [] encodeByte= Base64.decode(image,Base64.DEFAULT);
            Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        }catch(Exception e){
            e.getMessage();
            return null;
        }
    }
}
