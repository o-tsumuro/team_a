package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDAO;
import tool.Action;

public class StudentUpdateExecuteAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int no = Integer.parseInt(request.getParameter("no"));
        int entYear = Integer.parseInt(request.getParameter("entYear"));
        String name = request.getParameter("name");
        boolean isAttend = request.getParameter("isAttend") != null;
        int classNum = Integer.parseInt(request.getParameter("classNum"));


        Student student = new Student();
        student.setNo(no);
        student.setEntYear(entYear);
        student.setName(name);
        student.setClassNum(classNum);
        student.setAttend(isAttend);

        StudentDAO dao = new StudentDAO();
        dao.update(student);

        request.setAttribute("message", "更新が完了しました。");

        // 成功したらリストに戻す or 結果ページ
        return "../student/student_update_done.jsp";
    }
}
