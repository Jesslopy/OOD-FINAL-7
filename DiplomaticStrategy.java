public class DiplomaticStrategy implements Strategy {
    @Override
    public void executeStrategy(Character character, GameState gameState) {
        System.out.println(character.getName() + " is engaging in diplomacy.");
        System.out.println("All Influence and Wealth gain increased by 1.5x");

        // Get the current influence and wealth
        int currentInfluence = character.getInfluence();
        int currentWealth = character.getWealth();

        // Increase influence and wealth by a factor of 1.5
        int increasedInfluence = (int) Math.round(currentInfluence * 1.5);
        int increasedWealth = (int) Math.round(currentWealth * 1.5);

        // Update the character's influence and wealth
        character.setInfluence(increasedInfluence);
        character.setWealth(increasedWealth);
    }
}