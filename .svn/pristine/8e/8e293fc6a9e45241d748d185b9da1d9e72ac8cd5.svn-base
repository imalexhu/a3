# test for n people, where n is 11 with 4 proposer

sleep 1
java MemberSimulator 20 0 -1 0 0 &
M0=$!
java MemberSimulator 20 1 -1 0 0 &
M1=$!
java MemberSimulator 20 2 m2 1 0 &
M2=$!
java MemberSimulator 20 3 -1 0 0 &
M3=$!
java MemberSimulator 20 4 -1 0 0 &
M4=$!
java MemberSimulator 20 5 -1 0 0 &
M5=$!
java MemberSimulator 20 6 m6 0 2 &
M6=$!
java MemberSimulator 20 7 m7 1 3 &
M7=$!
java MemberSimulator 20 8 -1 0 0 &
M8=$!
java MemberSimulator 20 9 m9 0 0 &
M9=$!
java MemberSimulator 20 10 m10 0 0 &
M10=$!
java MemberSimulator 20 11 m11 2 5 &
M11=$!
java MemberSimulator 20 12 m12 0 0 &
M12=$!
java MemberSimulator 20 13 -1 1 0 &
M13=$!
java MemberSimulator 20 14 -1 0 0 &
M14=$!
java MemberSimulator 11 15 -1 0 0 &
M15=$!
sleep 20
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
kill $M11
kill $M12
kill $M13
kill $M14
kill $M15
