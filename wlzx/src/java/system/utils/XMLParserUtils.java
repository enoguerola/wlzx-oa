package system.utils;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import system.constants.Constants;
import system.excel.VoTplExcelField;
import system.excel.VoTplExcelObj;


public class XMLParserUtils {
	
	private static DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	
	private String xmlFile;
	private Document doc;
	
	public XMLParserUtils (String xmlFile) {
		this.xmlFile = xmlFile;
	}
	
	public static DocumentBuilderFactory getInstance(){
		return dbf;
	}
	
	public boolean parse() {
		doc = getDocument(xmlFile);
		return doc != null;
	}
	
	public NodeList getElementsByTagName(String tagName) {
		return doc != null ? doc.getElementsByTagName(tagName) : null;
	}
	
	public NodeList getChildNodes (Node node) {
		return node != null ? node.getChildNodes() : null;
	}
	
	public static String getAttributeByName(Node node, String attrName) {
		if (node != null && node.getAttributes() != null) {
			Node attrNode = node.getAttributes().getNamedItem(attrName);
			return attrNode != null ? attrNode.getNodeValue() : null;
		}
		return null;
	}
	
	private Document getDocument(String path) {
		try {
			Document doc = dbf.newDocumentBuilder().parse(new File(path));
			doc.normalize();
			return doc;
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setXmlFile(String xmlFile) {
		this.xmlFile = xmlFile;
	}

	public String getXmlFile() {
		return xmlFile;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}

	public Document getDoc() {
		return doc;
	}
	
	public static void main(String[] args) {
		XMLParserUtils parser = new XMLParserUtils(
				ResourcesUtils.getWebRootPath() + Constants.BASIC_XLS_TPL_PATH + "/tpl_xls.xml");
		if (parser.parse()) {
			
			NodeList root = parser.getElementsByTagName("xls-fields");
			Node node = root.item(0);
			
			int indexRowData = Integer.parseInt(XMLParserUtils.getAttributeByName(node, "data-row"));
			int indexRowColumn = Integer.parseInt(XMLParserUtils.getAttributeByName(node, "column-row"));
			
			VoTplExcelObj tplXlsObj = new VoTplExcelObj("Test", indexRowData, indexRowColumn);
			
			NodeList nodeFieldTitle = parser.getElementsByTagName("field-title");
			tplXlsObj.setTitle(VoTplExcelField.fromXmlNode(nodeFieldTitle.item(0)));
			
			NodeList nodeFieldColumns = parser.getElementsByTagName("field-columns");
			tplXlsObj.setColumns(VoTplExcelField.fromXmlNodeList(nodeFieldColumns));
			
			System.out.println(tplXlsObj.getColumns().size());
			
		}
	}
	
}
