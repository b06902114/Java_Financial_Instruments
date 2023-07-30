package Esun.demo.model;


import jakarta.persistence.*;


@Entity
@Table(name = "Product_table")
public class Product {

    @Id()
    @Column(name = "Product No", unique = true, nullable = false)
    private String No;
    private String Product_Name;
    private int Price;
    private float Fee_Rate;

    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        No = no;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public void setProduct_Name(String product_Name) {
        Product_Name = product_Name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public float  getFee_Rate() {
        return Fee_Rate;
    }

    public void setFee_Rate(float  fee_Rate) {
        Fee_Rate = fee_Rate;
    }
}
