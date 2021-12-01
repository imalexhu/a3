import java.util.concurrent.atomic.AtomicReference;

public class ResponseObject {
    int ID;
    AtomicReference<String> val;

    /*
    ADT representing the Response object returned from the MemberWorker
    Used to communicate Accepted value of PID
    */
    public ResponseObject(String response){
        if(response.endsWith(":")){
            response = response.substring(0, response.length()-1);
            ID = Integer.parseInt(response);
            val = new AtomicReference<String>("");
        }else{
            String[] temp = response.split(":");
            this.ID = Integer.parseInt(temp[0]);
            this.val = new AtomicReference<String>(temp[1]);
        }
    }
}
