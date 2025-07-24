package pomplatform.activityMpcor.handler;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import delicacy.date.util.DateUtil;
import delicacy.system.executor.SelectValueCache;
import pomplatform.activityMpcor.bean.BaseSactivityMpcor;
import pomplatform.activityMpcor.bean.ConditionSactivityMpcor;
import pomplatform.activityMpcor.query.QuerySactivityMpcor;

public class SactivityMpcorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SactivityMpcorHandler.class);

	public static BaseCollection<BaseSactivityMpcor> executeQuerySactivityMpcor(ConditionSactivityMpcor c, KeyValuePair[] replacements ) throws Exception {
		QuerySactivityMpcor dao = new QuerySactivityMpcor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSactivityMpcor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSactivityMpcor c = new ConditionSactivityMpcor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSactivityMpcor> result = executeQuerySactivityMpcor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSactivityMpcor> result;
		ConditionSactivityMpcor c = new ConditionSactivityMpcor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySactivityMpcor dao = new QuerySactivityMpcor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
//		try(PrintStream ps = new PrintStream(downFile, "GBK")){
//			ps.println(BaseSactivityMpcor.ALL_CAPTIONS);
//			for(BaseSactivityMpcor b : result.getCollections()){
//				ps.println(b.toCSVString());
//			}
//		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatTime = new SimpleDateFormat("HH:hh:ss");
		List<BaseSactivityMpcor> resultData = result.getCollections();
		if(!BaseHelpUtils.isNullOrEmpty(resultData) && resultData.size() > 0){
			String headName = BaseSactivityMpcor.EXPORT_CAPTIONS;
	    	String headNameArra [] = headName.split(",");
	    	String fileName = "营销中心差旅&会议报表.xls";
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
			// 定义单元格报头
//			String worksheetTitle = "";

			HSSFWorkbook wb = new HSSFWorkbook();
			// 创建单元格样式
			HSSFCellStyle cellStyleTitle = wb.createCellStyle();
			// 指定单元格居中对齐
			cellStyleTitle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			// 指定单元格垂直居中对齐
			cellStyleTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			// 指定当单元格内容显示不下时自动换行
			cellStyleTitle.setWrapText(false);
			// ------------------------------------------------------------------
			HSSFCellStyle cellStyle = wb.createCellStyle();
			// 指定单元格居中对齐
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			// 指定单元格垂直居中对齐
			cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			// 指定当单元格内容显示不下时自动换行
			cellStyle.setWrapText(false);
			// ------------------------------------------------------------------
			HSSFCellStyle numberStyle = wb.createCellStyle();
			// 指定单元格居中对齐
			numberStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			// 指定单元格垂直居中对齐
			numberStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			// 指定当单元格内容显示不下时自动换行
			numberStyle.setWrapText(false);
			// ------------------------------------------------------------------
			// 设置单元格字体
//			HSSFFont font = wb.createFont();
//			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
//			font.setFontName("宋体");
//			font.setFontHeight((short) 200);
//			cellStyleTitle.setFont(font);
			
			HSSFSheet sheet = wb.createSheet();
			sheet.setColumnWidth(4, 200*50);
			sheet.setColumnWidth(5, 200*50);
			sheet.setColumnWidth(6, 200*50);
			sheet.setColumnWidth(7, 200*50);
			sheet.setColumnWidth(8, 200*50);
			sheet.setDefaultRowHeight((short)(2 * 256));
//			ExportExcelUtil exportExcel = new ExportExcelUtil(wb, sheet);
			// 创建报表头部
//			exportExcel.createNormalHead(worksheetTitle, headNameArra.length);
			//设置表头
			HSSFRow row1 = sheet.createRow(0);
			for (int i = 0; i < headNameArra.length; i++) {
				HSSFCell tmpCell = row1.createCell(i);
				tmpCell.setCellStyle(cellStyleTitle);
				tmpCell.setCellValue(new HSSFRichTextString(headNameArra[i]));
			}
			HSSFRow row = sheet.createRow(1);
			HSSFCell cell = row.createCell(1);
			int size = resultData.size();
			Calendar calendar = Calendar.getInstance();
			for (int i = 0; i < size; i++) {
				BaseSactivityMpcor bean = resultData.get(i);
				calendar.setTime(bean.getMeetTime());
				int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
				if(weekDay - 1 == 0){
					weekDay = 8;
				}
				row = sheet.createRow(i + 1);
				int j = 0;
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				String strDepartmentId = " ";
				if(!BaseHelpUtils.isNullOrEmpty(bean.getDepartmentId())){
					strDepartmentId = SelectValueCache.getSelectValue("departments", String.valueOf(bean.getDepartmentId()));
				}
				cell.setCellValue(new HSSFRichTextString(strDepartmentId));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(format.format(bean.getMeetTime())));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				String strWeekDay = " ";
				if(!BaseHelpUtils.isNullOrEmpty(weekDay)){
					strWeekDay = SelectValueCache.getSelectValue("system_dictionary_23", String.valueOf(weekDay - 1));
				}
				cell.setCellValue(new HSSFRichTextString(strWeekDay + ""));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)));
				
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getOutTimeStart()==null?"":DateUtil.formatDateTimeString(bean.getOutTimeStart())));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getOutTimeEnd()==null?"":DateUtil.formatDateTimeString(bean.getOutTimeEnd())));
				
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getProvince()));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getCity()));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getMeetAddress()));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getCustomerName()));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getTheirEmployees()));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getOurEmployees()));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getOurDesignerEmployees()));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getMeetTitle()));
			}
			try {
				bufferedOutPut.flush();
				wb.write(bufferedOutPut);
				bufferedOutPut.close();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				resultData.clear();
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


