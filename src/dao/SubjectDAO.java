package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Subject;



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
		PreparedStatement st, st1;

		int num;

		String schoolCd = sbj.getSchoolCd();
		String cd = sbj.getCd();
		String name = sbj.getName();

		st1 = con.prepareStatement(
				"SELECT * FROM SUBJECT WHERE CD = ? AND SCHOOL_CD = ?");
		st1.setString(1, cd);
		st1.setString(2, schoolCd);

		ResultSet rs1 = st1.executeQuery();


		// すでにデータがあればupdate,なければinsertでsqlを実行

		if (rs1.next()) {

			st = con.prepareStatement(
					"UPDATE SUBJECT SET NAME = ? WHERE CD = ? AND SCHOOL_CD = ?");
			st.setString(1, name);
			st.setString(2, cd);
			st.setString(3, schoolCd);

			//	DBを更新した行数を取得
			num = st.executeUpdate();

		} else {
			st = con.prepareStatement(
					"INSERT INTO SUBJECT VALUES(?, ?, ?)");
			st.setString(1, schoolCd);
			st.setString(2, cd);
			st.setString(3, name);

			//	DBを更新した行数を取得
			num = st.executeUpdate();
		}

		st1.close();
		st.close();
		con.close();

		//	return (num == 1 ? true : false) と同じ意味
		return num == 1;
	}

	public boolean delete(Subject sbj)throws Exception {

		Connection con = getConnection();
		PreparedStatement st;

		st = con.prepareStatement(
				"DELETE FROM SUBJECT WHERE CD = ? AND SCHOOL_CD = ?");
		st.setString(1, sbj.getCd());
		st.setString(2, sbj.getSchoolCd());

		int num = st.executeUpdate();

		st.close();
		con.close();

		return num == 1;
	}

}
