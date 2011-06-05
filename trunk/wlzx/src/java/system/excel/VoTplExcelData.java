package system.excel;

public class VoTplExcelData {
	
	private String cellData;
	private String cellComment;
	private VoTplExcelField cellColumn;
	
	public void setCellData(String cellData) {
		this.cellData = cellData;
	}
	public String getCellData() {
		return cellData;
	}
	public void setCellComment(String cellComment) {
		this.cellComment = cellComment;
	}
	public String getCellComment() {
		return cellComment;
	}
	public void setCellColumn(VoTplExcelField cellColumn) {
		this.cellColumn = cellColumn;
	}
	public VoTplExcelField getCellColumn() {
		return cellColumn;
	}
	
}
