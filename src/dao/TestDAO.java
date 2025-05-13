package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;
import bean.Subject;
import bean.Test;

public class TestDAO extends DAO {

	public Test get(Student student, Subject subject, School school, int no) throws Exception {

		Test test = null;
		String sql = "SELECT * FROM test WHERE student_no = ? AND subject_cd = ? AND school_cd = ? AND no = ?";
		Connection con = getConnection();

		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, student.getNo());
		stmt.setString(2, subject.getCd());
		stmt.setString(3, school.getCd());
		stmt.setInt(4, no);

		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			test = new Test();
			test.setStudentNo(rs.getString("student_no"));
			test.setSubjectCd(rs.getString("subject_cd"));
			test.setSchoolCd(rs.getString("school_cd"));
			test.setNo(rs.getInt("no"));
			test.setPoint(rs.getInt("point"));
			test.setClassNum(rs.getString("class_num"));
		}
		return test;
	}

	public List<Test> filter(int entYear, String classNum, Subject subject, int num, School school) throws Exception {
		List<Test> list = new ArrayList<>();
	    Connection con = getConnection();

	    String sql = "SELECT t.* FROM test t, student s WHERE t.student_no = s.student_no" +
	          "AND s.ent_year = ? AND t.class_num = ? AND t.subject_cd = ? AND t.no = ? AND t.school_cd = ?";

	    PreparedStatement stmt = con.prepareStatement(sql);
	    stmt.setInt(1, entYear);
        stmt.setString(2, classNum);
        stmt.setString(3, subject.getCd());
        stmt.setInt(4, num);
        stmt.setString(5, school.getCd());

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Test test = new Test();
            test.setStudentNo(rs.getString("student_no"));
            test.setSubjectCd(rs.getString("subject_cd"));
            test.setSchoolCd(rs.getString("school_cd"));
            test.setNo(rs.getInt("no"));
            test.setPoint(rs.getInt("point"));
            test.setClassNum(rs.getString("class_num"));
            list.add(test);
        }
        return list;

	}

	public void save(List<Test> testList) throws Exception {
		Connection con = getConnection();

		String sql = "MERGE INTO test KEY(student_no, subject_cd, school_cd, no) " + "VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);

		for (Test test : testList) {
			st.setString(1, test.getStudentNo());
			st.setString(2, test.getSubjectCd());
			st.setString(3, test.getSchoolCd());
			st.setInt(4, test.getNo());
			st.setInt(5, test.getPoint());
			st.setString(6, test.getClassNum());

			st.executeUpdate();
		}

		st.close();
		con.close();
	}
}
