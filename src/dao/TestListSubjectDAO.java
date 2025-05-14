package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.School;
import bean.Student;
import bean.Subject;
import bean.Test;
import bean.TestListSubject;

public class TestListSubjectDAO extends DAO {


	public List<TestListSubject> filter (int entYear, String classNum, Subject sbj, School school) throws Exception{

		List<TestListSubject> sbjTestList = new ArrayList<>();

		StudentDAO stuDao = new StudentDAO();
		List<Student> stuList = stuDao.filter(school.getCd(), entYear, classNum);


		TestDAO dao = new TestDAO();

		for(Student stu : stuList) {
			Map<Integer, Integer> points = new HashMap<>();

			Test test1 = dao.get(stu, sbj, school, 1);
			Test test2 = dao.get(stu, sbj, school, 2);

			System.out.println(stu.getName());

			if (test1 == null && test2 == null) {
				continue;
			}

			if (test1 == null) {
				points.put(1, -1);
			} else {
				points.put(1, test1.getPoint());
			}

			if (test2 == null) {
				points.put(2, -1);
			} else{
				points.put(2, test2.getPoint());
			}

			System.out.println(stu.getEntYear());

			TestListSubject tlsbj = new TestListSubject();

			tlsbj.setClassNum(classNum);
			tlsbj.setEntYear(entYear);
			tlsbj.setStudentName(stu.getName());
			tlsbj.setStudentNo(String.valueOf(stu.getNo()));
			tlsbj.setPoints(points);

			sbjTestList.add(tlsbj);
		}

		return sbjTestList;
	}

}
