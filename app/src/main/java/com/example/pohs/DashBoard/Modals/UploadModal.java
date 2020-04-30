package com.example.pohs.DashBoard.Modals;

public class UploadModal {
    private String id;
    private  String ProductName;
    private  String ProductID;
    private  String ProductSize;
    private  String ProductType;
    private  String ProductPrice;
    private  String Descreption;
    private String image;


    public UploadModal(){

    }

    public UploadModal(String productName, String productID, String productSize, String productType, String productPrice, String descreption,String id, String image) {
        ProductName = productName;
        ProductID = productID;
        ProductSize = productSize;
        ProductType = productType;
        ProductPrice = productPrice;
        Descreption = descreption;
        this.image = image;
    }

    public String getProductName() {
        return ProductName;
    }

    public String getProductID() {
        return ProductID;
    }

    public String getProductSize() {
        return ProductSize;
    }

    public String getProductType() {
        return ProductType;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public String getDescreption() {
        return Descreption;
    }

    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public void setProductSize(String productSize) {
        ProductSize = productSize;
    }

    public void setProductType(String productType) {
        ProductType = productType;
    }

    public void setProductPrice(String productPrice) {
        ProductPrice = productPrice;
    }

    public void setDescreption(String descreption) {
        Descreption = descreption;
    }
}
