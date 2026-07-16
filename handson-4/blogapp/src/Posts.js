import React, { Component } from "react";

class Posts extends Component {
  constructor(props) {
    super(props);

    this.state = {
      posts: []
    };
  }

  loadPosts = async () => {
    try {
      const response = await fetch(
        "https://jsonplaceholder.typicode.com/posts"
      );

      const data = await response.json();

      this.setState({
        posts: data
      });
    } catch (error) {
      alert(error.message);
    }
  };

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error) {
    alert(error.message);
  }

  render() {
    return (
      <div style={{ padding: "20px" }}>
        <h2>Blog Posts</h2>

        {this.state.posts.map((post) => (
          <div
            key={post.id}
            style={{
              border: "1px solid #ccc",
              padding: "15px",
              marginBottom: "15px",
              borderRadius: "8px"
            }}
          >
            <h3>{post.title}</h3>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;