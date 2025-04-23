package scoremanager.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Subject;
import bean.Teacher;
import dao.ClassNumDAO;
import dao.SubjectDAO;
import tool.Action;

public class TestListAction extends Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession();

		Teacher teacher = (Teacher) session.getAttribute("teacher");
		School school = (School) session.getAttribute("school");

		//ユーザーが所属している学校のクラスデータを取得
		ClassNumDAO classDao = new ClassNumDAO();
		List<String> classList = classDao.filter(school);

		//ユーザーが所属している学校の科目データを取得
		SubjectDAO sbjDao = new SubjectDAO();
		List<Subject> sbjList = sbjDao.filter(school);

		session.setAttribute("classList", classList);
		session.setAttribute("subjectList", sbjList);


		return null;
	}

}
