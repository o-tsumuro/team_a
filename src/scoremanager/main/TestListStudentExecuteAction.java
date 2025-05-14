package scoremanager.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.TestListStudent;
import dao.StudentDAO;
import dao.TestListStudentDAO;
import tool.Action;

public class TestListStudentExecuteAction extends Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession();
		StudentDAO studentDAO = new StudentDAO();
		TestListStudentDAO testListStudentDAO = new TestListStudentDAO();

		String student_no = req.getParameter("student_no");
		Student student = studentDAO.get(student_no);
		List<TestListStudent> list = testListStudentDAO.filter(student);

	    session.setAttribute("student", student);
	    session.setAttribute("studentTestList", list);

		return "/test/testList.jsp";
	}

}
