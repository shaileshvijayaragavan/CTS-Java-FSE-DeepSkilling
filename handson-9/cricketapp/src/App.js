import ListofPlayers from "./Components/ListofPlayers";
import IndianPlayers from "./Components/IndianPlayers";

function App() {
  const flag = true;

  return (
    <div style={{ padding: "20px" }}>
      {flag ? <ListofPlayers /> : <IndianPlayers />}
    </div>
  );
}

export default App;