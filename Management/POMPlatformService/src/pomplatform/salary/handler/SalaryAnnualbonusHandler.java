package pomplatform.salary.handler;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
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
import pomplatform.salary.bean.BaseSalaryAnnualbonus;
import pomplatform.salary.bean.ConditionSalaryAnnualbonus;
import pomplatform.salary.query.QuerySalaryAnnualbonus;

public class SalaryAnnualbonusHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SalaryAnnualbonusHandler.class);

	public static BaseCollection<BaseSalaryAnnualbonus> executeQuerySalaryAnnualbonus(ConditionSalaryAnnualbonus c, KeyValuePair[] replacements ) throws Exception {
		QuerySalaryAnnualbonus dao = new QuerySalaryAnnualbonus();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSalaryAnnualbonus> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSalaryAnnualbonus c = new ConditionSalaryAnnualbonus();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSalaryAnnualbonus> result = executeQuerySalaryAnnualbonus(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSalaryAnnualbonus> result;
		ConditionSalaryAnnualbonus c = new ConditionSalaryAnnualbonus();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySalaryAnnualbonus dao = new QuerySalaryAnnualbonus();
		dao.setCurrentPage(0);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		List<BaseSalaryAnnualbonus> list = result.getCollections();
		String headName = BaseSalaryAnnualbonus.CAPTIONS;
    	String headNameArra [] = headName.split(",");
		
    	String fileName = c.getYear() + "年终奖报税明细" + ".xls";
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
		
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
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
			BaseSalaryAnnualbonus base = list.get(i);
			int index = 0;
			row = sheet.createRow(i + 1);
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(base.getBankAccount() == null ? "" : base.getBankAccount()));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(base.getEmployeeNo() == null ? "" : base.getEmployeeNo()));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(base.getEmployeeName() == null ? "" : base.getEmployeeName()));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(base.getCard() == null ? "" : base.getCard()));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(base.getMobile() == null ? "" : base.getMobile()));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getYear() == null ? "" : base.getYear().toString()));
			
			String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("company_records", String.valueOf(base.getCompanyId()));
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(strCompanyId));
			
			String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(base.getPlateId()));
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(strPlateId));
			
			String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("all_departments", String.valueOf(base.getDepartmentId()));
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(strDepartmentId));
			
			
			String OnboardStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_96", String.valueOf(base.getOnboardStatus()));
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(OnboardStatus));
			
			//入职日期
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
//			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getOnboardDate() == null ? "" : sdf.format(base.getOnboardDate())));
			
			//转正日期
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
//			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getPositiveDate() == null ? "" : sdf.format(base.getPositiveDate())));
			
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getOneToThreeRest() == null ? "" : base.getOneToThreeRest()));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getProgramBonus() == null ? "" : base.getProgramBonus()));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getYearPerformanceBonus() == null ? "" : base.getYearPerformanceBonus()));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getHousingSubsidy() == null ? "" : base.getHousingSubsidy()));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getTransferAccountMoney() == null ? "" : base.getTransferAccountMoney()));
			
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getSalaryDiffDeduct() == null ? "" : base.getSalaryDiffDeduct()));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getDeductPerformanceBonus() == null ? "" : base.getDeductPerformanceBonus()));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getDepositDeduct() == null ? "" : base.getDepositDeduct()));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getReimbursementDeduct() == null ? "" : base.getReimbursementDeduct()));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getOtherDeduct() == null ? "" : base.getOtherDeduct()));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getShouldTotal() == null ? "" : base.getShouldTotal()));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getAlreadyBonus() == null ? "" : base.getAlreadyBonus()));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getShouldTaxAchieve() == null ? "" : base.getShouldTaxAchieve()));
		
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(base.getShouldTax(), 2) + ""));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getInsteadDeduct() == null ? "" : base.getInsteadDeduct()));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getFactBonus() == null ? "" : base.getFactBonus()));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(base.getSendTime() == null ? "" : sdf.format(base.getSendTime())));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(base.getIsSended() == null ? "" : base.getIsSended().toString()));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(base.getRemark() == null ? "" : base.getRemark().toString()));
			
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
		
		
//		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
//			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
//		}
//		dao.setCurrentPage(0);
//		result = dao.executeQuery( c.getKeyValues(), c) ;
//		try(PrintStream ps = new PrintStream(downFile, "GBK")){
//			ps.println(BaseSalaryAnnualbonus.ALL_CAPTIONS);
//			for(BaseSalaryAnnualbonus b : result.getCollections()){
//				ps.println(b.toCSVString());
//			}
//		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


