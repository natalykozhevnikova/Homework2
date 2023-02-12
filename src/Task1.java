package Homework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Task1 {

    public static String reader() {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("task1_info.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String string = stringBuilder.toString();
        return string;

    }

    public static void split(String string) {
        String string2 = string.replace("{", "")
                .replace("}", "")
                .replace("\"", "");
        String[] newStr = string2.split(", ");

        Map<String, String> dictionary = new HashMap<String, String>();
        for (String item : newStr) {
            String[] stringnew = item.split(":");
            System.out.println(Arrays.toString(stringnew));
            for (int i = 0; i < newStr.length; i++) {
                dictionary.put(stringnew[0], stringnew[1]);

            }
        }
        System.out.println(dictionary.entrySet());
        StringBuilder WHERE = new StringBuilder();
        Set<Map.Entry<String, String>> pair = dictionary.entrySet();
        List<Map.Entry<String, String>> list = new ArrayList<>(pair);
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getValue().equals("null")) {
                WHERE.append(list.get(i).getKey() + " = " + list.get(i).getValue() + " and ");

            }
        }
        System.out.println(WHERE);

    }

    public static void main(String[] args) {

        split(reader());

    }
}
