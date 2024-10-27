package backend.academy.WordsProcessing;

import java.util.List;

public class CategorySport implements Category {
    public static List<String> easy = List.of(
        "футбол", "хоккей", "баскетбол", "теннис", "гольф",
        "волейбол", "плавание", "шахматы", "дзюдо", "бег"
    );

    public static List<String> medium = List.of(
        "фехтование", "биатлон", "гимнастика", "триатлон", "сноуборд",
        "регби", "бокс", "крикет", "гребля", "йога"
    );

    public static List<String> hard = List.of(
        "скалолазание", "сумо", "паркур", "автогонки", "шахматы",
        "кёрлинг", "фристайл", "бодибилдинг", "ушу", "прыжки"
    );

    public static List<String> getLevel(String level) {
        return switch (level) {
            case "easy" -> easy;
            case "medium" -> medium;
            default -> hard;
        };
    }
}
