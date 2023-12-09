//Leaf of the composite pattern used in Component

import java.util.ArrayList;
import java.util.List;

public class Sector implements Component {
    private String name;
    private List<Character> characters = new ArrayList<>();
    public Sector(String name) {
        this.name = name;
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Component component) {
        // Leaf nodes do not remove Components.
        throw new UnsupportedOperationException();
    }

    @Override
    public String display() {
        return "Sector: " + name;
    }

    @Override
    public List<Character> getCharacters() {
        return characters;
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }

}