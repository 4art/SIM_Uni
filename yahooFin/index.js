const financeService = require('./financeService').financeService
var express = require('express');
var app = express();

app.get('/yahoo', function (req, res) {
  if (req.query.symbols) {
    financeService.getHistories(req.query.symbols.split(",")).then(data => {
      res.send(data)
    })
  } else if(req.query.symbol) {

    financeService.getHistory(req.query.symbol).then(data => {
      res.send(data)
    })
  } else {
      res.send({
          error: "'symbol' or 'symbols' is requeired"
      })
  }
})

var server = app.listen(8082, function () {

  var host = server.address().address
  var port = server.address().port

  console.log("Example app listening at http://%s:%s", host, port)

})