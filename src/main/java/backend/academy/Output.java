package backend.academy;

import java.security.PublicKey;
import java.util.Set;

public class Output {
    private static final String[] Gallow = {
            "  +---+\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",

            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",

            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",

            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",

            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",

            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " /    |\n" +
                    "      |\n" +
                    "=========",

            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " / \\  |\n" +
                    "      |\n" +
                    "========="
    };

    public void printWord(String word) {
        System.out.println("Сейчас слово выглядит так: " + word);
    }

    public void printErrors(int errors, int lives) {
        System.out.println("Уже было " + errors + " попыток, осталось " + lives);
    }

    public void printCorrectLetters(Set<Character> cur) {
        System.out.print("Угаданные буквы: ");
        for (char c : cur) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public void printErrorLetters(Set<Character> cur) {
        System.out.print("Неправильные буквы: ");
        for (char c : cur) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public void printGallow(int step, int lives) {
        if (lives <= 6) {
            if (step == lives) {
                System.out.println(Gallow[6]);
            } else {
                System.out.println(Gallow[step]);
            }
            return;
        }

        System.out.println(Gallow[step]);
    }

}
