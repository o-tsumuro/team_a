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
        con.close();

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
        con.close();

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
        con.close();

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
        con.close();

        return list;
    }


    public List<Student> filter(String schoolCd, int entYear)
        	throws Exception{
            Connection con = getConnection();
            PreparedStatement st = con.prepareStatement(
                "SELECT * FROM student WHERE SCHOOL_CD = ? AND ENT_YEAR = ? "
            );

            st.setString(1, schoolCd);
            st.setInt(2, entYear);


            ResultSet rs = st.executeQuery();

            List<Student> list = postFilter(rs);

            rs.close();
            st.close();
            con.close();

            return list;
        }
    public List<Student> filter(String schoolCd, int entYear, String classNum)
        	throws Exception{
            Connection con = getConnection();
            PreparedStatement st = con.prepareStatement(
                "SELECT * FROM student WHERE SCHOOL_CD = ? AND ENT_YEAR = ? AND CLASS_NUM = ?"
            );

            st.setString(1, schoolCd);
            st.setInt(2, entYear);
            st.setString(3,classNum);


            ResultSet rs = st.executeQuery();

            List<Student> list = postFilter(rs);

            rs.close();
            st.close();
            con.close();

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
            con.close();

            return list;
    }
    public List<Student> filter(String schoolCd)
        	throws Exception{
            Connection con = getConnection();
            PreparedStatement st = con.prepareStatement(
                "SELECT * FROM student WHERE SCHOOL_CD = ? "
            );

            st.setString(1, schoolCd);


            ResultSet rs = st.executeQuery();

            List<Student> list = postFilter(rs);

            rs.close();
            st.close();
            con.close();

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
    public List<Integer> getEntYear() throws Exception {
    	List<Integer> list = new ArrayList<>();
    	Connection con = getConnection();
        PreparedStatement st = con.prepareStatement(
            "SELECT DISTINCT ent_year FROM student ORDER BY ent_year"
        );
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
        	list.add(rs.getInt("ent_year"));
        }
        rs.close();
        st.close();
        con.close();
        return list;
    }

    public boolean update(Student student) throws Exception {
        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement(
            "UPDATE student SET name = ?, class_num = ?, is_attend = ? WHERE no = ?"
        );

        st.setString(1, student.getName());
        st.setInt(2, student.getClassNum());
        st.setBoolean(3, student.isAttend());
        st.setInt(4, student.getNo());

        int line = st.executeUpdate();

        st.close();
        con.close();

        return line > 0;
    }

}