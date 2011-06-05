package system.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcelUtils {
	
	private String targetFile;
	private WritableWorkbook book;
	private WritableSheet sheet;
	
	public ExcelUtils() { }
	
	public ExcelUtils(String targetFile) {
		this.targetFile = targetFile;
	}
	
	
	/**
	 * @param sheet
	 *            要添加数据的工作表
	 * @param list
	 *            填充的数据
	 */
	public void addCellOfBug(WritableSheet sheet, List<String> list) {
		if (list.size() > 0) {
			int i = 0;
			for (Iterator<String> it = list.iterator(); it.hasNext();) {
				int j = 0;
				String bs = (String) it.next();
				if (null != bs) {
					try {
						// 第一列,填充 XXX, Label(列,行,值)
						sheet.addCell(new Label(j++, i + 3, bs));
					} catch (WriteException ex) {
						ex.printStackTrace();
					}
				}
				i++;
			}
		}
	}
	
	/**
	 * 
	 */
	public void createWorkBook() {
		this.createWorkBook(targetFile);
	}
	
	/**
	 * 
	 * @param targetFile
	 */
	public void createWorkBook(String targetFile) {
		try {
			OutputStream os = new FileOutputStream(targetFile);
			this.book = Workbook.createWorkbook(os);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param sheetName
	 * @param sheetIndex
	 */
	public void createSheet(String sheetName, int sheetIndex) {
		if (this.book != null) {
			this.sheet = this.book.createSheet(sheetName, sheetIndex);
		}
	}
	
	/**
	 * 
	 * @param idxColumn
	 * @param idxRow
	 * @param text
	 * @return
	 */
	public WritableCell createCell(int idxColumn, int idxRow, String text) {
		return this.createCell(idxColumn, idxRow, text, null);
	}
	
	/**
	 * 
	 * @param idxColumn
	 * @param idxRow
	 * @param text
	 * @param fmt
	 * @return
	 */
	public WritableCell createCell(int idxColumn, int idxRow, String text, WritableCellFormat fmt) {
		return new Label(idxColumn, idxRow, text, fmt);
	}
	
	/**
	 * 
	 * @param sheet
	 * @param cell
	 * @throws Exception
	 */
	public void addCell(WritableCell cell) throws Exception {
		if (sheet != null) {
			sheet.addCell(cell);
		}
	}
	
	public void write()	throws Exception {
		if (book != null) {
			book.write();
		}
	}
	
	public void close() throws Exception {
		if (book != null) {
			book.close();
		}
	}
	
	/**
	 * 
	 * @param srcIdxColumn
	 * @param srcIdxRow
	 * @param tgtIdxColumn
	 * @param tgtIdxRow
	 * @throws Exception
	 */
	public void mergeCells(int srcIdxColumn, int srcIdxRow, int tgtIdxColumn, int tgtIdxRow) throws Exception {
		if (sheet != null) {
			sheet.mergeCells(srcIdxColumn, srcIdxRow, tgtIdxColumn, tgtIdxRow);
		}
	}
	
	/**
	 * 
	 * @param cell
	 * @param comment
	 */
	public void addComment(WritableCell cell, String comment) {
		if (cell != null) {
			WritableCellFeatures cellFeatures = new WritableCellFeatures();
			cellFeatures.setComment(comment);
			cell.setCellFeatures(cellFeatures);
		}
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public WritableCellFormat getAlignCellFmt () throws Exception {
		return this.getAlignCellFmt(null);
	}
	
	/**
	 * 
	 * @param font
	 * @return
	 * @throws Exception
	 */
	public WritableCellFormat getAlignCellFmt (WritableFont font) throws Exception {
		return this.getAlignCellFmt(font, VerticalAlignment.CENTRE, Alignment.CENTRE);
	}
	
	/**
	 * 
	 * @param valign
	 * @param halign
	 * @return
	 * @throws Exception
	 */
	public WritableCellFormat getAlignCellFmt (VerticalAlignment valign, Alignment halign) throws Exception {
		WritableFont font= new WritableFont(WritableFont.TIMES, 11, WritableFont.BOLD);
		return this.getAlignCellFmt(font, valign, halign);
	}
	
	/**
	 * 
	 * @param font
	 * @param valign
	 * @param halign
	 * @return
	 * @throws Exception
	 */
	public WritableCellFormat getAlignCellFmt (WritableFont font, VerticalAlignment valign, Alignment halign) throws Exception {
		WritableCellFormat wc = font != null ? new WritableCellFormat(font) : new WritableCellFormat();
		if (valign != null) {
			wc.setVerticalAlignment(VerticalAlignment.CENTRE);
		}
		if (halign != null) {
			wc.setAlignment(halign);
		}
		return wc;
	}
	
	public WritableCellFormat setHAlign (WritableCellFormat wc, Alignment halign) throws Exception {
		if (wc != null) {
			wc.setAlignment(halign);
		}
		return wc;
	}
	
	public void setTargetFile(String targetFile) {
		this.targetFile = targetFile;
	}

	public String getTargetFile() {
		return targetFile;
	}

	public void setBook(WritableWorkbook book) {
		this.book = book;
	}

	public WritableWorkbook getBook() {
		return book;
	}

	public void setSheet(WritableSheet sheet) {
		this.sheet = sheet;
	}

	public WritableSheet getSheet() {
		return sheet;
	}
	
}
