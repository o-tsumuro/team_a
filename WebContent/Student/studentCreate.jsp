<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>



<h2>学生情報登録</h2>

<p><label for="year-select">入学年度</label><p>
<form action="" method="post">
<select name="ent_year" id="year-select">
  <option value="">------</option>
  <%
    int baseYear = 2025; // 基準となる年を設定
    for (int year = baseYear - 10; year <= baseYear + 10; year++) {
  %>
      <option value="<%= year %>"><%= year %></option>
  <%
    }
  %>

</select>
 <p><label for="student-no">学生番号</label></p>
    <input type="text" name="no" id="student-no" maxlength="10" placeholder="学生番号を入力してください" required>

<p><label for="student-name">氏名</label></p>
    <input type="text" name="name" id="student-name" maxlength="30" placeholder="氏名を入力して下さい" required>

<p><label for="student-class">クラス</label></p>
    <p><select name="class_num" id="student-class">
            <option value="">------</option>
    </select></p>

<p><input value="登録して終了"type="submit" name="end"></p>
</form>
<a href="student-list.jsp">戻る</a>