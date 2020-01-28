package HW1;

import HW1.model.BaseCandy;

public class Nesquik extends BaseCandy implements Box {
    private Nesquik(String name, int weight, int price, String unic) {
        super(name, weight, price);
        this.unic = generateUnic();
    }

    static Nesquik getInstance(String name, int weight, int price) {
        return new Nesquik(name, weight, price, generateUnic());
    }

    private static String generateUnic() {
        String[] words = {"Black", "White", "Double stick", "Helicopter"};
        int num = (int) (Math.random() * words.length);
        return words[num];
    }
}
