package pomplatform.check.handler;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import pomplatform.check.bean.BaseExportAttendanceSummaryDetail;
import pomplatform.check.bean.ConditionExportAttendanceSummaryDetail;
import pomplatform.check.query.QueryExportAttendanceSummaryDetail;

public class ExportAttendanceSummaryDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ExportAttendanceSummaryDetailHandler.class);

	public static BaseCollection<BaseExportAttendanceSummaryDetail> executeQueryExportAttendanceSummaryDetail(ConditionExportAttendanceSummaryDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryExportAttendanceSummaryDetail dao = new QueryExportAttendanceSummaryDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseExportAttendanceSummaryDetail> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionExportAttendanceSummaryDetail c = new ConditionExportAttendanceSummaryDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseExportAttendanceSummaryDetail> result = executeQueryExportAttendanceSummaryDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Date date = new Date();
		SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd");
		BaseCollection<BaseExportAttendanceSummaryDetail> result;
		ConditionExportAttendanceSummaryDetail c = new ConditionExportAttendanceSummaryDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		result = executeQueryExportAttendanceSummaryDetail(  c,c.getKeyValues()) ;
		List<BaseExportAttendanceSummaryDetail> list = result.getCollections();

		String headName = BaseExportAttendanceSummaryDetail.ALL_CAPTIONS;
		String headNameArra[] = headName.split(",");

		String fileName = sdfs.format(date) + "导出考勤汇总明细" + ".xls";
		fileName = new String(fileName.getBytes("GBK"), "iso8859-1");
		response.reset();
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);// 指定下载的文件名
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

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
			BaseExportAttendanceSummaryDetail base = list.get(i);
			int index = 0;
			row = sheet.createRow(i + 1);

			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(base.getEmployeeNo() == null ? "" : base.getEmployeeNo()));

			String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(base.getEmployeeId()));
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(strEmployeeId == null ? "" : strEmployeeId));

			String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(base.getDepartmentId()));
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(strDepartmentId == null ? "" : strDepartmentId));

			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getYear() == null ? "" : base.getYear() + ""));

			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getMonth() == null ? "" : base.getMonth() + ""));

			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(sdf.format(base.getRecordDate()) == null ? "" : sdf.format(base.getRecordDate()) + ""));

			String strShiftManageId = delicacy.system.executor.SelectValueCache.getSelectValue("shift_manages", String.valueOf(base.getShiftManageId()));
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue(new HSSFRichTextString(strShiftManageId == null ? "" : strShiftManageId));

			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getCheckin() == null ? "" : sdf.format(base.getCheckin())+ ""));

			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue(new HSSFRichTextString(base.getCheckout() == null ? "" : sdf.format(base.getCheckout()) + ""));

			String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_91", String.valueOf(base.getStatus()));
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(strStatus == null ? "" : strStatus + ""));

			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getNumberOfLate() == null ? "" : base.getNumberOfLate() + ""));

			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getLateForMinutes() == null ? "" : base.getLateForMinutes() + ""));

			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getNumberOfLeave() == null ? "" : base.getNumberOfLeave() + ""));

			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getLeaveForMinutes() == null ? "" : base.getLeaveForMinutes() + ""));

			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getLateCharge() == null ? "" : base.getLateCharge() + ""));

			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getThingLeaveHours() == null ? "" : base.getThingLeaveHours() + ""));


			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getNornalOvertimeHours() == null ? "" : base.getNornalOvertimeHours() + ""));

			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getWeekendOvertimeHours() == null ? "" : base.getWeekendOvertimeHours() + ""));

			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getHolidayOvertimeHours() == null ? "" : base.getHolidayOvertimeHours() + ""));

			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getOvertimePay() == null ? "" : base.getOvertimePay() + ""));

			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getOvertimePayBefore() == null ? "" : base.getOvertimePayBefore()+ ""));

			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getOvertimePaySub() == null ? "" : base.getOvertimePaySub() + ""));

			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getOvertimePaySubBefore() == null ? "" : base.getOvertimePaySubBefore() + ""));

			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getAdjust() == null ? "" : base.getAdjust() + ""));

			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getAnnualLeave() == null ? "" : base.getAnnualLeave() + ""));

			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getThingLeaveDays() == null ? "" : base.getThingLeaveDays() + ""));

			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getIllLeaveDays() == null ? "" : base.getIllLeaveDays() + ""));

			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getOtherLeaveDays() == null ? "" : base.getOtherLeaveDays() + ""));

			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getOutForBusiness() == null ? "" : base.getOutForBusiness() + ""));

			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getShouldDays() == null ? "" : base.getShouldDays() + ""));


			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getFactDays() == null ? "" : base.getFactDays() + ""));

			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getAbsenceDays() == null ? "" : base.getAbsenceDays() + ""));



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


