import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class PIDworker implements Runnable {
  private final Socket socket;
  private final int PID;

  public PIDworker(Socket socket, int PID){
    this.socket = socket;
    this.PID = PID;
  }
  /*
  Handle requests for PID
  Sends PID back through socket to the client
  */
  public void run() {
    DataOutputStream dout = null;
    try {
      dout = new DataOutputStream(this.socket.getOutputStream());
      System.out.println("Sent PID " + PID);
      dout.writeInt(this.PID);
      dout.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }finally{
      try {
        this.socket.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
