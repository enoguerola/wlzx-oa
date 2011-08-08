<%
////////////////////////////////////////////////////////////////////////////////////////////////////
//
//
//版权所有(c) 2002-2007 北京科翰软件有限公司
//
//
//
////////////////////////////////////////////////////////////////////////////////////////////////////
%>

<%@ page contentType="text/html;charset=gb2312" %>
<%@ page language="java" import="java.util.*,java.io.*,org.w3c.dom.*,javax.xml.parsers.*,sun.misc.*" %>
<%@ page import="java.sql.*" %>


<%

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); //载入驱动程序类别
Connection con = DriverManager.getConnection("jdbc:odbc:jspdata"); //建立数据库链接,jspdata为ODBC数据源名称
Statement stmt = con.createStatement();//建立Statement对象
  
String sID = request.getParameter("ID");
	PreparedStatement pstmt = null;

	
	try
	{     	   
 	   	//从客户端发送的流中提取文件
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		Document doc = builder.parse(request.getInputStream());

		Element root = doc.getDocumentElement();
		Node xml_File1 = root.getFirstChild();
		NamedNodeMap attList = xml_File1.getAttributes();
		String fileN = "";
		String fileExt = "";
		for (int i = 0; i < attList.getLength(); i++)
		{
		  Node currentNode = attList.item(i);
		  if(currentNode.getNodeName().equals("filename"))
		  {
			fileN = currentNode.getNodeValue();
			fileExt = fileN.substring(fileN.length()-4);
			fileExt = fileExt.toLowerCase();
			break;
		  }
		}
		
			Node textNode = xml_File1.getFirstChild();

			BASE64Decoder de = new BASE64Decoder();

			//下面的字节数组b就是SOAOffice控件提交到服务器的文档流,将b存入数据库字段里，
			byte[] b= de.decodeBuffer(textNode.getNodeValue());			

			//把流存入数据库
			pstmt = con.prepareStatement("update stream set word=? where ID="+sID);
			pstmt.setBytes(1,b);
			pstmt.executeUpdate();
		
              		pstmt.close();
			con.close();

			//本页面里请不要添加其他out.print();
			out.print("Save OK."); 
	}
	catch(Exception e)
	{
		out.print("Save Erro."); 
	}
	
 

%>