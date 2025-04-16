package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import tool.Action;

public class MenuAction extends Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession(true);
		User user = (session != null) ? (User) session.getAttribute("user") : null;

		if (user != null && user.isAuthenticated()) {
			return "/menu.jsp";
		} else {
			resp.sendRedirect("/team_a/Login.action");
			return null;
		}

	}

}
