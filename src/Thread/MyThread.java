package Thread;
public class MyThread extends Thread {

    private int sleepTime;
    private String tName;

    public MyThread(String name){
        tName = name;
        sleepTime = (int) (Math.random()*3000);
    }

    public void run(){
        System.err.println(tName + " is running");

        try{
            System.err.println(tName + " will sleep "+ sleepTime+ " ms");
            Thread.sleep(sleepTime);
            System.err.println(tName + " is done sleeping");
        }
        catch (InterruptedException ie){
            System.err.println(ie.getMessage());
        }

    }

}
