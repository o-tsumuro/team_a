package scoremanager.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Subject;
import bean.TestListSubject;
import dao.SubjectDAO;
import dao.TestListSubjectDAO;
import tool.Action;

public class TestListSubjectExecuteAction extends Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session  = req.getSession();

		String entYear = req.getParameter("f1");
		String classNum = req.getParameter("f2");
		String subjectCd = req.getParameter("f3");

		School school = (School) session.getAttribute("school");

		if (entYear.isEmpty() || classNum.isEmpty() || subjectCd.isEmpty()){
			req.setAttribute("sbjListError", "入学年度とクラスと科目を選択してください。");
			return "/test/testList.jsp";
		}

		SubjectDAO sbjDao = new SubjectDAO();
		Subject sbj = sbjDao.get(subjectCd, school);

		System.out.println(sbj.getName());
		System.out.println(sbj.getSchoolCd());

		TestListSubjectDAO dao = new TestListSubjectDAO();

		List<TestListSubject> sbjTestList = dao.filter(Integer.parseInt(entYear), classNum, sbj, school);
		req.setAttribute("sbjTestList", sbjTestList);


		return "/test/testListSubject.jsp";
	}

}
