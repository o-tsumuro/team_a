package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Student;
import dao.StudentDAO;
import tool.Action;

public class StudentCreateAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            int no = Integer.parseInt(request.getParameter("no"));
            String name = request.getParameter("name");
            int year = Integer.parseInt(request.getParameter("ent_year"));
            int classNum = Integer.parseInt(request.getParameter("class_num"));
            String schoolCd;

            HttpSession session = request.getSession(false);

            School school = (School) session.getAttribute("school");
            schoolCd = school.getCd();

            Student student = new Student();
            student.setNo(no);
            student.setName(name);
            student.setEntYear(year);
            student.setClassNum(classNum);
            student.setSchoolCd(schoolCd);



            StudentDAO dao = new StudentDAO();
            boolean result = dao.save(student);

            if (result) {
                request.setAttribute("message", "学生情報が正常に登録されました！");
            } else {
                request.setAttribute("message", "学生情報の登録に失敗しました。");
            }

            return "result.jsp";

        } catch (Exception e) {

            System.out.println( "エラーが発生しました: " + e.getMessage());
            return "error.jsp";
        }
    }
}
