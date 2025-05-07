package dao;

 import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import bean.Test;

 public class TestDAO extends DAO {
 	public void save(List<Test> testList) throws Exception {
         Connection con = getConnection();

         String sql = "MERGE INTO test KEY(student_no, subject_cd, school_cd, no) " +
                 	  "VALUES (?, ?, ?, ?, ?, ?)";
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