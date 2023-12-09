public interface Event {
    void triggerEvent(Character character);
}

class InvasionEvent implements Event {
    @Override
    public void triggerEvent(Character character) {
        System.out.println("An invasion has occurred [Health -10] [Influence -10]");
        // The character may lose health, or fight back, etc.
        character.decreaseHealth(10);
        character.decreaseInfluence(10);
    }
}

class FamineEvent implements Event {
    @Override
    public void triggerEvent(Character character) {
        System.out.println("A severe famine has struck [Health -15] [Strength -15] ");
        character.decreaseHealth(15);
        character.decreaseStrength(15);
    }
}

class TreasureDiscoveryEvent implements Event {
    @Override
    public void triggerEvent(Character character) {
        System.out.println( "You have discovered a hidden treasure [Wealth +30]");
        character.increaseWealth(30); // Assuming a method to increase wealth exists.
    }
}

class DiplomaticEvent implements Event {
    @Override
    public void triggerEvent(Character character) {
        System.out.println("You have entered into a diplomatic encounter [Influence +10]");
        character.increaseInfluence(10); // Assuming a method to increase influence exists.
    }
}

class NaturalDisasterEvent implements Event {
    @Override
    public void triggerEvent(Character character) {
        System.out.println("A devastating natural disaster has occurred [Health -15] [Strength -15] [Wealth -10]");
        character.decreaseHealth(15);
        character.decreaseStrength(15);
        character.decreaseWealth(10);
    }
}

class TradeOpportunityEvent implements Event {
    @Override
    public void triggerEvent(Character character) {
        System.out.println(character.getName() + " has encountered a lucrative trade opportunity [Wealth +25]");
        character.increaseWealth(25);
    }
}

class PlagueEvent implements Event {
    @Override
    public void triggerEvent(Character character) {
        System.out.println("A deadly plague spreads through the area afflicting the population [Health -15] [Strength -10]");
        character.decreaseHealth(15);
        character.decreaseStrength(10);
    }
}

class BanditAttackEvent implements Event {
    @Override
    public void triggerEvent(Character character) {
        System.out.println("Bandits have ambushed travelers [Health -15] [Wealth -10]");
        character.decreaseHealth(15);
        character.decreaseWealth(10);
    }
}

class FestivalEvent implements Event {
    @Override
    public void triggerEvent(Character character) {
        System.out.println("A grand festival brings joy and celebration [Influence +20]");
        character.increaseInfluence(20); // Assuming a method to increase morale exists.
    }
}

class MonsterAttackEvent implements Event {
    @Override
    public void triggerEvent(Character character) {
        System.out.println("Monsters have attacked the kingdom [Health -20] [Strength -20]");
        character.decreaseHealth(20);
        character.decreaseStrength(20);
    }
}

class MagicArtifactDiscoveryEvent implements Event {
    @Override
    public void triggerEvent(Character character) {
        System.out.println("You have discovered a powerful magic artifact [Strength +30]");
        character.increaseStrength(30);
    }
}

class EconomicBoomEvent implements Event {
    @Override
    public void triggerEvent(Character character) {
        System.out.println("The kingdom experiences an economic boom [Wealth +50]");
        character.increaseWealth(50);
    }
}

class PoliticalScandalEvent implements Event {
    @Override
    public void triggerEvent(Character character) {
        System.out.println("A political scandal rocks the kingdom [Influence -20]");
        character.decreaseInfluence(20);
    }
}

class DroughtEvent implements Event {
    @Override
    public void triggerEvent(Character character) {
        System.out.println("A severe drought affects the region [Wealth -30]");
        character.decreaseWealth(30);
    }
}

class HeroicDeedEvent implements Event {
    @Override
    public void triggerEvent(Character character) {
        System.out.println("You performed a heroic deed [Influence +15]");
        character.increaseInfluence(15);
    }
}

class AlienInvasionEvent implements Event {
    @Override
    public void triggerEvent(Character character) {
        System.out.println("Aliens from another planet invade [Health -30] [Strength -30]");
        character.decreaseHealth(30);
        character.decreaseStrength(30);
    }
}

class ArtThievesEvent implements Event {
    @Override
    public void triggerEvent(Character character) {
        System.out.println("Art thieves steal valuable artifacts [Wealth -40]");
        character.decreaseWealth(40);
    }
}

class RebellionEvent implements Event {
    @Override
    public void triggerEvent(Character character) {
        System.out.println("A rebellion against your rule erupts [Influence -25]");
        character.decreaseInfluence(25);
    }
}

class TimeTravelEvent implements Event {
    @Override
    public void triggerEvent(Character character) {
        System.out.println("You accidentally travel back in time [Influence -50]");
        character.decreaseInfluence(50);
    }
}