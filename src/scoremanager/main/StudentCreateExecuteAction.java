package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import dao.StudentDAO;
import tool.Action;

public class StudentCreateExecuteAction extends Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession(false);

        String entYear = request.getParameter("ent_year");
        String studentNo = request.getParameter("no");

        // 入学年度が未選択の場合
        if (entYear == null || entYear.isEmpty()) {
            request.setAttribute("error", "入学年度を選択してください。");
            return "StudentCreateForm.action";
        }

        // 学生番号が入力されている場合、重複チェック
        if (studentNo != null) {
            StudentDAO dao = new StudentDAO();
            Student existingStudent = dao.get(studentNo);

            if (existingStudent != null) {
                request.setAttribute("error2", "学生番号が重複しています。");
                return "StudentCreateForm.action";
            }
        }

        // エラーがなければ次の登録処理へリダイレクト
        return "StudentCreate.action"
            + "?no=" + studentNo
            + "&ent_year=" + entYear
            + "&name=" + java.net.URLEncoder.encode(request.getParameter("name"), "UTF-8")
            + "&class_num=" + request.getParameter("class_num");
    }
}
