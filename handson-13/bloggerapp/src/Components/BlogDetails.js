function BlogDetails(props) {

  const content = props.blogs.map((blog) => (
    <div key={blog.id}>
      <h2>{blog.title}</h2>
      <h4>{blog.author}</h4>
      <p>{blog.content}</p>
      <br />
    </div>
  ));

  return (
    <div>
      <h1>Blog Details</h1>
      {content}
    </div>
  );
}

export default BlogDetails;