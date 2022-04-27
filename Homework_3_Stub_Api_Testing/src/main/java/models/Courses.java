package models;

public class Courses {
   public String name;
    public Integer price;
    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Courses(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }


}
