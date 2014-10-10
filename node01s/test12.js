var http = require('http');
var url = require('url');
var qs = require('querystring');

http.createServer(function handler(req, res) {
	
	var v1,v2,op;
	var obj = url.parse(req.url, true);
	var result = compute();
	if (obj.pathname !='/calc'){
		res.end();
		return;
	}

	if (req.method == 'GET') {
		v1 = parseInt(obj.query.v1);
		v2 = parseInt(obj.query.v2);
		op = obj.query.op;
		
		displayResult(res, v1 + 'op' + v2 + ' = ' + result);
		
	} else {
		var messageBody = '';
		req.on('data', function(chunk){
			messageBody += chunk;
		});
		req.on('end', function(){
			var paramMap = qs.parse(messageBody);
			var v1= parseInt(paramMap.v1);
			var v2= parseInt(paramMap.v2);
			var op= paramMap.op;

			displayResult(res, v1 + 'op' + v2 + ' = ' + result);
		});
	}
		
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');


function compute(v1,op,v2){
	switch (op) {
	case 'plus': return v1 + v2;
	case 'minus': return v1 - v2;
	case 'multiple': return v1 * v2;
	case 'divide': return v1 / v2;
	default: res.write('해당 연산자가 없습니다!');
}
	
function displayResult(res, content){
	res.writeHead(200, 'ok', {
		'Content-Type' : 'text/html;charset=UTF-8'
	});
	res.write('<html><head><title>계산기</title></head>');
	res.write('<body>');
	res.write(content);
	res.end();
	res.write('</body></html>');

}
}