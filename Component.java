import java.util.List;

public interface Component {
    void add(Component component);
    void remove(Component component);
    String display();
    List<Character> getCharacters();
}