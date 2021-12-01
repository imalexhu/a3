import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Propose extends TimerTask{
  public List<Integer>ports;
  public Member member;
  public int PID;
  public AtomicInteger converge;

  public Propose(List<Integer> ports, Member member, int PID, AtomicInteger converge) {
    this.ports = ports;
    this.member = member;
    this.PID = PID; 
    this.converge = converge;
  }

  /*
  Initiates the propose protocal
  First given the port size, the majority is found 
  Sends a prepare to all members
  once majority returned preprare response
  sends accept to all members
  once majority return promise to accept
  value is elected
  one final message is sent to all members
  setting every member's value to be the converge value
   */

  public void run(){
    List<Integer>TempList =  new ArrayList<Integer>();
    List<Integer>AcceptorPorts = Collections.synchronizedList(TempList);
    AtomicReference<String> proposeValue = member.proposeValue;
    System.out.println("Proposing value " + proposeValue + " with PID " + PID);
    int majority = 0;
    if(ports.size()%2 != 0){
        majority = (ports.size()+1)/2;
    }else{
        majority = (ports.size()/2)+1;
    }
    for(int i = 0; i<ports.size();i++){ 
        SendMessage message = new SendMessage(this.PID,this.ports.get(i),AcceptorPorts, "propose", proposeValue,member.portNumber);
        Thread t = new Thread(message);
        t.setDaemon(true);
        t.start();
    }
    try {
        TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    
    while(majority >  AcceptorPorts.size()){};
    System.out.println("Recieved majority prepare");

    ArrayList<Integer>temp1 = new ArrayList<Integer>();
    for(int i = 0; i<AcceptorPorts.size();i++){
        SendMessage message = new SendMessage(this.PID, AcceptorPorts.get(i),temp1,"", proposeValue, member.portNumber);
        Thread thread = new Thread(message);
        thread.setDaemon(true);
        thread.start();
    }

    while(majority >  temp1.size()){};
    System.out.println("Recieved majority Accept, converged");
    this.converge.incrementAndGet(); 
    System.out.println("Proposer Converged : " + proposeValue );

    ArrayList<Integer> temp = new ArrayList<Integer>();
    for(int i = 0; i < ports.size();i++){
      SendMessage message = new SendMessage(-2, ports.get(i),temp,"", member.proposeValue,member.portNumber);
      new Thread(message).start();
    }
  }
}
