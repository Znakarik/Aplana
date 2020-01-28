package HW1;

import HW1.model.BaseCandy;

public class Mars extends BaseCandy implements Box {

    private Mars(String name, int weight, int price,String unic) {
        super(name, weight, price);
        this.unic = generateUnic();
    }

    static Mars getInstance(String name, int weight, int price) {
        return new Mars(name, weight, price,generateUnic());
    }

    private static String generateUnic() {
        String[] words = {"Jupiter", "Venus", "Earth", "Saturn", "Uranus"};
        int num = (int) (Math.random() * words.length);
        return words[num];
    }
}
