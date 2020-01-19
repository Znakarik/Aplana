package candies;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        JellyBean jellyBean = JellyBean.getInstance("Iriska", 20, 10, "Tasty");
        MolodeznieBaldeznie molodeznieBaldeznie = MolodeznieBaldeznie.getInstance("Cow", 5, 10, "First candy on the planet");
        Nesquik nesquik = Nesquik.getInstance("Lovely", 5, 10, "HippoAllergic");

        jellyBean.aboutAllCandies();
        System.out.println("==================");
        jellyBean.getBoxWeight();
        System.out.println("==================");
        jellyBean.reduceWeight();
        System.out.println("==================");
        jellyBean.aboutAllCandies();

    }
}
