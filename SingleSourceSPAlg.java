/*CPCS 324: Algorithms and Data Structures (II)
Group Project 
Section: BAR
Team members
Sarah Hamoud Aljabri   - 1907215
Khadija Salem Balfagih - 1914895
Nouf Abdullah Alharbi  - 1906257 */
package cpcs324_project_part2;

/**
 *
 * @author KHADIJA.B, Nouf, Sarah
 */
public class SingleSourceSPAlg extends ShortestPathAlgorithm {

    /**
     *to store the shortest distances 
     */
    int distances[];

    /**
     *source is = 0 'A'
     */
    public int source = 0;

    /**
     *store parent of vertex
     */
    int parents[];

    /**
     *it take the generated graph
     * @param g it take the generated graph
     */
    public SingleSourceSPAlg(Graph g){
        graph = g;
    }

    /**
     *searches for the minimum value inside the distances array
     * @param distances array of shortest distances 
     * @param isVisited array of boolean if vertix is vitied or not
     * @return minimum index
     */
    int min(int distances[], Boolean isVisited[])
    {
        int min = Integer.MAX_VALUE, min_index = -1;
 
        for (int i = 0; i < graph.verticesNo; i++)
            if (isVisited[i] == false && distances[i] <= min) {
                min = distances[i];
                min_index = i;
            }
        return min_index;
    }

    /**
     *print the result of solution algorithm 
     */
    void print(){
        System.out.println("Short paths starting from source A ->\n");
        for (int i = 1; i < graph.verticesNo; i++){
            //print minimum weight of vertex i from source A
            System.out.println("From A To "+(char)('A' + i) + ": of length "+distances[i]);
            System.out.print((char)('A' + i)+ " <- ");
            int j = parents[i];
            //start to print parents of i from its parent
            //and it will stop untill we reach the root (source) vertex that its parent is equal -1
            while(j != -1){
                System.out.print((char)('A' + j));
                //check the parent of parent
                j = parents[j];
                if(j != -1){
                    System.out.print(" <- ");
                }
            }
            System.out.println("\n");
        }
    }


    /**
     *DIJKSTRA ALGORITHM
     */
    public void computeDijkstraAlg(){
        //start the time
        double StartTime = System.currentTimeMillis();
        
        //initialize array to vertex number
        distances = new int[graph.verticesNo]; 
        Boolean isVisited[] = new Boolean[graph.verticesNo];
        parents = new int[graph.verticesNo];
        
        //set all distances to max value and isVisited to false and parents to -1
        for (int i = 0; i < graph.verticesNo; i++) {
            distances[i] = Integer.MAX_VALUE;
            isVisited[i] = false;
            parents[i]=-1;
        }
        //set source distance to 0 "A"
        distances[source] = 0;
        for (int i = 0; i < graph.verticesNo - 1; i++) {
            //take minimum distance
            int u = min(distances, isVisited);
            //set isVisited of u vertex to true
            isVisited[u] = true;
            //check all edges of u
            for (int v = 0; v < graph.verticesNo; v++){
                //if there is an edge between u and v, and v is not visited and weight from source to u + edge 
                //between u and v is smaller than v distance, then set v distance and update parent 
                if (!isVisited[v] && graph.adjMatrix[u][v] != null && distances[u] != Integer.MAX_VALUE && distances[u] + graph.adjMatrix[u][v].weight < distances[v]){
                    distances[v] = distances[u] + graph.adjMatrix[u][v].weight;
                    parents[v] = u;
                }
            }
        }
        //finish the time
        double FinishTime = System.currentTimeMillis();
        //calculate the duration
        duration = (int) (FinishTime - StartTime);
        //print the time that the algorithm has taken
        System.out.println("Total runtime of Dijkstra's Algorithm: " + (FinishTime - StartTime) + " ms.");
    }
}
