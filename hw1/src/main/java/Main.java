
public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        JellyBean jellyBean = JellyBean.getInstance("Iriska", 20, 10);
        Mars mars = Mars.getInstance("Cow", 5, 10);
        Nesquik nesquik = Nesquik.getInstance("Lovely", 5, 1);

//        jellyBean.aboutAllCandies();
//        System.out.println("==================");
//        jellyBean.getBoxWeight();
//        System.out.println("==================");
//        jellyBean.reduceWeight();
//        System.out.println("==================");
//        jellyBean.aboutAllCandies();
//        System.out.println("==================");
        System.out.println("==================");
        jellyBean.aboutAllCandies();
        jellyBean.reducePrice();
        jellyBean.aboutAllCandies();
        jellyBean.boxPrice();
    }
}
