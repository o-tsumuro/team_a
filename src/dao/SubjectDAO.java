package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Subject;


//一部未完成です
public class SubjectDAO extends DAO {

	public Subject get(String cd, School school)throws Exception {

		Subject sbj = null;

		Connection con = getConnection();
		PreparedStatement st;
		st = con.prepareStatement(
				"SELECT * FROM SUBJECT WHERE CD = ? AND SCHOOL_CD = ?");
		st.setString(1, cd);
		st.setString(2, school.getCd());
		ResultSet rs = st.executeQuery();

		if (rs.next()){
			sbj = new Subject();
			sbj.setCd(rs.getString("cd"));
			sbj.setName(rs.getString("name"));
			sbj.setSchoolCd(rs.getString("school_cd"));
		}

		st.close();
		con.close();

		return sbj;

	}

	public List<Subject> filter(School school)throws Exception{

		List<Subject> list = new ArrayList<>();

		Connection con = getConnection();
		PreparedStatement st;
		st = con.prepareStatement(
				"SELECT * FROM SUBJECT WHERE SCHOOL_CD = ?");
		st.setString(1, school.getCd());
		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			Subject sbj = new Subject();
			sbj.setCd(rs.getString("cd"));
			sbj.setName(rs.getString("name"));
			sbj.setSchoolCd(rs.getString("school_cd"));
			list.add(sbj);

		}

		st.close();
		con.close();

		return list;
	}

	public boolean save(Subject sbj)throws Exception {
		Connection con = getConnection();
		PreparedStatement st;
		st = con.prepareStatement(
				"INSERT INTO SUBJECT VALUES(?, ?, ?)");
		st.setString(1, sbj.getSchoolCd());
		st.setString(2, sbj.getCd());
		st.setString(3, sbj.getName());

//		DBを更新した行数を取得
		int num = st.executeUpdate();

		st.close();
		con.close();

//		return (num == 1 ? true : false) と同じ意味
		return num == 1;
	}

	public boolean delete(Subject sbj)throws Exception {
		return true;
	}

}
