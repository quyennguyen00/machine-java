package pojo;

import java.util.Date;

public class Order {
    private int id;
    private Date date;
    private int userId;
    private int  productId;
    private double amount;

    public Order() {
    }

    public Order(int id, Date date, int user, int product, double amount) {
        this.id = id;
        this.date = date;
        this.userId = user;
        this.productId = product;
        this.amount = amount;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
