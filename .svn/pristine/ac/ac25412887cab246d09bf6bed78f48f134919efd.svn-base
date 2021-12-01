import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;


/*
Simulates out a member in the paxos protocal
*/

public class MemberSimulator {

/*
Reads in from the setup file to initalise all the ports
*/
  public static List<Integer> setup(int numPorts){
    int counter = 0 ;
    List<Integer> ports = new ArrayList<Integer>();
    try {
    FileReader file = new FileReader("setup.txt");
    try {
    BufferedReader br = new BufferedReader(file);
      try {
          StringBuilder sb = new StringBuilder();
          String line = br.readLine();

          while (line != null) {
              sb.append(line);
              sb.append(System.lineSeparator());
              line = br.readLine();
          }
          String[] s = sb.toString().split("\n");
            for(int i = 0; i<s.length;i++){
              Integer everything = Integer.parseInt(s[i]);
              ports.add(everything);
              counter++;
              if(counter == numPorts){
                break;
              }
            }
            br.close();
        } catch( Exception e ){
          System.out.println(e);
          System.out.println("Error getting data from content");
          System.exit(1);
        }
      } catch (Exception e) {
        System.out.println("Error creating buffer");
        System.exit(1);
      }    
    } catch (Exception e) {
      System.out.println("Error reading");
    }


    
    return ports;
  }

/*
Simulates paxos protocal on a member
If the person proposing it will create a thread to propose
Everyone will have a mutithreaded client listenning to incomming requests
*/
  public static void main(String args[]) throws UnknownHostException, IOException, InterruptedException {
    String numPorts = args[0];
    int myPortIndex = Integer.parseInt(args[1]);
    String val = args[2];
    int responseSpeed = Integer.parseInt(args[3]);
    int priority = Integer.parseInt(args[4]);

    List<Integer> ports;
    ports = setup(Integer.parseInt(numPorts));
    int myPort = ports.get(myPortIndex);
    
    ports.remove(myPortIndex);


    Member member = new Member(responseSpeed,new AtomicReference<String>(val),myPort,priority);
    System.out.println("Created memeber with port " + myPort + " : " + member.proposeValue);

    ServerSocket ss = new ServerSocket(myPort);
    AtomicInteger converge = new AtomicInteger(); 

    TimeUnit.MILLISECONDS.sleep(1000);
    if(!val.equals("-1")){
      Proposer P = new Proposer(ports ,member,converge);
      Thread t = new Thread(P);
      t.setDaemon(true);
      t.start();
    }

    while(converge.get() != 1){
      try
      {
        MemberWorker worker = new MemberWorker(ss.accept(),member,converge);
        Thread thread = new Thread(worker);
        thread.setDaemon(true);
        thread.start();
      }catch(Exception e)
      {
        System.out.println(e);
        System.exit(1);
      }  
      TimeUnit.MICROSECONDS.sleep(10);
      if(converge.get() == 1){
        break;
      }else{
      }
    }
    if(converge.get() == 1){
      TimeUnit.SECONDS.sleep(1);
      
      System.exit(0);
    }
  }
}

