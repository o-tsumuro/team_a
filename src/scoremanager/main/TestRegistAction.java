package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import dao.ClassNumDAO;
import dao.StudentDAO;
import dao.SubjectDAO;
import tool.Action;

public class TestRegistAction extends Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if ("POST".equalsIgnoreCase(req.getMethod())) {
            return handlePost(req, resp);
        } else {
            return handleGet(req, resp);
        }
	}

	private String handleGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession();

		School school = (School) session.getAttribute("school");

		StudentDAO studentDao = new StudentDAO();
		ClassNumDAO classNumDao = new ClassNumDAO();
		SubjectDAO subjectDao = new SubjectDAO();

		session.setAttribute("entYearList", studentDao.getEntYear());
		session.setAttribute("classList", classNumDao.filter(school));
		session.setAttribute("subjectList", subjectDao.filter(school));

		return "/test/testRegist.jsp";
    }

    private String handlePost(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    	req.setCharacterEncoding("UTF-8");
    	resp.setContentType("text/html; charset=UTF-8");

    	int selectedYear = Integer.parseInt(req.getParameter("entYear"));
    	String selectedClass = req.getParameter("class");
    	String selectedSubjectCd = req.getParameter("subject");
    	int selectedTimes = Integer.parseInt(req.getParameter("times"));

    	req.setAttribute("selectedYear", selectedYear);
    	req.setAttribute("selectedClass", selectedClass);
    	req.setAttribute("selectedSubjectCd", selectedSubjectCd);
    	req.setAttribute("selectedTimes", selectedTimes);

        return "/test/testRegist.jsp";
    }

}
