import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class MemberWorker implements Runnable {
  private final Socket socket;
  private final Member member;

  public AtomicInteger converge;
  MemberWorker(Socket socket, Member m, AtomicInteger converge){
    this.socket = socket; 
    this.member = m;
    this.converge = converge;
  }
  
/*
Handles each request from each client
Processes the string message sent in
Depending on the request type forward it
to the appropriate member function

ie if proposal, call the member's propose function
if accept call accept 
etc etc
*/

  public void process() throws IOException, InterruptedException{
  if(member.responseSpeed < 4){
      TimeUnit.SECONDS.sleep(member.responseSpeed);
      DataInputStream dis = new DataInputStream(socket.getInputStream());
      String str = dis.readUTF();
      System.out.println(member.portNumber + " recived : " + str );
      String[] temp = str.split(":",2);
      String ret = new String();
      if(Integer.parseInt(temp[1])!= -2){
        if(temp[0].equals("propose")){
          ret = member.recievePreareMessage(Integer.parseInt(temp[1]));
        }else{
          ret = member.recieveAcceptPropsal(Integer.parseInt(temp[1]),temp[0]);
        }
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
        System.out.println("Returning value "  + ret + " from member " + member.portNumber);
        dout.writeUTF(ret);
        dout.flush();
        dout.close();
      }else{
        converge.incrementAndGet();
        member.proposeValue = new AtomicReference<String>(temp[0]);
        System.out.println("Convergence reached : " + member.proposeValue);
      } 
    }
    socket.close();
  }

  @Override
  public void run() {
    try {
      process();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
