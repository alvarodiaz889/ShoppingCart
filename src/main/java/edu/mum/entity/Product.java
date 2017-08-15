package edu.mum.entity;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue
    int productId;



    String productName;

    double price;
    @Enumerated(EnumType.STRING)
    ProductType type;
    String description;
    @Lob
    byte[] image;

    @Transient
    private
    String strData;
    /*OrderLine orderline;*/

    public Product(String productName,double price, int productId, ProductType type, String description, byte[] image) {
        super();

        this.productName = productName;
        this.price = price;
        this.productId = productId;
        this.type = type;
        this.description = description;
        this.image = image;

    }

    public Product() {
        super();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public String getDescription() {
        if(image != null)
        {
            try{
                image = Base64.encodeBase64(image);
                strData = new String(image,"UTF-8");
            }catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getStrData() {

        return strData;
    }

    public void setStrData(String strData) {
        this.strData = strData;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
