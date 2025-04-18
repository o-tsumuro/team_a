package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Teacher;
import dao.ClassNumDAO;
import dao.SubjectDAO;
import tool.Action;

public class TestRegistAction extends Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();

		Teacher teacher = (Teacher) session.getAttribute("teacher");
		School school = (School) session.getAttribute("school");

		ClassNumDAO classNumDao = new ClassNumDAO();
		SubjectDAO subjectDao = new SubjectDAO();

		session.setAttribute("classList", classNumDao.filter(school));
		session.setAttribute("subjectList", subjectDao.filter(school));

		return "/test/testRegist.jsp";
	}

}
