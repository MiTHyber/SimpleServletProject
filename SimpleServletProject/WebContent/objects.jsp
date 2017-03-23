<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String userName = request.getParameter("userName");
		if (!"".equals(userName) && userName != null) {
			session.setAttribute("userName", userName);
			//application.setAttribute("userName", userName);
			pageContext.setAttribute("userName", userName, PageContext.APPLICATION_SCOPE); //same as previous line
			pageContext.setAttribute("userName", userName);			
			pageContext.findAttribute("userName");
		}
	%>
	<br> Request parameter has userName as
	<%=userName%>
	<br> Session parameter has userName as
	<%=session.getAttribute("userName")%>
	<br> Application context parameter has userName as
	<%=application.getAttribute("userName")%>
	<br> Page context parameter has userName as
	<%=pageContext.getAttribute("userName")%>
</body>
</html>