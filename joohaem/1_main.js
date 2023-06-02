"use strict";

const readline = require("readline");
const Calculator = require("./1_calculator");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.question("Enter One Space Apart: ", (input) => {
  const calculator = new Calculator();
  calculator.calculate(input);

  rl.close();
});
