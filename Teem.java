import interfaces.Action;

public class Teem {
    private String teemName;
    private final Action[] teemMembers;

    public Teem(String teemName, Action[] teemMembers) {
        this.teemName = teemName;
        this.teemMembers = new Action[4];
        for (int i = 0; i < teemMembers.length; i++) {
            if (teemMembers.length != 4){
                System.out.println("The number of participants is incorrect!");
            }

        }
    }

    public String getTeemName() {
        return teemName;
    }

    public void setTeemName(String teemName) {
        this.teemName = teemName;
    }

    public Action[] getTeemMembers() {
        return teemMembers;
    }
}