var http = require('http');

var url = require('url');

http.createServer(function handler(req, res) {

	var urlInfoMap = url.parse(req.url, true);
	var v1 = parseInt(urlInfoMap.query.v1);
	var v2 = parseInt(urlInfoMap.query.v2);
	var op = urlInfoMap.query.op;

	res.writeHead(200, 'ok', {
		'Content-Type' : 'text/html;charset=UTF-8'
	});
	res.write('<html><head><title>test09</title></head>');
	res.write('<body>');
	res.write('<p>계산기</p>');
	res.write('</body></html>');
	if (req.method == 'GET') {
		switch (op) {
		case 'plus':
			res.write(v1 + ' + ' + v2 + ' = ' + (v1 + v2));
			break;
		case 'minus':
			res.write(v1 + ' - ' + v2 + ' = ' + (v1 - v2));
			break;
		case 'multiple':
			res.write(v1 + ' * ' + v2 + ' = ' + (v1 * v2));
			break;
		case 'divide':
			res.write(v1 + ' / ' + v2 + ' = ' + (v1 / v2));
			break;
		default:
			res.write('해당 연산자가 없습니다!');
		}

		/*
		 * if (op == 'plus') { res.write(v1 + '+' + v2 + '=' + (v1+v2)); } else
		 * if (op == 'minus') { res.write(v1 + '-' + v2 + '=' + (v1-v2)); } else
		 * if (op == 'multiple') { res.write(v1 + '*' + v2 + '=' + (v1*v2)); }
		 * else if (op == 'divide') { res.write(v1 + '/' + v2 + '=' + (v1/v2)); }
		 * else { res.write('연산자가 없습니다.');}
		 */
	} else {
		res.write(req.method + '요청을 지원하지 않습니다');
	}

	res.end();
	console.log('okok');
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');
