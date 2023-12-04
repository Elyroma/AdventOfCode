import java.io.BufferedReader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static Scratchcard lineToScratchcard(String line) {
        String card[] = line.split(": ");
        Scratchcard s = new Scratchcard(Integer.parseInt(card[0].split(" ")[card[0].split(" ").length-1]));
        String numbers[] = card[1].split(" \\| ");
        for(String number : numbers[0].split(" ")){
            try {
                s.addWiningNumber(Integer.parseInt(number));
            }catch (Exception ignored){
            }
        }
        for(String number : numbers[1].split(" ")){
            try {
                s.addOurNumber(Integer.parseInt(number));
            }catch (Exception ignored){
            }
        }
        return s;
    }

    public static void main(String[] args) {
        int sum = 0;
        List<Scratchcard> scratchcards = new ArrayList<>();
        int sum_2 = 0;
        try
        {
            // Le fichier d'entrée
            File file = new File("input.txt");
            // Créer l'objet File Reader
            FileReader fr = new FileReader(file);
            // Créer l'objet BufferedReader
            BufferedReader br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            String line;
            while((line = br.readLine()) != null)
            {
                // créé la carte à gratter
                Scratchcard s = lineToScratchcard(line);
                sum += s.getPoints();
                scratchcards.add(s);
                // ajoute la ligne au buffer
                sb.append(line);
                sb.append("\n");
                sb.append(s);
                sb.append("\n");
            }
            fr.close();
            System.out.println("Contenu du fichier: ");
            System.out.println(sb);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        for(int s = 0; s < scratchcards.size(); s++){
            int cpy = scratchcards.get(s).getNbOfMatchingNumber();
            for(int i = scratchcards.get(s).getId(); i < scratchcards.get(s).getId() + cpy && i < scratchcards.size(); i++){
                scratchcards.add(new Scratchcard(scratchcards.get(i)));
            }
        }

        sum_2 = scratchcards.size();

        System.out.println("Le résultat du premier défis est : " + sum);

        System.out.println("Le résultat du deuxieme défis est : " + sum_2);
    }
}