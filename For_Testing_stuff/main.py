from flask import Flask, request, Response, make_response
import requests
from bs4 import BeautifulSoup
from urllib.parse import urlparse
from cryptography import x509

app = Flask(__name__)


http_proxy  = "http://127.0.0.1:8080"
https_proxy = "http://127.0.0.1:8080"
proxie = {"http": http_proxy, "https": https_proxy}


@app.route('/')
def proxy():
    # Get the 'url' parameter from the GET request
    url = request.args.get('url')
    url = url.replace("runtime.542c0dcecc2736fede71.js", "eailrr/canens/runtime.542c0dcecc2736fede71.js")
    url = url.replace("polyfills.3590a8f04e2c7f47c609.js", "eailrr/canens/polyfills.3590a8f04e2c7f47c609.js")
    url = url.replace("scripts.948f7e6df5cf460f3c64.js", "eailrr/canens/scripts.948f7e6df5cf460f3c64.js")
    url = url.replace("main.da7159bc46eae471a9c6.js", "eailrr/canens/main.da7159bc46eae471a9c6.js")
    url = url.replace("styles/janus-form.scss", "eailrr/canens/styles/janus-form.scss")
    url = url.replace("styles.f19128721b980dc4a82d.css", "eailrr/canens/styles.f19128721b980dc4a82d.css")
    # Get the original request headers
    original_headers = request.headers
    new_headers = {
        'User-Agent': original_headers.get('User-Agent')
    }
    for ioh in original_headers:
        if ioh[0] == "Host":
            continue
        new_headers[ioh[0]] = original_headers.get(ioh[0]).replace("http://127.0.0.1:5000/?url=", "")
    # print(new_headers)
    if not url:
        return "No URL provided", 400
    parsed_uri = urlparse(url)
    base_result = '{uri.scheme}://{uri.netloc}/'.format(uri=parsed_uri)
    # Fetch the content from the URL
    # print(url)
    response = requests.get(url, proxies=proxie, verify='filename.pem', allow_redirects=False, headers=new_headers)
    status_code = response.status_code
    header_v = response.headers['Content-Type']
    if not str(header_v).__contains__('text'):
        print("Skipped", header_v)
        return Response(response.content, content_type=response.headers['Content-Type'])

    soup = BeautifulSoup(response.content, 'html.parser')
    # Rewrite all the links to point to the proxy server
    # for link in soup.find_all('a'):
    #     original_link = link.get('href')
    #     if not (str(original_link).startswith('http')):
    #         original_link = base_result + original_link
    #     link['href'] = '/?url=' + original_link
    
    for tag in soup.find_all(src=True):
        original_link = tag['src']
        # print(original_link)
        if not (str(original_link).startswith('http')):
            original_link = base_result + original_link
        tag['src'] = '/?url=' + original_link
        
    for tag in soup.find_all(href=True):
        original_link = tag['href']
        # print(original_link)
        if not (str(original_link).startswith('http')):
            original_link = base_result + original_link
        tag['href'] = '/?url=' + original_link
        
    # print(str(soup))
    # Return the modified HTML
    with open("1.txt", "r") as fff:
        resp = make_response(str(soup)+ fff.read())
    # for ih in response.headers:
    #     resp.headers[ih] = response.headers[ih]
        # print(response.headers[ih])
    if 'Location' in response.headers:
        # Replace the Location header with a new value
        resp.headers['Location'] = "http://127.0.0.1:5000/?url=" + response.headers['location']
    if 'Set-Cookie' in response.headers:
        # Replace the Location header with a new value
        resp.headers['Set-Cookie'] = response.headers['Set-Cookie']
    return resp, status_code
    # return Response(str(soup), content_type=response.headers['Content-Type'])

# @app.route('/xxx')
@app.route('/<path:path>')
def proxy2(path):
    # The domain you want to proxy
    proxy_domain = 'https://vh.us.kpmg.com/eailrr/canens'
    # The domain you want to replace in the response
    replace_domain_with = 'http://127.0.0.1:5000'

    # Construct the new URL
    new_url = f'{proxy_domain}/{path}'
    base_result = proxy_domain + "/"
    # Get the original request headers
    original_headers = request.headers
    new_headers = {
        'User-Agent': original_headers.get('User-Agent')
    }
    for ioh in original_headers:
        if ioh[0] == "Host":
            continue
        new_headers[ioh[0]] = original_headers.get(ioh[0]).replace("http://127.0.0.1:5000/?url=", "")
    # print(new_headers)
    # Fetch the content from the new URL
    response = requests.get(new_url, proxies=proxie, verify='filename.pem', allow_redirects=False, headers=new_headers)
    status_code = response.status_code
    header_v = response.headers['Content-Type']
    if not str(header_v).__contains__('text'):
        print("Skipped", header_v)
        return Response(response.content, content_type=response.headers['Content-Type'])

    soup = BeautifulSoup(response.content, 'html.parser')
    # Rewrite all the links to point to the proxy server
    # for link in soup.find_all('a'):
    #     original_link = link.get('href')
    #     if not (str(original_link).startswith('http')):
    #         original_link = base_result + original_link
    #     link['href'] = '/?url=' + original_link
    
    for tag in soup.find_all(src=True):
        original_link = tag['src']
        # print(original_link)
        if not (str(original_link).startswith('http')):
            original_link = base_result + original_link
        tag['src'] = '/?url=' + original_link
        
    for tag in soup.find_all(href=True):
        original_link = tag['href']
        # print(original_link)
        if not (str(original_link).startswith('http')):
            original_link = base_result + original_link
        tag['href'] = '/?url=' + original_link
        
    # print(str(soup))
    # Return the modified HTML
    with open("1.txt", "r") as fff:
        resp = make_response(str(soup)+ fff.read())
    # for ih in response.headers:
    #     resp.headers[ih] = response.headers[ih]
        # print(response.headers[ih])
    if 'Location' in response.headers:
        # Replace the Location header with a new value
        resp.headers['Location'] = "http://127.0.0.1:5000/?url=" + response.headers['location']
    if 'Set-Cookie' in response.headers:
        # Replace the Location header with a new value
        resp.headers['Set-Cookie'] = response.headers['Set-Cookie']
    return resp, status_code
    # # If the content type is HTML, replace the domain in links
    # if 'text/html' in response.headers['Content-Type']:
    #     soup = BeautifulSoup(response.content, 'html.parser')
        
    #     # Replace 'href' and 'src' attributes
    #     for tag in soup.find_all(href=True):
    #         tag['href'] = tag['href'].replace(proxy_domain, replace_domain_with)
    #     for tag in soup.find_all(src=True):
    #         tag['src'] = tag['src'].replace(proxy_domain, replace_domain_with)

    #     # Return the modified HTML
    #     return Response(str(soup), content_type='text/html')

    # # If the content is not HTML, return it as is
    # return Response(response.content, content_type=response.headers['Content-Type'])



if __name__ == '__main__':
    app.run(debug=True, host='127.0.0.1', port=5000)
