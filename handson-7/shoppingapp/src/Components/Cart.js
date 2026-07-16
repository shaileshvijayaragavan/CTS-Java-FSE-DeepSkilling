import React, { Component } from "react";

class Cart extends Component {
  render() {
    const { itemName, price } = this.props;

    return (
      <div
        style={{
          border: "1px solid black",
          margin: "10px",
          padding: "10px",
          borderRadius: "5px",
        }}
      >
        <h3>{itemName}</h3>
        <p>Price: ₹{price}</p>
      </div>
    );
  }
}

export default Cart;