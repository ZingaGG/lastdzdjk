package Game;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class Game{
    private int totalGames;
    private List<Integer> switchWins = new ArrayList<>();
    private List<Integer> stayWins = new ArrayList<>();

    public Game(int totalGames) {
        this.totalGames = totalGames;
    }

    public void runGames() {
        for (int i = 0; i < totalGames; i++) {
            boolean[] doors = new boolean[3];
            int carIndex = new Random().nextInt(3);
            doors[carIndex] = true;
            int playerChoice = new Random().nextInt(3);

            int openedDoor = openDoor(playerChoice, doors);

            boolean switchChoice = new Random().nextBoolean();

            playerChoice = reChoice(switchChoice, playerChoice);

            saveResult(playerChoice, carIndex, switchChoice);
        }
    }

    private int openDoor(int playerChoice, boolean[] doors){
        int openedDoor;
        do {
            openedDoor = new Random().nextInt(3);
        } while (openedDoor == playerChoice || doors[openedDoor]);
        return openedDoor;
    }

    private int reChoice(boolean switchChoice, int playerChoice){
        if (switchChoice) {
            playerChoice = (playerChoice + 1) % 3;
        }
        return playerChoice;
    }

    // Сохранить результат игр в одну из коллекций или в какой то библиотечный класс
    private void saveResult(int playerChoice, int carIndex, boolean switchChoice){
        if (playerChoice == carIndex) {
            if (switchChoice) {
                switchWins.add(1);
            } else {
                stayWins.add(1);
            }
        }
    }

    public void printStatistics() {
        System.out.println("Победы при смене выбора: " + switchWins.size());
        System.out.println("Победы без смены выбора: " + stayWins.size());
    }
}

