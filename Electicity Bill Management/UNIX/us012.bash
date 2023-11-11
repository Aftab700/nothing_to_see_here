
echo 'awk -F' '"|"' '{sum = 0; for (i = 2; i <= 6; i++) sum += $i; avg = sum / 5; print $1 "|" $2 "|" avg}' 'bill2.txt | sort -k 3 -nr'

awk -F '|' '{sum = 0; for (i = 2; i <= 6; i++) sum += $i; avg = sum / 5; print $1 "|" $2 "|" avg}' bill2.txt | sort -k 3 -nr

