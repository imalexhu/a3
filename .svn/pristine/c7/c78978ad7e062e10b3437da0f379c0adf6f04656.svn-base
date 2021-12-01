# Scenario for instant response

sleep 1
java MemberSimulator 11 1 m1 0 10 &
M1=$!
java MemberSimulator 11 2 m2 5 10 &
M2=$!
java MemberSimulator 11 3 m3 5 5 &
M3=$!
java MemberSimulator 11 4 -1 0 0 &
M4=$!
java MemberSimulator 11 5 -1 0 0 &
M5=$!
java MemberSimulator 11 6 -1 0 0 &
M6=$!
java MemberSimulator 11 7 -1 0 0 &
M7=$!
java MemberSimulator 11 8 -1 0 0 &
M8=$!
java MemberSimulator 11 9 -1 0 0 &
M9=$!
sleep 15
kill $M1
kill $M2
kill $M3
kill $M4
kill $M5
kill $M6
kill $M7
kill $M8
kill $M9
