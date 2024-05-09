/**
 * The main class the runs the application/game
 */
public class VirtualPetApp {
    public static void main(String[] args) {
        GameLoop game = new GameLoop();
        game.startGame();
    }

    /**
     * Override method for toString
     */
    @Override
    public String toString() {
        return "VirtualPetApp []";
    }

}
