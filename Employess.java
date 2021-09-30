public class Employess {
    private String name;
    private String job;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;


    public Employess(String name, String job, String email, String phoneNumber, int salary, int age) {
        this.name = name;
        this.job = job;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printEmployessInfo() {
        System.out.println(this);
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" + "Name - " + name  + " / Job - " + job  + " / Email - " + email + " / PhoneNumber - " + phoneNumber + " / Salary - " + salary + " / Age - " + age + '}';
    }

 static class Main {
    public static void main(String[] args) {
        Employess[] employessArray = new Employess[5];
        employessArray[0] = new Employess("Senior Remi", "It programmer", "ssenior.remi@gmail.com", "+5572001", 10000 , 19);
        employessArray[1] = new Employess("Steve Jackson", "Designer", "steve.jackson@gmail.com", "+5334114", 5000, 45);
        employessArray[2] = new Employess("Sara Clairy", "Architector", "sara.clairy@gmail.com", "+5572002", 8000, 18);
        employessArray[3] = new Employess("Joshua Mann", "Accountant", "joshua.mann@gmail.com", "+5532442", 6000, 47);
        employessArray[4] = new Employess("Rose Eilis", "Project Manager", "rose.eilis@gmail.com", "+5332332", 3000, 24);

        for (int i = 0; i < employessArray.length; i++) {
            if (employessArray[i].getAge() > 40) {
            	employessArray[i].printEmployessInfo();
            }
        }
    }
}
}