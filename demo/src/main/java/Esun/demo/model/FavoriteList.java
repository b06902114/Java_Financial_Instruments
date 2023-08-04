package Esun.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "User_List_table")
public class FavoriteList {
    @Id()
    @Column(name = "Num", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Num;

    //User Id
    private String ID;

    // Product ID
    private String SN;

    private int quantity;

    public Long getNum() {
        return Num;
    }

    public void setNum(Long num) {
        Num = num;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSN() {
        return SN;
    }

    public void setSN(String SN) {
        this.SN = SN;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
