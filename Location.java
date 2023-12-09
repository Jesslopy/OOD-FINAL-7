import java.util.List;
import java.util.ArrayList;

public class Location implements Component {
    private String name;

    public Location(String name) {
        this.name = name;
    }

    @Override
    public void add(Component component) {
        // No operation, as adding components is not required
    }

    @Override
    public void remove(Component component) {
        // No operation, as removing components is not required
    }

    @Override
    public String display() {
        return "Location: " + name;
    }

    @Override
    public List<Character> getCharacters() {
        // Return an empty list or implement as needed
        return new ArrayList<>();
    }
}