package com.bkatwal;

import java.util.*;

/**
 * created by bikas katwal on 18/2/18
 */

public class GraphTraversal
{

    public void DFS(Graph<Integer> graph)
    {
        Set<Long> visited = new HashSet<Long>();
        for (Vertex<Integer> vertex : graph.getAllVertex())
        {
            if (!visited.contains(vertex.getId()))
            {
                DFSUtil(vertex, visited);
            }
        }

    }

    private void DFSUtil(Vertex<Integer> v, Set<Long> visited)
    {
        visited.add(v.getId());
        System.out.print(v.getId() + " ");
        for (Vertex<Integer> vertex : v.getAdjacentVertexes())
        {
            if (!visited.contains(vertex.getId()))
                DFSUtil(vertex, visited);
        }
    }

    public void BFS(Graph<Integer> graph)
    {
        Set<Long> visited = new HashSet<>();
        Queue<Vertex<Integer>> q = new LinkedList<>();

        for (Vertex<Integer> vertex : graph.getAllVertex())
        {
            if (!visited.contains(vertex.getId()))
            {
                q.add(vertex);
                visited.add(vertex.getId());
                while (q.size() != 0)
                {
                    Vertex<Integer> vq = q.poll();
                    System.out.print(vq.getId() + " ");
                    for (Vertex<Integer> v : vq.getAdjacentVertexes())
                    {
                        if (!visited.contains(v.getId()))
                        {
                            q.add(v);
                            visited.add(v.getId());
                        }
                    }
                }
            }
        }

    }

    public static Set<String> BFS(Graph<String> graph, Vertex<String> vertex1, Vertex<String> vertex2)
    {
        Set<Long> visited = new HashSet<>();
        Queue<Vertex<String>> q = new LinkedList<>();

        Set<String> traversedVertex = new LinkedHashSet<>();

        q.add(vertex1);
        visited.add(vertex1.getId());
        while (q.size() != 0)
        {
            Vertex<String> vq = q.poll();
            for (Vertex<String> v : vq.getAdjacentVertexes())
            {
                if(v.getId() == vertex2.getId()){
                    break;
                }
                if (!visited.contains(v.getId()))
                {
                    q.add(v);
                    visited.add(v.getId());
                    traversedVertex.add(v.getData());
                }
            }

        }

        return traversedVertex;

    }

}
