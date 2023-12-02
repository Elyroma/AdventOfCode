import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static Game lineToGame(String line){
        String game[] = line.split(":");
        Game g = new Game(Integer.parseInt(game[0].split(" ")[1]));
        String grabs[] = game[1].split(";");
        for(String grab : grabs){
            String datas[] = grab.split(",");
            int red = 0, green = 0, blue = 0;
            for(String data : datas){
                String color = data.split(" ")[2];
                int value = Integer.parseInt(data.split(" ")[1]);
                switch (color) {
                    case "red" -> red = value;
                    case "green" -> green = value;
                    case "blue" -> blue = value;
                }
            }
            g.addGrab(new Grab(red, green, blue));
        }
        return g;
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
                // créé la partie
                Game g = lineToGame(line);
                if(g.possible()){
                    sum += g.getId();
                }
                sum_2 += g.power();
                // ajoute la ligne au buffer
                sb.append(line);
                sb.append("\n");
                sb.append(g);
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
        System.out.println("Le résultat du premier défis est : " + sum);

        System.out.println("Le résultat du deuxieme défis est : " + sum_2);
    }
}