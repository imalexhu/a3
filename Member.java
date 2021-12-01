import java.util.concurrent.atomic.AtomicReference;

/*
ADT for a member class
Prepares the correct response for every type message recieved
*/


public class Member {
  int responseSpeed;
  int priority;
  int max_id; 
  AtomicReference<String> proposeValue;
  int PromiseID;
  String PromiseValue;
  int portNumber; 


  public Member(int responseSpeed, AtomicReference<String> proposeValue,int portNumber, int priority){
    this.responseSpeed = responseSpeed;
    this.priority = priority; 
    this.max_id = -1;
    this.PromiseValue = "";
    this.proposeValue = proposeValue;
    this.portNumber = portNumber;
  }
/*
Action on recieve PrepareMessage
If PID is greater set as new PID
IF promised someone else return that 
Otherwise send -1 to ignore
*/

  public String recievePreareMessage(int proposeID){
    if(proposeID > max_id && PromiseValue.isEmpty()){
      max_id = proposeID;
      return Integer.toString(max_id) + ":";
    }else if(proposeID > max_id && !PromiseValue.isEmpty()){
      return Integer.toString(PromiseID) + ":" + this.PromiseValue;
    }else{
      return "-1:";
    }
  }

/*
Action on recieve recieveProposal
If PID is equal to the max id recieved
send approve
Otherwise send -1 to ignore
*/

  public String recieveAcceptPropsal(int acceptID, String acceptValue){
    if(acceptID == max_id){
      this.PromiseValue = acceptValue;
      this.PromiseID = max_id;
      return Integer.toString(max_id) +":";
    }else{
      return "-1:"; 
    }
  }
}