package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    GameStore store = new GameStore();
    Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
    Game game1 = store.publishGame("Arche Age","MMORPG");
    Game game2 = store.publishGame("Аллоды", "Аркады");
    Game game3 = store.publishGame("Lineage 2", "MMORPG");
    Game game4 = store.publishGame("Mortal Kombat", "Fights");


    @Test
    public void shouldSumGenreIfOneGame() {

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    // Новые тесты
    @Test
    public void shouldExpIfGameNotInstall() {
        Player player = new Player("Русик");
        assertThrows(RuntimeException.class, () ->{
            player.play(game3,5);
        });
    }

    @Test
    public void shouldSumGenreIfGameReplay() {

        Player player = new Player("Санек");
        player.installGame(game4);
        player.installGame(game);
        player.installGame(game3);

        player.play(game4, 3);
        player.play(game4, 3);


        int expected = 6;
        int actual = player.sumGenre("Fights");

        assertEquals(expected, actual);
    }


}
