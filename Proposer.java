import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Proposer implements Runnable{
  public List<Integer>ports;
  public Member member;
  public AtomicInteger converge;

  public Proposer(List<Integer> ports, Member member, AtomicInteger converge) {
    this.ports = ports;
    this.member = member;
    this.converge = converge; 
  }

  /*
  Gets a PID from the PID server
  */

  public static int getPID() throws IOException {
    Socket PIDClient = new Socket("localhost", 3456);
    DataInputStream dis = new DataInputStream(PIDClient.getInputStream());
    int PID = dis.readInt();
    dis.close();
    PIDClient.close();
    return PID;
  }

  /*
  Runs a timer that initates a propose protocal
  With each failed protocal, the time increases
  */
  public void run(){
    int sleep = 8;
    Timer timer = new Timer();
    while(converge.get() != 1){
      timer.purge();
      Integer PID = null;
      try {
        PID = getPID() + member.priority;
      } catch (IOException e) {
        e.printStackTrace();
      }
      timer.schedule(new Propose(this.ports,this.member,PID, this.converge), 0);
      sleep += 4;
      try {
        TimeUnit.SECONDS.sleep(sleep);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
