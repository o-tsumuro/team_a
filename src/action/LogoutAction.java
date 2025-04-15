package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

public class LogoutAction extends Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session=req.getSession();

		if (session.getAttribute("teacher") != null) {
			session.removeAttribute("teacher");
			return "/auth/logout.jsp";
		}

		return "#";
	}

}
