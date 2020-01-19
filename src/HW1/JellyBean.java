package HW1;

public class JellyBean extends BaseCandy implements Box {

    public JellyBean(String name, int weight, int price, String unic) {
        super(name, weight, price, unic);
    }


    public static JellyBean getInstance(String name, int weight, int price, String unic){
        return new JellyBean(name, weight, price, unic);
    }

}
