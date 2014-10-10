var http = require('http');
var url = require('url');

http.createServer(function handler(req, res) {
	console.log(req.url);
	var urlInfoMap = url.parse(req.url, true);
	console.log('all:',urlInfoMap.href);
	console.log('path:',urlInfoMap.pathname);
	console.log('data:', urlInfoMap.search);
	console.log('query 객체:', urlInfoMap.query);
	console.log('name=',urlInfoMap.query.name);
	console.log('age=',urlInfoMap.query.age);
	console.log('tel=',urlInfoMap.query.tel);
	res.writeHead(200, 'ok', {
		'Content-Type' : 'text/html;charset=UTF-8'
	});
	res.write('<html><head><title>test06</title></head>');
	res.write('<body>');
	res.write('<h1>노드제이에스</h1>');
	res.write('<p>음흠흠</p>');
	res.write('</body></html>');
	res.end();
	console.log('okok');
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');



