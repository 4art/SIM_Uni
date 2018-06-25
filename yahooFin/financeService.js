const yahooFinance = require('yahoo-finance');
const arraySort = require('array-sort');
function FinanceService() {
    this.getHistory = (symbol) => {
      return yahooFinance.historical({
        symbol: symbol,
        from: '2000-01-01',
        // to: '2018-05-24',
        period: 'd'
      }).then(data => {
        return arraySort(data, 'date')
      })
    }
  
    this.getHistories = (symbols) => {
      return yahooFinance.historical({
        symbols: symbols,
        from: '2000-01-01',
        // to: '2018-05-24',
        period: 'd'
      }).then(data => {
        for(let i = 0; i < symbols.length; i++){
          data[symbols[i]] = arraySort(data[symbols[i]], 'date')
        }
        return data
      })
    }
  
    this.getQuotes = (symbols) => {
      return yahooFinance.quote({
        symbols: symbols,
        // from: '2000-01-01',
        // to: '2018-05-24',
        modules: ['price', 'summaryDetail']
      })
    }
  
    this.getQuote = (symbol) => {
      return yahooFinance.quote({
        symbol: symbol,
        // from: '2000-01-01',
        // to: '2018-05-24',
        modules: ['price', 'summaryDetail']
      })
    }
  }
exports.financeService = new FinanceService()