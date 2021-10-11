public class Main {
    public static void main(String[] args) {
        Cat[] cat = new Cat[5];
        cat[0] = new Cat("Tom", 2);
        cat[1] = new Cat("Marsi", 5);
        cat[2] = new Cat("Lulu", 7);
        cat[3] = new Cat("Ziko", 8);
        cat[4] = new Cat("Lola", 0);
        Plate plate = new Plate(new Eat("\"Meat\"", 15));

        for (int i = 0; i < cat.length; i++) {
            System.out.println("***********************");
            System.out.println("The cat " + cat[i].getName() + " satieted by " + cat[i].getSatiety() + " out of 10.");
            System.out.println("For fully saturation, the cat need eat " + (10 - cat[i].getSatiety()) + " food units of " + plate.getEat().getName());
            CatService catService = new CatService(cat[i]);


            if (cat[i].isCatFull(catService.eat(plate.getEat()))) {
                System.out.println("The cat " + cat[i].getName() + " ate enought food.");
            } else if (cat[i].getSatiety() < 10) {
                plate.addEat(new Eat("Meat", 7));
                catService.eat(plate.getEat());
            }

            System.out.println("The remaining amount of food " + plate.getEat().getName() + " in plate are equale to " + plate.getEat().getCount());

        }


    }
}