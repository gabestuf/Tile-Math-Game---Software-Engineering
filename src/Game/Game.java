package Game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    // Moving right adds the numbers
    // Moving left subtracts the selected tile from the left tile, only works if result is positive
    // Moving down divides bottom tile by selected tile, only works if result is whole number
    // Moving up multiplies
    // You win the game by only having the center tile be the only remaining tile

    public ChoiceHandler cHandler = new ChoiceHandler();
    public UI ui = new UI();
    public VisibilityManager vm = new VisibilityManager(ui);
    public Board board = new Board(this, ui, vm);

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        ui.createUI(cHandler);
        board.initBoard();
        vm.showBoard();
    }

    public class ChoiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String yourChoice = event.getActionCommand();

            switch (yourChoice) {
                case "start": vm.showBoard();
                    break;
                case "quit": vm.exitGame(); break;
                case "toQuitScreen": vm.showQuitScreen(); break;
                case "00": board.selectPiece(0,0); break;
                case "10": board.selectPiece(1,0); break;
                case "20": board.selectPiece(2,0); break;
                case "01": board.selectPiece(0,1); break;
                case "11": board.selectPiece(1,1); break;
                case "21": board.selectPiece(2,1); break;
                case "02": board.selectPiece(0,2); break;
                case "12": board.selectPiece(1,2); break;
                case "22": board.selectPiece(2,2); break;
                case "reset": board.resetGame(); break;
                default:
                    board.movePiece(yourChoice);
                    break;
            }
        }
    }
}
