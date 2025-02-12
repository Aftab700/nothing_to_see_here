# Hello There

## Allow ssh on port 2222:

```bash
#!/bin/bash

echo "Port 700" | sudo tee -a /etc/ssh/sshd_config
echo "Port 2222" | sudo tee -a /etc/ssh/sshd_config
echo "AddressFamily any" | sudo tee -a /etc/ssh/sshd_config
echo "ListenAddress 0.0.0.0" | sudo tee -a /etc/ssh/sshd_config
echo "ListenAddress ::" | sudo tee -a /etc/ssh/sshd_config
sudo systemctl restart ssh
sudo ufw allow ssh

sudo iptables -A INPUT -p tcp --dport 22 -j ACCEPT
sudo iptables-save
```

For easy copy paste:
```bash
echo 'IyEvYmluL2Jhc2gKCmVjaG8gIlBvcnQgNzAwIiB8IHN1ZG8gdGVlIC1hIC9ldGMvc3NoL3NzaGRfY29uZmlnCmVjaG8gIlBvcnQgMjIyMiIgfCBzdWRvIHRlZSAtYSAvZXRjL3NzaC9zc2hkX2NvbmZpZwplY2hvICJBZGRyZXNzRmFtaWx5IGFueSIgfCBzdWRvIHRlZSAtYSAvZXRjL3NzaC9zc2hkX2NvbmZpZwplY2hvICJMaXN0ZW5BZGRyZXNzIDAuMC4wLjAiIHwgc3VkbyB0ZWUgLWEgL2V0Yy9zc2gvc3NoZF9jb25maWcKZWNobyAiTGlzdGVuQWRkcmVzcyA6OiIgfCBzdWRvIHRlZSAtYSAvZXRjL3NzaC9zc2hkX2NvbmZpZwpzdWRvIHN5c3RlbWN0bCByZXN0YXJ0IHNzaApzdWRvIHVmdyBhbGxvdyBzc2gKCnN1ZG8gaXB0YWJsZXMgLUEgSU5QVVQgLXAgdGNwIC0tZHBvcnQgMjIgLWogQUNDRVBUCnN1ZG8gaXB0YWJsZXMtc2F2ZQo=' | base64 -d > allow_ssh.bash
chmod +x allow_ssh.bash
sudo ./allow_ssh.bash
```

To connect use:
```bash
ssh -p 700 aftab700@IP
```
