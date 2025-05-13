package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.TestListStudent;

public class TestListStudentDAO extends DAO {

	public List<TestListStudent> filter(Student student) throws Exception{
		List <TestListStudent> list = new ArrayList<>();
		Connection con = getConnection();
		String sql = "SELECT t.subject_cd, t.no, t.point, s.name AS subject_name" +
		"FROM test t, subject s WHERE t.subject_cd = s.cd AND t.student_no = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, student.getNo());
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			TestListStudent item = new TestListStudent();
			item.setSubjectCd(rs.getString("subject_cd"));
			item.setNum(rs.getInt("no"));
			item.setPoint(rs.getInt("point"));
			item.setSubjectName(rs.getString("subject_name"));
			list.add(item);
		}
		return list;
	}

}
