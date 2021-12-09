public class MyArraySizeException extends ArrayIndexOutOfBoundsException{


    public static boolean testArray (int a, int b){
        try {
            if (a != 4 || b != 4){
                throw new MyArraySizeException();
            }
        }catch (MyArraySizeException se) {
            System.out.println( "MyArraySizeException" + " Массив не верныой длинны");
            return true;

        }
        return false;
    }
}