public class MyThreadClass extends Thread{


    public void run(){
        while (true) {
            try {
                MyThreadClass.sleep(1000);
            } catch (Exception e) {
            }
            MyServlet.plusadin();
        }
    }
    public void doShutdown(){}
}