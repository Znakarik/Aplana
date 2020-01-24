package HW1;

class JellyBean extends BaseCandy implements Box {

    private JellyBean(String name, int weight, int price, String unic) {
        super(name, weight, price, unic);
    }


    static JellyBean getInstance(String name, int weight, int price, String unic){
        return new JellyBean(name, weight, price, unic);
    }

}
