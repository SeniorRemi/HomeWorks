
import interfaces.Action;
import interfaces.Runable;
public class Treadmill extends Barrier {

    private boolean doAction;
    public void runOverWall(Runable runable){
        if (doAction) {
            runable.run();
        }else {

            System.out.println(" The competitor was unable to pass obstacles on the treadmill!");
        }
    }

    @Override
   public void doAction(Action action) {
        if (doAction) {
            action.run();
        }else {

            System.out.println(" The competitor was unable to pass obstacles on the treadmill!");
        }

    }
}