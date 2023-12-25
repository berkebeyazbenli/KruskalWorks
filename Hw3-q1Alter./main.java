import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fileName = scanner.nextLine();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            List<City> cities = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String cityName = parts[0];
                double x = Double.parseDouble(parts[1]);
                double y = Double.parseDouble(parts[2]);
                cities.add(new City(cityName, x, y));
            }

            List<Edge> mstEdges = KruskalMST.kruskalMST(cities);
            System.out.println("Paths are: ");
            for (Edge edge : mstEdges) {

                System.out.println(
                        edge.city1 + "-" + edge.city2 + ": " + String.format("%.1f", edge.weight).replace(',', '.'));
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
