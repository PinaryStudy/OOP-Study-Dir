const UtilForCalculator = require("./1_util");

function Calculator() {
  const util = new UtilForCalculator();
  this.result = 0;

  this.calculate = (formula) => {
    const tokens = this.splitFormula(formula);
    this.result = this.calculateTokens(tokens);

    console.log(this.result);
  };

  this.splitFormula = (formula) => {
    util.checkIsEmpty(formula);
    return formula.split(" ").map(this.onMapForParseToken);
  };

  this.onMapForParseToken = (stringToken, i) => {
    if (util.isNumberIdx(i) && util.checkNumber(stringToken))
      return +stringToken;
    if (util.isOperatorIdx(i) && util.checkOperator(stringToken))
      return stringToken;
    util.checkWhole();
  };

  this.calculateTokens = (tokens) => {
    return tokens.reduce(this.onReduceCalculating, tokens[0]);
  };

  this.onReduceCalculating = (acc, token, idx, array) => {
    if (util.isNumberIdx(idx)) return acc;

    return this.calculateLeftNRight(acc, token, array[idx + 1]);
  };

  this.calculateLeftNRight = (left, operator, right) => {
    return eval(`${left} ${operator} ${right}`);
  };
}

module.exports = Calculator;
