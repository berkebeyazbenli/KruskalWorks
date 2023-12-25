public class Edge implements Comparable<Edge> {
    String city1, city2;
    double weight;

    public Edge(String city1, String city2, double weight) {
        this.city1 = city1;
        this.city2 = city2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Double.compare(this.weight, other.weight);
    }
}
