package backend.academy;

import lombok.experimental.UtilityClass;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

@UtilityClass

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Map<String, String> how_level = new HashMap<>();
        how_level.put("1", "easy");
        how_level.put("2", "medium");
        how_level.put("3", "hard");
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
            System.out.println("Выберите уровень сложности набора слов - 1,2,3 (если просто нажать Enter уровень будет выбран случайно): ");
            String level = scanner.nextLine();
            if (level.isEmpty() || !Arrays.asList("1", "2", "3").contains(level)) {
                level = Dictionary.getRandomCategory();
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

            String secret_word = Dictionary.getRandomWord(level);

            Game game = new Game(secret_word, level_lives);
            System.out.println("У вас есть " + game.getUserLives() + " попыток.");
            game.playGame();
            System.out.println("Игра завершена! Нажмите Enter, чтобы продолжить.");
            scanner.nextLine();
        }
    }
}
