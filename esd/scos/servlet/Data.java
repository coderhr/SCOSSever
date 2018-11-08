package esd.scos.servlet;

public class Data {

    private String name;
    private int price;
    private int num;

    public Data(String name, int price, int num) {
        this.name = name;
        this.price = price;
        this.num = 1;
    }
    public String getName() {
        if(name.equals(null)) {
            name = "";
        }
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getNum() {
        return num;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void set_Price(int price) {

        this.price = price;
    }

    public void setNum(int num) {

        this.num = num;
    }

}