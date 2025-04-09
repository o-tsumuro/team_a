package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(urlPatterns={"/test/h2test"})
public class H2Test extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		try {
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/comp/env/jdbc/team_a");
			Connection con=ds.getConnection();

			PreparedStatement st=con.prepareStatement(
			"SELECT * FROM STUDENT");
			ResultSet rs=st.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("name"));

			}

			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}

	}
}
