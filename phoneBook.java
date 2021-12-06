import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

 class Phonebook {


        private Map<String, HashSet<String>> map;

        Phonebook() {
            this.map = new HashMap<>();
        }

        void add(String lastName, String phone) {
            HashSet<String> numbers;

            if (map.containsKey(lastName)) {
                numbers = map.get(lastName);
            } else {
                numbers = new HashSet<>();
            }
            numbers.add(phone);
            map.put(lastName, numbers);

        }

        HashSet<String> get(String lastName) {
            return map.get(lastName);
        }
    }
