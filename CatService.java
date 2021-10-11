public class CatService {

    private Cat cat;

    public CatService(Cat cat) {
        this.cat = cat;
    }

    public int eat(Eat eat) {
        while (cat.getSatiety() <= 10) {
            if (cat.getSatiety() == 10) {
                System.out.println("The cat " + cat.getName() + " is full.The satiety  " + cat.getSatiety());
                return cat.getSatiety();
            }
            if (eat.getCount() < 1) {
                System.out.println("For Cat " + cat.getName() + " the food are overed :( ");
                return cat.getSatiety();
            }
            cat.setSatiety(cat.getSatiety() + 1);
            eat.decreaseCount();
        }
        return cat.getSatiety();
    }
}