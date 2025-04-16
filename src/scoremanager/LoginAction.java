package scoremanager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

public class LoginAction extends Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();

		String id = (String) session.getAttribute("id");
		req.setAttribute("id", id);
		session.removeAttribute("id");

		String error = (String) session.getAttribute("error");

		if (error != null) {
		    req.setAttribute("error", error);
		    session.removeAttribute("error");
		}

		return "/auth/login.jsp";
	}

}
