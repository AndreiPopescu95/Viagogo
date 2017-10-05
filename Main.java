import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

//Create the Touple class to store the Event object and distance from the location
class Touple{
    private Event_ e;
    private int x;

    public Touple(Event_ e_, int x_){
        e = e_;
        x = x_;
    }

    public Event_ getE() {
        return e;
    }

    public int get_Dist() {
        return x;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        Random randomGenerator = new Random();
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        line = in.readLine();
        Touple[][] matrix = new Touple[21][21];
        //Reading the grid bounds
        String[] lineArr =  line.split(",");
        int x;
        int y;
        if(lineArr.length > 3 || lineArr[0].replaceAll("[^0-9]","").isEmpty() || lineArr[0].replaceAll("[^0-9]","").isEmpty()){
            x = -1;
            y = -1;
        } else {
            x = Integer.parseInt(lineArr[0])+10; // horizontal coord
            y = Integer.parseInt(lineArr[1])+10; // vertical coord
        }
        if(x < 0 || x > 20 || y < 0 || y > 20){
            System.out.println("Please input coordinates between [-10,10]");
        } else {
            int no_of_events = randomGenerator.nextInt(441);
            //Creating events, and adding the computed distance to matrix
            for (int i = 0; i < no_of_events; i++) {
                Event_ e = new Event_(i + 1);
                int m = randomGenerator.nextInt(21);
                int n = randomGenerator.nextInt(21);
                int dist = Math.abs(m - x) + Math.abs(n - y);
                Touple t = new Touple(e, dist);
                matrix[m][n] = t;
            }
            //Create an array of distances, sort it and output the closest 5 events
            ArrayList<Touple> sorted_dist = new ArrayList<>();
            int events = 5;
            for (int i = 0; i < 21; i++) {
                for (int j = 0; j < 21; j++) {
                    if (matrix[i][j] != null) {
                        sorted_dist.add(matrix[i][j]);
                    }
                }
            }
            sorted_dist.sort(Comparator.comparingInt(Touple::get_Dist));
            int size = events;
            if (sorted_dist.size() <= events) {
                size = sorted_dist.size();
            }
            System.out.println("Closest Events to (" + (x - 10) + "," + (y - 10) + "):");
            for (int i = 0; i < size; i++) {
                System.out.println("Event " + sorted_dist.get(i).getE().get_event_no() + " - $" + (double) Math.round(sorted_dist.get(i).getE().get_lowest_price() * 100) / 100 + ", Distance " + sorted_dist.get(i).get_Dist());
            }
        }
    }
}
