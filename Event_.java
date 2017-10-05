import java.lang.reflect.Array;
import java.util.*;


public class Event_ {

    private ArrayList<Double> prices;
    private int no_of_tickets;
    private int e_no;
    Random randomGenerator = new Random();

    public Event_(int x){
        prices = new ArrayList<>();
        no_of_tickets = randomGenerator.nextInt(100);
        for(int i = 0; i < no_of_tickets; i++){
            prices.add((500*randomGenerator.nextDouble() + 1));
        }
        Collections.sort(prices);
        e_no = x;
    }

    public double get_lowest_price(){
        return prices.get(0);
    }

    public int get_no_of_tickets(){
        return  no_of_tickets;
    }

    public int get_event_no(){
        return e_no;
    }
}
