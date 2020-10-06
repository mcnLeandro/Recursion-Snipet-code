// 鞄の中から選ぶには、ラウンドロビンというやり方を使いましょう。ラウンドロビンとは、1つずつ周回して、終わったら最初からやり直すという意味です。
// 4つのバッグがある場合, bag1 -> bag2 -> bag3 -> bag4 -> bag1 -> bag2...のような処理が行われます。
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

    public static void main(String[] args) {
        // それぞれのバッグは4つの数字を含んでいます。
// 二次元配列
        int[][] luckyArrayOfBags = new int[][]{{21,5,12,25},{100,88,354,643},{122,145,825,4},{228,674,777,77}};

        printArray(chooseNFromBags2d(10, luckyArrayOfBags));
    }
}
