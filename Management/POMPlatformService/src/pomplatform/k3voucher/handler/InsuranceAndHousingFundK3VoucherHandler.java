package pomplatform.k3voucher.handler;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.k3voucher.bean.BaseIncomeVoucher;
import pomplatform.k3voucher.bean.BaseInsuranceAndHousingFundK3Voucher;
import pomplatform.k3voucher.bean.ConditionInsuranceAndHousingFundK3Voucher;
import pomplatform.k3voucher.query.QueryInsuranceAndHousingFundK3Voucher;

public class InsuranceAndHousingFundK3VoucherHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(InsuranceAndHousingFundK3VoucherHandler.class);

	public static BaseCollection<BaseInsuranceAndHousingFundK3Voucher> executeQueryInsuranceAndHousingFundK3Voucher(ConditionInsuranceAndHousingFundK3Voucher c, KeyValuePair[] replacements ) throws Exception {
		QueryInsuranceAndHousingFundK3Voucher dao = new QueryInsuranceAndHousingFundK3Voucher();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseInsuranceAndHousingFundK3Voucher> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionInsuranceAndHousingFundK3Voucher c = new ConditionInsuranceAndHousingFundK3Voucher();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseInsuranceAndHousingFundK3Voucher> result = executeQueryInsuranceAndHousingFundK3Voucher(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSON parser = new JSON(new StringReader(creteria)); 
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		String employeeName = BaseHelpUtils.getString(params.get("employeeName"));
		BaseCollection<BaseInsuranceAndHousingFundK3Voucher> result;
		ConditionInsuranceAndHousingFundK3Voucher condition = new ConditionInsuranceAndHousingFundK3Voucher();
		condition.setDataFromMap(params);
		QueryInsuranceAndHousingFundK3Voucher dao = new QueryInsuranceAndHousingFundK3Voucher();
		result = dao.executeQuery(condition.getKeyValues(), condition) ;
		if(null != result && null != result.getCollections() && !result.getCollections().isEmpty()){
			List<BaseInsuranceAndHousingFundK3Voucher> downloadList = result.getCollections();
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String headName = BaseIncomeVoucher.DOWNLOAD_CAPTIONS;
	    	String headNameArra [] = headName.split(",");
	    	String fileName = format.format(date) + "导出的五险一金K3凭证.xls";
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
				BaseInsuranceAndHousingFundK3Voucher bean = downloadList.get(i);
				c.setTime(bean.getVestingDate());
				row = sheet.createRow(i + 1);
				int j = 0;
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(format.format(bean.getVestingDate())));
				
				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString(c.get(Calendar.YEAR) + ""));
				
				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString((c.get(Calendar.MONTH) + 1) + ""));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString("记"));
				
				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getSequenceNumber().toString()));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getCode()));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getName()));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString("RMB"));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString("人民币"));

				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				BigDecimal debitSide = BigDecimal.ZERO;
				BigDecimal creditSide = BigDecimal.ZERO;
				BigDecimal sum = BigDecimal.ZERO;
				if(null != bean.getDebitSide()){
					debitSide = bean.getDebitSide();
				}
				if(null != bean.getCreditSide()){
					creditSide = bean.getCreditSide();
				}
				sum = creditSide.add(debitSide);
				cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(sum, 2).toString()));

				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(debitSide, 2).toString()));

				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(creditSide, 2).toString()));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(employeeName));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString("NONE"));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString("NONE"));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString("NONE"));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(null));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString("*"));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(null));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getSimplifyRemark()));
				
				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString("0"));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString("*"));
				
				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString("0"));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(null));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(format.format(bean.getVestingDate())));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(null));
				
				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString("0"));

				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getSequenceNumber().toString()));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(null));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(null));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString("公司汇率"));
				
				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString("1"));

				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getInternalSequenceNumber().toString()));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(null));
				
				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString("0"));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(null));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(null));
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


