package scoremanager.main;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import bean.Test;
import dao.TestDAO;
import tool.Action;

public class TestRegistExecuteAction extends Action {

	@Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setCharacterEncoding("UTF-8");

        String subjectCd = req.getParameter("subjectCd");
        String classNum = req.getParameter("classNum");
        int times = Integer.parseInt(req.getParameter("times"));
        String[] studentNos = req.getParameterValues("studentNo");

        HttpSession session = req.getSession();
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        String schoolCd = teacher.getSchoolCd();

        List<Test> testList = new ArrayList<>();

        for (String studentNo : studentNos) {
            String scoreStr = req.getParameter("score_" + studentNo);
            int score = Integer.parseInt(scoreStr);

            Test test = new Test();
            test.setStudentNo(studentNo);
            test.setSubjectCd(subjectCd);
            test.setSchoolCd(schoolCd);
            test.setNo(times);
            test.setPoint(score);
            test.setClassNum(classNum);

            testList.add(test);
        }

        TestDAO testDao = new TestDAO();
        testDao.save(testList);

        req.setAttribute("message", "テスト結果を保存しました");
        return "/test/testInsertResult.jsp";
    }

}
