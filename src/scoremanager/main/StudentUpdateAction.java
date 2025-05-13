package scoremanager.main;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Student;
import dao.ClassNumDAO;
import dao.StudentDAO;
import tool.Action;

public class StudentUpdateAction extends Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		School school = (School) session.getAttribute("school");

		String no = request.getParameter("no");
		StudentDAO studentDao = new StudentDAO();
		Student student = studentDao.get(no);

		List<String> classNumList = new ArrayList<>();
		ClassNumDAO classNumDao = new ClassNumDAO();

		classNumList = classNumDao.filter(school);
		request.setAttribute("classNumList", classNumList);
		request.setAttribute("student", student);

		return "../student/student_update.jsp";
	}
}
