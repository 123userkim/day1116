<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.InputNameDAO"%>
<%@page import="com.sist.vo.InputNameVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<body>
	
	<form action="inputName.jsp" method="post">
		�̸��� �Է��ϼ��� ==> <input type="text" name="name">
		<input type="submit" value="Ȯ��">
	</form>
	
	<%
		request.setCharacterEncoding("euc-kr");
		if(request.getParameter("name") != null){
			String name = request.getParameter("name");
			InputNameDAO dao = new InputNameDAO();
			ArrayList<InputNameVO>list= dao.listAll(name);
			
			%>
			<table border="1">
				<tr>
					<td>�����̸�</td>
					<td>�󿵰���ȣ</td>
					<td>��ȭ����</td>
					<td>��¥</td>
					<td>�¼���ȣ</td>
					<td>����</td>
				</tr>
				<%
					for(InputNameVO i:list){
						%>
						<tr>
							<td><%= i.getcName() %></td>
							<td><%= i.getThNumber() %></td>
							<td><%= i.getTitle() %></td>
							<td><%= i.getOdate() %></td>
							<td><%= i.getSeatNumber() %></td>
							<td><%= i.getPrice() %></td>
						</tr>
						<%
					}
				%>
				
			</table>
			<br>
			
			<%
			
		}
	%>
</body>
</html>