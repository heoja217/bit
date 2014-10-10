var http = require('http');

var url = require('url');

http.createServer(function handler(req, res) {

	var urlInfoMap = url.parse(req.url, true);
	var name = urlInfoMap.query.name;

	console.log('name=',urlInfoMap.query.name);
	
	res.writeHead(200, 'ok', {
		'Content-Type' : 'text/html;charset=UTF-8'
	});
	res.write('<html><head><title>test07</title></head>');
	res.write('<body>');
	res.write('<h1>안녕하세요. '+name+'님</h1>');
	res.write('<p>으흠흠</p>');
	res.write('</body></html>');
	res.end();
	console.log('okok');
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');



