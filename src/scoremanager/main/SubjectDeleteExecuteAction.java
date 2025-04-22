package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import dao.SubjectDAO;
import tool.Action;

public class SubjectDeleteExecuteAction extends Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession();

		Subject sbj = (Subject) session.getAttribute("subject");

		SubjectDAO dao = new SubjectDAO();

		if (dao.delete(sbj)) {
			return "/subject/subjectDeleteDone.jsp";
		}

		return "/subject/subjectList.jsp";
	}

}
