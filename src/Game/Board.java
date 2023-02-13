package Game;
import java.awt.Color;

public class Board {
    Game game;
    UI ui;
    VisibilityManager vm;
    int remainingTiles;

    Tile[][] tileArr = new Tile[3][3];
    Tile selectedTile;


    public Board (Game game_, UI ui_, VisibilityManager vm_) {
        game = game_;
        ui = ui_;
        vm = vm_;
    }

    public void initBoard() {
        tileArr[0][0] = new Tile(7,0,0);
        tileArr[1][0] = new Tile(2,1,0);
        tileArr[2][0] = new Tile(8,2,0);
        tileArr[0][1] = new Tile(1,0,1);
        tileArr[1][1] = new Tile(4,1,1);
        tileArr[2][1] = new Tile(9,2,1);
        tileArr[0][2] = new Tile(6,0,2);
        tileArr[1][2] = new Tile(3,1,2);
        tileArr[2][2] = new Tile(5,2,2);

        remainingTiles = 9;
    }

    public boolean isLastTileWin() {

        boolean middleTileVisible = tileArr[1][1].isVisible;

        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(tileArr[i][i] == tileArr[1][1])) {
                    if(tileArr[i][i].isVisible) {
                        return false;
                    }
                }
            }
        }

        return middleTileVisible;
    }

    public void deselectPieces() {
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                if (tileArr[i][j].isSelected) {
                    tileArr[i][j].isSelected = false;
                    unpaintPiece(i,j);
                }
            }
        }
    }

    public void hideMoveButton() {
        ui.downButton.setVisible(false);
        ui.upButton.setVisible(false);
        ui.leftButton.setVisible(false);
        ui.rightButton.setVisible(false);
    }

    public void hideButton() {
        int x = selectedTile.posX;
        int y = selectedTile.posY;

        switch (x) {
            case 0:
                switch(y) {
                    case 0: ui.button00.setVisible(false); break;
                    case 1: ui.button01.setVisible(false); break;
                    case 2: ui.button02.setVisible(false); break;
                    default: break;
                } break;
            case 1:
                switch (y) {
                    case 0: ui.button10.setVisible(false); break;
                    case 1: ui.button11.setVisible(false); break;
                    case 2: ui.button12.setVisible(false); break;
                    default: break;
                } break;
            case 2:
                switch (y) {
                    case 0: ui.button20.setVisible(false); break;
                    case 1: ui.button21.setVisible(false); break;
                    case 2: ui.button22.setVisible(false); break;
                    default: break;
                } break;
            default: break;
        }
    }

    public void winGame() {

        vm.winGame();

    }

    public void loseGame() {
        vm.loseGame();
    }

    public void resetGame() {
        deselectPieces();
        initBoard();
        vm.showBoard();
        ui.screenLabel.setText("   TILE GAME");
        ui.screenLabel.setForeground(Color.magenta);
        ui.resetUI();
    }

    public void selectPiece(int x, int y) {

        deselectPieces();

        switch (x) {
            case 0:
                switch(y) {
                    case 0: ui.button00.setBackground(Color.DARK_GRAY); selectedTile = tileArr[0][0]; tileArr[0][0].isSelected = true; updatePossibleMoves(); break;
                    case 1: ui.button01.setBackground(Color.DARK_GRAY); selectedTile = tileArr[0][1]; tileArr[0][1].isSelected = true; updatePossibleMoves(); break;
                    case 2: ui.button02.setBackground(Color.DARK_GRAY); selectedTile = tileArr[0][2]; tileArr[0][2].isSelected = true; updatePossibleMoves(); break;
                    default: break;
                } break;
            case 1:
                switch (y) {
                    case 0: ui.button10.setBackground(Color.DARK_GRAY); selectedTile = tileArr[1][0]; tileArr[1][0].isSelected = true; updatePossibleMoves(); break;
                    case 1: ui.button11.setBackground(Color.DARK_GRAY); selectedTile = tileArr[1][1]; tileArr[1][1].isSelected = true; updatePossibleMoves(); break;
                    case 2: ui.button12.setBackground(Color.DARK_GRAY); selectedTile = tileArr[1][2]; tileArr[1][2].isSelected = true; updatePossibleMoves(); break;
                    default: break;
                } break;
            case 2:
                switch (y) {
                    case 0: ui.button20.setBackground(Color.DARK_GRAY); selectedTile = tileArr[2][0]; tileArr[2][0].isSelected = true; updatePossibleMoves(); break;
                    case 1: ui.button21.setBackground(Color.DARK_GRAY); selectedTile = tileArr[2][1]; tileArr[2][1].isSelected = true; updatePossibleMoves(); break;
                    case 2: ui.button22.setBackground(Color.DARK_GRAY); selectedTile = tileArr[2][2]; tileArr[2][2].isSelected = true; updatePossibleMoves(); break;
                    default: break;
                } break;
            default: break;
        }

    }



    public void isGameOver() {
        int remainingMoves = 0;
        if(remainingTiles == 1) {
            gameOver();
        } else {
            for(int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(hasPossibleMoves(tileArr[i][j])) {
                        remainingMoves++;
                    }
                }
            }
        }
        if(remainingMoves == 0)
            gameOver();
    }

    public boolean hasPossibleMoves(Tile t) {
        selectedTile = t;
        return (canMoveUp() || canMoveDown() || canMoveLeft() || canMoveRight());
    }

    public void gameOver() {
        if (remainingTiles == 1 && isLastTileWin()) {
            vm.winGame();
        } else
            vm.loseGame();
    }

    public void movePiece(String direction) {
        switch(direction) {
            case "moveRight": moveRight(); break;
            case "moveLeft": moveLeft(); break;
            case "moveUp": moveUp(); break;
            case "moveDown": moveDown(); break;
            default:
                break;
        }
        remainingTiles--;
        hideMoveButton();
        hideButton();
        isGameOver();
    }

    public void moveRight() {
        int x = selectedTile.posX;
        int y = selectedTile.posY;

        tileArr[x+1][y].value = tileArr[x][y].value + tileArr[x+1][y].value;
        tileArr[x][y].isVisible = false;

        updateButtonValue(x+1, y,tileArr[x+1][y].value);
    }

    public void moveLeft() {
        int x = selectedTile.posX;
        int y = selectedTile.posY;

        tileArr[x-1][y].value = tileArr[x-1][y].value - tileArr[x][y].value;
        tileArr[x][y].isVisible = false;

        updateButtonValue(x-1,y,tileArr[x-1][y].value);
    }

    public void moveUp() {
        int x = selectedTile.posX;
        int y = selectedTile.posY;

        tileArr[x][y-1].value = tileArr[x][y-1].value * tileArr[x][y].value;
        tileArr[x][y].isVisible = false;

        updateButtonValue(x, y-1,tileArr[x][y-1].value );
    }

    public void moveDown() {
        int x = selectedTile.posX;
        int y = selectedTile.posY;

        tileArr[x][y+1].value = tileArr[x][y+1].value / tileArr[x][y].value;
        tileArr[x][y].isVisible = false;

        updateButtonValue(x,y+1,tileArr[x][y+1].value);
    }

    public void updateButtonValue(int x, int y, int value) {
        switch (x) {
            case 0:
                switch(y) {
                    case 0: ui.button00.setText("" + value); break;
                    case 1: ui.button01.setText("" + value); break;
                    case 2: ui.button02.setText("" + value); break;
                    default: break;
                } break;
            case 1:
                switch (y) {
                    case 0: ui.button10.setText("" + value); break;
                    case 1: ui.button11.setText("" + value); break;
                    case 2: ui.button12.setText("" + value); break;
                    default: break;
                } break;
            case 2:
                switch (y) {
                    case 0: ui.button20.setText("" + value); break;
                    case 1: ui.button21.setText("" + value); break;
                    case 2: ui.button22.setText("" + value); break;
                    default: break;
                } break;
            default: break;
        }
    }

    public void updatePossibleMoves() {
        if (canMoveUp()) {
            ui.upButton.setVisible(true);
        } else {ui.upButton.setVisible(false);}
        if (canMoveDown()) {
            ui.downButton.setVisible(true);
        } else {ui.downButton.setVisible(false);}
        if (canMoveLeft()) {
            ui.leftButton.setVisible(true);
        } else {ui.leftButton.setVisible(false);}
        if (canMoveRight()) {
            ui.rightButton.setVisible(true);
        } else {ui.rightButton.setVisible(false);}
    }

    public boolean canMoveUp() {
        return (selectedTile.isVisible && (selectedTile.posY - 1 > 0) && tileArr[selectedTile.posX][selectedTile.posY-1].isVisible);
    }

    public boolean canMoveDown() {
        double x;
        if (selectedTile.posY + 1 < 3) {
            x = (double)tileArr[selectedTile.posX][selectedTile.posY + 1].value / (double)selectedTile.value;
            return (selectedTile.isVisible && (3 > selectedTile.posY + 1) && ( x== (int)x) && tileArr[selectedTile.posX][selectedTile.posY+1].isVisible);
        } else
            return false;

    }

    public boolean canMoveLeft() {
        int x;
        if (selectedTile.posX - 1 > -1) {
            x = tileArr[selectedTile.posX - 1][selectedTile.posY].value - selectedTile.value;
            return (selectedTile.isVisible && (-1 < selectedTile.posX - 1) && (x >= 0) &&tileArr[selectedTile.posX-1][selectedTile.posY].isVisible);
        } else {
            return false;}
    }

    public boolean canMoveRight() {
        return (selectedTile.isVisible && (selectedTile.posX + 1 < 3) && tileArr[selectedTile.posX+1][selectedTile.posY].isVisible);
    }

    public void unpaintPiece(int x, int y) {

        switch (x) {
            case 0:
                switch(y) {
                    case 0: ui.button00.setBackground(Color.black); break;
                    case 1: ui.button01.setBackground(Color.black); break;
                    case 2: ui.button02.setBackground(Color.black); break;
                    default: break;
                } break;
            case 1:
                switch (y) {
                    case 0: ui.button10.setBackground(Color.black); break;
                    case 1: ui.button11.setBackground(Color.black); break;
                    case 2: ui.button12.setBackground(Color.black); break;
                    default: break;
                } break;
            case 2:
                switch (y) {
                    case 0: ui.button20.setBackground(Color.black); break;
                    case 1: ui.button21.setBackground(Color.black); break;
                    case 2: ui.button22.setBackground(Color.black); break;
                    default: break;
                } break;
            default:
                break;
        }
    }
}
