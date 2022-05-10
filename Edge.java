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
public class Edge implements Comparable<Edge> {

    /**
     *source vertex
     */
    Vertex source;

    /**
     *target vertex
     */
    Vertex target;

    /**
     *weigh of edge
     */
    int weight;

    /**
     *the constructor with integer parameter
     * @param source int position for source
     * @param target int position for target
     * @param weight int weigh of edge
     */
    public Edge(int source, int target, int weight) {
        this.source = new Vertex(source);
        this.target = new Vertex(target);
        this.weight = weight;
    }

    /**
     *the constructor with vertex and int parameter
     * @param source Vertex source
     * @param target Vertex target
     * @param weight int weight of edge
     */
    public Edge(Vertex source, Vertex target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    /**
     *the defulte constructor
     */
    public Edge() {
        this.source = new Vertex(0);
        this.target = new Vertex(1);
        this.weight = 0;
    }

    /**
     * @return source, target and weight, not used
     */
    public String toString() {
        return source + "-" + target + ": " + weight;
    }


    /**
     *override the comparator to do the sorting based keys, not used
     * @param o edge that compare it
     * @return 1 o1 grater than o2, -1 o1 smaller than o2, 0 is equal.
     */
    @Override
    public int compareTo(Edge o) {
        if(this.weight > o.weight) {
            return 1;
        } else if (this.weight < o.weight) {
            return -1;
        } else {
            return 0;
        }
    }

}
