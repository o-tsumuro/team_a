package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;


public class SubjectCreateAction extends Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession();


		return "/subject/subjectCreate.jsp";
	}

}
