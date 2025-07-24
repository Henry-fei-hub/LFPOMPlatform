package pomplatform.reimbursement.handler;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
import pomplatform.common.utils.StaticUtils;
import pomplatform.reimbursement.bean.BaseK3VoucherList;
import pomplatform.reimbursement.bean.ConditionK3VoucherList;
import pomplatform.reimbursement.query.QueryK3VoucherList;

public class K3VoucherListHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(K3VoucherListHandler.class);

	public static BaseCollection<BaseK3VoucherList> executeQueryK3VoucherList(ConditionK3VoucherList c, KeyValuePair[] replacements ) throws Exception {
		QueryK3VoucherList dao = new QueryK3VoucherList();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseK3VoucherList> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionK3VoucherList c = new ConditionK3VoucherList();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseK3VoucherList> result = executeQueryK3VoucherList(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSON parser = new JSON(new StringReader(creteria)); 
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		List<BaseK3VoucherList> downloadList = new ArrayList<>();
		String employeeName = null;
		for(String key : params.keySet()){
			if(key.equals("employeeName")){
				employeeName = BaseHelpUtils.getString(params.get(key));
			}else{
				ConditionK3VoucherList c = new ConditionK3VoucherList();
				c.setReimbursementPackageCode(BaseHelpUtils.getString(params.get(key)));
				QueryK3VoucherList dao = new QueryK3VoucherList();
				BaseCollection<BaseK3VoucherList> bc = dao.executeQuery(null, c);
				if(null != bc && null != bc.getCollections()){
					downloadList.addAll(bc.getCollections());
				}
			}
		}
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if(downloadList.size() > 0){
			String headName = BaseK3VoucherList.ALL_CAPTIONS;
	    	String headNameArra [] = headName.split(",");
	    	String fileName = format.format(date) + "导出的报销凭证.xls";
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
				BaseK3VoucherList bean = downloadList.get(i);
				c.setTime(bean.getVestingDate());
				row = sheet.createRow(i + 1);
				int j = 0;
				
				//凭证日期
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(format.format(bean.getVestingDate())));
				//会计年度
				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString(c.get(Calendar.YEAR) + ""));
				//会计期间
				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString((c.get(Calendar.MONTH) + 1) + ""));
				//凭证字
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString("记"));
				//凭证号
				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getSequenceNumber().toString()));
				//科目代码
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getCode()));
				//科目名称
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getName()));
				//币别代码
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString("RMB"));
				//币别名称
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString("人民币"));
				
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
				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				//原币金额
				cell.setCellValue(BaseHelpUtils.format(sum, 2).doubleValue());
				//借方
				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(BaseHelpUtils.format(debitSide, 2).doubleValue());
				//贷方
				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(BaseHelpUtils.format(creditSide, 2).doubleValue());
				//制单
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(employeeName));
				//审核	核准	出纳 经办
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
				//结算方式
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString("*"));
				//结算号
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(null));
				//凭证摘要
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getSimplifyRemark()));
				//数量
				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString("0"));
				//数量单位
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString("*"));
				//单价
				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString("0"));
				//单价
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(null));
				//业务日期
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(format.format(bean.getVestingDate())));
				//往来业务编号
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(null));
				//附件数
				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString("0"));
				//序号
				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getSequenceNumber().toString()));
				//系统模块	业务描述
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(null));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(null));
				//汇率类型
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString("公司汇率"));
				//汇率
				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString("1"));
				//分录序号
				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getInternalSequenceNumber().toString()));
				//核算项目
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				String secondaryName = bean.getSecondaryName();
				if(!BaseHelpUtils.isNullOrEmpty(secondaryName)) {
					if(secondaryName.indexOf("---") < 0) {
						if(Objects.equals(bean.getSecondaryCodeType(), StaticUtils.K3_CODE_TYPE_1)) {
							secondaryName = String.format("职员---%1$s---%2$s", bean.getSecondaryCode(), secondaryName);
						}else if(Objects.equals(bean.getSecondaryCodeType(), StaticUtils.K3_CODE_TYPE_8)) {
							secondaryName = String.format("供应商---%1$s---%2$s", bean.getSecondaryCode(), secondaryName);
						}else if(Objects.equals(bean.getSecondaryCodeType(), StaticUtils.K3_CODE_TYPE_9)) {
							secondaryName = String.format("客户---%1$s---%2$s", bean.getSecondaryCode(), secondaryName);
						}
					}
				}
				cell.setCellValue(new HSSFRichTextString(secondaryName));
				//过账
				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString("0"));
				//机制凭证

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(null));
				//现金流量

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


