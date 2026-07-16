function ListofPlayers() {
  const players = [
    { name: "Virat Kohli", score: 95 },
    { name: "Rohit Sharma", score: 82 },
    { name: "KL Rahul", score: 45 },
    { name: "Shubman Gill", score: 76 },
    { name: "Hardik Pandya", score: 68 },
    { name: "Ravindra Jadeja", score: 59 },
    { name: "Rishabh Pant", score: 88 },
    { name: "Surya Kumar", score: 91 },
    { name: "Ashwin", score: 55 },
    { name: "Bumrah", score: 73 },
    { name: "Siraj", score: 40 }
  ];

  const lowScorers = players.filter(player => player.score < 70);

  return (
    <div>
      <h2>List of Players</h2>

      <h3>All Players</h3>
      <ul>
        {players.map((player, index) => (
          <li key={index}>
            {player.name} - {player.score}
          </li>
        ))}
      </ul>

      <h3>Players with Score below 70</h3>
      <ul>
        {lowScorers.map((player, index) => (
          <li key={index}>
            {player.name} - {player.score}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ListofPlayers;