package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bean.Student;


public class StudentDAO extends DAO {



    public boolean save(Student student) throws Exception {


        Connection con = getConnection();


        PreparedStatement st = con.prepareStatement(
        	"INSERT INTO student (no, name, ent_year, class_num,IS_ATTEND, SCHOOL_CD) VALUES (?, ?, ?, ?,?,?)");


        st.setInt(1, student.getNo());
        st.setString(2, student.getName());
        st.setInt(3, student.getEntYear());
        st.setInt(4, student.getClassNum());
        st.setBoolean(5,student.isAttend());
        st.setString(6,student.getSchoolCd());


        int line = st.executeUpdate();


        st.close();

        return line > 0;
    }
}
