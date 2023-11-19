import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] zahlenArray;
        zahlenArray = new int[5];
        fillIntArray(zahlenArray);

        zahlenArray[0] = 0;
        Arrays.sort(zahlenArray);
        printArray(zahlenArray);
        System.out.println(" index:" + binäreSuche(zahlenArray, 2));

    }
    public  static void fillIntArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*5);
        }
    }
    public  static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + " " + array[i]);
        }
    }

    public static int lineareSuche(int[] array, int gesuchtesObjekt) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == gesuchtesObjekt) {
                return i;
            }
        }
        return -1;
    }

    public static int binäreSuche(int[] array, int gesuchteZahl) {

        Arrays.sort(array);

        double lastIndex = ((double)array.length)-1 ;

        int currentMiddle = round(lastIndex/2);
        double toAdd = currentMiddle;

        for (int i = 0; i < findLog2(array.length); i++) {

            if(array[currentMiddle] == gesuchteZahl) {
                return currentMiddle;
            }

           toAdd/=2;
            if(gesuchteZahl > array[currentMiddle]){
                currentMiddle += round(toAdd);
            }else if(gesuchteZahl < array[currentMiddle]){
                currentMiddle -= round(toAdd);
            }

        }
        throw new Error("Zahl nicht vorhanden");
    }
    public static int findLog2(int number){
        double helpNumber = number;
        if(helpNumber < 0) {
            throw new Error("-unendlich");
        }
        int count = 0;
        while(helpNumber>1){ // ich runde stark hoch weil wir die ganze zeit in der binären suche runden
            helpNumber/=2;
            count++;
        }
        return count;
    }
    public static int round(double number){
        boolean rundeHoch = number-0.5 >= (int)number;
        if(rundeHoch){
            return ((int)number)+1;
        }
        return (int)number;
    }


}