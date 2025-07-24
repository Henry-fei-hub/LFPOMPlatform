package pomplatform.OnEmployeeDayPlateRecords.handler;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.postgresql.jdbc2.optional.SimpleDataSource;

import pomplatform.OnEmployeeDayPlateRecords.bean.BaseOnEmployeeDayPlateRecords;
import pomplatform.OnEmployeeDayPlateRecords.bean.ConditionOnEmployeeDayPlateRecords;
import pomplatform.OnEmployeeDayPlateRecords.query.QueryOnEmployeeDayPlateRecords;
import pomplatform.salary.bean.BaseSalaryAnnualbonus;
import pomplatform.salary.bean.ConditionSalaryAnnualbonus;
import pomplatform.salary.query.QuerySalaryAnnualbonus;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;

public class OnEmployeeDayPlateRecordsHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnEmployeeDayPlateRecordsHandler.class);

	public static BaseCollection<BaseOnEmployeeDayPlateRecords> executeQueryOnEmployeeDayPlateRecords(ConditionOnEmployeeDayPlateRecords c, KeyValuePair[] replacements ) throws Exception {
		QueryOnEmployeeDayPlateRecords dao = new QueryOnEmployeeDayPlateRecords();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnEmployeeDayPlateRecords> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnEmployeeDayPlateRecords c = new ConditionOnEmployeeDayPlateRecords();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnEmployeeDayPlateRecords> result = executeQueryOnEmployeeDayPlateRecords(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ConditionOnEmployeeDayPlateRecords c = new ConditionOnEmployeeDayPlateRecords();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		BaseCollection<BaseOnEmployeeDayPlateRecords> result = executeQueryOnEmployeeDayPlateRecords(c, c.getKeyValues());
		List<BaseOnEmployeeDayPlateRecords> list = result.getCollections();
		
		String headName = "职员工号,职员姓名,记录日期,年份,月份,所属公司,业务部门,所属部门,人事状态";
    	String headNameArra [] = headName.split(",");
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
    	Date date = c.getRecordDate();
        String recordDate =sdf.format(date); 
    	
    	String fileName = recordDate + "职员每日所属业务部门" + ".xls";
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
			BaseOnEmployeeDayPlateRecords base = list.get(i);
			int index = 0;
			row = sheet.createRow(i + 1);
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(base.getEmployeeNo() == null ? "" : base.getEmployeeNo()));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(base.getEmployeeName() == null ? "" : base.getEmployeeName()));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(recordDate);
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(base.getYear());
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(base.getMonth());
			
			String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("company_records", String.valueOf(base.getCompanyId()));
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(strCompanyId));
			
			String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("plate_records", String.valueOf(base.getPlateId()));
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(strPlateId));
			
			String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(base.getDepartmentId()));
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(strDepartmentId));

			
			String onboardStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_96", String.valueOf(base.getOnboardStatus()));
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(onboardStatus));
			
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
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


