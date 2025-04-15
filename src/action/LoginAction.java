package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.TeacherDAO;
import tool.Action;

public class LoginAction extends Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session=req.getSession();


		String id=req.getParameter("id");
		String password=req.getParameter("password");
		TeacherDAO dao=new TeacherDAO();
		Teacher teacher=dao.login(id, password);

		 if (teacher != null) {
		        // ログイン成功時
		        session.setAttribute("teacher", teacher);  // teacher オブジェクトをセッションに保存

		        // ここで teacher オブジェクトから schoolCd を取り出し、セッションに保存
		        session.setAttribute("user_school_cd", teacher.getSchoolCd());  // user_school_cd をセッションに保存

		        System.out.println("success");
		        return "/index.jsp";  // ログイン後の遷移先
		    }

		return "#";
	}

}
