package com.entrust.ScenarioBased;

/**
 * Created by rathna on 2016-05-31.
 */
public class BullsCowsGuessGame {
    public static String getHint(String secret, String guess) {
        int countBull=0;
        int countCow =0;
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];

        for(int i=0; i<secret.length(); i++){
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);

            if(c1==c2)
                countBull++;
            else{
                arr1[c1-'0']=1;
                arr2[c2-'0']=1;
            }
        }

        for(int i=0; i<10; i++){
            countCow += Math.min(arr1[i], arr2[i]);
        }

        return countBull+"A"+countCow+"B";
    }

    public static void main(String[] args){
        System.out.println(getHint("8901","8021"));
        System.out.println("a".chars());
    }

}
