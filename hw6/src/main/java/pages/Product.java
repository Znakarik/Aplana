package pages;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Product {

    static List<Product> productList = new ArrayList<>();

    public Integer getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    Integer price;
    String name;

    public Product(Integer price, String name) {
        this.price = price;
        this.name = name;
        productList.add(this);
    }

    public static void getProductList(){
        System.out.println(Product.productList.toString());
    }
    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
