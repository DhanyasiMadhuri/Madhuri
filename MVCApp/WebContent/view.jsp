<%@page  import="com.ihub.www.LoginBean" %>

<%
	LoginBean lb=(LoginBean)request.getAttribute("bean");
%>

<%= "UserName :"+lb.getUsername() %> <br>
<%= "Password :"+lb.getPassword() %> <br>
