public class Test {

    public static void arrayMethod(String[][] arrayString) throws MyArraySizeException, MyArrayDataException {

        int a = arrayString.length;
        int b = arrayString[0].length;
        int sum = 0;
        boolean finish = false;

        if (MyArraySizeException.testArray(a, b)) {
            finish = true;
        }

        for (int arr1 = 0; arr1 < arrayString.length; arr1++) {
            for (int arr2 = 0; arr2 < arrayString[0].length; arr2++) {


                try {
                    if (MyArrayDataException.testExceptionData(arrayString, arr1, arr2) ) {
                        finish = true;
                        throw new MyArrayDataException();
                    }
                    sum += Integer.parseInt(arrayString[arr1][arr2]);
                } catch (MyArrayDataException de) {
                    System.out.println("Ошибка приобразования сторки " + "Сторка - " + arr1 + " Столбец - " + arr2);
                }
            }
        }
        if (finish ) {
            System.out.println("Устраните исключения не возможно посчитать");
        }else {
            System.out.println("Сумма элементов массива = " + sum);
        }
    }
}