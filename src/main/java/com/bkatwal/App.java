package com.bkatwal;

import com.bkatwal.util.WordChainUtil;

import java.util.Map;
import java.util.Set;

/**
 * Hello world!
 */
public class App
{
    static Graph<String> wordChainGraph = new Graph<>(false);

    public static void main(String[] args)
    {
        if (args.length != 2)
        {
            System.out.println("Illegal number of argument passed. " +
                    "Please part start word and end word as arguments.");
            System.exit(0);
        }

        Map<Long, String> wordsMap = WordChainUtil.getDictionarySet();
        createGraph(wordsMap);

        String start = args[0];

        String end = args[1];

        Set<String> wordChain = getWordChain(start, end);
        System.out.println(wordChain);
    }

    private static Set<String> getWordChain(String str1, String str2)
    {
        Vertex<String> vertex1 = wordChainGraph.getVertexByVal(str1);
        Vertex<String> vertex2 = wordChainGraph.getVertexByVal(str2);
        if (vertex1 == null)
        {
            System.out.println(str1 + ", is not present in dictionary");
            System.exit(0);
        }
        if (vertex2 == null)
        {
            System.out.println(str2 + ", is not present in dictionary");
            System.exit(0);
        }

        return GraphTraversal.BFS(wordChainGraph, vertex1, vertex2);
    }

    private static void createGraph(Map<Long, String> wordsMap)
    {
        for (Long id : wordsMap.keySet())
        {

            for (Long compareId : wordsMap.keySet())
            {
                {
                    if (!wordsMap.get(id).equals(wordsMap.get(compareId)) &&
                            WordChainUtil.isDiffOne(wordsMap.get(id), wordsMap.get(compareId)))
                    {
                        wordChainGraph.addEdge(id, wordsMap.get(id), compareId,
                                wordsMap.get(compareId), 0);
                    }
                }
            }

        }
    }
}
