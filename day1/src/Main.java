import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int getValue(String line){
        List<Integer> numbers = new ArrayList<>();
        for(String character : line.split("")){
            try{
                int value = Integer.parseInt(character);
                numbers.add(value);
            } catch (Exception ignored){
            }
        }
        if(numbers.size() > 0) {
            return Integer.parseInt(numbers.get(0) + "" + numbers.get(numbers.size() - 1));
        }
        return 0;
    }
    public static void main(String[] args) {
        int sum = 0;
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
                // ajoute le nombre s'il est écrit littéralement
                String line_convert = (new TextToInt(line)).getText();

                int value = getValue(line);
                int value_2 = getValue(line_convert);

                // ajoute la ligne au buffer
                sb.append(line);
                sb.append(" ");
                // ajoute la valeur de la ligne
                sb.append(value);
                // idem avec la ligne convertie
                sb.append(" | ");
                sb.append(line_convert);
                sb.append(" ");
                sb.append(value_2);
                sb.append("\n");

                // met a jour la somme de toutes les valeurs
                sum += value;
                // met a jour la somme de toutes les valeurs
                sum_2 += value_2;
            }
            fr.close();
            System.out.println("Contenu du fichier: ");
            System.out.println(sb.toString());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("Le résultat du premier défis est : " + sum);
        System.out.println("Le résultat du deuxieme défis est : " + sum_2);
    }

}