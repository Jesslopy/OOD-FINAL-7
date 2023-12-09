import java.util.Scanner;

public class TowerConquestGame {
    private GameState gameState;
    private Character playerCharacter;
    private int weekCounter = 0;
    private Strategy playerStrategy;
    private int count;

    public TowerConquestGame() {
        gameState = new GameState();
        initializeGameElements();
    }

    private void initializeGameElements() {
        // Create characters
        Character hero = new Character("Hero", 100, 10);

        // Add characters to GameState
        gameState.addCharacter(hero);

        // Initialize player character
        playerCharacter = new Character("Player", 100, 10);
        gameState.addCharacter(playerCharacter);
    }

    private void allocatePoints(int alloted_points) {
        Scanner scanner = new Scanner(System.in);
        boolean pointsAllocated = false;
    
        while (!pointsAllocated) {
            count = 0; // Reset count for each attempt
            System.out.println("You have " + alloted_points + " points to allocate to Health, Strength, Wealth, and Influence.");
    
            System.out.print("Enter points for Health: ");
            int healthPoints = scanner.nextInt();
            count += healthPoints;
    
            System.out.print("Enter points for Strength: ");
            int strengthPoints = scanner.nextInt();
            count += strengthPoints;
    
            System.out.print("Enter points for Wealth: ");
            int wealthPoints = scanner.nextInt();
            count += wealthPoints;
    
            System.out.print("Enter points for Influence: ");
            int influencePoints = scanner.nextInt();
            count += influencePoints;
    
            if (count <= alloted_points) {
                playerCharacter.setHealth(healthPoints);
                playerCharacter.setStrength(strengthPoints);
                playerCharacter.setWealth(wealthPoints);
                playerCharacter.setInfluence(influencePoints);
                pointsAllocated = true; // Exit the loop
            } else {
                System.out.println("Your point allocation exceeds " + alloted_points + " points! Please try again.");
            }
        }
    }

    private void assignStrategy(String strategyName) {
        switch (strategyName.toLowerCase()) {
            case "aggressive":
                playerStrategy = new AggressiveStrategy();
                break;
            case "defensive":
                playerStrategy = new DefensiveStrategy();
                break;
            case "diplomatic":
                playerStrategy = new DiplomaticStrategy();
                break;
            default:
                System.out.println("Invalid strategy. Defaulting to Aggressive.");
                playerStrategy = new AggressiveStrategy();
        }
        // Ensure playerCharacter is not null and then set the strategy
        if (playerCharacter != null) {
            playerCharacter.setStrategy(playerStrategy);
        }
    }

    private void processWeek() {
        // Implement the logic for what happens each week
        Event event = EventFactory.createRandomEvent(); // Get a random event from EventFactory
        if (event != null) {
            event.triggerEvent(playerCharacter); // Trigger the event for the player character

        } else {
            System.out.println("No random event available.");
        }
    
    }

    private boolean checkGameOver() {
        // Check if any resource falls to zero or below
        if (playerCharacter.getHealth() <= 0 ||
            playerCharacter.getStrength() <= 0 ||
            playerCharacter.getWealth() <= 0 ||
            playerCharacter.getInfluence() <= 0) {
            return true; // Game over condition met
        }
        return false; // Game continues
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Tower Conquest!");
        System.out.print("Choose game difficulty for the number of allocation points (easy (200), normal (150), hard (100)): ");
        String difficulty = scanner.nextLine();
        GameDifficultyFacade difficultyFacade = new GameDifficultyFacade(gameState);
        int allocationPoints = difficultyFacade.getAllocationPointsForDifficulty(difficulty);



        System.out.print("Enter your character's name: ");
        String playerName = scanner.nextLine();
        playerCharacter.setName(playerName);
    
        System.out.println("Enter the name of your kingdom:");
        String kingdomName = scanner.nextLine();
        Location kingdomLocation = new Location(kingdomName); // Create a Location object
        playerCharacter.setCurrentLocation(kingdomLocation);


        allocatePoints(allocationPoints);

        // Strategy selection
        System.out.print("Choose your strategy (Aggressive, Defensive, Diplomatic): ");
        String strategyName = scanner.nextLine();
        assignStrategy(strategyName);
        playerStrategy.executeStrategy(playerCharacter, gameState);



        System.out.println("Game starts now. Survive as many weeks as you can!");

        while (true) {
            weekCounter++;
            System.out.println();
            System.out.println("Week " + weekCounter + ":");
            playerCharacter.displayResources();
            processWeek();
            // Game logic for each week

            if (checkGameOver()) {
                System.out.println("Game Over! You survived " + weekCounter + " weeks.");
                break;
            }

            System.out.println("Enter command for this week: strengthen, heal, mine, debate, exit");
            String command = scanner.nextLine();
            switch (command.toLowerCase()) {
                case "strengthen":
                    playerCharacter.setStrength(playerCharacter.getStrength() + 10); // Correct usage
                    System.out.println("Your army spent the week conditioning +10 Strength");
                    break;
                case "heal":
                    // Assuming you have a method to increase health
                    playerCharacter.increaseHealth(10); // Make sure this method exists in Character class
                    System.out.println("You spent the week recovering +10 Health");
                    break;
                case "mine":
                    playerCharacter.increaseWealth(10); // Assuming a method to increase wealth
                    System.out.println("Your miners found gold +10 Wealth");
                    break;
                case "debate":
                    playerCharacter.increaseInfluence(10); // Assuming a method to increase influence
                    System.out.println("You hosted a successful debate +10 Influence");
                    break;
                case "exit":
                    System.out.println("Exiting game after " + weekCounter + " weeks.");
                    return; // Exit the game loop
                default:
                    System.out.println("Unknown command. Please try again.");
                    break;
            }

        }

        scanner.close();
    }

    public static void main(String[] args) {
        TowerConquestGame game = new TowerConquestGame();
        game.startGame();
    }
}