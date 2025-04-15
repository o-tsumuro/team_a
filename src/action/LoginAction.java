package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.SchoolDAO;
import dao.TeacherDAO;
import tool.Action;

public class LoginAction extends Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();

		String id = req.getParameter("id");
		String password=req.getParameter("password");

		TeacherDAO teacherDao = new TeacherDAO();
		Teacher teacher = teacherDao.login(id, password);

		if (teacher == null) {
			System.out.println("ログイン失敗");
			return "#";
		}

		session.setAttribute("teacher", teacher);
		session.setAttribute("user_school_cd", teacher.getSchoolCd());

		SchoolDAO schoolDao = new SchoolDAO();
		schoolDao.getSchool(teacher.getSchoolCd());

		return "/index.jsp";
	}

}
