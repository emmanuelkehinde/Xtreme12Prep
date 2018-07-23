import java.util.*;
import java.lang.*;

class ShoePairs {

    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, HashMap<Integer, String>> shoesMap;
        int noOfPairs = 0;

        int noOfShoes = in.nextInt();
        shoesMap = new HashMap<>(noOfShoes);
        in.nextLine(); // Consumes "\n"
        for (int i=0; i < noOfShoes; i++) {
            String shoe = in.nextLine();
            String[] specs = shoe.split(" ");

            Integer size = Integer.valueOf(specs[0]);
            String foot = specs[1]; // L or R

            HashMap<Integer, String> oneShoeMap = new HashMap<>(1);
            oneShoeMap.put(size,foot);

            if (shoesMap.containsKey(size) && !(shoesMap.get(size).get(size).equals(foot))) { // Pair found
                noOfPairs++;
                shoesMap.remove(size); // Remove the shoe pair and do not insert
            } else {
                shoesMap.put(size, oneShoeMap); // Insert or replace if same shoe
            }
        }
        System.out.println(String.valueOf(noOfPairs));
    }

}