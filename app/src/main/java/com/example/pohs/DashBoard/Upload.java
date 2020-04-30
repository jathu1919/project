package com.example.pohs.DashBoard;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import com.example.pohs.DashBoard.Modals.UploadModal;
import com.example.pohs.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayOutputStream;


public class Upload extends AppCompatActivity {

    private Toolbar mtoolbar;

    private static int RESULT_LOAD_IMAGE = 1;

    ImageView imageView;


    ImageButton imageButton;
    private int Gallary_intent = 2;

    EditText Pname;
    EditText Pid;
    EditText Psize;
    Spinner Ptype;
    EditText Pprice;
    EditText Descrip;
    Button addb;
    String picturePath;
    Bitmap bitmap;

    DatabaseReference databaseRefUploadItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        mtoolbar = (Toolbar) findViewById(R.id.Upload_dashboard_toolbar);
        //setSupportActionBar(mtoolbar);
        getSupportActionBar().setTitle("UPLOAD");


        ActivityCompat.requestPermissions(Upload.this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                10002);

        imageView = findViewById(R.id.imgview);


        Button buttonLoadImage = (Button) findViewById(R.id.imguploadbtn);
        buttonLoadImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

        databaseRefUploadItem = FirebaseDatabase.getInstance().getReference("UploadItems");


        Pname = (EditText) findViewById(R.id.pName);
        Pid = (EditText) findViewById(R.id.pId);
        Psize = (EditText) findViewById(R.id.pSize);
        Ptype = (Spinner) findViewById(R.id.dresstype);
        Pprice = (EditText) findViewById(R.id.pPrice);
        Descrip = (EditText) findViewById(R.id.pDescription);
        addb = (Button) findViewById(R.id.addbtn);
        

        //dropdown for dress type


        addb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItems();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }


    public void addItems() {

        String ProName = Pname.getText().toString().trim();
        String ProID = Pid.getText().toString().trim();
        String ProSize = Psize.getText().toString().trim();
        String ProType = Ptype.getSelectedItem().toString();
        String ProPrice = Pprice.getText().toString().trim();
        String Des = Descrip.getText().toString().trim();

        if (!TextUtils.isEmpty(ProName) && !TextUtils.isEmpty(ProID) && !TextUtils.isEmpty(ProSize) && !TextUtils.isEmpty(ProType) && !TextUtils.isEmpty(ProPrice) && !TextUtils.isEmpty(Des)) {
            String id = databaseRefUploadItem.push().getKey();
            UploadModal uploadModal = new UploadModal();
            uploadModal.setId(id);
            uploadModal.setProductName(ProName);
            uploadModal.setDescreption(Des);
            uploadModal.setProductID(ProID);
            uploadModal.setProductPrice(ProPrice);
            uploadModal.setProductType(ProType);
            uploadModal.setImage(BitMapToString(bitmap));
            databaseRefUploadItem.child(id).setValue(uploadModal);
            // Toast.makeText(this,"Product Added",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Upload.this, SuccessMessage.class);
            startActivity(intent);


        } else {
            Toast.makeText(this, "All Field Should be Fill", Toast.LENGTH_LONG).show();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
            cursor.close();

            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            bitmap = BitmapFactory.decodeFile(picturePath);

        }


    }

    public String BitMapToString(Bitmap bitmap){
        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
        byte [] arr=baos.toByteArray();
        String result= Base64.encodeToString(arr, Base64.DEFAULT);
        return result;
    }
}
