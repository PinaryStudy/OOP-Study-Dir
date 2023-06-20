const Car = require("./2_car");
const { ERROR_MESSAGE } = require("./2_error");

const MAX_CAR_COUNT = 5;
const MAX_CAR_NAME_LENGTH = 5;

function Game([_cars, _movingCount]) {
  let carNames = _cars.split(",");
  let movingCount = _movingCount;

  let cars = null;
  let winners = [];

  this.start = () => {
    checkInits();

    playGame();

    printResult();
  };

  const checkInits = () => {
    const isErrorWithCarCount =
      carNames.length <= 0 || carNames.length > MAX_CAR_COUNT;
    const isErrorWithMoveCount = movingCount <= 0;

    if (isErrorWithCarCount) throw new Error(ERROR_MESSAGE.CarCount);
    if (!checkInitCarsName()) throw new Error(ERROR_MESSAGE.CarNameLength);
    if (isErrorWithMoveCount) throw new Error(ERROR_MESSAGE.MoveCount);
  };

  const checkInitCarsName = () => {
    return carNames.every((car) => car.length <= MAX_CAR_NAME_LENGTH);
  };

  const playGame = () => {
    generateCars();
    moveCars();
    findWinners();
  };

  const generateCars = () => {
    cars = carNames.map((carName) => new Car(carName));
  };

  const moveCars = () => {
    cars.forEach((car) => {
      car.go(movingCount);
    });
  };

  const findWinners = () => {
    let maxMoving = -1;
    winners = cars.reduce((acc, car) => {
      if (maxMoving < car.currentMovingCount) {
        maxMoving = car.currentMovingCount;

        acc = [];
        acc.push(car.name);
      } else if (maxMoving === car.currentMovingCount) {
        acc.push(car.name);
      }

      return acc;
    }, []);
  };

  const printResult = () => {
    printCarsResult();
    console.log("===============");
    printWinners();
  };

  const printCarsResult = () => {
    cars.forEach((car) => {
      console.log(`${car.name} : ${"-".repeat(car.currentMovingCount)}`);
    });
  };

  const printWinners = () => {
    console.log(`winner : ${winners.join(",")}`);
  };
}

module.exports = Game;
