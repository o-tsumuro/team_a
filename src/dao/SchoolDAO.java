package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.School;

public class SchoolDAO extends DAO {

	 public School getSchool(String cd) throws Exception {
	        School school = null;

	        Connection con = getConnection();
	        PreparedStatement st = con.prepareStatement("SELECT * FROM school WHERE cd = ?");
	        st.setString(1, cd);

	        ResultSet rs = st.executeQuery();

	        if (rs.next()) {
	            school = new School();
	            school.setCd(rs.getString("cd"));
	            school.setName(rs.getString("name"));
	        }

	        rs.close();
	        st.close();
	        con.close();

	        return school;
	    }
}
