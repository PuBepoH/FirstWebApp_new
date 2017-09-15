

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


class MyThreadClass extends Thread{


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

public class MyServletContextListener implements ServletContextListener{
    private MyThreadClass myThread = null;

    public void contextInitialized(ServletContextEvent sce) {
        if ((myThread == null) || (!myThread.isAlive())) {
            myThread = new MyThreadClass();
            myThread.start();
        }
    }

    public void contextDestroyed(ServletContextEvent sce){
        try {
            myThread.doShutdown();
            myThread.interrupt();
        } catch (Exception ex) {
        }
    }

}
