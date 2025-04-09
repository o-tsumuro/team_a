package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.TeacherDAO;
import tool.Action;

public class LoginAction extends Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session=req.getSession();

		String id=req.getParameter("id");
		String password=req.getParameter("password");
		TeacherDAO dao=new TeacherDAO();
		Teacher teacher=dao.login(id, password);

		if (teacher != null) {
			session.setAttribute("teacher", teacher);
			System.out.println("success");
			return "/index.jsp";
		}

		return "#";
	}

}
