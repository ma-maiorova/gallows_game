package backend.academy.WordsProcessing;

import java.util.List;

public class CategoryAnimal implements Category {
    public static List<String> easy = List.of(
        "кот", "собака", "лиса", "утка", "сова",
        "лось", "тигр", "кит", "рак", "лев"
    );

    public static List<String> medium = List.of(
        "кенгуру", "воробей", "ястреб", "енот", "верблюд",
        "омар", "зебра", "барсук", "питон", "хомяк"
    );

    public static List<String> hard = List.of(
        "аллигатор", "гиппопотам", "дельфин", "коала", "хамелеон",
        "носорог", "мангуст", "фламинго", "птеродактиль", "сурикат"
    );

    public static List<String> getLevel(String level) {
        return switch (level) {
            case "easy" -> easy;
            case "medium" -> medium;
            default -> hard;
        };
    }
}
