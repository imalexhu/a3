import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class paxosChecker {


    // gets the file with the file path return as a string
    static String getFile(String filePath){

    String ret = "";
    try {
    FileReader file = new FileReader(filePath);
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
                ret = sb.toString();
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
    return ret;
    }

    //Reads in the logs and finds the final value that has beeen elected
    //checks to see that there all members have exited with that value been elected

    public static void main(String args[]){
        String filePath = args[0];
        String file = getFile(filePath);
        int compare = Integer.parseInt(args[1]);
        int i = 0;
        int electedValueIndex = file.indexOf("Proposer Converged : ") + 21;
        
        String electedValue = "";

        ArrayList<Integer> check= new ArrayList<Integer>();
        check.add(1);
        check.add(2);
        check.add(3);
        check.add(4);
        check.add(5);
        check.add(6);
        check.add(7);
        check.add(8);
        check.add(9);

        while(file.charAt(electedValueIndex) == 'm' || check.indexOf(file.charAt(electedValueIndex) - '0') != -1){
            electedValue = electedValue + file.charAt(electedValueIndex);
            electedValueIndex++;
        }

        System.out.println(electedValue);
        
        
        while(file.indexOf("Convergence reached : " + electedValue)!= -1){
            i++;
            file = file.replaceFirst("Convergence reached : " + electedValue , "");
        }


        //Special case when either m2 or m3 is offline since they can not respond.

        if(filePath.equals("test/result/scenarioOffline.txt")){
            if(i == 6 || i == 7){
                System.out.println("Paxos Converged Successfully : " + electedValue);

            }else{
                System.out.println("Paxos Failed");

            }

        }else{
            if(i == compare-1){
                System.out.println("Paxos Converged Successfully : " + electedValue);
            }else{
                System.out.println("Paxos Failed");
    
            }
        }
    }
}
