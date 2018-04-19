// ��������� ������ http
var http = require('http');

// ������� web-������ � ������������ ��������
var server = http.createServer(function (req, res) {
  console.log('Server created ...');
  // �������� ��� ������ � http-���������
  res.writeHead(200, {
    'Content-Type': 'text/plain; charset=UTF-8'
  });
  res.end('Hello world!');
});

// ��������� web-������
server.listen(2002, "127.0.0.1", function () {
   console.log('Start Server http://127.0.0.1:2002/');
});
