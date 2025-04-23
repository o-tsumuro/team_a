package scoremanager.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Student;
import bean.Subject;
import bean.Teacher;
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

	    List<Integer> entYearList = studentDao.getEntYear();
	    List<String> classList = classNumDao.filter(school);
	    List<Subject> subjectList = subjectDao.filter(school);

	    session.setAttribute("entYearList", entYearList);
	    session.setAttribute("classList", classList);
	    session.setAttribute("subjectList", subjectList);

		return "/test/test_regist.jsp";
    }

	private String handlePost(HttpServletRequest req, HttpServletResponse resp) throws Exception {
	    req.setCharacterEncoding("UTF-8");
	    resp.setContentType("text/html; charset=UTF-8");

	    String yearStr = req.getParameter("entYear");
	    String selectedClass = req.getParameter("class");
	    String selectedSubjectCd = req.getParameter("subject");
	    String timesStr = req.getParameter("times");

	    if (yearStr == null || yearStr.isEmpty() ||
	        selectedClass == null || selectedClass.isEmpty() ||
	        selectedSubjectCd == null || selectedSubjectCd.isEmpty() ||
	        timesStr == null || timesStr.isEmpty()) {

	        req.setAttribute("error", "入学年度とクラスと科目と回数を選択してください");

	        HttpSession session = req.getSession();
	        School school = (School) session.getAttribute("school");
	        StudentDAO studentDao = new StudentDAO();
	        ClassNumDAO classNumDao = new ClassNumDAO();
	        SubjectDAO subjectDao = new SubjectDAO();
	        req.setAttribute("entYearList", studentDao.getEntYear());
	        req.setAttribute("classList", classNumDao.filter(school));
	        req.setAttribute("subjectList", subjectDao.filter(school));

	        return "/test/test_regist.jsp";
	    }

	    int selectedYear = Integer.parseInt(yearStr);
	    int selectedTimes = Integer.parseInt(timesStr);

	    req.setAttribute("selectedYear", selectedYear);
	    req.setAttribute("selectedClass", selectedClass);
	    req.setAttribute("selectedSubjectCd", selectedSubjectCd);
	    req.setAttribute("selectedTimes", selectedTimes);

	    HttpSession session = req.getSession();
	    Teacher teacher = (Teacher) session.getAttribute("teacher");
	    String schoolCd = teacher.getSchoolCd();
	    StudentDAO studentDao = new StudentDAO();

	    School school = (School) session.getAttribute("school");
	    SubjectDAO subjectDao = new SubjectDAO();
	    List<Subject> subjectList = subjectDao.filter(school);

	    Subject selectedSubject = null;
	    for (Subject s : subjectList) {
	        if (s.getCd().equals(selectedSubjectCd)) {
	            selectedSubject = s;
	            break;
	        }
	    }

	    List<Student> studentList = studentDao.filter(schoolCd, selectedYear, selectedClass, true);
	    req.setAttribute("studentList", studentList);
	    req.setAttribute("selectedSubject", selectedSubject);

	    return "/test/test_regist.jsp";
	}

}
