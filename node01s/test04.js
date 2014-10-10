var http = require('http');
http.createServer(function handler(req, res) {
	res.writeHead(200, 'ok', {
		'Content-Type' : 'text/html;charset=UTF-8'
	});
	res.write('<html><head><title>test04</title></head>');
	res.write('<body>');
	res.write('<h1>노드제이에스</h1>');
	res.write('<p>음흠흠</p>');
	res.write('</body></html>');
	res.end();
	console.log('okok');
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');



