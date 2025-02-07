# Hello There

## Allow ssh on port 2222:

```bash
#!/bin/bash

sudo echo "Port 22" | sudo tee -a /etc/ssh/sshd_config
sudo echo "Port 2222" | sudo tee -a /etc/ssh/sshd_config
sudo echo "AddressFamily any" | sudo tee -a /etc/ssh/sshd_config
sudo echo "ListenAddress 0.0.0.0" | sudo tee -a /etc/ssh/sshd_config
sudo echo "ListenAddress ::" | sudo tee -a /etc/ssh/sshd_config
sudo systemctl restart ssh
sudo ufw allow ssh

sudo iptables -A INPUT -p tcp --dport 22 -j ACCEPT
sudo iptables-save
```
