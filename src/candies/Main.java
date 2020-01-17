package candies;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        JellyBean jellyBean = new JellyBean("Cow", 1000, 50, "Big");
        JellyBean jellyBean4 = new JellyBean("Rabbit", 30, 50, "Small");
        JellyBean jellyBean2 = new JellyBean("Row", 45, 45, "Talented");
        JellyBean jellyBean3 = new JellyBean("Milka", 70, 45, "Bought");
        MolodeznieBaldeznie molodeznieBaldeznie = new MolodeznieBaldeznie("Maya", 1, 50, "Following");
        Nesquik nesquik = new Nesquik("Trim",34,65,"Tasty");


//        System.out.println("boxPrice:" + jellyBean.boxPrice());
//        System.out.println("BoxWeight:" + jellyBean.getBoxWeight());
//        System.out.println("================\nABOUT jellyBean\n");
//        jellyBean.aboutAllCandies();
//        jellyBean.deleteLastCandy();

//        jellyBean.deleteCandy(0);
//        System.out.println("================\nABOUT molodeznieBaldeznie\n");

//        molodeznieBaldeznie.aboutAllCandies();

//        molodeznieBaldeznie.deleteLastCandy();
//        System.out.println("================\nThere shouldn't be any candies\n");
//        molodeznieBaldeznie.aboutAllCandies();

//        molodeznieBaldeznie.aboutAllCandies();
        System.out.println("================\nALL CANDIES\n");
        molodeznieBaldeznie.aboutAllCandies();
        jellyBean.reduceWeight();
        System.out.println("================\nREDUSED\n");
        molodeznieBaldeznie.aboutAllCandies();
        System.out.println("================\nTRYING TO DELETE THE BIGGEST CANDY WITH INDEX\n");
        molodeznieBaldeznie.deleteCandy(1);
        molodeznieBaldeznie.aboutAllCandies();


    }
}
