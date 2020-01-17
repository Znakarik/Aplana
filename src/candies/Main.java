package candies;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        MolodeznieBaldeznie molodeznieBaldeznie = new MolodeznieBaldeznie("Maya", 1, 50, "Following");
        JellyBean jellyBean = new JellyBean("Cow", 10, 50, "Big");
//        JellyBean jellyBean4 = new JellyBean("Rabbit", 5, 50, "Big");
//        JellyBean jellyBean2 = new JellyBean("Row", 28, 45, "Talented");
//        JellyBean jellyBean3 = new JellyBean("Milka", 26, 45, "Bought");


        System.out.println("boxPrice:" + jellyBean.boxPrice());
        System.out.println("BoxWeight:" + jellyBean.getBoxWeight());
        System.out.println("================\nABOUT jellyBean\n");
        jellyBean.aboutAllCandies();
//        jellyBean.deleteLastCandy();

        jellyBean.deleteCandy(0);
        System.out.println("================\nABOUT molodeznieBaldeznie\n");

        molodeznieBaldeznie.aboutAllCandies();

        molodeznieBaldeznie.deleteLastCandy();
        System.out.println("================\nThere shouldn't be any candies\n");
        molodeznieBaldeznie.aboutAllCandies();


    }
}
