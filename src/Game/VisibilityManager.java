package Game;

import java.awt.Color;

public class VisibilityManager {
    UI ui;

    public VisibilityManager(UI userInterface) {
        ui = userInterface;
    }

    public void showQuitScreen() {
        //Show Quit Screen
        ui.quitNamePanel.setVisible(true);
        ui.boardButtonPanel.setVisible(true);

        //Hide GAME Screen
        ui.topPanel.setVisible(false);
        ui.tilePanel.setVisible(false);
        ui.moveButtonPanel.setVisible(false);
    }

    public void showBoard() {
        //Show Game Screen
        ui.topPanel.setVisible(true);
        ui.tilePanel.setVisible(true);
        ui.moveButtonPanel.setVisible(true);

        //Hide Quit Screen
        ui.quitNamePanel.setVisible(false);
        ui.boardButtonPanel.setVisible(false);
    }

    public void winGame() {
        //Show Game Screen
        ui.topPanel.setVisible(true);
        ui.tilePanel.setVisible(true);
        ui.button11.setBackground(Color.green);
        ui.moveButtonPanel.setVisible(false);
        ui.screenLabel.setText("      You Win :)");
        ui.screenLabel.setForeground(Color.green);

        //Hide Quit Screen
        ui.quitNamePanel.setVisible(false);
        ui.boardButtonPanel.setVisible(false);
    }

    public void loseGame() {
        //Show Game Screen
        ui.topPanel.setVisible(true);
        ui.tilePanel.setVisible(true);
        ui.moveButtonPanel.setVisible(false);
        ui.screenLabel.setText("      You Lose :(");
        ui.screenLabel.setForeground(Color.red);


        //Hide Quit Screen
        ui.quitNamePanel.setVisible(false);
        ui.boardButtonPanel.setVisible(false);
    }

    public void exitGame() {
        System.exit(0);
    }

}
