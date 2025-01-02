import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrianglePascal {

    public static void main(String[] args){
        printPascalLine(5);
    }

    public static void printPascalLine(final int index){

        int[] constructorLine = new int[]{0, 1, 0};

        if (index == 1){
            System.out.println(Arrays.toString(constructorLine));
            return;
        }

        for (int i = 4; i <= index + 2; i++){

            int[] currentLine = new int[i];
            currentLine[0] = 0;
            currentLine[i-1] = 0;

            for(int j = 1; j < currentLine.length - 1; j++){
                currentLine[j] = constructorLine[j-1] + constructorLine[j];
            }

            constructorLine = currentLine;

        }

        System.out.println(Arrays.toString(constructorLine));

    }


}
