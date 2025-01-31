public class Encodage {

    public static String encodage(final String sentence, final String key){
        String codedSentence = "";
        char[][] encodingTable = initTable();
        //parsing through the sentence to encode
        for (int i = 0; i <= sentence.length()-1; i++) {
            //encoding each letter
            codedSentence += encodingTable[charPlace(sentence.charAt(i))][charPlace(key.charAt(i%key.length()))];
        }
        return codedSentence;
    }

    public static char[][] initTable(){

        char[][] table = new char[26][26];
        table[0] = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char tmp;

        for(int i = 1; i <= 25; i++){
            tmp = table[i-1][0];
            for(int j = 0; j <= 24; j++){
                table[i][j] = table[i-1][j+1];
            }
            table[i][25] = tmp;
        }

        return table;
    }

    //associates to each letter its number in the alphabet minus 1
    public static int charPlace(final char letter){
        return switch (letter) {
            case 'A' -> 0;
            case 'B' -> 1;
            case 'C' -> 2;
            case 'D' -> 3;
            case 'E' -> 4;
            case 'F' -> 5;
            case 'G' -> 6;
            case 'H' -> 7;
            case 'I' -> 8;
            case 'J' -> 9;
            case 'K' -> 10;
            case 'L' -> 11;
            case 'M' -> 12;
            case 'N' -> 13;
            case 'O' -> 14;
            case 'P' -> 15;
            case 'Q' -> 16;
            case 'R' -> 17;
            case 'S' -> 18;
            case 'T' -> 19;
            case 'U' -> 20;
            case 'V' -> 21;
            case 'W' -> 22;
            case 'X' -> 23;
            case 'Y' -> 24;
            case 'Z' -> 25;
            default -> {
                System.out.println("Invalid character!");
                yield 0;
            }
        };
    }

}
