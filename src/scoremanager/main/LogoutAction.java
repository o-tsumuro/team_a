package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import tool.Action;

public class LogoutAction extends Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session=req.getSession();

		session.removeAttribute("teacher");
		User user = (User) session.getAttribute("user");
		user.setAuthenticated(false);
		return "/auth/logout.jsp";

	}

}
