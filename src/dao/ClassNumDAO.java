package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.ClassNum;
import bean.School;

public class ClassNumDAO extends DAO {

	public ClassNum get(String classnum, School school) throws Exception {
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"SELECT * FROM CLASS_NUM WHERE SCHOOL_CD = ? AND CLASS_NUM = ? ");
		st.setString(1, school.getCd());
		st.setString(2, classnum);

		ResultSet rs = st.executeQuery();

		ClassNum cn = new ClassNum();
		cn.setClassNum(Integer.parseInt(rs.getString("class_num")));
		cn.setSchoolCd(rs.getString("school_cd"));


    	st.close();
    	con.close();

    	return cn;

	}


}
