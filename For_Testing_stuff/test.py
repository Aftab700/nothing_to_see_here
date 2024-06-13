from urllib.parse import urlparse
import requests

http_proxy  = "http://127.0.0.1:8080"
https_proxy = "http://127.0.0.1:8080"
proxie = {"http": http_proxy, "https": https_proxy}


parsed_uri = urlparse('https://stackoverflow.com/questions/1234567/blah-blah-blah-blah' )
result = '{uri.scheme}://{uri.netloc}/'.format(uri=parsed_uri)
print(result)

r = requests.get(result, proxies=proxie, verify='filename.pem')#, verify=False)

print(r.status_code)

