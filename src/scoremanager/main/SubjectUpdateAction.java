package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Subject;
import dao.SubjectDAO;
import tool.Action;

public class SubjectUpdateAction extends Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession();

		School school = (School) session.getAttribute("school");
		String sbjCd = req.getParameter("cd");

		SubjectDAO dao = new SubjectDAO();
		Subject sbj = dao.get(sbjCd, school);

		session.setAttribute("subject", sbj);

		return "../subject/subjectUpdate.jsp";
	}

}
