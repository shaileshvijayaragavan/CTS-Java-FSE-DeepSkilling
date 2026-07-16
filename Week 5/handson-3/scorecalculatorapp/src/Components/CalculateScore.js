import "../Stylesheets/mystyle.css";

function CalculateScore(props) {
  const average = props.total / props.goal;

  return (
    <div className="container">
      <h2>Student Score Card</h2>

      <p><strong>Name:</strong> {props.name}</p>
      <p><strong>School:</strong> {props.school}</p>
      <p><strong>Total Marks:</strong> {props.total}</p>
      <p><strong>Total Subjects:</strong> {props.goal}</p>
      <p><strong>Average:</strong> {average.toFixed(2)}</p>
    </div>
  );
}

export default CalculateScore;