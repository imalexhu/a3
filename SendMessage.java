import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class SendMessage implements Runnable{
    String val;
    List<Integer> acceptedPorts;
    int PID;
    int portNumber;
    AtomicReference<String> proposeValue;
    String identifier;
    int myPort;
    
    public SendMessage(int PID, Integer portNumber,  List<Integer> acceptedPorts,String identifier, AtomicReference<String> proposeValue,int myport){
        this.PID = PID;
        this.portNumber = portNumber;
        this.acceptedPorts = acceptedPorts;
        this.identifier = identifier;
        this.proposeValue = proposeValue; 
        this.myPort = myPort;
    }
    /*
    Creates a socket to the specified portnumber conducts the paxos protocal
    Response object is inteperted and appropriate actions are taken according to the paxos protocal
    */
    public void sendMessage() throws UnknownHostException, IOException{
        Socket socket = null;
        socket = new Socket("localhost",portNumber);
        DataOutputStream dout = null;
        dout = new DataOutputStream(socket.getOutputStream());
        String msg = null;
        if(identifier.equals("propose")){
            msg = "propose:"+PID;
        } else{
            msg = proposeValue + ":" +PID;
        }
        System.out.println(" " + myPort + " Sending message : " + msg + " to port " + this.portNumber);
        dout.writeUTF(msg);
        dout.flush();
        DataInputStream dis = null;
        dis = new DataInputStream(socket.getInputStream());
        String response = null;
        response = dis.readUTF();
        System.out.println(" " + myPort + " Recieved Message back : " + response );
        socket.close();
        ResponseObject res = new ResponseObject(response);
        if(res.ID == PID){
            acceptedPorts.add(portNumber);
        }else if(res.ID != -1 && res.ID != -2){
            this.proposeValue = res.val;
        }
    }

    public void run(){
        try {
            sendMessage();
        } catch (IOException e) {
        }
    }
}
