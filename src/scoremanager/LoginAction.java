package scoremanager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class LoginAction extends Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//		HttpSession session = resp.getSession();
//		String error = (String) session.getAttribute("error");
//
//		if (error != null) {
//		    req.setAttribute("error", error);
//		    session.removeAttribute("error");
//		}

		return "/auth/login.jsp";
	}

}
