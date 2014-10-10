var http = require('http');

var url = require('url');

var qs = require('querystring');

http.createServer(function handler(req, res) {

	if (req.method == 'GET') {
		console.log('get');
	} else {
		console.log('post');
	}
	res.end();
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');


/*

url=localhost:1337/test/okok?v1=20&op=plus&v2=30
                 pathㄱ 
(localhost):(1337)(/test/okok)?(v1=20&op=plus&v2=30)
  ㄴhostname   ㄴport No.            ㄴquerystring

*/
