package HW1;

import HW1.model.BaseCandy;

class JellyBean extends BaseCandy implements Box {

    private JellyBean(String name, int weight, int price, String unic) {
        super(name, weight, price);
        this.unic = generateUnic();
    }

    static JellyBean getInstance(String name, int weight, int price) {
        return new JellyBean(name, weight, price, generateUnic());
    }

    private static String generateUnic() {
        String[] words = {"Tasty", "Awful", "Big"};
        int num = (int) (Math.random() * words.length);
        return words[num];
    }
}
