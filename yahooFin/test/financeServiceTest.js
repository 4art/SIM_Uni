var assert = require('assert');
var chai = require('chai');
const financeService = require('../financeService').financeService

describe('yahooFin', () => {
  describe('history', () => {
    it('should have history', (done) => {
      financeService.getHistory("AAPL").then(data => {
        done(assert.ok(chai.expect(data).to.be.a('array')), 'should be an array')
      }).catch(err => {
          done(err)
      })
    }).timeout(6000)
  });
  describe('histories', () => {
    it('should have histories for more symbols', (done) => {
      financeService.getHistories(['AAPL', 'MSFT']).then(data => {
          done(assert.ok(chai.expect(data.MSFT).to.be.a('array')), 'should be an array')
      })
    })
  })
  describe('quotes', () => {
    it('should have quotes for more symbols', (done) => {
      financeService.getQuotes(['AAPL', 'MSFT']).then(data => {
          done(assert.ok(data.MSFT))
      })
    })
  })
  describe('quote', () => {
    it('should have quote for more symbol', (done) => {
      financeService.getQuote('AAPL').then(data => {
          done(assert.ok(data.summaryDetail))
      })
    })
  })
});
