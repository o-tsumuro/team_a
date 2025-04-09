package dao;

public class ClassNumDAO extends DAO {

//	public ClassNum get(String class_num, School school) throws Exception {
//		Connection con = getConnection();
//
//		PreparedStatement st = con.prepareStatement(
//				"SELECT * FROM CLASS_NUM WHERE SCHOOL_CD = ? AND CLASS_NUM = ? ");
//		st.setString(1, school.getCd());
//		st.setString(2, class_num.);
//	}
//
//
//    public List<ClassNum> getAllStudents() throws Exception {
//        // TODO: 実装
//    	List<ClassNum> list = new ArrayList<>();
//    	Connection con = getConnection();
//
//    	PreparedStatement st = con.prepareStatement(
//    			"SELECT student_id, student_name, STUDENT.course_id, course_name FROM STUDENT JOIN COURSE ON STUDENT.course_id = COURSE.course_id");
//    	ResultSet rs = st.executeQuery();
//
//    	while(rs.next()){
//			Student stu = new Student();
//			stu.setId(rs.getInt("student_id"));
//			stu.setName(rs.getString("student_name"));
//			stu.setCourseId(rs.getInt("course_id"));
//			stu.setCourseName(rs.getString("course_name"));
//			list.add(stu);
//    	}
//
//    	st.close();
//    	con.close();
//
//        return list;
//    }

}
