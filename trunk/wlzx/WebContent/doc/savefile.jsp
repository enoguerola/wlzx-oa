<%
////////////////////////////////////////////////////////////////////////////////////////////////////
//
//
//��Ȩ����(c) 2002-2007 �����ƺ�������޹�˾
//
//
//
////////////////////////////////////////////////////////////////////////////////////////////////////
%>

<%@ page contentType="text/html;charset=gb2312" %>
<%@ page language="java" import="java.util.*,java.io.*,org.w3c.dom.*,javax.xml.parsers.*,sun.misc.*" %>
<%@ page import="java.sql.*" %>


<%

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); //���������������
Connection con = DriverManager.getConnection("jdbc:odbc:jspdata"); //�������ݿ�����,jspdataΪODBC����Դ����
Statement stmt = con.createStatement();//����Statement����
  
String sID = request.getParameter("ID");
	PreparedStatement pstmt = null;

	
	try
	{     	   
 	   	//�ӿͻ��˷��͵�������ȡ�ļ�
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

			//������ֽ�����b����SOAOffice�ؼ��ύ�����������ĵ���,��b�������ݿ��ֶ��
			byte[] b= de.decodeBuffer(textNode.getNodeValue());			

			//�����������ݿ�
			pstmt = con.prepareStatement("update stream set word=? where ID="+sID);
			pstmt.setBytes(1,b);
			pstmt.executeUpdate();
		
              		pstmt.close();
			con.close();

			//��ҳ�����벻Ҫ�������out.print();
			out.print("Save OK."); 
	}
	catch(Exception e)
	{
		out.print("Save Erro."); 
	}
	
 

%>