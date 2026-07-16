import { useParams } from "react-router-dom";
import trainers from "../Data/TrainersMock";

function TrainerDetails() {
  const { id } = useParams();

  const trainer = trainers.find(
    (t) => t.id === Number(id)
  );

  if (!trainer) {
    return <h3>Trainer Not Found</h3>;
  }

  return (
    <div>
      <h2>{trainer.name}</h2>

      <p>
        <strong>Email:</strong> {trainer.email}
      </p>

      <p>
        <strong>Phone:</strong> {trainer.phone}
      </p>

      <p>
        <strong>Technology:</strong> {trainer.technology}
      </p>

      <p>
        <strong>Skills:</strong> {trainer.skills}
      </p>
    </div>
  );
}

export default TrainerDetails;