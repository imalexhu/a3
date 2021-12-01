import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.locks.ReentrantLock;

public class PIDServer {
  static int PID = 0;
  
  private static int incrementPID(ReentrantLock lock) {
      lock.lock();
      PID++;
      lock.unlock();
      return PID;
  }

  /*
  Starts a PID server which is hands out PID, PID is non recurring and atomic
  */
  public static void main(String args[]) throws IOException {
      ReentrantLock lock = new ReentrantLock();
      
      ServerSocket ss = new ServerSocket(3456);
        while(true){
            try
            {
                PIDworker worker = new PIDworker(ss.accept(),incrementPID(lock));
                Thread t= new Thread(worker);
                t.setDaemon(true);
                t.start();
            }catch(Exception e)
            {
                System.out.println(e);
                System.exit(1);
            }
    }
  }
}