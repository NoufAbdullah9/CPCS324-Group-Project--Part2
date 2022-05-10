/*CPCS 324: Algorithms and Data Structures (II)
Group Project 
Section: BAR
Team members
Sarah Hamoud Aljabri   - 1907215
Khadija Salem Balfagih - 1914895
Nouf Abdullah Alharbi  - 1906257 */
package cpcs324_project_part2;

import java.util.Scanner;

/**
 *
 * @author KHADIJA.B, Nouf, Sarah
 */
public class Application {

    /**
     * the main application
     * @param args the main
     */
    public static void main(String[] args) {
        //print the header of program
        System.out.println("[                      W E L C O M E                       ]");
        System.out.println("[    The application applay the Shortest Path Algorithm    ]\n");
        
        //--------------------------requirement 1
        System.out.println(" ----------------");
        System.out.println("[  Requirement 1 ]");
        System.out.println(" ----------------");

        int MyC;
        //creat and read graph
        Graph graphFtomFile = new Graph(0,0);
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("\n[1- Dijkstra's Algorithm        ]");
            System.out.println("[2- Floyed Warshal's Algorithm  ]");
            System.out.println("[0- for exit from Requirement 1 ]");
            System.out.print(" • your choice : ");
            MyC = in.nextInt();
            //if enter any other number
            if (MyC != 1 && MyC != 2 && MyC != 0) {
                System.out.println("Invalid input");
                
            } else if (MyC == 1) {
                //if choose Dijkstra's Algorithm
                graphFtomFile.readGraphFromFile("graph.txt");
                SingleSourceSPAlg algD = new SingleSourceSPAlg(graphFtomFile);
                System.out.println("Dijkstra's Algorithm result:");
                //call Dijkstra method and display the time
                algD.computeDijkstraAlg();
                //print result
                algD.print();
                
            } else if (MyC == 2){
                //if choose Floyed Warshal's Algorithm
                graphFtomFile.readGraphFromFile("graph.txt");
                AllSourceSPAlg algF = new AllSourceSPAlg(graphFtomFile);
                System.out.println("Floyed Warshal's Algorithm result:\n");
                //set value to true to print result in each step
                algF.isPrint = true;
                //call Floyed method and display the time
                algF.computeFloyedWarshalAlg();
                //print result
                System.out.println("D(10): The shortest distances between every vertices");
                algF.print();
            }
        } while (MyC != 0);
        
        
        //--------------------------requirement 2
        System.out.println("\n ----------------");
        System.out.println("[  Requirement 2 ]");
        System.out.println(" ----------------");
        
        int n = 0, m = 0;        
        int MyC2;
        Scanner in2 = new Scanner(System.in);
        do {
            System.out.println("\n[1- Dijkstra's Algorithm        ]");
            System.out.println("[2- Floyed Warshal's Algorithm  ]");
            System.out.println("[0- for exit from Requirement 2 ]");
            System.out.print(" • your choice : ");
            MyC2 = in2.nextInt();
            //if enter any other number
            if (MyC2 != 1 && MyC2 != 2 && MyC2 != 0) {
                System.out.println("Invalid input");
            }
            else if (MyC2 == 1) {
                //if choose Dijkstra's Algorithm with large numbers of vertices and edges
                System.out.println("-----------------------");
                System.out.println(" 1-  n=5000  - m=25000");
                System.out.println(" 2-  n=10000 - m=50000");
                System.out.println(" 3-  n=15000 - m=75000");
                System.out.println(" 4-  n=20000 - m=100000");
                System.out.println(" 5-  n=25000 - m=125000");
                System.out.println("-----------------------");
                System.out.print(" • Enter a case to test: ");
                int choice = in2.nextInt();

                //if enter any other number
                while (choice < 1 || choice > 5) {
                    System.out.println("Invalid input!");
                    System.out.print(" • Enter a case to test: ");
                    choice = in2.nextInt();
                }
                //switch for all avaliable cases of the test  
                switch (choice) {
                    case 1: {n = 5000; m = 25000; } break;
                    case 2: {n = 10000; m = 50000; } break;
                    case 3: {n = 15000; m = 75000; } break;
                    case 4: {n = 20000; m = 100000; } break;
                    case 5: {n = 25000; m = 125000; } break;
                }                          
                //to specific input vertices(n) and edges(m)
                Graph g = new Graph(n, m);
                //generate randolly graph and call Dijkstra algorithm and display the time
                g.makeGraph();
                System.out.println("Vertices: "+n+", Edges: "+m+":");
                SingleSourceSPAlg alg = new SingleSourceSPAlg(g);
                alg.computeDijkstraAlg();
                
            } else if (MyC2 == 2){
                //if choose Floyed Warshal's Algorithm with less numbers of vertices and edges
                System.out.println("-----------------------");
                System.out.println(" 1-  n=2000 - m=10000");
                System.out.println(" 2-  n=3000 - m=15000");
                System.out.println(" 3-  n=4000 - m=20000");
                System.out.println(" 4-  n=5000 - m=25000");
                System.out.println(" 5-  n=6000 - m=30000");
                System.out.println("-----------------------");                
                System.out.print(" • Enter a case to test: ");
                int choice = in2.nextInt();

                //if enter any other number
                while (choice < 1 || choice > 5) {
                    System.out.println("Invalid input!");
                    System.out.print(" • Enter a case to test: ");
                    choice = in2.nextInt();
                }
                //switch for all avaliable cases of the test 
                switch (choice) {
                    case 1: {n = 2000; m = 10000; } break;
                    case 2: {n = 3000; m = 15000; } break;
                    case 3: {n = 4000; m = 20000; } break;
                    case 4: {n = 5000; m = 25000; } break;
                    case 5: {n = 6000; m = 30000; } break;
                }      
                //to specific input vertices(n) and edges(m)
                Graph g = new Graph(n, m);
                //generate randolly graph and call Dijkstra algorithm and display the time
                g.makeGraph();
                System.out.println("Vertices: "+n+", Edges: "+m+":");
                AllSourceSPAlg alg = new AllSourceSPAlg(g);
                alg.computeFloyedWarshalAlg();
            }
        } while (MyC2 != 0);
    }
}
