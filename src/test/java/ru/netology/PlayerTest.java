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
    Game game5 = store.publishGame("World of Tanks", "Simulator");


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


    @Test
    public void addDoubleGame() {
        Player player = new Player("Петя");
        player.installGame(game);
        player.play(game, 1);
        player.installGame(game);

        int expected = 1;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }


    @Test
    public void mostPlayerByGenreGamePlayed() {
        Player player = new Player("Жорж");
        player.installGame(game4);
        player.installGame(game5);
        player.installGame(game2);

        player.play(game4, 6);
        player.play(game5, 5);
        player.play(game2, 3);


        Game expected = game4;
        Game actual = player.mostPlayerByGenre("Fights");

        assertEquals(expected, actual);
    }


}
