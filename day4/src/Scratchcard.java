import java.util.ArrayList;
import java.util.List;

public class Scratchcard {
    private int id;
    private List<Integer> winningNumbers;
    private List<Integer> ourNumbers;

    public Scratchcard (int id){
        this.id = id;
        this.winningNumbers = new ArrayList<>();
        this.ourNumbers = new ArrayList<>();
    }

    public Scratchcard (Scratchcard s){
        this.id = s.id;
        this.winningNumbers = s.winningNumbers;
        this.ourNumbers = s.ourNumbers;
    }

    public int getId(){
        return id;
    }

    public void addWiningNumber(int nb){
        winningNumbers.add(nb);
    }

    public void addOurNumber(int nb){
        ourNumbers.add(nb);
    }

    public int getPoints(){
        int points = 0;
        for(int winning : winningNumbers){
            for(int our : ourNumbers){
                if(our == winning){
                    points = points == 0 ? 1 : points * 2;
                }
            }
        }
        return points;
    }

    public int getNbOfMatchingNumber(){
        int nb = 0;
        for(int winning : winningNumbers){
            for(int our : ourNumbers){
                if(our == winning){
                    nb++;
                }
            }
        }
        return nb;
    }

    @Override
    public String toString() {
        return "Scratchcard{" +
                "id=" + id +
                ", winningNumbers=" + winningNumbers +
                ", ourNumbers=" + ourNumbers +
                '}';
    }
}
