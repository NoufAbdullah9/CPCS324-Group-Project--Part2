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
public class AllSourceSPAlg extends ShortestPathAlgorithm {

    /**
     *isPrint was true for print all itreation
     */
    boolean isPrint = false;

    /**
     *it take the generated graph
     * @param g it take the generated graph
     */
    public AllSourceSPAlg(Graph g){
        graph = g;
    }
    
    /**
     *print the result
     */
    void print()
    {
        //print the letters in the first row
        System.out.print("     ");
        for (int i=0; i<graph.verticesNo; ++i)
        {
            System.out.printf("%-5c",(char)('A' + i));
        }
        System.out.println("");
        //print matrix 
        for (int i=0; i<graph.verticesNo; ++i)
        {
            for (int j=0; j<graph.verticesNo; ++j)
            {
                //to print the character at the beginning of line
                if(j == 0){
                    System.out.printf("%-5c",(char)('A' + i));
                }
                //if edge is exist between i and j, then print the weight
                if(graph.adjMatrix[i][j].weight != 99999)
                    System.out.printf("%-5d",graph.adjMatrix[i][j].weight);
                //else, print infinity symbol
                else
                    System.out.printf("%-5s","INF");
            }
            System.out.println();
        }
    }

    /**
     *FLOYED WARSHAL ALGORITHM
     */
    public void computeFloyedWarshalAlg(){
        //start the time
        double StartTime = System.currentTimeMillis();
        //we need to set graph for the algorithm
        for (int i = 0; i < graph.verticesNo; i++)
            {
                for (int j = 0; j < graph.verticesNo; j++)
                {
                    //if edge is null then set edge to a large number
                    if(graph.adjMatrix[i][j] == null && i != j){
                        graph.adjMatrix[i][j] = new Edge(i,j,99999);
                    }
                    //if edge is diagonal then set the weight to 0
                    else if(graph.adjMatrix[i][j] == null && i == j){
                        graph.adjMatrix[i][j] = new Edge(i,j,0); 
                    }
                }
            }
        
        //run all source algorithm starting from different sources k
        for (int k = 0; k < graph.verticesNo; k++)
        {
            //if isPrint is set true then print the result
            if(isPrint == true){
                System.out.println("D(" +k+"):");
                print();
                System.out.println();
            }
            for (int i = 0; i < graph.verticesNo; i++)
            {
                for (int j = 0; j < graph.verticesNo; j++)
                {
                    //check comulitive weight starting from source + edge weight is smaller than the current weight
                    if (graph.adjMatrix[i][k].weight + graph.adjMatrix[k][j].weight < graph.adjMatrix[i][j].weight)
                        graph.adjMatrix[i][j].weight = graph.adjMatrix[i][k].weight + graph.adjMatrix[k][j].weight;
                }
            }
        }
        //finish the time
        double FinishTime = System.currentTimeMillis();
        //calculate the duration
        duration = (int) (FinishTime - StartTime);
        //print the time that the algorithm has taken
        System.out.println("Total runtime of Floyed Warshal's Algorithm: " + (FinishTime - StartTime) + " ms.");
        
    }
}
