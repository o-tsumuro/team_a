package scoremanager.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String, String> errorMap = new HashMap<>();

        for (String studentNo : studentNos) {
            String scoreStr = req.getParameter("score_" + studentNo);
            int score = -1;
            try {
                score = Integer.parseInt(scoreStr);
                if (score < 0 || score > 100) {
                    errorMap.put(studentNo, "0〜100の範囲で入力してください");
                }
            } catch (NumberFormatException e) {
                errorMap.put(studentNo, "数値を入力してください");
            }

            Test test = new Test();
            test.setStudentNo(studentNo);
            test.setSubjectCd(subjectCd);
            test.setSchoolCd(schoolCd);
            test.setNo(times);
            test.setPoint(score);
            test.setClassNum(classNum);

            testList.add(test);
        }

        if (!errorMap.isEmpty()) {
            req.setAttribute("testList", testList);
            req.setAttribute("errorMap", errorMap);
            req.setAttribute("selectedSubjectCd", subjectCd);
            req.setAttribute("selectedClass", classNum);
            req.setAttribute("selectedTimes", times);
            // subjectList, studentList, classList, entYearList 等も必要なら渡す
            return "/test/test_regist.jsp";
        }

        TestDAO testDao = new TestDAO();
        testDao.save(testList);

        req.setAttribute("message", "登録が完了しました");
        return "/test/test_regist_done.jsp";
    }
}
