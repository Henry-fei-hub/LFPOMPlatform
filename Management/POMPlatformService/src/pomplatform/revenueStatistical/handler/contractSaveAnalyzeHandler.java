package pomplatform.revenueStatistical.handler;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import pomplatform.revenueStatistical.bean.BaseRevenueStatisticalOfRevenue;
import pomplatform.revenueStatistical.bean.BasecontractSaveAnalyze;
import pomplatform.revenueStatistical.bean.ConditionRevenueStatisticalOfRevenue;
import pomplatform.revenueStatistical.bean.ConditioncontractSaveAnalyze;
import pomplatform.revenueStatistical.query.QuerycontractSaveAnalyze;
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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;

public class contractSaveAnalyzeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(contractSaveAnalyzeHandler.class);

	public static BaseCollection<BasecontractSaveAnalyze> executeQuerycontractSaveAnalyze(ConditioncontractSaveAnalyze c, KeyValuePair[] replacements ) throws Exception {
		int year = c.getYear();
		QuerycontractSaveAnalyze dao = new QuerycontractSaveAnalyze();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasecontractSaveAnalyze> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(!BaseHelpUtils.isNullOrEmpty(result)) {
			List<BasecontractSaveAnalyze> collections = result.getCollections();
			if(!BaseHelpUtils.isNullOrEmpty(collections)&&collections.size()>0) {
				for (BasecontractSaveAnalyze basecontractSaveAnalyze : collections) {
					basecontractSaveAnalyze.setYear(year);
				}
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditioncontractSaveAnalyze c = new ConditioncontractSaveAnalyze();
		c.setDataFromJSON(creteria);
		BaseCollection<BasecontractSaveAnalyze> result = executeQuerycontractSaveAnalyze(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ConditioncontractSaveAnalyze c = new ConditioncontractSaveAnalyze();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		BaseCollection<BasecontractSaveAnalyze> result = executeQuerycontractSaveAnalyze(c, c.getKeyValues()) ;
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if(!BaseHelpUtils.isNullOrEmpty(result)){
			String headName = BasecontractSaveAnalyze.ALL_CAPTIONS;
	    	String headNameArra [] = headName.split(",");
	    	String fileName = format.format(date) + "导出的合同存量报表.xls";
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
			 List<BasecontractSaveAnalyze> downloadList = result.getCollections();
			int size = downloadList.size();
			int year = c.getYear();
			DecimalFormat df = new DecimalFormat("#.00");
			for (int i = 0; i < size; i++) {
				BasecontractSaveAnalyze bean = downloadList.get(i);
				row = sheet.createRow(i + 1);
				int j = 0;
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(delicacy.system.executor.SelectValueCache.getSelectValue("plate_records", String.valueOf(bean.getPlateId()))));
			
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(year);
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(String.valueOf(df.format(bean.getJanuaryContractSave()))));
			
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(String.valueOf(df.format(bean.getFebruaryContractSave()))));
			
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(String.valueOf(df.format(bean.getMarchContractSave()))));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(String.valueOf(df.format(bean.getAprilContractSave()))));
			
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(String.valueOf(df.format(bean.getMayContractSave()))));
			
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(String.valueOf(df.format(bean.getJuneContractSave()))));
			
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(String.valueOf(df.format(bean.getJulyContractSave()))));
			
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(String.valueOf(df.format(bean.getAugustContractSave()))));
			
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(String.valueOf(df.format(bean.getSeptemberContractSave()))));
			
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(String.valueOf(df.format(bean.getOctoberContractSave()))));
			
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(String.valueOf(df.format(bean.getNovemberContractSave()))));
			
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(String.valueOf(df.format(bean.getDecemberContractSave()))));
			
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(String.valueOf(df.format(bean.getTotal()))));
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


