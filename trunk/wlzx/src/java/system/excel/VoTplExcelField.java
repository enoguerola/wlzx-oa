package system.excel;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import system.utils.XMLParserUtils;


public class VoTplExcelField {
	
	private boolean isTitle = false;
	private boolean paramInfieldText = false;
	private int fieldRowSpan = VoTplExcelObj.DEFAULT_COLUMN_ROWSPAN;
	private String fieldCell = null;
	private String fieldText = null;
	private String fieldKeyData = null;
	private String fieldKeyComment = null;
	private String fieldDescription = null;
	
	public VoTplExcelField () { }
	
	public VoTplExcelField (
			boolean isTitle, 
			String fieldCell, 
			String fieldText, 
			String fieldKeyData) {
		this(isTitle, fieldCell, fieldText, fieldKeyData, null);
	}
	
	public VoTplExcelField (
			boolean isTitle, 
			String fieldCell, 
			String fieldText, 
			String fieldKeyData, 
			String fieldKeyComment) {
		this(isTitle, fieldCell, fieldText, fieldKeyData, fieldKeyComment, null, VoTplExcelObj.DEFAULT_COLUMN_ROWSPAN);
	}
	
	public VoTplExcelField (
			boolean isTitle, 
			String fieldCell, 
			String fieldText, 
			String fieldKeyData, 
			String fieldKeyComment, 
			String fieldDescription, 
			int fieldRowSpan) {
		this.isTitle = isTitle;
		this.fieldCell = fieldCell;
		this.fieldText = fieldText;
		this.fieldKeyData = fieldKeyData;
		this.fieldKeyComment = fieldKeyComment;
		this.fieldDescription = fieldDescription;
		this.fieldRowSpan = fieldRowSpan;
	}
	
	public static List<VoTplExcelField> fromXmlNodeList(NodeList nodes) {
		if (nodes != null) {
			Node node = nodes.item(0);
			if (node.getChildNodes() != null && node.getChildNodes().getLength() > 0) {
				NodeList childs = node.getChildNodes();
				List<VoTplExcelField> vtobjList = new ArrayList<VoTplExcelField>();
				for (int i = 0, len = childs.getLength(); i < len; i++) {
					VoTplExcelField data = fromXmlNode(childs.item(i));
					if (data != null) {
						vtobjList.add(data);
					}
				}
				return vtobjList;
			}
		}
		return null;
	}
	
	public static VoTplExcelField fromXmlNode(Node node) {
		if (node != null) {
			VoTplExcelField vtobj = new VoTplExcelField();
			if (node.getNodeName().equals("field-title")) {
				vtobj.setTitle(true);
			}
			if (XMLParserUtils.getAttributeByName(node, "rowspan") != null) {
				vtobj.setFieldRowSpan(Integer.parseInt(XMLParserUtils.getAttributeByName(node, "rowspan")));
			}
			NodeList childs = node.getChildNodes();
			if (childs != null && childs.getLength() > 0) {
				for (int i = 0, len = childs.getLength(); i < len; i++) {
					Node child = childs.item(i);
					if (child instanceof Element) {
						if (child.getNodeName().equals("field-cell")) {
							vtobj.setFieldCell(child.getFirstChild().getNodeValue());
						} else if (child.getNodeName().equals("field-text")) {
							vtobj.setFieldText(child.getFirstChild().getNodeValue());
							if (child.getFirstChild().getNodeValue() != null && child.getFirstChild().getNodeValue().indexOf("${") > -1) {
								vtobj.setParamInfieldText(true);
							}
						} else if (child.getNodeName().equals("field-key-data")) {
							vtobj.setFieldKeyData(child.getFirstChild().getNodeValue());
						} else if (child.getNodeName().equals("field-key-comment")) {
							vtobj.setFieldKeyComment(child.getFirstChild().getNodeValue());
						} else if (child.getNodeName().equals("field-description")) {
							vtobj.setFieldDescription(child.getFirstChild().getNodeValue());
						}
					}
				}
				return vtobj;
			}
		}
		return null;
	}
	
	public boolean isTitle() {
		return isTitle;
	}
	public void setTitle(boolean isTitle) {
		this.isTitle = isTitle;
	}
	public String getFieldCell() {
		return fieldCell;
	}
	public void setFieldCell(String fieldCell) {
		this.fieldCell = fieldCell;
	}
	public String getFieldText() {
		return fieldText;
	}
	public void setFieldText(String fieldText) {
		this.fieldText = fieldText;
	}
	public String getFieldKeyData() {
		return fieldKeyData;
	}
	public void setFieldKeyData(String fieldKeyData) {
		this.fieldKeyData = fieldKeyData;
	}
	public String getFieldKeyComment() {
		return fieldKeyComment;
	}
	public void setFieldKeyComment(String fieldKeyComment) {
		this.fieldKeyComment = fieldKeyComment;
	}
	public String getFieldDescription() {
		return fieldDescription;
	}
	public void setFieldDescription(String fieldDescription) {
		this.fieldDescription = fieldDescription;
	}

	public void setParamInfieldText(boolean paramInfieldText) {
		this.paramInfieldText = paramInfieldText;
	}

	public boolean isParamInfieldText() {
		return paramInfieldText;
	}

	public void setFieldRowSpan(int fieldRowSpan) {
		this.fieldRowSpan = fieldRowSpan;
	}

	public int getFieldRowSpan() {
		return fieldRowSpan;
	}
	
}
