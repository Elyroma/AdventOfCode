import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static List<List<String>> engineSchematic = new ArrayList<>();
    public static void fileToArray(String line){
        List<String> l = new ArrayList<>(Arrays.asList(line.split("")));
        engineSchematic.add(l);
    }

    public static boolean hasSymbol(int i, int j, int lenght){
        System.out.println("--------new nb---------");
        if(i - 1 >= 0){
            System.out.println("----------------i-1-" + (i-1) + "------------");
            for(int k = j-1 < 0 ? 0 : j-1; k < engineSchematic.get(i - 1).size() && k < j + lenght + 1; k++){
                System.out.println("-----------------" + k + "------------");
                System.out.println(engineSchematic.get(i-1).get(k));
                try{
                    int value = Integer.parseInt(engineSchematic.get(i-1).get(k));
                }catch (Exception e){
                    if (!engineSchematic.get(i-1).get(k).equals(".")) {
                        return true;
                    }
                }
            }
        }

        for(int l = i; l <= i+1 && l < engineSchematic.size(); l++) {
            System.out.println("-----------------" + l + "------" + j+ "------");
            for (int k = j - 1 < 0 ? 0 : j - 1; k < engineSchematic.get(l).size() && k < j + lenght + 1; k++) {
                System.out.println("-----------------" + k + "------------");
                System.out.println(engineSchematic.get(l).get(k));
                try{
                    int value = Integer.parseInt(engineSchematic.get(l).get(k));
                }catch (Exception e){
                    if (!engineSchematic.get(l).get(k).equals(".")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int getSumValid(){
        int sum = 0;
        for(int i = 0; i < engineSchematic.size(); i++){
            String number = "";
            for(int j = 0; j < engineSchematic.get(i).size(); j++){
                try{
                    number += Integer.parseInt(engineSchematic.get(i).get(j));
                } catch (Exception ignored){
                    System.out.println(number);
                    System.out.println(i + " " + (j - number.length()));
                    if(!number.equals("") && hasSymbol(i, j - number.length(), number.length())){
                        sum += Integer.parseInt(number);
                    }
                    number = "";
                }

                if(!number.equals("") && !(j + 1 < engineSchematic.get(i).size()) && hasSymbol(i, j - number.length(), number.length())){
                    System.out.println(number);
                    sum += Integer.parseInt(number);
                }
                System.out.println(" ===========SOMME============= " + sum);
            }
        }
        return sum;
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
                fileToArray(line);
                // ajoute la ligne au buffer
                sb.append(line);
                sb.append("\n");
            }
            fr.close();
            System.out.println("Contenu du fichier: ");
            //System.out.println(sb);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        sum = getSumValid();
        System.out.println("Le résultat du premier défis est : " + sum);

        System.out.println("Le résultat du deuxieme défis est : " + sum_2);
    }
}