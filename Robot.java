import interfaces.Action;

public class Robot implements Action {
    protected String name;

    public Robot(String name) {


        this.name = name;
    }


    public String getName() {
        return name;
    }


    public void run() {
        System.out.println("The Robot " + name + " run");

    }
}