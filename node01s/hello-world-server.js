var http = require('http');
http.createServer(function handler(req, res) {
	res.writeHead(200, 'ok', {
		'Content-Type' : 'text/plain'
	});
	res.end('Hello World\n');
	console.log('okok');
}).listen(1337, '192.168.0.67');
console.log('Server running at http://127.0.0.1:1337/');

/*
GET http://192.168.0.67:1337/ HTTP/1.1 
Host: 192.168.0.67:1337 
Connection:keep-alive 
Cache-Control: max-age=0 
Accept:text/html,application/xhtml+xml... 
User-Agent: Mozilla/5.0 (X11; Linux...
Accept-Encoding: gzip,deflate,sdch Accept-Language:
ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4
----------------------------------------------------------------
  
 	HTTP프로토콜 - 응답
 	형식
 	
----------------------------------------------------------------
 	상태라인(엔터)
 	헤더:
---------------------------------------------------------------- 
HTTP/1.1 200 ok
Content-Type: text/plain
Date: Wed, 08 Oct 2014 05:52:39 GMT
Connection: keep-alive
Transfer-Encoding: chunked

Hello World

 	
 	
 */

