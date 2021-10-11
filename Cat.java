public class Cat {


    private String name;
    private int satiety;

    public Cat(String name, int satiety) {

        this.satiety = satiety;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    public boolean isCatFull(int satiety) {
        return satiety == 10;
    }
}