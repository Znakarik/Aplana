package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.jvm.hotspot.utilities.Assert;

import java.util.*;

@Getter
public class BasketPage extends BasePage {

    @Getter
    public class Item {
        @FindBy(xpath = "//div[(@class='cart-items__product-thumbnail cart-items__product-thumbnail_product')]")
        List<WebElement> items;
        List<Item> itemList= new ArrayList<>();

        public void loadItems(){
            for (int i = 0; i < prices.size(); i++) {
//                itemList.add(new Item(Integer.parseInt(names.get(1).getText().replaceAll(" ","").trim()),names.get(1).getText().trim())
            }
        }
        String name;
        String price;

        public Item(String name, String price) {
            this.name = name;
            this.price = price;
        }

    }


        @FindBy(xpath = "//div[contains(@class,'cart-items__products')]//span[contains(@class,'price__current')]")
        public List<WebElement> prices;

        @FindBy(xpath = "//div[@class='cart-items__product-name']")
        public List<WebElement> names;

    public BasketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public Map<Integer, String> webElementMap = new HashMap<>();

    public void setItems() {
        for (int i = 0; i < prices.size(); i++) {
            webElementMap.put(Integer.parseInt(prices.get(i).getText().replaceAll(" ", "").trim()), names.get(i).getText());
        }
    }

    public void printItems() {
        for (Map.Entry<Integer, String> web : webElementMap.entrySet()) {
            System.out.printf("\nPRICE: %s NAME: %s", web.getKey(), web.getValue());
        }
    }


    public void checkParameters() {
        for (Map.Entry<Integer, String> element : webElementMap.entrySet()) {
            Collections.reverse(Product.productList);
            System.out.printf("\nTrying to Assert.equals %s AND %s", element.getKey(), Product.productList.get(1).getPrice());
            Assert.that(element.getKey().equals(Product.productList.get(1).getPrice()), "Prices not the same");
        }
    }

}
