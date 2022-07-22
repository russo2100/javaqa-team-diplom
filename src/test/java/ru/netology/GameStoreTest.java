package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameStoreTest {

    public GameStore store = new GameStore();
    public Game game1 = new Game("Крестики нолики", "головоломка", store);

    @Test
    public void shouldAddGame() {

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertEquals(true, store.containsGame(game));
    }

    @Test
    public void shouldContainsGameNotGame() {
        assertTrue(!store.containsGame(game1));
    }

    @Test
    public void shouldContainsLostGame() {
        Game game2 = store.publishGame("game2", "genre2");
        Game game3 = store.publishGame("game3", "genre3");
        Game game4 = store.publishGame("game4", "genre4");
        Game game5 = store.publishGame("game5", "genre5");
        Game game6 = store.publishGame("game6", "genre6");

        assertTrue(store.containsGame(game6));
    }

    @Test
    public void shouldContainsGame() {
        Game game2 = store.publishGame("game2", "genre2");
        Game game3 = store.publishGame("game3", "genre3");
        Game game4 = store.publishGame("game4", "genre4");
        Game game5 = store.publishGame("game5", "genre5");
        Game game6 = store.publishGame("game6", "genre6");

        assertTrue(store.containsGame(game4));
    }

    @Test
    public void shouldGetMostPlayer4() {
        store.addPlayTime("Player1", 1);
        store.addPlayTime("Player2", 3);
        store.addPlayTime("Player3", 7);
        store.addPlayTime("Player4", 20);
        store.addPlayTime("Player5", 5);
        store.addPlayTime("Player6", 5);

        String actual = store.getMostPlayer();
        String expected = "Player4";

        assertEquals(actual, expected);

    }

    @Test
    public void shouldGetMostPlayerOneHour() {
        store.addPlayTime("Player1", 1);

        String actual = store.getMostPlayer();
        String expected = "Player1";

        assertEquals(actual, expected);

    }

    @Test
    public void shouldGetMostPlayerNull() {

        String actual = store.getMostPlayer();

        assertNull(actual);
    }

    @Test
    public void shouldAddPlayTime() {
        store.addPlayTime("Player1", 2);
        store.addPlayTime("Player2", 3);
        store.addPlayTime("Player1", 7);

        String actual = store.getMostPlayer();
        String expected = "Player1";

        assertEquals(actual, expected);


    }

    @Test
    public void shouldGetSumPlayedTime() {
        store.addPlayTime("Player1", 1);
        store.addPlayTime("Player2", 3);
        store.addPlayTime("Player3", 7);
        store.addPlayTime("Player4", 20);
        store.addPlayTime("Player5", 5);
        store.addPlayTime("Player6", 5);


        assertEquals(41, store.getSumPlayedTime());

    }


}
