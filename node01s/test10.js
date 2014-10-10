var http = require('http');

var url = require('url');

var qs = require('querystring');

http.createServer(function handler(req, res) {
	
	var v1,v2,op;

	if (req.method == 'GET') {
		var urlInfoMap = url.parse(req.url, true);
		v1 = parseInt(urlInfoMap.query.v1);
		v2 = parseInt(urlInfoMap.query.v2);
		op = urlInfoMap.query.op;
		
		displayResult(req,res,v1,v2,op);
		}
		/*
		  if (op == 'plus') { res.write(v1 + '+' + v2 + '=' + (v1+v2)); } else
		  if (op == 'minus') { res.write(v1 + '-' + v2 + '=' + (v1-v2)); } else
		  if (op == 'multiple') { res.write(v1 + '*' + v2 + '=' + (v1*v2)); }
		  else if (op == 'divide') { res.write(v1 + '/' + v2 + '=' + (v1/v2)); }
		  else { res.write('연산자가 없습니다.');}
		 */
	 else {
		//
		var messageBody = '';
		req.on('data', function(chunk){
			messageBody += chunk;
		});
		req.on('end', function(){
			//console.log(messageBody);
			var paramMap = qs.parse(messageBody);
			v1= parseInt(paramMap.v1);
			v2= parseInt(paramMap.v2);
			op= paramMap.op;
			
			displayResult(req,res,v1,v2,op);
		});
	}

	console.log('okok');
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');


function displayResult(req, res, v1, v2, op){
	res.writeHead(200, 'ok', {
		'Content-Type' : 'text/html;charset=UTF-8'
	});
	res.write('<html><head><title>test10</title></head>');
	res.write('<body>');
	res.write('<p>계산기</p>');

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

	res.write('</body></html>');
	res.end();
	
}
}