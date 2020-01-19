package HW2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.*;

public class OurFileReader {

    public static void main(String[] args) throws IOException {

//        File file = new File("/Users/o/IdeaProjects/Aplana/src/HW2/file");
//        FileReader ourFileReader = new FileReader(file);
//        Scanner scanner = new Scanner(ourFileReader);
//        ArrayList<String> strings = new ArrayList<>();
//
////        int i = 0;
//        while (scanner.hasNext()) {
//            String a = scanner.nextLine().trim();
//            strings.add(a);
////            i++;
//
//        }
//
//        ourFileReader.close();
//
//        for (String s : strings) {
//            System.out.println(s);
//        }
//        System.out.println("==================");
//        System.out.println("==================");
//        System.out.println(strings.get(0));
        File file = new File("/Users/o/IdeaProjects/Aplana/src/HW2/file");
        File file1 = new File("/Users/o/IdeaProjects/Aplana/src/HW2/text");

        // Прочитали файл целиком
        Scanner scanner = new Scanner(Paths.get(file.toString()), StandardCharsets.UTF_8.name());
        String data = scanner.useDelimiter("\\A").next();
        scanner.close();
        // Положили весь текст в массив по слову
        String[] strings = data.split(" ");

        //Итерируемся и смотим сколько раз встречалось
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(strings);

        for (String string : strings) {
            map.put(string, map.containsKey(string) ? map.get(string) + 1 : 1);
        }

        for (Map.Entry<String, Integer> a : map.entrySet()) {
            if (a.getKey().equals(" ")) {
                map.remove(a);
            }
            System.out.println("KEY: " + a.getKey() + " | COUNT: " + a.getValue());
            System.out.println("================");
        }

    }
}

