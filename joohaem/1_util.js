const ERROR_MESSAGE = require("./1_error");

const OPERATORS = ["+", "-", "/", "*"];

function UtilForCalculator() {
  this.checkIsEmpty = (formula) => {
    if (formula === "") throw new Error(ERROR_MESSAGE.EmptyEntered);
  };

  this.checkNumber = (token) => {
    const result = !isNaN(+token);
    if (!result) throw new Error(ERROR_MESSAGE.Number);
    return result;
  };

  this.checkOperator = (token) => {
    const result = OPERATORS.some((operator) => operator === token);
    if (!result) throw new Error(ERROR_MESSAGE.Operator);
    return result;
  };

  this.checkWhole = () => {
    throw new Error(ERROR_MESSAGE.Operator);
  };

  this.isNumberIdx = (idx) => {
    return idx % 2 === 0;
  };

  this.isOperatorIdx = (idx) => {
    return idx % 2 === 1;
  };
}

module.exports = UtilForCalculator;
