package com.fortunewheel.backend.handlers.players;


public class PlayerModel {
    private final String username;
    private Integer money;
    private Integer moneyInRound;

    public String getUsername() {
        return username;
    }

    public PlayerModel(String username) {
        this.username = username;
    }

    public void resetRoundMoney() {
        moneyInRound = 0;
    }

    public void updatePlayerRoundMoney(Integer amountToUpdate) {
        if (amountToUpdate < 0 && moneyInRound < 1000) {
            moneyInRound = 0;
        } else {
            moneyInRound += amountToUpdate;
        }
    }

    public void updatePlayerMoney(Integer amountToUpdate) {
        money += amountToUpdate;
    }
}
