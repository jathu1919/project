package com.example.pohs.Search.Modal;

import android.graphics.Bitmap;

public class searchItemModal {
    private String productName;
    private String productId;
    private String productSize;
    private String productType;
    private String productPrice;
    private String descreption;
    private Bitmap productImage;

    public searchItemModal() {
    }

    public searchItemModal(String productName, String productId, String productSize, String productType, String productPrice, String descreption, Bitmap productImage) {
        this.productName = productName;
        this.productId = productId;
        this.productSize = productSize;
       this.productType = productType;
        this.productPrice = productPrice;
        this.descreption = descreption;
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductSize() {
        return productSize;
    }

    public String getProductType() {
        return productType;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getDescreption() {
        return descreption;
    }

    public Bitmap getProductImage() {
        return productImage;
    }
}
