package candies;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        JellyBean jellyBean = new JellyBean("Cow", 10, 50, "Big");
        JellyBean jellyBean4 = new JellyBean("Rabbit", 5, 50, "Big");
        JellyBean jellyBean2 = new JellyBean("Row", 28, 45, "Talented");
        JellyBean jellyBean3 = new JellyBean("Milka", 26, 45, "Bought");

        MolodeznieBaldeznie molodeznieBaldeznie = new MolodeznieBaldeznie("Maya", 1, 50, "Following");

        System.out.println("boxPrice:" + jellyBean.boxPrice());
        System.out.println("BoxWeight:" + jellyBean.getBoxWeight());
    }
}
