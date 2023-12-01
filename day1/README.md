# ❄ Jour 1

#### Récupération de la première et la dernière valeur d'une chaîne de caractères pour obtenir un nombre
```java
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
```
#### Conversion d'une chaîne de caractère en transformant les nombres écrit littéralement avec leur valeur numérique
```java
private static final String[] TEXT = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

private String addIntValue(String text){
        String tmp = "";
        String newText = "";
        for(String character : text.split("")){
            tmp += character;
            newText += character;
            for(String intInText : TEXT){
                if(tmp.contains(intInText)){
                    // on ajoute la valeur convertie
                    newText += Arrays.asList(TEXT).indexOf(intInText);
                    // remise à 0 du tmp
                    tmp = character;
                }
            }
        }
        return newText;
    }
```