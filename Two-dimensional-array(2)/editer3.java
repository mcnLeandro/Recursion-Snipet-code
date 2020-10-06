import java.util.ArrayList;// ArrayListライブラリーを読み込みます。
import java.util.List;
class Main {
    public static int randomInt(int min,int max) {
        return (int)(Math.random()*(max - min + 1) + min);
    }
    public static void printArray(ArrayList<Integer> arrayList) {
        String string = "[";
        for (int i = 0; i < arrayList.size(); i++) {
            string += arrayList.get(i) + " ";
        }
        System.out.println(string + "]");
    }
    //2次元配列
    public static ArrayList<Integer> chooseNFromBags2d(int n, int[][] listOfBags) {
        int  totalBags = listOfBags.length;
        ArrayList<Integer> chosenNumbers = new ArrayList<Integer>();
        int counter = 0;
        while (counter < n){
            // counter % numberOfBags によって、ラウンドロビンができます。バッグの中を循環します。
            int[] currentBag = listOfBags[counter % totalBags];
            // 選択された数値を追加します。currentBagからランダムな値が選択されます。
            chosenNumbers.add(currentBag[randomInt(0, currentBag.length-1)]);
            // counterを1ずつ増加します。
            counter+=1;
        }
        return chosenNumbers;
    }
    
    // bagOfNumbersはm x nの2次元配列です。m個のバッグ(totalBags)があり、それぞれのバッグがn個の要素(numbersPerBag)を持っています。
    public static ArrayList<Integer> chooseNFromBags1d(int n, int[] bagOfNumbers,int totalBags,int  numbersPerBag){
        ArrayList<Integer> chosenNumbers = new ArrayList<Integer>();
        int counter = 0;
        while (counter < n){
            // 現在のバッグの範囲を取得します。
            int currentBagStart = (counter % totalBags) * numbersPerBag;
            int currentBagEnd = currentBagStart + numbersPerBag;
            chosenNumbers.add(bagOfNumbers[randomInt(currentBagStart, currentBagEnd-1)]);
            counter += 1;
        }
        return chosenNumbers;
    }
    public static void main(String[] args) {
        // それぞれのバッグは4つの数字を含みます。
        // 2次元配列
        int[][] luckyArrayOfBags = new int[][]{{21,5,12,25},{100,88,354,643},{122,145,825,4},{228,674,777,77}};
        printArray(chooseNFromBags2d(10, luckyArrayOfBags));

        // 1元配列
        // [[292,39,78,978],[668,6,66,666],[662,876,276,782],[879,869,478,1968]]と等しいです。
        int[] unluckyBagOfNumbers = new int[]{292,39,78,978,668,6,66,666,662,876,276,782,879,869,478,1968};

        // unluckyBagOfNumbersは4つのバッグを持ち、それぞれには4つの数字が含まれています。
        printArray(chooseNFromBags1d(10, unluckyBagOfNumbers, 4,4));
    }
}
