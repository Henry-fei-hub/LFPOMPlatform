package pomplatform.k3voucher.handler;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.common.utils.StaticUtils;
import pomplatform.k3voucher.bean.BaseAllVoucherDetail;
import pomplatform.k3voucher.bean.ConditionAllVoucherDetail;
import pomplatform.k3voucher.query.QueryAllVoucherDetail;

public class DownloadVoucherHandler implements GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(DownloadVoucherHandler.class);
	
	public final String K3_ALL_CAPTIONS = "凭证日期,会计年度,会计期间,凭证字,凭证号,科目代码,科目名称,币别代码,币别名称,原币金额,借方,贷方,制单,审核,核准,出纳,经办,结算方式,结算号,凭证摘要,数量,数量单位,单价,参考信息,业务日期,往来业务编号,附件数,序号,系统模块,业务描述,汇率类型,汇率,分录序号,核算项目,过账,机制凭证,现金流量";
	public final String YON_YOU_ALL_CAPTIONS = "凭证日期,会计年度,会计期间,凭证字,凭证号,科目代码,科目名称,币别代码,币别名称,原币金额,借方,贷方,制单,审核,核准,出纳,经办,结算方式,结算号,凭证摘要,数量,数量单位,单价,参考信息,业务日期,往来业务编号,附件数,序号,系统模块,业务描述,汇率类型,汇率,分录序号,核算项目,过账,机制凭证,现金流量";

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseAllVoucherDetail> result;
		ConditionAllVoucherDetail condition = new ConditionAllVoucherDetail();
		condition.setDataFromJSON(creteria);
		QueryAllVoucherDetail dao = new QueryAllVoucherDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery(condition.getKeyValues(), condition) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery(condition.getKeyValues(), condition) ;
		JSON parser = new JSON(new StringReader(creteria)); 
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		String employeeName = BaseHelpUtils.getString(params.get("employeeName"));
		String downloadType = BaseHelpUtils.getString(params.get("downloadType"));
		List<BaseAllVoucherDetail> downloadList = result.getCollections();
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if(downloadList.size() > 0){
			String[] headNameArra = null;
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
			HSSFWorkbook wb = new HSSFWorkbook();
			switch(downloadType){
			case "k3"://按K3格式导出凭证
				headNameArra = K3_ALL_CAPTIONS.split(",");
				generateK3DownloadData(downloadList, wb, headNameArra, employeeName);
				break;
			case "yonyou"://按用友格式导出凭证
				headNameArra = YON_YOU_ALL_CAPTIONS.split(",");
				generateYonYouDownloadData(downloadList, wb, headNameArra, employeeName);
				break;
			default:
				throw new Exception("导出类型错误");
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

	public void generateK3DownloadData(List<BaseAllVoucherDetail> downloadList, HSSFWorkbook wb, String[] headNameArra, String employeeName) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
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
//		HSSFFont font = wb.createFont();
//		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
//		font.setFontName("宋体");
//		font.setFontHeight((short) 200);
//		cellStyleTitle.setFont(font);
		HSSFSheet sheet = wb.createSheet();
//		ExportExcelUtil exportExcel = new ExportExcelUtil(wb, sheet);
		// 创建报表头部
//		exportExcel.createNormalHead(worksheetTitle, headNameArra.length);
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
		Integer sequenceNumber = null;
		int orderNum = 1;
		for (int i = 0; i < size; i++) {
			BaseAllVoucherDetail bean = downloadList.get(i);
			if(null == sequenceNumber) {
				sequenceNumber = bean.getSequenceNumber();
			}else if(!sequenceNumber.equals(bean.getSequenceNumber())) {
				sequenceNumber = bean.getSequenceNumber();
				orderNum++;
			}
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
			cell.setCellValue(new HSSFRichTextString(orderNum + ""));
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
			cell.setCellValue(new HSSFRichTextString(orderNum + ""));
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
					}else if(Objects.equals(bean.getSecondaryCodeType(), StaticUtils.K3_CODE_TYPE_2)) {
						secondaryName = String.format("分支机构---%1$s---%2$s", bean.getSecondaryCode(), secondaryName);
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
	}
	
	
	public void generateYonYouDownloadData(List<BaseAllVoucherDetail> downloadList, HSSFWorkbook wb, String[] headNameArra, String employeeName) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
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
//		HSSFFont font = wb.createFont();
//		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
//		font.setFontName("宋体");
//		font.setFontHeight((short) 200);
//		cellStyleTitle.setFont(font);
		HSSFSheet sheet = wb.createSheet();
//		ExportExcelUtil exportExcel = new ExportExcelUtil(wb, sheet);
		// 创建报表头部
//		exportExcel.createNormalHead(worksheetTitle, headNameArra.length);
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
			BaseAllVoucherDetail bean = downloadList.get(i);
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
				if(secondaryName.indexOf("---") >= 0) {
					String[] arrs = secondaryName.split("---");
					secondaryName = arrs[arrs.length - 1];
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
	}
	
	
	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


