package pomplatform.project.handler;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
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
import pomplatform.project.bean.BaseOnLoadInAchieveDetail;
import pomplatform.project.bean.ConditionOnLoadInAchieveDetail;
import pomplatform.project.query.QueryOnLoadInAchieveDetail;

public class OnLoadInAchieveDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadInAchieveDetailHandler.class);

	public static BaseCollection<BaseOnLoadInAchieveDetail> executeQueryOnLoadInAchieveDetail(ConditionOnLoadInAchieveDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadInAchieveDetail dao = new QueryOnLoadInAchieveDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadInAchieveDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadInAchieveDetail c = new ConditionOnLoadInAchieveDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadInAchieveDetail> result = executeQueryOnLoadInAchieveDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadInAchieveDetail> result;
		ConditionOnLoadInAchieveDetail c = new ConditionOnLoadInAchieveDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadInAchieveDetail dao = new QueryOnLoadInAchieveDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
//		try(PrintStream ps = new PrintStream(downFile, "GBK")){
//			ps.println(BaseOnLoadInAchieveDetail.ALL_CAPTIONS);
//			for(BaseOnLoadInAchieveDetail b : result.getCollections()){
//				ps.println(b.toCSVString());
//			}
//		}
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if(!BaseHelpUtils.isNullOrEmpty(result)){
			String headName = BaseOnLoadInAchieveDetail.ALL_CAPTIONS;
	    	String headNameArra [] = headName.split(",");
	    	String fileName = format.format(date) + "内部收入明细表.xls";
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
			cellStyleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			// 指定单元格垂直居中对齐
			cellStyleTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			// 指定当单元格内容显示不下时自动换行
			cellStyleTitle.setWrapText(false);
			// ------------------------------------------------------------------
			HSSFCellStyle cellStyle = wb.createCellStyle();
			// 指定单元格居中对齐
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
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
			HSSFFont font = wb.createFont();
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			font.setFontName("宋体");
			font.setFontHeight((short) 200);
			cellStyleTitle.setFont(font);
			
			HSSFSheet sheet = wb.createSheet();
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
			List<BaseOnLoadInAchieveDetail> downloadList = result.getCollections();
			int size = downloadList.size();
			for (int i = 0; i < size; i++) {
				BaseOnLoadInAchieveDetail bean = downloadList.get(i);
				row = sheet.createRow(i + 1);
				int j = 0;
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(bean.getPlateId()))));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getFinancialContractCode()));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getContractCode()));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getContractName()));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getSheetCode()));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getSheetName()));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getTotalRevenue()+""));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getCurrentRevenue()+""));

				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getLastTotalRevenue()+ ""));
			}
			try {
				bufferedOutPut.flush();
				wb.write(bufferedOutPut);
				bufferedOutPut.close();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				downloadList.clear();
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


