package backend.academy.WordsProcessing;

import java.util.List;

public class CategoryCities implements Category {
    public static List<String> easy = List.of(
        "париж", "рим", "киев", "минск", "берлин",
        "лондон", "мадрид", "токио", "канада", "сидней"
    );

    public static List<String> medium = List.of(
        "ванкувер", "стокгольм", "будапешт", "афины", "варшава",
        "дубай", "стамбул", "чикаго", "вена", "манила"
    );

    public static List<String> hard = List.of(
        "йоханнесбург", "кострома", "копенгаген", "эдинбург", "бразилиа",
        "валлетта", "лихтенштейн", "брюссель", "каракас", "мале"
    );

    public static List<String> getLevel(String level) {
        return switch (level) {
            case "easy" -> easy;
            case "medium" -> medium;
            default -> hard;
        };
    }
}
