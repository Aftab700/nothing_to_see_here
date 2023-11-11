echo "grep -F '1101132490783' bill.txt | awk -F '|' '{print $1, $2, $5, $6}' | head -n 1"

grep -F "1101132490783" bill.txt | awk -F '|' '{print $1"|" $2"|" $5"|" $6}' 

echo 'awk -F' '|' '$1 ~ "1101132490783" {print $1"|"$2"|"$5"|"$6; found=1} END {if (!found) print "Consumer Not Found"}' 'bill.txt'

awk -F '|' '$1 ~ "1101132490783" {print $1"|"$2"|"$5"|"$6; found=1} END {if (!found) print "Consumer Not Found"}' bill.txt
