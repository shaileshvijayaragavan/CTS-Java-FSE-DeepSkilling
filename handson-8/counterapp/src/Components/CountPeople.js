import React, { Component } from "react";

class CountPeople extends Component {
  constructor(props) {
    super(props);

    this.state = {
      entryCount: 0,
      exitCount: 0,
    };
  }

  updateEntry = () => {
    this.setState({
      entryCount: this.state.entryCount + 1,
    });
  };

  updateExit = () => {
    this.setState({
      exitCount: this.state.exitCount + 1,
    });
  };

  render() {
    return (
      <div style={{ textAlign: "center", marginTop: "40px" }}>
        <h2>Mall Entry Counter</h2>

        <h3>People Entered : {this.state.entryCount}</h3>

        <button onClick={this.updateEntry}>
          Login
        </button>

        <br /><br />

        <h3>People Exited : {this.state.exitCount}</h3>

        <button onClick={this.updateExit}>
          Exit
        </button>
      </div>
    );
  }
}

export default CountPeople;