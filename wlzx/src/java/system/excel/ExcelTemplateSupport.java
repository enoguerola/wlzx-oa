package system.excel;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jxl.format.Alignment;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import system.constants.Constants;
import system.utils.ReflectUtils;
import system.utils.ResourcesUtils;
import system.utils.StringUtils;
import system.utils.XMLParserUtils;
import system.wlims.basic.entity.teacher.TeacherModel;

public class ExcelTemplateSupport {

	/**
	 * 通过模板XML文件生成Excel的模板对象
	 * @return
	
	public static VoTplExcelObj getTplObjFromTplFile () {
		return getTplObjFromTplFile(ExcelUtils.XLS_TPL_PATH + "/tpl_xls.xml");
	} */
	
	/**
	 * 通过模板XML文件生成Excel的模板对象
	 * @param tplFile
	 * @return
	 */
	public static VoTplExcelObj getTplObjFromTplFile (String tplFile) {
		XMLParserUtils parser = new XMLParserUtils(ResourcesUtils.getWebRootPath() + tplFile);
		if (parser.parse()) {
			
			NodeList root = parser.getElementsByTagName("xls-fields");
			Node node = root.item(0);
			
			int indexRowData = Integer.parseInt(XMLParserUtils.getAttributeByName(node, "data-row-index"));
			int indexRowColumn = Integer.parseInt(XMLParserUtils.getAttributeByName(node, "column-row-index"));
			int spanRowColumn = Integer.parseInt(XMLParserUtils.getAttributeByName(node, "column-row-span"));
			
			VoTplExcelObj tplXlsObj = new VoTplExcelObj(indexRowColumn, spanRowColumn, indexRowData);
			
			NodeList nodeFieldTitle = parser.getElementsByTagName("field-title");
			tplXlsObj.setTitle(VoTplExcelField.fromXmlNode(nodeFieldTitle.item(0)));
			
			NodeList nodeFieldColumns = parser.getElementsByTagName("field-columns");
			tplXlsObj.setColumns(VoTplExcelField.fromXmlNodeList(nodeFieldColumns));
			
			return tplXlsObj;
		}
		return null;
	}
	
	/**
	 * 填充数据至模板对象
	 * @param tplObj
	 * @return
	 */
	public static VoTplExcelObj fillTplData (VoTplExcelObj tplObj, List<Map<String, Object>> data) {
		return fillTplData(tplObj, data, null);
	}
	
	/**
	 * 填充数据至模板对象
	 * @param tplObj
	 * @param data
	 * @param extraParams
	 * @return
	 */
	public static VoTplExcelObj fillTplData (VoTplExcelObj tplObj, List<Map<String, Object>> data, Map<String, String> extraParams) {
		if (tplObj != null && data != null && data.size() > 0) {
			
			// 填充参数值, 主要是头部信息
			if (extraParams != null) {
				for (Entry<String, String> item : extraParams.entrySet()) {
					if (item != null) {
						VoTplExcelField header = tplObj.getTitle();
						if (header.isParamInfieldText()) {
							String param = getParamInText(header.getFieldText());
							if (StringUtils.isNotEmpty(param)) {
								if (extraParams.containsKey(param) && extraParams.get(param) != null) {
									header.setFieldText(header.getFieldText().replace(
											"${" + param + "}", extraParams.get(param)));
									
									header.setParamInfieldText(false);
								}
							}
						}
					}
				}
			}
			
			// 填充数据
			if (data != null) {
				HashMap<String, Object> objcmp = new HashMap<String, Object>();
				for (Map<String, Object> item : data) {
					if (item != null) {
						List<VoTplExcelData> rowDataList = new ArrayList<VoTplExcelData>();
						objcmp.clear();
						for (Entry<String, Object> entry : item.entrySet()) {
							objcmp.putAll(ReflectUtils.getAllComponentsName(
									entry.getKey() + ".", entry.getValue()));
						}
						for (VoTplExcelField column : tplObj.getColumns()) {
							VoTplExcelData rowData = new VoTplExcelData();
							
							// 填充单元格内容
							if (objcmp.containsKey(column.getFieldKeyData()) && 
									objcmp.get(column.getFieldKeyData()) != null) {
								if(objcmp.get(column.getFieldKeyData()).toString().equals(""))//if "" set data "无" ---add by yufeng
									rowData.setCellData("无");
								else
									rowData.setCellData(objcmp.get(column.getFieldKeyData()).toString());
							}else
								rowData.setCellData("无");//if null set data "无" ---add by yufeng
							
							// 填充批注信息
							if (StringUtils.isNotEmpty(column.getFieldKeyComment()) && 
									objcmp.containsKey(column.getFieldKeyComment()) && 
									objcmp.get(column.getFieldKeyComment()) != null) {
								rowData.setCellComment(objcmp.get(column.getFieldKeyComment()).toString());
							}
							
							// 填充Column中的参数
							if (column.isParamInfieldText()) {
								String param = getParamInText(column.getFieldText());
								if (StringUtils.isNotEmpty(param)) {
									if (objcmp.containsKey(param) && objcmp.get(param) != null) {
										column.setParamInfieldText(false);
										column.setFieldText(column.getFieldText().replace(
												"${" + param + "}", objcmp.get(param).toString()));
									}
								}
							}
							
							rowData.setCellColumn(column);
							rowDataList.add(rowData);
						}
						tplObj.getData().add(rowDataList);
					}
				}
			}
		}
		return tplObj;
	}
	
	/**
	 * 获取字符串中所存在的参数值
	 * @param text
	 * @return
	 */
	public static String getParamInText(String text) {
		if (StringUtils.isNotEmpty(text)) {
			int s = text.indexOf("${");
			int t = text.indexOf("}");
			if (s >= 0 && t > s) {
				return text.substring(s + 2, t);//modified by yufeng
			}
		}
		return null;
	}
	
	/**
	 * 通过模板对象填充并生成Excel文件
	 * @param tplObj
	 */
	public static void createExcel (String targetFile, VoTplExcelObj tplObj) {
		if (tplObj != null) {
			try{
				ExcelUtils xls = new ExcelUtils(targetFile);
				xls.createWorkBook();
				
				String sheetName = StringUtils.isNotEmpty(tplObj.getSheetName()) ? 
						tplObj.getSheetName() : tplObj.getTitle().getFieldText();
				
				xls.createSheet(sheetName, 0);
				
				// build title
				WritableCellFormat fmtTitle = xls.getAlignCellFmt(VerticalAlignment.CENTRE,null);
				Label lblTitle = (Label) xls.createCell(0, 0, tplObj.getTitle().getFieldText(), fmtTitle);
				xls.addCell(lblTitle);
				xls.mergeCells(0, 0, tplObj.getColumns().size() - 1, tplObj.getTitle().getFieldRowSpan() - 1);
				
				// build columns
				WritableFont fontColumn = new WritableFont(WritableFont.TIMES, 11, WritableFont.BOLD);
				WritableCellFormat fmtColumn = xls.getAlignCellFmt(fontColumn);
				if (tplObj.getColumns() != null && tplObj.getColumns().size() > 0) {
					for (int i = 0, len = tplObj.getColumns().size(); i < len; i++) {
						VoTplExcelField ef = tplObj.getColumns().get(i);
						String text = ef.getFieldText();
						if (ef.isParamInfieldText()) {
							// TODO parameter should be handled in the text
							
						}
						Label lbl = new Label(i, tplObj.getIdxRowColumn(), text, fmtColumn);
						xls.addCell(lbl);
						xls.mergeCells(
								i, tplObj.getIdxRowColumn(), i, tplObj.getIdxRowColumn() + tplObj.getSpanRowColumn() - 1);
					}
				}
				
				//build data
				WritableFont fontData = new WritableFont(WritableFont.TIMES, 9, WritableFont.NO_BOLD);
				WritableCellFormat fmtData = xls.getAlignCellFmt(fontData, null, Alignment.CENTRE);
				if (tplObj.getData() != null && tplObj.getData().size() > 0) {
					for (int i = 0, len = tplObj.getData().size(); i < len; i++) {
						List<VoTplExcelData> ed = tplObj.getData().get(i);
						if (ed != null && ed.size() > 0) {
							for (int j = 0, size = ed.size(); j < size; j++) {
								VoTplExcelData cellData = ed.get(j);
								if (StringUtils.isNotEmpty(cellData.getCellData())) {
									Label lbl = new Label(j, tplObj.getIdxRowData() + i, cellData.getCellData(), fmtData);
									if (StringUtils.isNotEmpty(cellData.getCellComment())) {
										WritableCellFeatures cellFeatures = new WritableCellFeatures();
										cellFeatures.setComment(cellData.getCellComment());
										lbl.setCellFeatures(cellFeatures);
									}
									xls.addCell(lbl);
								}
							}
						}
					}
				}
				
				xls.write();
				xls.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		//getTplObjFromTplFile(ExcelUtils.XLS_TPL_PATH + "/tpl_xls_ent_experiments.xml");
		//getTplObjFromTplFile(ExcelUtils.XLS_TPL_PATH + "/tpl_xls_ent_demonstration.xml");
		VoTplExcelObj obj = ExcelTemplateSupport.getTplObjFromTplFile(
				Constants.BASIC_XLS_TPL_PATH + "/teachers.xml");
		
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		//数据一
		Map<String, Object> ents = new HashMap<String, Object>();
		TeacherModel base = new TeacherModel();
		base.setAddress("address");
		base.setBirthday(Date.valueOf("2011-11-11"));
		base.setCreationDate(Date.valueOf("2011-11-11"));
		base.setHomePhone("122");
		base.setTeacherPosition("position");
		base.setTeacherProfession("profession");
		base.setTeacherSkillLevel("skill level");
		
		ents.put("base", base);
		data.add(ents);
		
		Map<String, String> extraParams = new HashMap<String, String>();
		extraParams.put("title.year", "2014");
		
		obj = ExcelTemplateSupport.fillTplData(obj, data, extraParams);
		
		ExcelTemplateSupport.createExcel("D:\\a.xls", obj);

	}
	
}
