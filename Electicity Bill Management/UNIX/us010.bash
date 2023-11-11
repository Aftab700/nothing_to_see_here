echo 'grep "Active" Complaints.txt | wc -l'

grep "Active" Complaints.txt | wc -l

echo 'awk -F' '"|"' '{if ($7 ~ /Active/ ) count++} END {print count}' 'Complaints.txt'

awk -F '|' '{if ($7 ~ /Active/ ) count++} END {print count}' Complaints.txt
