public class Character {
    private String name;
    private int health;
    private int strength;
    private Component currentLocation;
    private int wealth; // For events affecting wealth
    private int influence; // For diplomatic events
    private boolean infected; // For plague events
    private Strategy strategy;
    private int morale; // For events affecting morale

    // Resource types
    private int food;
    private int gold;

    public Character(String name, int health, int strength) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.wealth = 0; // Initial wealth
        this.influence = 0; // Initial influence
        this.infected = false; // Initial health status
        this.morale = 0; // Initial morale
        this.food = 100; // Initial food resource
        this.gold = 50; // Initial gold resource
        this.currentLocation = currentLocation;
    }


    public void setWealth(int wealth) {
        this.wealth = wealth;
    }
    
    public void setInfluence(int influence) {
        this.influence = influence;
    }
    
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Component getCurrentLocation() {
        return currentLocation;
    }

    public void increaseWealth(int amount) {
        this.wealth += amount;
    }

    public void increaseHealth(int amount) {
        this.health += amount;
        if (this.health > 100) this.health = 100; // Assuming 100 is the max health
    }

    public void increaseInfluence(int amount) {
        this.influence += amount;
    }

    public void loseResources(String resource, int amount) {
        switch (resource.toLowerCase()) {
            case "food":
                this.food -= amount;
                if (this.food < 0) this.food = 0;
                break;
            case "gold":
                this.gold -= amount;
                if (this.gold < 0) this.gold = 0;
                break;
            default:
                System.out.println("Unknown resource type.");
        }
    }

    public void displayResources() {
        System.out.println("Character's Resources:");
        System.out.println("Health: " + health);
        System.out.println("Strength: " + strength);
        System.out.println("Wealth: " + wealth);
        System.out.println("Influence: " + influence);
        // Add other resources if needed
    }

    public void setInfected(boolean infected) {
        this.infected = infected;
    }

    public void increaseMorale(int amount) {
        this.morale += amount;
    }

    public void increaseStrength(int amount){
        this.strength += amount;
    }

    public void decreaseHealth(int amount) {
        this.health -= amount;
        if (this.health < 0) this.health = 0;
    }

    public void decreaseStrength(int amount) {
        this.strength -= amount;
        if (this.strength < 0) this.strength = 0;
    }

    public void decreaseInfluence(int amount) {
        this.influence -= amount;
        if (this.influence < 0) this.influence = 0;
    }

    public void decreaseWealth(int amount) {
        this.wealth -= amount;
        if (this.wealth < 0) this.wealth = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }



    public int getWealth() {
        return wealth;
    }

    public int getInfluence() {
        return influence;
    }

    public boolean isInfected() {
        return infected;
    }

    public int getMorale() {
        return morale;
    }

    public int getFood() {
        return food;
    }

    public int getGold() {
        return gold;
    }

    public void setCurrentLocation(Component currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void interactWithEvent(Event event) {
        event.triggerEvent(this);
        // Additional logic for interaction can be added here
    }
}