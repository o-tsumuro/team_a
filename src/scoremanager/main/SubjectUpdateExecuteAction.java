package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Subject;
import dao.SubjectDAO;
import tool.Action;

public class SubjectUpdateExecuteAction extends Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession();

		String cd = req.getParameter("cd");
		String name = req.getParameter("name");
		School school = (School) session.getAttribute("school");

		Subject sbj = new Subject();
		sbj.setCd(cd);
		sbj.setName(name);
		sbj.setSchoolCd(school.getCd());

		SubjectDAO dao = new SubjectDAO();

		if (dao.save(sbj)) {
			return "/subject/subjectUpdateDone.jsp";
		}

		return "/subject/subjectList.jsp";
	}

}
