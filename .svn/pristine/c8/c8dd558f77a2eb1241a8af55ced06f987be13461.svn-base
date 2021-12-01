# test for n people, where n is 11 with 4 proposer

sleep 1
java MemberSimulator 10 0 -1 0 0 &
M0=$!
java MemberSimulator 11 1 -1 0 0 &
M1=$!
java MemberSimulator 11 2 m2 0 0 &
M2=$!
java MemberSimulator 11 3 -1 0 0 &
M3=$!
java MemberSimulator 11 4 -1 0 0 &
M4=$!
java MemberSimulator 11 5 -1 0 0 &
M5=$!
java MemberSimulator 11 6 m6 0 0 &
M6=$!
java MemberSimulator 11 7 m7 0 0 &
M7=$!
java MemberSimulator 11 8 -1 0 0 &
M8=$!
java MemberSimulator 11 9 m9 0 0 &
M9=$!
java MemberSimulator 11 10 m10 0 0 &
M10=$!
sleep 15
kill $M0
kill $M1
kill $M2
kill $M3
kill $M4
kill $M5
kill $M6
kill $M7
kill $M8
kill $M9
kill $M10
