package scoremanager.main;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Student;
import dao.ClassNumDAO;
import dao.StudentDAO;
import tool.Action;

public class StudentListAction extends Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    HttpSession session = request.getSession(false);
	    School school = (School) session.getAttribute("school");
	    String schoolCd = school.getCd();

	    String entYearStr = request.getParameter("entYear");
	    String classNum = request.getParameter("classNum");
	    String isAttendStr = request.getParameter("isAttend");

	    List<Student> studentList = new ArrayList<>();
	    StudentDAO dao = new StudentDAO();
	    List<String> classNumList = new ArrayList<>();
	    ClassNumDAO dao2 = new ClassNumDAO();
	    classNumList = dao2.filter(school);  // ← すでに取得してるなら
	    request.setAttribute("classNumList", classNumList);

	    boolean hasEntYear = entYearStr != null && !entYearStr.isEmpty();
	    boolean hasClassNum = classNum != null && !classNum.isEmpty();
	    boolean hasIsAttend = isAttendStr != null;

	    // --- 条件分岐 ---
	    if (!hasEntYear && !hasClassNum && !hasIsAttend) {
	        studentList = dao.filter(schoolCd); // 学校だけ
	    } else if (hasEntYear && !hasClassNum && !hasIsAttend) {
	        studentList = dao.filter(schoolCd, Integer.parseInt(entYearStr));
	    } else if (!hasEntYear && hasClassNum) {
	        request.setAttribute("message", "クラスを指定する場合は入学年度も指定してください");
	    } else if (!hasEntYear && !hasClassNum && hasIsAttend) {
	        studentList = dao.filter(schoolCd, true); // 在学中のみ
	    } else if (hasEntYear && hasClassNum && !hasIsAttend) {
	        studentList = dao.filter(schoolCd, Integer.parseInt(entYearStr), classNum);
	    } else if (hasEntYear && !hasClassNum && hasIsAttend) {
	        studentList = dao.filter(schoolCd, Integer.parseInt(entYearStr), true);
	    } else if (!hasEntYear && hasClassNum && hasIsAttend) {
	        request.setAttribute("message", "クラスを指定する場合は入学年度も指定してください");
	    } else if (hasEntYear && hasClassNum && hasIsAttend) {
	        studentList = dao.filter(schoolCd, Integer.parseInt(entYearStr), classNum, true);
	    }

	    request.setAttribute("studentList", studentList);
	    return "../student/student_list.jsp";
	}
}

