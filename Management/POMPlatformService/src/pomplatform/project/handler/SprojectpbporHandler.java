package pomplatform.project.handler;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import pomplatform.project.bean.BaseSprojectpbpor;
import pomplatform.project.bean.BaseSprojectpricechangedrecordcppor;
import pomplatform.project.bean.ConditionSprojectpbpor;
import pomplatform.project.bean.ConditionSprojectpricechangedrecordcppor;
import pomplatform.project.query.QuerySprojectpbpor;
import pomplatform.project.query.QuerySprojectpricechangedrecordcppor;
import pomplatform.project.query.QuerySprojectpricechangedrecordgroupor;
import pomplatform.reimbursement.bean.BaseK3VoucherList;
import pomplatform.reimbursement.bean.ConditionK3VoucherList;
import pomplatform.reimbursement.query.QueryK3VoucherList;
import delicacy.common.KeyValuePair;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.dsig.keyinfo.KeyValue;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;

public class SprojectpbporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SprojectpbporHandler.class);

	public static BaseCollection<BaseSprojectpbpor> executeQuerySprojectpbpor(ConditionSprojectpbpor c, KeyValuePair[] replacements ) throws Exception {
		QuerySprojectpbpor dao = new QuerySprojectpbpor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSprojectpbpor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSprojectpbpor c = new ConditionSprojectpbpor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSprojectpbpor> executeQuerySprojectpbpor =executeQuerySprojectpbpor = executeQuerySprojectpbpor(c, c.getKeyValues());
		return executeQuerySprojectpbpor.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSON parser = new JSON(new StringReader(creteria)); 
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		List<BaseSprojectpbpor> downloadList = new ArrayList<>();
		ConditionSprojectpbpor cs = new ConditionSprojectpbpor();
		cs.setDataFromJSON(creteria);
		QuerySprojectpbpor dao = new QuerySprojectpbpor();
		BaseCollection<BaseSprojectpbpor> bc = dao.executeQuery(cs.getKeyValues(), cs) ;
		if(null != bc && null != bc.getCollections()){
			downloadList.addAll(bc.getCollections());
		}
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if(downloadList.size() > 0){
			String headName = "合同编号,项目名称,业务部门,项目类别,业务类别,定价类型,备注";
	    	String headNameArra [] = headName.split(",");
	    	String fileName = format.format(date) + "导出的订单定价维护.xls";
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
			int size = downloadList.size();
			Calendar c = Calendar.getInstance();
			for (int i = 0; i < size; i++) {
				BaseSprojectpbpor bean = downloadList.get(i);
				row = sheet.createRow(i + 1);
				int j = 0;
				//合同编号,项目名称,业务部门,项目类别,业务类别,定价类型,备注
				//合同编号
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getContractCode()));
				//项目名称
				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getProjectName()));
				//业务部门
				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString(delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(bean.getPlateId()))));
				//项目类别
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_32", String.valueOf(bean.getProjectType()))));
				//业务类别
				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString(delicacy.system.executor.SelectValueCache.getSelectValue("production_value_coefficient_type", String.valueOf(bean.getBusinessType()))));
				//定价类型
				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString(delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_207", String.valueOf(bean.getPricingType()))));
				//备注
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getRemark()));
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


