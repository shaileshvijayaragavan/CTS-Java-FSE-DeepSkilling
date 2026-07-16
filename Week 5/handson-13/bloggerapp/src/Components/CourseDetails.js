function CourseDetails(props) {

  const coursedet = props.courses.map((course) => (
    <div key={course.id}>
      <h2>{course.cname}</h2>
      <h4>{course.date}</h4>
      <br />
    </div>
  ));

  return (
    <div>
      <h1>Course Details</h1>
      {coursedet}
    </div>
  );
}

export default CourseDetails;