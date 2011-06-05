package system.excel;

import java.util.ArrayList;
import java.util.List;

public class VoTplExcelObj {
	
	public static final int DEFAULT_COLUMN_ROWSPAN = 1;
	
	private String sheetName;
	private int idxRowColumn;
	private int spanRowColumn;
	private int idxRowData;
	private VoTplExcelField title;
	private List<VoTplExcelField> columns = new ArrayList<VoTplExcelField>();
	private List<List<VoTplExcelData>> data = new ArrayList<List<VoTplExcelData>>();
	
	public VoTplExcelObj () { }
	
	public VoTplExcelObj (int idxRowColumn, int idxRowData) {
		this(idxRowColumn, DEFAULT_COLUMN_ROWSPAN, idxRowData);
	}
	
	public VoTplExcelObj (int idxRowColumn, int spanRowColumn, int idxRowData) {
		this(null, idxRowColumn, spanRowColumn, idxRowData);
	}
	
	public VoTplExcelObj (String sheetName, int idxRowColumn, int idxRowData) {
		this(sheetName, idxRowColumn, DEFAULT_COLUMN_ROWSPAN, idxRowData);
	}
	
	public VoTplExcelObj (String sheetName, int idxRowColumn, int spanRowColumn, int idxRowData) {
		this.sheetName = sheetName;
		this.idxRowColumn = idxRowColumn;
		this.idxRowData = idxRowData;
		this.spanRowColumn = spanRowColumn;
	}
	
	public String getSheetName() {
		return sheetName;
	}
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
	public int getIdxRowColumn() {
		return idxRowColumn;
	}
	public void setIdxRowColumn(int idxRowColumn) {
		this.idxRowColumn = idxRowColumn;
	}
	public int getIdxRowData() {
		return idxRowData;
	}
	public void setIdxRowData(int idxRowData) {
		this.idxRowData = idxRowData;
	}
	public VoTplExcelField getTitle() {
		return title;
	}
	public void setTitle(VoTplExcelField title) {
		this.title = title;
	}
	public List<VoTplExcelField> getColumns() {
		return columns;
	}
	public void setColumns(List<VoTplExcelField> columns) {
		this.columns = columns;
	}

	public void setData(List<List<VoTplExcelData>> data) {
		this.data = data;
	}

	public List<List<VoTplExcelData>> getData() {
		return data;
	}

	public void setSpanRowColumn(int spanRowColumn) {
		this.spanRowColumn = spanRowColumn;
	}

	public int getSpanRowColumn() {
		return spanRowColumn;
	}
	
}
