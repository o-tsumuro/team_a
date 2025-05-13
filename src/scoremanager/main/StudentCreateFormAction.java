package scoremanager.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import dao.ClassNumDAO;
import tool.Action;

public class StudentCreateFormAction extends Action {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        School school = (School) session.getAttribute("school");

        ClassNumDAO classNumDao = new ClassNumDAO();
        List<String> classNumList = classNumDao.filter(school);
        request.setAttribute("classNumList", classNumList);

        return"/student/student_create.jsp";
    }
}
