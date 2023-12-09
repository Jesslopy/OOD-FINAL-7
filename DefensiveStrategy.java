public class DefensiveStrategy implements Strategy {
    @Override
    public void executeStrategy(Character character, GameState gameState) {
        System.out.println(character.getName() + " is using a defensive strategy.");
        System.out.println("All Strength and Health gain increased by 1.5x");

        // Get the current strength and health
        int currentStrength = character.getStrength();
        int currentHealth = character.getHealth();

        // Increase strength and health by a factor of 1.5
        int increasedStrength = (int) Math.round(currentStrength * 1.5);
        int increasedHealth = (int) Math.round(currentHealth * 1.5);

        // Update the character's strength and health
        character.setStrength(increasedStrength);
        character.setHealth(increasedHealth);
    }
}