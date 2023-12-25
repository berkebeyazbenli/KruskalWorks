public class UF {
    private int[] parent;
    private int[] rank;

    public UF(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int city) {
        if (parent[city] != city) {
            parent[city] = find(parent[city]); // Path compression
        }
        return parent[city];
    }

    public void union(int city1, int city2) {
        int root1 = find(city1);
        int root2 = find(city2);

        if (root1 != root2) {
            if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else {
                parent[root1] = root2;
                rank[root2]++;
            }
        }
    }
}