public class Main {
    public static void main(String[] args) {
        firstMethod();
        try {
            secondMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    public static void firstMethod() {
        int size = 10000000;
        float[] array = new float[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1.0f;
        }
        long theTime = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() - theTime + " ms "));
    }

    public static void secondMethod() throws InterruptedException {
        int size = 10000000;
        float[] array = new float[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1.0f;
        }
        long theTime = System.currentTimeMillis();
        float[] array1 = new float[array.length / 2];
        float[] array2 = new float[array.length / 2];

        System.arraycopy(array, 0, array1, 0, array.length / 2);
        System.arraycopy(array, array.length / 2, array2, 0, array.length / 2);

        Thread thread1 = new Thread(() -> {

            for (int i = 0; i < array1.length; i++) {
                array1[i] = (float) (array1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread thread2 = new Thread(()->{
            for (int i = 0; i < array2.length; i++) {
                array2[i] = (float) (array2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        float [] finalArray = new float[array1.length + array2.length];
        System.arraycopy(array1, 0, finalArray, 0, array1.length);
        System.arraycopy(array2, 0, finalArray, array1.length, array2.length);
        System.out.println("Two thread time: " + (System.currentTimeMillis() - theTime) + " ms.");


    }
}