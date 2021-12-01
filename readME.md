This is a submission for ALEX HU for distributed system assignment 3

MemberSimulator takes in 5 parameters, the number of members in the paxos protocal, the index representing itself in the startup file, the propose value of the member, the speed at which the person responds, and the priority he has.


The test will generate the logs, afterwhich a java program will be ran to check if the log outputs were correct. 

logs are stored in test/results

A java compare function was made to see if paxos outputs were valid. It checks for the converged value, and then sees if all other members converged to the same value.


WARNINGS :

I have used KILL to kill all threads to make the application safe. There will be warnings in the console, but they do not affect the outputs.

There is a thread warning for accessing some memory index out of bound for index 15 or something. I have tried to find this issue, but cant. It is not affecting the script at all. And should still run perfectly. 

Please note that the test scripts takes 2.5 min to run



To compile all files
javac *.java 

To run test
chmod +x *test.sh

chmod +x test/*.sh

start the PID server in a seperate window
java PIDServer

then run the test file 
./test.sh

