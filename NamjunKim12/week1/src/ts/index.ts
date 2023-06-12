type HTMLElementEvent<T extends HTMLElement> = Event & {
  target: T;
};

function App() {
  const $ = (selector: string) => document.querySelector(selector) as HTMLElement;

  const $digits = $(".digits");
  const $total = $("#total") as HTMLDivElement;
  const $operations = $(".operations");
  const $modifiers = $(".modifiers");
  const operators = ["+", "-", "X", "/"];

  const handleDigitClick = (e: HTMLElementEvent<HTMLDivElement>) => {
    if (!e.target.classList.contains("digit")) return;

    const currentTotal = $total.innerText;
    const newDigit = e.target.innerText;

    $total.innerText =
      currentTotal === "0" ? newDigit : currentTotal + newDigit;
  };

  const handleOperationClick = (e: HTMLElementEvent<HTMLDivElement>) => {
    if (!e.target.classList.contains("operation")) return;
    const newOperation = e.target.innerText;
    const currentTotal = $total.innerText;

    if (newOperation === "=") return getCalculatedValue(currentTotal);

    $total.innerText = operators.includes(currentTotal.slice(-1)[0])
      ? currentTotal.slice(0, currentTotal.length - 1) + newOperation
      : currentTotal + newOperation;
  };

  const handleModifiersClick = (e: HTMLElementEvent<HTMLDivElement>) => {
    if (!e.target.classList.contains("modifier")) return;
    const modifier = e.target.innerText;

    if (modifier === "AC") $total.innerText = "0";
  };

  const getCalculatedValue = (total: string) => {
    const operator = total.match(/[+X/-]/g);
    if (operator === null || operators.includes(total.slice(-1))) return;
    if (operator[0] === "X") total = total.replace("X", "*");

    $total.innerText = Math.floor(eval(total)).toString();
  };

  $digits.addEventListener("click", handleDigitClick);
  $operations.addEventListener("click", handleOperationClick);
  $modifiers.addEventListener("click", handleModifiersClick);
}

App();