abstract class Animal {
    protected String name;
    protected final int runLimit;
    protected final int swimLimit;


    public Animal(String name, int runLimit, int swimLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
    }


    public abstract void Run(int distance);

    public abstract void Swim(int distance);

    public abstract void runWithLimit(int distance);

    public abstract void swimWithLimit(int distance);


}
class Dog extends Animal {

    public Dog(String name,int runLimit, int swimLimit) {

        super(name, runLimit, swimLimit);
    }


    @Override
    public void Run(int distance) {
        System.out.println("The Dog " + name + " ran " + distance + " meters, without limit.");

    }

    @Override
    public void Swim(int distance) {
        System.out.println("The Dog " + name + " swam " + distance + " meters, without limit.");

    }

    @Override
    public void runWithLimit(int distance) {
        if (distance < runLimit) {
            System.out.println("The Dog " + name + " ran " + distance + " meters the limit is " + runLimit + ".");
        } else {
            System.out.println("The Dog " + name + " ran " + runLimit + " meters the limit is " + runLimit + ".");
        }
    }

    @Override
    public void swimWithLimit(int distance) {
        if (distance < swimLimit) {
            System.out.println("The Dog " + name + " swam " + distance + " meters the limit is " + runLimit + ".");
        } else {
            System.out.println("The Dog " + name + " swam " + swimLimit + " meters the limit is " + runLimit + ".");
        }
    }

}
class Cat extends Animal {

    public Cat(String name, int runLimit, int swimLimit) {
        super(name, runLimit, swimLimit);
    }


    @Override
    public void Run(int distance) {
        System.out.println("The cat " + name + " ran " + distance + " meters, without limit.");
    }

    @Override
    public void Swim(int distance) {
        System.out.println("The cat " + name + " swam " + distance + " meters, without limit.");
    }

    @Override
    public void runWithLimit(int distance) {
        if (distance < runLimit) {
            System.out.println("The cat " + name + " ran " + distance + " meters the limit is " + runLimit + ".");
        } else {
            System.out.println("The cat " + name + " ran " + runLimit + " meters the limit is " + runLimit + ".");
        }
    }

    @Override
    public void swimWithLimit(int distance) {
        System.out.println("Cat can not swim at all.");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Boby", 500,10);
        Cat cat = new Cat("Tom", 200,0);
        dog.Run(25);
        dog.Swim(13);
        dog.runWithLimit(250);
        dog.swimWithLimit(5);
        cat.Run(50);
        cat.Swim(24);
        cat.runWithLimit(100);
        cat.swimWithLimit(5);



    }
}