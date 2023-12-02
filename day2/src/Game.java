import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int MAX_RED = 12, MAX_GREEN = 13, MAX_BLUE = 14;
    private int id;
    private List<Grab> grabs;

    public Game (int id){
        this.id = id;
        this.grabs = new ArrayList<>();
    }

    public void addGrab(Grab g){
        grabs.add(g);
    }

    public boolean possible(){
        for(Grab g : grabs){
            if (g.getRed() > MAX_RED || g.getGreen() > MAX_GREEN || g.getBlue() > MAX_BLUE) {
                return false;
            }
        }
        return true;
    }

    public int power(){
        int max_r = 0, max_g = 0, max_b = 0;
        for(Grab g: grabs){
            max_r = Math.max(g.getRed(), max_r);
            max_g = Math.max(g.getGreen(), max_g);
            max_b = Math.max(g.getBlue(), max_b);
        }
        return max_r * max_g * max_b;
    }

    public int getId(){
        return id;
    }
    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", grabs=" + grabs +
                '}';
    }
}
