public class MyArrayDataException  extends  NumberFormatException{

    static boolean testExceptionData(String [][] arr, int a, int b) throws NumberFormatException{

        try {
            Integer.parseInt(arr[a][b]);

        }catch (NumberFormatException ss){
            return true;

        }
        return false;
    }
}