package scoremanager.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

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
		ClassNumDAO classNumDao = new ClassNumDAO();

		classNumList = classNumDao.filter(school);
		request.setAttribute("classNumList", classNumList);

		int studentCount = studentList.size();
		request.setAttribute("studentCount", studentCount);

		boolean hasEntYear = entYearStr != null && !entYearStr.isEmpty();
		boolean hasClassNum = classNum != null && !classNum.isEmpty();
		boolean hasIsAttend = isAttendStr != null;

		// --- 条件分岐 ---
		String key = (hasEntYear ? "1" : "0") + (hasClassNum ? "1" : "0") + (hasIsAttend ? "1" : "0");

		Map<String, Supplier<List<Student>>> actions = new HashMap<>();
		actions.put("000", () -> {
			try {
				return dao.filter(schoolCd);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message", "検索中にエラーが発生しました（000）");
				return new ArrayList<>();
			}
		});

		actions.put("100", () -> {
			try {
				return dao.filter(schoolCd, Integer.parseInt(entYearStr));
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message", "検索中にエラーが発生しました（100）");
				return new ArrayList<>();
			}
		});

		actions.put("001", () -> {
			try {
				return dao.filter(schoolCd, true);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message", "検索中にエラーが発生しました（001）");
				return new ArrayList<>();
			}
		});

		actions.put("110", () -> {
			try {
				return dao.filter(schoolCd, Integer.parseInt(entYearStr), classNum);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message", "検索中にエラーが発生しました（110）");
				return new ArrayList<>();
			}
		});

		actions.put("101", () -> {
			try {
				return dao.filter(schoolCd, Integer.parseInt(entYearStr), true);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message", "検索中にエラーが発生しました（101）");
				return new ArrayList<>();
			}
		});

		actions.put("111", () -> {
			try {
				return dao.filter(schoolCd, Integer.parseInt(entYearStr), classNum, true);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message", "検索中にエラーが発生しました（111）");
				return new ArrayList<>();
			}
		});

		if (key.equals("010") || key.equals("011")) {
			request.setAttribute("message", "クラスを指定する場合は入学年度も指定してください");

		} else {
			studentList = actions.get(key).get();
		}

		request.setAttribute("studentList", studentList);
		request.setAttribute("studentCount", studentList.size());
		request.setAttribute("classNumList", classNumList);

		return "../student/student_list.jsp";
	}
}
