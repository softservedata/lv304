// Загружаем модуль http
var http = require('http');

// Создаем web-сервер с обработчиком запросов
var server = http.createServer(function (req, res) {
  console.log('Server created ...');
  // Передаем код ответа и http-заголовки
  res.writeHead(200, {
    'Content-Type': 'text/plain; charset=UTF-8'
  });
  res.end('Hello world!');
});

// Запускаем web-сервер
server.listen(2002, "127.0.0.1", function () {
   console.log('Start Server http://127.0.0.1:2002/');
});
