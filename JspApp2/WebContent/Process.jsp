<%@page import=java.sql.* %>
<%
String sno=request.getParameter("t1");
int no=Integer.parseInt(sno);
String name=request.getParameter("t2");
String add=request.getParameter("t3");

Connection con=null;
PreparedStatement ps=null;
String qry=null;
int result=0;
try
{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
	qry="insert into student values(?,?,?)";
	ps=con.prepareStatement(qry);
	
	ps.setInt(1,no);
	ps.setString(2,name);
	ps.setString(3,add);
	
	result=ps.executeUpdate();
	if(result==0)
		out.println("No Record inserted");
	else
		out.println("Record inserted");
	ps.close();
	con.close();
}
catch(Exception e)
{
	out.println(e);
}

%>
