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
		이름을 입력하세요 ==> <input type="text" name="name">
		<input type="submit" value="확인">
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
					<td>극장이름</td>
					<td>상영관번호</td>
					<td>영화제목</td>
					<td>날짜</td>
					<td>좌석번호</td>
					<td>가격</td>
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