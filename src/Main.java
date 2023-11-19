import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] zahlenArray;
        zahlenArray = new int[4];
        fillIntArray(zahlenArray);

        Arrays.sort(zahlenArray);
        printArray(zahlenArray);
        System.out.println(" index:" + binäreSuche(zahlenArray, 4));

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

        int vergleichcount = 0;

        double currentMiddle = array.length/2;
        double add = array.length/2;

        for (int i = 0; i < findLog2(array.length); i++) {
            vergleichcount++;
            if(array[(int)currentMiddle] == gesuchteZahl) {
                System.out.println(vergleichcount);
                return (int)currentMiddle;
            }

            add/=2;
            if(gesuchteZahl > array[(int)currentMiddle]){
                currentMiddle += add;
            }else if(gesuchteZahl < array[(int)currentMiddle]){
                currentMiddle -= add;
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


}