package com.bkatwal.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

/**
 * created by bikas katwal on 18/2/18
 */
public class WordChainUtil
{
    public static void main(String[] args)
    {
        System.out.println(isDiffOne("coin","curn"));
    }

    public static Map<Long, String> getDictionarySet()
    {
        try
        {
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();

            InputStream stream=classLoader.getResourceAsStream("dictionary.txt");
            Scanner scanner = new Scanner(stream);
            //Scanner scanner = new Scanner(new File(classLoader.getResource("dictionary.txt").getFile()));
            Map<Long, String> wordsSetMap = new HashMap<>();
            Long id = 0l;
            while(scanner.hasNext()){
                wordsSetMap.put(id++, scanner.nextLine());
            }
            return wordsSetMap;

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return Collections.EMPTY_MAP;
    }

    public static boolean isDiffOne(String first, String second)
    {
        int count = 0;  // to store count of differences

        if(first.length() != second.length()){
            return false;
        }
        int n = first.length();

        char[] a = first.toCharArray();

        char[] b = second.toCharArray();

        for (int i = 0; i < n; i++)
        {
            if (a[i] != b[i]) count++;
            if (count > 1) return false;
        }
        return count == 1 ? true : false;
    }
}
