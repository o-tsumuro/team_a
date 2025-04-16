package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public Student get(String no) throws Exception {
        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement(
            "SELECT * FROM student WHERE no = ?"
        );
        st.setInt(1, Integer.parseInt(no));

        ResultSet rs = st.executeQuery();

        Student student = null;
        if (rs.next()) {
            student = new Student();
            student.setNo(rs.getInt("no"));
            student.setName(rs.getString("name"));
            student.setEntYear(rs.getInt("ent_year"));
            student.setClassNum(rs.getInt("class_num"));
            student.setAttend(rs.getBoolean("is_attend"));
            student.setSchoolCd(rs.getString("school_cd"));
        }

        rs.close();
        st.close();

        return student;
    }

    public List<Student> filter(String schoolCd, int entYear, String classNum, boolean isAttend)
    	throws Exception {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement(
            "SELECT * FROM student WHERE SCHOOL_CD = ? AND ENT_YEAR = ? AND CLASS_NUM = ? AND IS_ATTEND = ?"
        );

        st.setString(1, schoolCd);
        st.setInt(2, entYear);
        st.setString(3, classNum);
        st.setBoolean(4, isAttend);

        ResultSet rs = st.executeQuery();

        List<Student> list = postFilter(rs);

        rs.close();
        st.close();

        return list;
    }
    public List<Student> filter(String schoolCd, int entYear,boolean isAttend)
    	throws Exception{
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement(
            "SELECT * FROM student WHERE SCHOOL_CD = ? AND ENT_YEAR = ? AND IS_ATTEND = ?"
        );

        st.setString(1, schoolCd);
        st.setInt(2, entYear);
        st.setBoolean(3 ,isAttend);

        ResultSet rs = st.executeQuery();

        List<Student> list = postFilter(rs);

        rs.close();
        st.close();

        return list;
    }
    public List<Student> filter(String schoolCd,boolean isAttend)
        	throws Exception{
            Connection con = getConnection();
            PreparedStatement st = con.prepareStatement(
                "SELECT * FROM student WHERE SCHOOL_CD = ?  AND IS_ATTEND = ?"
            );

            st.setString(1, schoolCd);
            st.setBoolean(2, isAttend);

            ResultSet rs = st.executeQuery();

            List<Student> list = postFilter(rs);

            rs.close();
            st.close();

            return list;
    }
    public List<Student> postFilter (ResultSet rs) throws Exception {
         List<Student> list = new ArrayList<>();
         while (rs.next()) {
             Student student = new Student();
             student.setNo(rs.getInt("no"));
             student.setName(rs.getString("name"));
             student.setEntYear(rs.getInt("ent_year"));
             student.setClassNum(rs.getInt("class_num"));
             student.setAttend(rs.getBoolean("is_attend"));
             student.setSchoolCd(rs.getString("school_cd"));
             list.add(student);
         }
         return list;
    }
}