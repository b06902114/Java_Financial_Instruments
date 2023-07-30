package Esun.demo.model;


import jakarta.persistence.*;

@Entity
@Table(name = "User_table")
public class User {

    @Id()
    @Column(name = "User ID", unique = true, nullable = false)
    private String ID;

    private String Name;

    private String Email;

    private String Account;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }
}
