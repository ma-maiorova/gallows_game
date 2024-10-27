import backend.academy.Game;
import backend.academy.WordsProcessing.Dictionary;
import org.junit .Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class GameTest {
    @Test
    public void testRandCategory() {
        Dictionary Dictionary = new Dictionary();
        String level = Dictionary.getRandomLevel();
        assertTrue(Arrays.asList("easy", "medium", "hard").contains(level));
    }

    @Test
    public void testRandWord() {
        Dictionary Dictionary = new Dictionary();
        String cat = Dictionary.getRandomCategory();
        String word = Dictionary.getRandomWord(cat, "easy");
        assertNotNull(word);
        assertFalse(word.isEmpty());
        word = Dictionary.getRandomWord(cat, "medium");
        assertNotNull(word);
        assertFalse(word.isEmpty());
        word = Dictionary.getRandomWord(cat, "hard");
        assertNotNull(word);
        assertFalse(word.isEmpty());
    }

    @Test
    public void testGameStart() {
        Game game = new Game("старт");
        game.checkLetter('т');
        assertEquals(game.getUserWord(), "_т__т");
    }

    @Test
    public void testGameProcess() {
        Game game = new Game("старт");
        game.checkLetter('т');
        assertEquals(game.getUserWord(), "_т__т");
        game.checkLetter('С');
        assertEquals(game.getUserWord(), "ст__т");
        game.checkLetter('й');
        assertEquals(game.getUserWord(), "ст__т");
    }

    @Test
    public void wordNotNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Game("");
        });
    }

    @Test
    public void testGameMaxErrors() {
        Game game = new Game("старт");
        char i = 'а';
        while (i != 'я') {
            game.checkLetter(i);
            i += 1;
        }
        assertTrue(game.gameOver());
    }

    @Test
    public void testGameErrorLetter() {
        Game game = new Game("старт");
        // boolean flag = game.checkLetter("fe"); идет проверка на вводе, что лишь 1 буква, функция checLetter принимает только char
        // assertFalse(flag);
    }
}
