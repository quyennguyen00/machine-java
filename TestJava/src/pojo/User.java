package pojo;

public class User {
    private int id;
    private String username;
    private String password;
    private double money;

    public User(){

    }

    public User(int id, String username, String password, double money)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.money = money;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
