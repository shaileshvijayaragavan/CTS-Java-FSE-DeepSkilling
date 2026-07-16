import officeImage from "./office.jpg";

function App() {
  const office = {
    name: "Tech Park",
    rent: 55000,
    address: "Chennai"
  };

  const officeSpaces = [
    {
      name: "Tech Park",
      rent: 55000,
      address: "Chennai"
    },
    {
      name: "Innovation Hub",
      rent: 70000,
      address: "Bangalore"
    },
    {
      name: "Business Tower",
      rent: 45000,
      address: "Hyderabad"
    }
  ];

  return (
    <div style={{ padding: "20px" }}>
      <h1>Office Space Rental App</h1>

      <img
        src={officeImage}
        alt="Office"
        width="400"
        height="250"
      />

      <hr />

      <h2>Featured Office</h2>

      <p><strong>Name:</strong> {office.name}</p>

      <p>
        <strong>Rent:</strong>
        <span
          style={{
            color: office.rent < 60000 ? "red" : "green",
            marginLeft: "5px"
          }}
        >
          ₹{office.rent}
        </span>
      </p>

      <p><strong>Address:</strong> {office.address}</p>

      <hr />

      <h2>Available Office Spaces</h2>

      {officeSpaces.map((item, index) => (
        <div
          key={index}
          style={{
            border: "1px solid gray",
            padding: "10px",
            marginBottom: "10px",
            width: "350px"
          }}
        >
          <p><strong>Name:</strong> {item.name}</p>

          <p>
            <strong>Rent:</strong>
            <span
              style={{
                color: item.rent < 60000 ? "red" : "green",
                marginLeft: "5px"
              }}
            >
              ₹{item.rent}
            </span>
          </p>

          <p><strong>Address:</strong> {item.address}</p>
        </div>
      ))}
    </div>
  );
}

export default App;