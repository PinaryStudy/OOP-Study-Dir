"use strict";

const readline = require("readline");
const Game = require("./2_game");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const lines = [];

rl.on("line", (line) => {
  lines.push(line);

  if (lines.length === 2) {
    const game = new Game(lines);
    game.start();

    rl.close();
  }
});
