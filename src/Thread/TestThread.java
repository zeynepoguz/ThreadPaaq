package Thread;

public class TestThread {

    public static void main(String[] args) {
        MyThread t1 = new MyThread("Zey");
        MyThread t2 = new MyThread("Nep");
        MyThread t3 = new MyThread("Kito");


       t1.start();
       t2.start();
       t3.start();

        System.err.println("end main..");
    }
}
