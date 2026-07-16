import { useState } from "react";

function CurrencyConverter() {
  const [rupees, setRupees] = useState("");
  const [euro, setEuro] = useState("");

  const handleSubmit = () => {
    const converted = (parseFloat(rupees) / 90).toFixed(2);
    setEuro(converted);
  };

  return (
    <div style={{ marginTop: "30px" }}>
      <h2>Currency Converter</h2>

      <input
        type="number"
        placeholder="Enter Rupees"
        value={rupees}
        onChange={(e) => setRupees(e.target.value)}
      />

      <button onClick={handleSubmit}>Convert</button>

      {euro && <h3>Euro : € {euro}</h3>}
    </div>
  );
}

export default CurrencyConverter;