package pomplatform.payment.handler;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import pomplatform.payment.bean.BaseOnSalaryBonusSendData;
import pomplatform.payment.bean.BaseOnSalarySendData;
import pomplatform.payment.bean.ConditionOnSalaryBonusSendData;
import pomplatform.payment.query.QueryOnSalaryBonusSendData;

public class OnSalaryBonusSendDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnSalaryBonusSendDataHandler.class);

	public static BaseCollection<BaseOnSalaryBonusSendData> executeQueryOnSalaryBonusSendData(ConditionOnSalaryBonusSendData c, KeyValuePair[] replacements ) throws Exception {
		QueryOnSalaryBonusSendData dao = new QueryOnSalaryBonusSendData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnSalaryBonusSendData> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnSalaryBonusSendData c = new ConditionOnSalaryBonusSendData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnSalaryBonusSendData> result = executeQueryOnSalaryBonusSendData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnSalaryBonusSendData> result;
		ConditionOnSalaryBonusSendData c = new ConditionOnSalaryBonusSendData();
		c.setDataFromJSON(creteria);
		QueryOnSalaryBonusSendData dao = new QueryOnSalaryBonusSendData();
		dao.setPageLines(1);
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		List<BaseOnSalaryBonusSendData> list = result.getCollections();
		String headName = BaseOnSalaryBonusSendData.ALL_CAPTIONS;
    	String headNameArra [] = headName.split(",");
		
    	String fileName = c.getYear() + "年" + c.getMonth() + "月奖金发放明细" + ".xls";
    	fileName = new String(fileName.getBytes("GBK"), "iso8859-1");
    	response.reset();
    	response.setHeader("Content-Disposition", "attachment;filename="
				+ fileName);// 指定下载的文件名
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		OutputStream output = response.getOutputStream();
		BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
		HSSFWorkbook wb = new HSSFWorkbook();

		// 创建单元格样式
		HSSFCellStyle cellStyleTitle = wb.createCellStyle();
		// 指定单元格居中对齐
		cellStyleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 指定单元格垂直居中对齐
		cellStyleTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 指定当单元格内容显示不下时自动换行
		cellStyleTitle.setWrapText(true);
		// ------------------------------------------------------------------
		HSSFCellStyle cellStyle = wb.createCellStyle();
		// 指定单元格居中对齐
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 指定单元格垂直居中对齐
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 指定当单元格内容显示不下时自动换行
		cellStyle.setWrapText(true);
		
		HSSFCellStyle cellStyle1 = wb.createCellStyle(); 
		// 指定单元格居中对齐
		cellStyle1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 指定单元格垂直居中对齐
		cellStyle1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 指定当单元格内容显示不下时自动换行
		cellStyle1.setWrapText(true);
		//创建一个DataFormat对象 
		HSSFDataFormat format = wb.createDataFormat(); 
		cellStyle1.setDataFormat(format.getFormat("##########0.00")); 
		// ------------------------------------------------------------------
		// 设置单元格字体
		HSSFFont font = wb.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		font.setFontHeight((short) 200);
		cellStyleTitle.setFont(font);
		
		HSSFSheet sheet = wb.createSheet();
		//设置表头
		HSSFRow row1 = sheet.createRow(0);
		for (int i = 0; i < headNameArra.length; i++) {
			HSSFCell tmpCell = row1.createCell(i);
			tmpCell.setCellStyle(cellStyleTitle);
			tmpCell.setCellValue(new HSSFRichTextString(headNameArra[i]));
		}
		HSSFRow row = sheet.createRow(1);
		HSSFCell cell = row.createCell(1);
		for (int i = 0; i < list.size(); i++) {
			BaseOnSalaryBonusSendData base = list.get(i);
			row = sheet.createRow(i + 1);
			
			String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(base.getCompanyId()));
			cell = row.createCell(0);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(strCompanyId));

			cell = row.createCell(1);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(base.getEmployeeNo() == null ? "" : base.getEmployeeNo()));

			cell = row.createCell(2);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(base.getEmployeeName() == null ? "" : base.getEmployeeName()));

			cell = row.createCell(3);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(base.getBankAccount() == null ? "" : base.getBankAccount()));
			
			cell = row.createCell(4);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getYear() == null ? "" : base.getYear().toString()));
			
			cell = row.createCell(5);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getMonth() == null ? "" : base.getMonth().toString()));
			
			HSSFCell cell1 = row.createCell(6);
//			cell1 = row.createCell(6);
			cell1.setCellStyle(cellStyle1);
			cell1.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell1.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(base.getFactBonus(), 2) + ""));

		}
		try {
			bufferedOutPut.flush();
			wb.write(bufferedOutPut);
			bufferedOutPut.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Output   is   closed ");
		} finally {
			list.clear();
		}
		
		
//		BaseCollection<BaseOnSalaryBonusSendData> result;
//		ConditionOnSalaryBonusSendData c = new ConditionOnSalaryBonusSendData();
//		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
//		QueryOnSalaryBonusSendData dao = new QueryOnSalaryBonusSendData();
//		dao.setCurrentPage(1);
//		dao.setPageLines(1);
//		result = dao.executeQuery( c.getKeyValues(), c) ;
//		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
//			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
//		}
//		dao.setCurrentPage(0);
//		result = dao.executeQuery( c.getKeyValues(), c) ;
//		try(PrintStream ps = new PrintStream(downFile, "GBK")){
//			ps.println(BaseOnSalaryBonusSendData.ALL_CAPTIONS);
//			for(BaseOnSalaryBonusSendData b : result.getCollections()){
//				ps.println(b.toCSVString());
//			}
//		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


