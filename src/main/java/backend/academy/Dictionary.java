package backend.academy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Arrays;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Dictionary {
    private Map<String, List<String>> categories;

    public Dictionary() {
        categories = new HashMap<String, List<String>>();
        readFromFail("/home/marina/Java-projects/Academy-of-backend/backend_academy_2024_project_1-java-ma-maiorova/src/main/java/backend/academy/dict_easy.txt", "easy");
        readFromFail("/home/marina/Java-projects/Academy-of-backend/backend_academy_2024_project_1-java-ma-maiorova/src/main/java/backend/academy/dict_medium.txt", "medium");
        readFromFail("/home/marina/Java-projects/Academy-of-backend/backend_academy_2024_project_1-java-ma-maiorova/src/main/java/backend/academy/dict_hard.txt", "hard");
    }

    private void readFromFail(String filename, String type) {
        try {
            List<String> words = Files.readAllLines(Paths.get(filename), java.nio.charset.StandardCharsets.UTF_8);
            categories.put(type, words);
        } catch (IOException e) {
            System.out.println("Can`t read " + filename + " " + type);
            e.printStackTrace();
        }
    }

    public String getRandomWord(String type) {
        if (Arrays.asList("easy", "medium", "hard").contains(type)) {
            type = getRandomCategory();
        }
        List<String> words = categories.get(type);
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

    public String getRandomCategory() {
        Random random = new Random();
        int level = random.nextInt(3) + 1;
        if (level == 1) {
            return "easy";
        } else if (level == 2) {
            return "medium";
        }
        return "hard";
    }
}
