from cryptography import x509

# Load your .der certificate
# with open('./cacert.der', 'rb') as f:
#     der_cert = f.read()
#     cert = x509.load_der_x509_certificate(der_cert)

# # Convert the certificate to PEM format
# pem_cert = cert.public_bytes(encoding=x509.Encoding.PEM)
# with open('your_certificate.pem', 'wb') as f:
#     f.write(pem_cert)

url = "1"
url = [url.replace(i, "x/"+i) for i in ["1", "2"]]

print(url)

