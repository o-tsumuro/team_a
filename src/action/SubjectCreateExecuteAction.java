package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import dao.SubjectDAO;
import tool.Action;

public class SubjectCreateExecuteAction extends Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession();

		String cd = req.getParameter("cd");
		String name = req.getParameter("name");
		String schoolCd = (String) session.getAttribute("user_school_cd");

		if (cd.length() != 3){
			session.setAttribute("message", "科目コードは3文字で入力してください。");
			return "#";
		}

		Subject sbj = new Subject();
		sbj.setCd(cd);
		sbj.setName(name);
		sbj.setSchoolCd(schoolCd);

		SubjectDAO dao = new SubjectDAO();

//		if (dao.get(schoolCd, school))

		if (dao.save(sbj)){
			return "/subject/subjectCreateDone.jsp";
		}



		return null;
	}

}
