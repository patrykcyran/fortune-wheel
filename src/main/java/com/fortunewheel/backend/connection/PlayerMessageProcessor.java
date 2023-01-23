package com.fortunewheel.backend.connection;

import com.fortunewheel.backend.connection.Message;
import com.fortunewheel.backend.game.Functions;
import com.fortunewheel.frontend.PlayerController;
import com.fortunewheel.frontend.WheelSection;
import javafx.application.Platform;

public class PlayerMessageProcessor {
    public static void processMessage(Message message, PlayerController controller) {
        Functions function = message.getFunction();
        switch (function) {
            case SPIN -> {
                WheelSection wheelSection = WheelSection.valueOf(message.getMessage());
                controller.changeWheelView(wheelSection);
            }
            case BLOCK -> controller.blockFields();
            case UNBLOCK -> controller.unblockFields();
            case CHAT -> {
                Platform.runLater(()->controller.changeChat(message.getMessage()));
            }
            case SETUP_ROUND -> Platform.runLater(()->controller.setupRound(message.getMessage()));
            case ROUND_NUMBER -> Platform.runLater(()->controller.setRoundNumber(message.getMessage()));
            case ROUND_PLAYER -> Platform.runLater(()->controller.setCurrentPlayer(message.getMessage()));
        }
    }
}