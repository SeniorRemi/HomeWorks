import interfaces.Action;
import interfaces.Jumpable;

public class Wall extends Barrier {

    public int doAction = 5;
    public void jumpOverWall(Jumpable jumpable){
        if (doAction == 5 ) {
            jumpable.jump();
            System.out.println("The participant was able to pass the obstacle of the wall!");
        }else {
            System.out.println("The participant was not able to pass the obstacle of the wall!");
        }
    }


    @Override
   public void doAction(Action action ) {
        if (doAction == 5 ) {
            action.jump();
            System.out.println("The participant was able to pass the obstacle of the wall!");
        }else {
            System.out.println("The participant was not able to pass the obstacle of the wall!");
        }

    }
}