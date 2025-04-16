package scoremanager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Teacher;
import bean.User;
import dao.SchoolDAO;
import dao.TeacherDAO;
import tool.Action;

public class LoginExecuteAction extends Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();

		String id = req.getParameter("id");
		String password=req.getParameter("password");

		session.setAttribute("id", id);

		TeacherDAO teacherDao = new TeacherDAO();
		Teacher teacher = teacherDao.login(id, password);

		if (teacher == null) {
			System.out.println("ログイン失敗");
			session.setAttribute("error", "ログインに失敗しました。IDまたはパスワードが正しくありません。");
			resp.sendRedirect("/team_a/Login.action");
		}

		User user = new User();
		user.setAuthenticated(true);

		session.setAttribute("teacher", teacher);
		session.setAttribute("user", user);

		School school;
		SchoolDAO schoolDao = new SchoolDAO();
		school = schoolDao.getSchool(teacher.getSchoolCd());
		session.setAttribute("school", school);

		return "/index.jsp";
	}

}
