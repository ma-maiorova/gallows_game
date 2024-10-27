package backend.academy.WordsProcessing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Dictionary {
    private Map<String, List<String>> categories;
//    private List<String> useCategories = List.of("Animal", "Cities", "Food", "Sport");

    public Dictionary() {
//        categories = new HashMap<String, List<String>>();
//        readFromFail("/home/marina/Java-projects/Academy-of-backend/backend_academy_2024_project_1-java-ma-maiorova/src/main/java/backend/academy/resources/dict_easy.txt", "easy");
//        readFromFail("/home/marina/Java-projects/Academy-of-backend/backend_academy_2024_project_1-java-ma-maiorova/src/main/java/backend/academy/resources/dict_medium.txt", "medium");
//        readFromFail("/home/marina/Java-projects/Academy-of-backend/backend_academy_2024_project_1-java-ma-maiorova/src/main/java/backend/academy/resources/dict_hard.txt", "hard");
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

    public String getRandomCategory() {
        Random random = new Random();
        int cat = random.nextInt(4) + 1;
        return Integer.toString(cat);
    }

    public String getRandomWord(String cat, String type) {
        Random random = new Random();
        List<String> words;
        switch (cat) {
            case "Animal" ->
                words = CategoryAnimal.getLevel(type);
            case "Cities" ->
                words = CategoryCities.getLevel(type);
            case "Food" ->
                words = CategoryFood.getLevel(type);
            case "Sport" ->
                words = CategorySport.getLevel(type);
            default ->
                words = CategoryAnimal.getLevel(type);
        }
        return words.get(random.nextInt(words.size()));
    }

    public String getRandomLevel() {
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
