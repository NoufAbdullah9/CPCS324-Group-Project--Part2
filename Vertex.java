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
public class Vertex {

    /**
     *the label vertex value
     */
    char label;

    /**
     *the positoin of vertix
     */
    int position;

    /**
     *Is the vertex vesited or not
     */
    boolean isVisited;


    /**
     *the constructor with int label parameter
     * @param vertex the positoin of vertix
     */
    public Vertex(int vertex){
        this.label = (char)('A' + vertex);
        position = vertex;
        isVisited = false;
    }


    /**
     *to get the position we need to subtract the givin character from A
     * @param c character
     * @return the position of vertix 
     */
    public static int getVertPos(char c){
        return c - 'A';
    }

    
}