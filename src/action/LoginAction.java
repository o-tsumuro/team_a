package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class LoginAction extends Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return "/auth/login.jsp";
	}

}
