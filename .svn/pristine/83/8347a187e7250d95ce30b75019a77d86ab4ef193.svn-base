echo "Generating logs"
./generateLogs.sh > test/bin.txt

echo "Generated Running tests"
sleep 1
echo "N test with 1 proposer"
java paxosChecker test/result/a.txt 11
sleep 1

echo "N test with 5 proposer"
java paxosChecker test/result/b.txt 11
sleep 1

echo "Test with instant response"
java paxosChecker test/result/scenarioInstant.txt 9
sleep 1

echo "Test with assignment description"
java paxosChecker test/result/scenarioNormal.txt 9
sleep 1

echo "Test with m2 and m3 offline"
java paxosChecker test/result/scenarioOffline.txt 9
sleep 1

echo "Test with m = 15 and proposer = 7 with random response speed and prioirity"
java paxosChecker test/result/n.txt 15

