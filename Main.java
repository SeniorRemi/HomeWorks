import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String name;

        String[] arrays =  {"Senior","Malek","Claura","Senior","Rose","Remi","Melis","Ali","Esma","Rose"};


Arrays.uniqueness(arrays);

        Phonebook pb = new Phonebook();

        pb.add("Remi", "123");
        pb.add("Senior", "456");
        pb.add("Senior", "789");

        System.out.println(pb.get("Senior"));






    }
}