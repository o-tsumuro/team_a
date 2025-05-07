package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDAO;
import tool.Action;

public class StudentUpdateAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String no = request.getParameter("no");

        StudentDAO dao = new StudentDAO();
        Student student = dao.get(no);

        request.setAttribute("student", student);

        return "../student/student_update.jsp";
    }
}
