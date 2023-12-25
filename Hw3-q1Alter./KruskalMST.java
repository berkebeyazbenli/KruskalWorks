import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalMST {
    public static double eucladian(City city1, City city2) {
        return Math.sqrt(Math.pow(city1.x - city2.x, 2) + Math.pow(city1.y - city2.y, 2));
    }

    public static List<Edge> kruskalMST(List<City> cities) {
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < cities.size(); i++) {
            for (int j = i + 1; j < cities.size(); j++) {
                double distance = eucladian(cities.get(i), cities.get(j));
                edges.add(new Edge(cities.get(i).name, cities.get(j).name, distance));
            }
        }

        Collections.sort(edges);

        List<Edge> mstEdges = new ArrayList<>();
        UF uf = new UF(cities.size());

        for (Edge edge : edges) {
            int city1Index = getCityIndex(cities, edge.city1);
            int city2Index = getCityIndex(cities, edge.city2);

            if (uf.find(city1Index) != uf.find(city2Index)) {
                mstEdges.add(edge);
                uf.union(city1Index, city2Index);
            }
        }

        return mstEdges;
    }

    private static int getCityIndex(List<City> cities, String cityName) {
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).name.equals(cityName)) {
                return i;
            }
        }
        return -1;
    }
}
