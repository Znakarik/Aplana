package HW2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.*;

public class OurFileReader {

//    static void printAll(Map<String, Integer> map) {
//        for (Map.Entry<String, Integer> a : map.entrySet()) {
//            System.out.println("KEY: " + a.getKey() + " | COUNT: " + a.getValue());
//            System.out.println("____________");
//        }
//    }

    static String[] makeArr(File file) throws IOException {
        Scanner scanner = new Scanner(Paths.get(file.toString()), StandardCharsets.UTF_8.name());
        // Прочитали файл целиком
        String data = scanner.useDelimiter("\\A").next();
        String string = data.replaceAll("/", "")
                .replaceAll("\\)", "")
                .replaceAll("\\(", "")
                .replaceAll("\\{", "")
                .replaceAll("}", "")
                .replaceAll("—", "")
                .replaceAll("'?'", "")
                .replaceAll(",", "")
                .replaceAll("%", "")   // Процент
//                .replaceAll(" ", "")   // Пробел
                .replaceAll("\t", "")  // Табуляция (заменяем на пробел)
                .replaceAll("\n", "")  // Переход строки (заменяем на пробел)
                .replaceAll("\r", "")  // Возврат каретки (заменяем на пробел)
                .replaceAll("!", "")   // Восклицательный знак
                .replaceAll("\"", "")  // Двойная кавычка
                .replaceAll("#", "")   // Октоторп, решетка
                .replaceAll("\\$", "") // Знак доллара
                .replaceAll("&", "")   // Амперсанд
                .replaceAll("'", "")   // Одиночная кавычка
                .replaceAll("\\(", "") // Открывающаяся скобка
                .replaceAll("\\)", "") // Закрывающаяся скобка
                .replaceAll("\\*", "") // Звездочка
                .replaceAll("\\+", "") // Знак плюс
                .replaceAll(",", "")   // Запятая
                .replaceAll("-", "")   // Дефис
                .replaceAll("\\.", "") // Точка
                .replaceAll("/", "")   // Слеш, косая черта
                .replaceAll(":", "")   // Двоеточие
                .replaceAll(";", "")   // Точка с запятой
                .replaceAll("<", "")   // Открывающаяся угловая скобка
                .replaceAll("=", "")   // Знак равно
                .replaceAll(">", "")   // Закрывающаяся угловая скобка
                .replaceAll("\\?", "") // Вопросительный знак
                .replaceAll("@", "")   // At sign, по цене, собачка
                .replaceAll("\\[", "") // Открывающаяся квадратная скобка
                .replaceAll("\\\\", "") // Одиночный обратный слеш '\'
                .replaceAll("\\]", "") // Закрывающаяся квадратная скобка
                .replaceAll("\\^", "") // Циркумфлекс
                .replaceAll("_", "")   // Нижнее подчеркивание
                .replaceAll("`", "")   // Гравис
                .replaceAll("\\{", "") // Открывающаяся фигурная скобка
                .replaceAll("\\|", "") // Вертикальная черта
                .replaceAll("\\}", "") // Закрывающаяся фигурная скобка
                .toLowerCase()
                .trim()
                .replaceAll("~", "");  // Тил

        scanner.close();
        // Положили весь текст в массив по слову
        return string.split(" ");
    }

    static void count() throws IOException {
        //Итерируемся и смотим сколько раз встречалось
        Map<String, Integer> map = new HashMap<>();
        // Сортируем наш список по алфавиту
        String[] strings = makeArr(new File("/Users/o/IdeaProjects/Aplana/src/HW2/res/file2"));
        Arrays.sort(strings);
        for (String s : strings) {
            map.put(s, map.containsKey(s) ? map.get(s) + 1 : 1);
        }

        int max = Collections.max(map.values());
        String maxString = "";
        for (Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> entry = it.next();
            if (entry.getKey().equals("\t")) {
                it.remove();
            }
            if (entry.getValue().equals(max)) {
                maxString = entry.getKey();
            }
        }
//        for (Map.Entry<String, Integer> a : map.entrySet()) {
//            if (a.getKey().equals("")) {
//                map.remove(a);
//            }
//            if (a.getValue().equals(max)) {
//                maxString = a.getKey();
//            }
//        }

        System.out.printf("MAX STRING: %s \nREPEATED %d" +
                "\n________\n", maxString, max);

        //Просто печатаем все значения
//        map.entrySet().stream()
//                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
//                .forEach(System.out::println);

    }


    public static void main(String[] args) throws IOException {
//        File file = new File("/Users/o/IdeaProjects/Aplana/src/HW2/res/file");
//        File file1 = new File("/Users/o/IdeaProjects/Aplana/src/HW2/res/text");
        count();
    }
}


