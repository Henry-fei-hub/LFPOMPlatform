package pomplatform.payment.handler;

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
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import pomplatform.payment.bean.BaseOnSalaryTotalData;
import pomplatform.payment.bean.ConditionOnSalaryTotalData;
import pomplatform.payment.query.QueryOnSalaryTotalData;

public class OnSalaryTotalDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnSalaryTotalDataHandler.class);

	public static BaseCollection<BaseOnSalaryTotalData> executeQueryOnSalaryTotalData(ConditionOnSalaryTotalData c, KeyValuePair[] replacements ) throws Exception {
		QueryOnSalaryTotalData dao = new QueryOnSalaryTotalData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnSalaryTotalData> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnSalaryTotalData c = new ConditionOnSalaryTotalData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnSalaryTotalData> result = executeQueryOnSalaryTotalData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnSalaryTotalData> result;
		ConditionOnSalaryTotalData c = new ConditionOnSalaryTotalData();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnSalaryTotalData dao = new QueryOnSalaryTotalData();
		dao.setCurrentPage(0);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		List<BaseOnSalaryTotalData> list = result.getCollections();
		String headName = BaseOnSalaryTotalData.ALL_CAPTIONS;
    	String headNameArra [] = headName.split(",");
		
    	String fileName = c.getYear() + "年" + c.getMonth() + "月报税明细" + ".xls";
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
			BaseOnSalaryTotalData base = list.get(i);
			int index = 0;
			row = sheet.createRow(i + 1);
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(base.getEmployeeNo() == null ? "" : base.getEmployeeNo()));

			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(base.getEmployeeName() == null ? "" : base.getEmployeeName()));
			
			String gender = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_12", String.valueOf(base.getGender()));
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(gender));
		
			Date onboardDate = base.getOnboardDate();
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(onboardDate == null ? "" : sdf.format(onboardDate));
			
			Date positiveDate = base.getPositiveDate();
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(positiveDate == null ? "" : sdf.format(positiveDate));
			
			Date resignationDate = base.getResignationDate();
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(resignationDate == null ? "" : sdf.format(resignationDate));
		
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(base.getCard() == null ? "" : base.getCard()));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(base.getMobile() == null ? "" : base.getMobile()));
			
			String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("company_records", String.valueOf(base.getCompanyId()));
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(strCompanyId));
			
			String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(base.getPlateId()));
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(strPlateId));
			
			String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(base.getDepartmentId()));
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString(strDepartmentId));

			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getYear() == null ? "" : base.getYear().toString()));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(base.getMonth() == null ? "" : base.getMonth().toString()));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(base.getShouldSalary(), 2) + ""));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(base.getShouldBonus(), 2) + ""));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(base.getAlreadyBonus(), 2) + ""));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(base.getOtherBonus(), 2) + ""));
			
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(base.getShouldTaxAchieve(), 2) + ""));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(base.getTaxTotal(), 2) + ""));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(base.getDeductTax(), 2) + ""));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(base.getShouldTax(), 2) + ""));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(base.getTotalFund(), 2) + ""));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(base.getInsteadDeductIll(), 2) + ""));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(base.getPersonalPension(), 2) + ""));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(base.getPersonalMedicalInsurance(), 2) + ""));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(base.getPersonalLargeMedicalInsurance(), 2) + ""));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(base.getPersonalSeriousIllInsurance(), 2) + ""));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(base.getPersonalUnemploymentInsurance(), 2) + ""));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(base.getPersonalHeating(), 2) + ""));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(base.getTotalInsurance(), 2) + ""));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(base.getSpecialDuduct1(), 2) + ""));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(base.getSpecialDuduct2(), 2) + ""));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(base.getSpecialDuduct3(), 2) + ""));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(base.getSpecialDuduct4(), 2) + ""));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(base.getSpecialDuduct5(), 2) + ""));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(base.getSpecialDuduct6(), 2) + ""));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(base.getSpecialAdditionalDuduct(), 2) + ""));
			
			cell = row.createCell(index++);
			cell.setCellStyle(cellStyle1);
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(base.getSpecialDuductSum(), 2) + ""));

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
//			ps.println(BaseOnSalaryTotalData.ALL_CAPTIONS);
//			for(BaseOnSalaryTotalData b : result.getCollections()){
//				ps.println(b.toCSVString());
//			}
//		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


