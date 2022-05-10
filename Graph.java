/*CPCS 324: Algorithms and Data Structures (II)
Group Project 
Section: BAR
Team members
Sarah Hamoud Aljabri   - 1907215
Khadija Salem Balfagih - 1914895
Nouf Abdullah Alharbi  - 1906257 */
package cpcs324_project_part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author KHADIJA.B, Nouf, Sarah
 */
public class Graph {

    /**
     *number of vertices in graph
     */
    int verticesNo;

    /**
     *number of edge in graph
     */
    int edgeNo;

    /**
     *array list for all verteces in graph
     */
    ArrayList<Vertex> vertices;

    /**
     *Is Direct graph or not
     */
    boolean isDigraph = true;

    /**
     * the 2 dim array to store matrix
     */
    Edge [][] adjMatrix;


    /**
     *constructor to initialize the vertices with integer number of edge and vertices
     * @param verticesNonumber of vertices in graph
     * @param edgeNo number of edge in graph
     */
    Graph(int verticesNo, int edgeNo) {
        this.verticesNo = verticesNo;
        this.edgeNo = edgeNo;
        this.vertices = new ArrayList<Vertex>();
        adjMatrix = new Edge[verticesNo][verticesNo];
        for (int i = 0; i < verticesNo; i++) {
            for(int j=0; j < verticesNo; j++){
                adjMatrix[i][j] = null;
            }
        }
        for (int i = 0; i < verticesNo; i++) {
            vertices.add(new Vertex(i));
        }
    }

    /**
     *reads a file txt using given format
     * @param FileName file txt to read from it
     */
    void readGraphFromFile(String FileName){
        try {
            File myObj = new File(FileName);
            Scanner myReader = new Scanner(myObj);
            //read the first line to set digraph or not
            if (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //split the line using space
                String ar[] = data.split(" ");
                int t = Integer.parseInt(ar[1]);
                if (t == 0) {
                    this.isDigraph = false;
                } else {
                    this.isDigraph = true;
                }
            }
            //the second line contains the number of vertices and edges
            if (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //split the line using space
                String ar[] = data.split(" ");
                this.verticesNo = Integer.parseInt(ar[0]);
                this.edgeNo = Integer.parseInt(ar[1]);
                //set matrix to the givin vertices number and initialize all edges to null
                adjMatrix = new Edge[verticesNo][verticesNo];
                for (int i = 0; i < verticesNo; i++) {
                    for (int j = 0; j < verticesNo; j++) {
                        adjMatrix[i][j] = null;
                    }
                }
                this.vertices = new ArrayList<Vertex>();
                for (int i = 0; i < verticesNo; i++) {
                    vertices.add(new Vertex(i));
                }
            }
            //read the rest of lines
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //split the line using space
                String ar[] = data.split(" ");
                //using getVertPos(), we transfare character to position
                //set source, target and weight of the vertex
                this.addEdge(Vertex.getVertPos(ar[0].charAt(0)), Vertex.getVertPos(ar[1].charAt(0)), Integer.parseInt(ar[2]));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }

    /**
     *checks if there is a direct edge between source and target
     * @param Source the source vertex
     * @param target tha target vertix
     * @return boolean F or T
     */
    public boolean isConnected(int Source, int target) {
        //if there is a null value in the source and target, then there is no edge between them
        if(adjMatrix[Source][target] != null)
            return true;
        return false;
    }

    /**
     *add new edge from source to target and vice versa
     * @param source source vertix position
     * @param target target vertix position
     * @param weight int weight
     * @return edge opject
     */
    public Edge addEdge(int source, int target, int weight) {
        Edge edge = new Edge(source, target, weight);
        adjMatrix[source][target] = edge;
        if(this.isDigraph == false){
            adjMatrix[target][source] = new Edge(target, source, weight);
        }        
        return edge;
    }

    /**
     *add vertix label
     * @param vLabel label of vertix
     * @return true
     */
    public boolean addVertLabel(char vLabel){
        return true;
    }

    /**
     *randomly generate graph by makes edges based on edgeNo value
     */
    public void makeGraph() {
        Random random = new Random(); //Random Class
        //for connect each vertex with its next
        for (int i = 0; i < verticesNo - 1; i++) {
            int randG = random.nextInt(30) + 1;
            addEdge(i, i + 1, randG);
        }
        int remaning = edgeNo - (verticesNo - 1); //for take rwmaning edge
        //generate random graph with the remaining edges
        for (int i = 0; i < remaning; i++) {
            //generate random for source, Destination and weight
            int source = random.nextInt(verticesNo);
            int Destination = random.nextInt(verticesNo);
            int weight = random.nextInt(30) + 1;
            //if it is already existed 
            if (Destination == source || isConnected(source, Destination)) {
                i--;
                continue;
            }
            
            addEdge(source, Destination, weight);
        }
    }
}