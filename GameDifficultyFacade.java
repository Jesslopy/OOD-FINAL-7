public class GameDifficultyFacade {
    private GameState gameState;

    public GameDifficultyFacade(GameState gameState) {
        this.gameState = gameState;
    }

    public int getAllocationPointsForDifficulty(String difficulty) {
        switch (difficulty.toLowerCase()) {
            case "easy":
                return 200; // More points for easy mode
            case "normal":
                return 150; // Standard points for normal mode
            case "hard":
                return 100; // Fewer points for hard mode
            default:
                return 200;
        }
    }
}
