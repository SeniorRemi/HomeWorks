
import interfaces.Action;
public class Human implements Action {


    public String name;

    public Human(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println("The Human " + name + " run.");

    }

    @Override
    public void jump() {
        System.out.println("The Human " + name + " jumped.");

    }
}