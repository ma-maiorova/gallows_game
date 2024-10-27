package backend.academy.WordsProcessing;

import java.util.List;

public class CategoryFood implements Category {
    public static List<String> easy = List.of(
        "яблоко", "груша", "банан", "морковь", "слива",
        "персик", "арбуз", "лук", "помидор", "вишня"
    );

    public static List<String> medium = List.of(
        "ананас", "манго", "дыня", "баклажан", "лимон",
        "грейпфрут", "абрикос", "огурец", "чеснок", "капуста"
    );

    public static List<String> hard = List.of(
        "папайя", "маракуйя", "авокадо", "редиска", "брокколи",
        "свекла", "киви", "хурма", "гранат", "артишок"
    );

    public static List<String> getLevel(String level) {
        return switch (level) {
            case "easy" -> easy;
            case "medium" -> medium;
            default -> hard;
        };
    }
}
