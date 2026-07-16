import "./App.css";

import BookDetails from "./Components/BookDetails";
import BlogDetails from "./Components/BlogDetails";
import CourseDetails from "./Components/CourseDetails";

import { books, blogs, courses } from "./Data";

function App() {

  const showBooks = true;
  const showBlogs = true;
  const showCourses = true;

  return (
    <div className="container">

      <div className="box">
        {showCourses && <CourseDetails courses={courses} />}
      </div>

      <div className="box">
        {showBooks ? (
          <BookDetails books={books} />
        ) : (
          <h2>No Books Available</h2>
        )}
      </div>

      <div className="box">
        {showBlogs ? (
          <BlogDetails blogs={blogs} />
        ) : (
          <h2>No Blogs Available</h2>
        )}
      </div>

    </div>
  );
}

export default App;