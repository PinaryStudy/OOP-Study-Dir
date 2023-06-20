function Car(name) {
  this.name = name;
  this.currentMovingCount = 0;

  this.go = (count) => {
    Array.from({ length: count }).forEach(() => {
      if (couldGo()) this.currentMovingCount += 1;
    });
  };

  const couldGo = () => {
    if (getRandomInteger() >= 4) return true;
    return false;
  };

  const getRandomInteger = () => {
    return Math.floor(Math.random() * 10);
  };
}

module.exports = Car;
