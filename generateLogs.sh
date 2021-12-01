./test/a.sh > test/result/a.txt
sleep 1

./test/b.sh > test/result/b.txt
sleep 1

./test/scenarioInstant.sh > test/result/scenarioInstant.txt
sleep 1

./test/scenarioNormal.sh > test/result/scenarioNormal.txt
sleep 1

./test/scenarioOffline.sh > test/result/scenarioOffline.txt

./test/n.sh > test/result/n.txt
