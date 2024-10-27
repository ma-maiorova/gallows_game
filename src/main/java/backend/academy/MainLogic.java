package backend.academy;

import backend.academy.WordsProcessing.Dictionary;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class MainLogic {
    public void Play() {
        Map<String, String> how_level = new HashMap<>();
        how_level.put("1", "easy");
        how_level.put("2", "medium");
        how_level.put("3", "hard");

        Map<String, String> how_category = new HashMap<>();
        how_category.put("1", "Animal");
        how_category.put("2", "Cities");
        how_category.put("3", "Food");
        how_category.put("4", "Sport");

        Scanner scanner = new Scanner(System.in);
        Dictionary Dictionary = new Dictionary();
        while (true) {
            System.out.println("Игра Виселица, привет!");
            System.out.println("Хотите поиграть? (да/нет)");

            if (scanner.hasNextLine()) {
                String input = scanner.nextLine().trim().toLowerCase();

                if (input.equals("да")) {
                    System.out.println("Начинаем игру!");
                    // Здесь запускается игра
                } else if (input.equals("нет")) {
                    System.out.println("Пока!");
                    break;
                } else {
                    System.out.println("Некорректный ввод, попробуйте снова.");
                }
            } else {
                System.out.println("Не удалось получить ввод.");
                break;
            }

//            String input = scanner.nextLine().trim().toLowerCase();
//            if (input.equals("нет")) {
//                break;
//            }
            System.out.println("Выберите категорию слов: 1 - Животные, 2 - Города, 3 - Еда, 4 - Спорт (если просто нажать Enter уровень будет выбран случайно): ");
            String category = scanner.nextLine();
            if (category.isEmpty() || !Arrays.asList("1", "2", "3", "4").contains(category)) {
                category = how_category.get(Dictionary.getRandomCategory());
                System.out.println("Ваша категория слов: " + category);
            } else category = how_category.get(category);

            System.out.println("Выберите уровень сложности набора слов - 1,2,3 (если просто нажать Enter уровень будет выбран случайно): ");
            String level = scanner.nextLine();
            if (level.isEmpty() || !Arrays.asList("1", "2", "3").contains(level)) {
                level = Dictionary.getRandomLevel();
                System.out.println("Ваш уровень сложности набора слов: " + level);
            } else level = how_level.get(level);

            System.out.println("Выберите уровень сложности количества жизней - 1,2,3 (если просто нажать Enter уровень будет выбран случайно): ");
            String level_str = scanner.nextLine();
            int level_lives;
            if (level_str.isEmpty() || !Arrays.asList("1", "2", "3").contains(level_str)) {
                Random random = new Random();
                level_lives = random.nextInt(3) + 1;
                System.out.println("Ваш уровень сложности количества жизней : " + level_lives);
            } else level_lives = Integer.parseInt(level_str);

            String secret_word = Dictionary.getRandomWord(category, level);

            Game game = new Game(secret_word, level_lives);
            System.out.println("У вас есть " + game.getUserLives() + " попыток.");
            game.playGame();
            System.out.println("Игра завершена! Нажмите Enter, чтобы продолжить.");
            scanner.nextLine();
        }
    }
}
