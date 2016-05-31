package com.entrust.trials;

/**
 * Created by rathna on 2016-05-30.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNASequence
{
    private static final Map<Character, Integer> encodings = new HashMap<>();
    static { encodings.put('A',0); encodings.put('C',1); encodings.put('G',2); encodings.put('T',3); }
    private final int Two_POW_9 = (int) Math.pow(2, 9);

    public List<String> findRepeatedDnaSequences(String s) {

        Set<String>       res = new HashSet<>();
        HashMap duplicates = new HashMap<Integer, String>();

        for (int i = 0, rhash = 0; i < s.length(); i++)
        {
            if (i > 9) rhash -= Two_POW_9 * encodings.get(s.charAt(i-10));

            rhash = 2 * rhash + encodings.get(s.charAt(i));

            if (i > 8)
            {
                if (duplicates.get(rhash) != null)
                {
                    res.add(s.substring(i-9,i+1));
                }
                else
                {
                    duplicates.put(rhash, "");
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args)
    {
        RepeatedDNASequence sln = new RepeatedDNASequence();
        List<String> list = sln.findRepeatedDnaSequences("AACAAAAACAAAACCAAAAACAAAAACAAAA");

        System.out.println("Repeated DNA sequences are: ");
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
    }
}
