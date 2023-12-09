public class AggressiveStrategy implements Strategy {
    @Override
    public void executeStrategy(Character character, GameState gameState) {
        System.out.println(character.getName() + " is using an aggressive strategy.");
        System.out.println("All Strength and Wealth gain increased by 1.5x");

        // Assuming you have methods to get the current gains for strength and wealth
        int currentStrengthGain = character.getStrength();
        int currentWealthGain = character.getWealth();

        // Increase gains by a factor of 1.5
        int increasedStrengthGain = (int) Math.round(currentStrengthGain * 1.5);
        int increasedWealthGain = (int) Math.round(currentWealthGain * 1.5);

        // Update the character's strength and wealth gains
        character.setStrength(increasedStrengthGain);
        character.setWealth(increasedWealthGain);
    }
}
