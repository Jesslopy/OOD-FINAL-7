import java.util.Random;

public class EventFactory {
    public static Event createRandomEvent() {
        String[] eventTypes = {
            "invasion", "famine", "plague", "treasure discovery", "diplomatic",
            "natural disaster", "trade opportunity", "bandit attack", "festival"
            // Add other event types as needed
        };

        // Choose a random event type
        Random random = new Random();
        String randomEventType = eventTypes[random.nextInt(eventTypes.length)];

        // Create and return the chosen event
        return createEvent(randomEventType);
    }

    public static Event createEvent(String eventType) {
        switch (eventType.toLowerCase()) {
            case "invasion":
                return new InvasionEvent();
            case "famine":
                return new FamineEvent();
            case "plague":
                return new PlagueEvent();
            case "treasure discovery":
                return new TreasureDiscoveryEvent();
            case "diplomatic":
                return new DiplomaticEvent();
            case "natural disaster":
                return new NaturalDisasterEvent();
            case "trade opportunity":
                return new TradeOpportunityEvent();
            case "bandit attack":
                return new BanditAttackEvent();
            case "festival":
                return new FestivalEvent();
            // Add other cases as needed
            default:
                throw new IllegalArgumentException("Unknown event type: " + eventType);
        }
    }
}