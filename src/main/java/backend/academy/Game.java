package backend.academy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Game {
    private String secret_word;
    private String user_word;
    private Set<Character> used_letters;
    private Set<Character> correct_letters;
    private Set<Character> wrong_letters;
    private int cur_user_lives;
    private int user_lives;
    private int MAX_USER_LIVES = 6;
    //    private String hint;
    private int errors;
    private Output output;
    Scanner scanner = new Scanner(System.in);

//    private int need_find;

    public Game(String secret_word) {
        this(secret_word, 0);
    }

    public Game(String secret_word, int lives_level) {
        if (secret_word == null || secret_word.isEmpty()) {
            throw new IllegalArgumentException("Неверное слово");
        }
        this.secret_word = secret_word;
        this.user_word = "_".repeat(secret_word.length());
        this.used_letters = new HashSet<Character>();
        this.correct_letters = new HashSet<>();
        this.wrong_letters = new HashSet<>();
        if (lives_level == 1) {
            this.cur_user_lives = min(secret_word.length() - 1, MAX_USER_LIVES);
        } else if (lives_level == 2) {
            this.cur_user_lives = min(secret_word.length()  - secret_word.length() / 3, MAX_USER_LIVES);
        } else if (lives_level == 3) {
            this.cur_user_lives = min(secret_word.length()  - secret_word.length() / 2, MAX_USER_LIVES);
        }
        this.user_lives = this.cur_user_lives;
//        this.hint = hint;
        this.errors = 0;
        this.output = new Output();
//        this.need_find = 0;
    }

    public boolean checkLetter(char letter) {
        letter = Character.toLowerCase(letter);
        if (wrong_letters.contains(letter)) {
            return false;
        }
        boolean letter_found = false;
        for (int i = 0; i < secret_word.length(); ++i) {
            if (letter == secret_word.charAt(i)) {
                user_word = user_word.substring(0, i) + letter + user_word.substring(i + 1);
                letter_found = true;
            }
        }
        if (letter_found) {
            correct_letters.add(letter);
        } else {
            wrong_letters.add(letter);
            errors++;
            cur_user_lives--;
        }
        return letter_found;
    }

    public boolean checkWord(String word) {
        return secret_word.equals(user_word);
    }

    public boolean gameOver() {
        return user_lives == errors || Objects.equals(user_word, secret_word);
    }

    public String getAnswer() {
        return secret_word;
    }

    public String getUserWord() {
        return user_word;
    }

    public String getHint() {
        return "hint";
    }

    public int getUserLives() {
        return cur_user_lives;
    }

    public void playGame() {
        while (!gameOver()) {
            output.printWord(user_word);
            output.printCorrectLetters(correct_letters);
            output.printErrorLetters(wrong_letters);
            output.printErrors(errors, cur_user_lives);
            System.out.println("Введите букву:");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Неверный ввод. Пожалуйста, введите одну букву.");
                continue;
            }
            char cur_letter = input.charAt(0);
            if (!checkLetter(cur_letter)) {
                System.out.println("Неправильная буква, осталось попыток: " + getUserLives());
            } else {
                System.out.println("Правильная буква!");
            }
            output.printGallow(errors, user_lives);
        }
        if (checkWord(secret_word)) {
            System.out.println("Вы угадали слово: " + secret_word);
        } else {
            System.out.println("Вы проиграли( Загаданное слово: " + secret_word);
            output.printGallow(errors, user_lives);
        }
    }
}
