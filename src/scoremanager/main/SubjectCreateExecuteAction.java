package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Subject;
import dao.SubjectDAO;
import tool.Action;


public class SubjectCreateExecuteAction extends Action {

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

		req.setAttribute("subject", sbj);

		if (cd.length() != 3){
			req.setAttribute("sbjCdError", "科目コードは3文字で入力してください。");
			return "/subject/subjectCreate.jsp";
		}


		SubjectDAO dao = new SubjectDAO();

		if (dao.get(cd, school) != null){
			req.setAttribute("sbjCdError","科目コードが重複しています。");
			return "/subject/subjectCreate.jsp";
		}

		if (dao.save(sbj)){
			session.removeAttribute("subject");
			return "/subject/subjectCreateDone.jsp";
		}

		return "/error.jsp";

	}

}
