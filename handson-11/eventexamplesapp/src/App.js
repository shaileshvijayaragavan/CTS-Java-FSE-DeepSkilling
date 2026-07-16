import { useState } from "react";
import CurrencyConverter from "./Components/CurrencyConverter";

function App() {
  const [count, setCount] = useState(0);

  const increment = () => {
    setCount(count + 1);
  };

  const decrement = () => {
    setCount(count - 1);
  };

  const sayHello = () => {
    alert("Hello! Counter Increased");
  };

  const handleIncrement = () => {
    increment();
    sayHello();
  };

  const sayWelcome = (message) => {
    alert(message);
  };

  const handleClick = () => {
    alert("I was clicked");
  };

  return (
    <div style={{ padding: "20px" }}>
      <h1>React Event Handling</h1>

      <h2>Counter : {count}</h2>

      <button onClick={handleIncrement}>
        Increment
      </button>

      <button
        onClick={decrement}
        style={{ marginLeft: "10px" }}
      >
        Decrement
      </button>

      <br />
      <br />

      <button
        onClick={() => sayWelcome("Welcome")}
      >
        Say Welcome
      </button>

      <br />
      <br />

      <button onClick={handleClick}>
        OnPress
      </button>

      <CurrencyConverter />
    </div>
  );
}

export default App;