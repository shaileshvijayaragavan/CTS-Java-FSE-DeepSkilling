function IndianPlayers() {
  const players = [
    "Virat",
    "Rohit",
    "Gill",
    "Rahul",
    "Pant",
    "Hardik"
  ];

  const oddPlayers = players.filter((_, index) => index % 2 === 0);
  const evenPlayers = players.filter((_, index) => index % 2 !== 0);

  const t20Players = ["Surya", "Tilak", "Rinku"];
  const ranjiPlayers = ["Pujara", "Rahane", "Sarfaraz"];

  const mergedPlayers = [...t20Players, ...ranjiPlayers];

  return (
    <div>
      <h2>Indian Players</h2>

      <h3>Odd Team Players</h3>
      <ul>
        {oddPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>

      <h3>Even Team Players</h3>
      <ul>
        {evenPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>

      <h3>Merged Team Players</h3>
      <ul>
        {mergedPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>
    </div>
  );
}

export default IndianPlayers;