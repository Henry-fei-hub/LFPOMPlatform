package pomplatform.attachment.handler;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import delicacy.system.executor.SelectValueCache;
import pomplatform.attachment.bean.BaseOnLoadAttachmentDataOfAttachment;
import pomplatform.attachment.bean.ConditionOnLoadAttachmentDataOfAttachment;
import pomplatform.attachment.query.QueryOnLoadAttachmentDataOfAttachment;

public class OnLoadAttachmentDataOfAttachmentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadAttachmentDataOfAttachmentHandler.class);

	public static BaseCollection<BaseOnLoadAttachmentDataOfAttachment> executeQueryOnLoadAttachmentDataOfAttachment(ConditionOnLoadAttachmentDataOfAttachment c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadAttachmentDataOfAttachment dao = new QueryOnLoadAttachmentDataOfAttachment();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadAttachmentDataOfAttachment> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadAttachmentDataOfAttachment c = new ConditionOnLoadAttachmentDataOfAttachment();
		c.setDataFromJSON(creteria);
		c.setEmployeeId(null);
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String reSql = "AND a.contract_id IN (SELECT contract_id FROM projects WHERE project_manage_id in (replace))";
		KeyValuePair kv = new KeyValuePair();
		int type = BaseHelpUtils.getIntValue(result, "type");
		int checkEmployeeId = BaseHelpUtils.getIntValue(result, "checkEmployeeId");
		if(type == 1){
			if(checkEmployeeId > 0){
				kv.setKey("replace");
				kv.setValue(checkEmployeeId + "");
			}else{
				kv.setKey(reSql);
				kv.setValue("");
			}
		}else if(type == 2){
			if(checkEmployeeId > 0){
				kv.setKey("replace");
				kv.setValue(checkEmployeeId + "");
			}else{
				//获取业务部门信息
				String plateIds = BaseHelpUtils.getStringValue(result, "plateIds");
				if(!BaseHelpUtils.isNullOrEmpty(plateIds)) {
					kv.setKey(reSql);
					kv.setValue("AND a.contract_id IN (SELECT contract_id FROM projects WHERE plate_id in ("+plateIds+"))");
				}else {
					kv.setKey("replace");
					kv.setValue(checkEmployeeId + "");
				}
			}
		}else if(type == 3){
			kv.setKey("replace");
			kv.setValue(checkEmployeeId + "");
		}
		KeyValuePair[] replacements = new KeyValuePair[3];
		replacements[0] = kv;
		
		KeyValuePair kv1 = new KeyValuePair();
		kv1.setKey("replce11");
		if (null!=result.get("contractStatusM")) {
			kv1.setValue(" b.contract_status in "+BaseHelpUtils.getString(result.get("contractStatusM")));
		}else{
			kv1.setValue(" 1=1");
		}
		replacements[1] = kv1;
		
		KeyValuePair kv2 = new KeyValuePair();
		kv2.setKey("replce12");
		if(null == result.get("checkAmount")){
			kv2.setValue(" 1 = 1 ");
		}else{
			boolean checkAmount = BaseHelpUtils.getBoolean(result.get("checkAmount"));
			if(checkAmount){
				kv2.setValue(" ( A.return_amount = C.invoice_amount AND A.return_amount > 0 ) ");
			}else{
				kv2.setValue(" ( A.return_amount <> C.invoice_amount OR A.return_amount ISNULL OR C.invoice_amount ISNULL )");
			}
		}
		replacements[2] = kv2;
		
		c.setKeyValues(replacements);
		
		BaseCollection<BaseOnLoadAttachmentDataOfAttachment> resultData = executeQueryOnLoadAttachmentDataOfAttachment(c, c.getKeyValues());
		return resultData.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ConditionOnLoadAttachmentDataOfAttachment c = new ConditionOnLoadAttachmentDataOfAttachment();
		c.setDataFromJSON(creteria);
		c.setEmployeeId(null);
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String reSql = "AND a.contract_id IN (SELECT contract_id FROM projects WHERE project_manage_id in (replace))";
		KeyValuePair kv = new KeyValuePair();
		int type = BaseHelpUtils.getIntValue(result, "type");
		int checkEmployeeId = BaseHelpUtils.getIntValue(result, "checkEmployeeId");
		int employeeId = BaseHelpUtils.getIntValue(result, "employeeId");
		if(type == 1){
			if(checkEmployeeId > 0){
				kv.setKey("replace");
				kv.setValue(checkEmployeeId + "");
			}else{
				kv.setKey(reSql);
				kv.setValue("");
			}
		}else if(type == 2){
			if(checkEmployeeId > 0){
				kv.setKey("replace");
				kv.setValue(checkEmployeeId + "");
			}else{
				List<BaseEmployee> list = new ArrayList<>();
				Employee emDao = new Employee();
				emDao.setEmployeeId(employeeId);
				if(emDao.load()){
					Integer departmentId = emDao.getDepartmentId();
					if(null != departmentId){
						emDao.clear();
						list = emDao.conditionalLoad(" department_id in (SELECT child_id FROM department_ids WHERE department_id = " + departmentId + ")");
						
					}
				}
				String ids = "";
				for (int i = 0; i < list.size(); i++) {
					if(i != 0){
						ids += ",";
					}
					ids += list.get(i).getEmployeeId();
				}
				kv.setKey("replace");
				kv.setValue(ids);
			}
		}else if(type == 3){
			kv.setKey("replace");
			kv.setValue(checkEmployeeId + "");
		}
		KeyValuePair[] replacements = new KeyValuePair[3];
		replacements[0] = kv;
		
		KeyValuePair kv1 = new KeyValuePair();
		kv1.setKey("replce11");
		if (null!=result.get("contractStatusM")) {
			kv1.setValue(" b.contract_status in "+BaseHelpUtils.getString(result.get("contractStatusM")));
		}else{
			kv1.setValue(" 1=1");
		}
		replacements[1] = kv1;
		
		KeyValuePair kv2 = new KeyValuePair();
		kv2.setKey("replce12");
		if(null == result.get("checkAmount")){
			kv2.setValue(" 1 = 1 ");
		}else{
			boolean checkAmount = BaseHelpUtils.getBoolean(result.get("checkAmount"));
			if(checkAmount){
				kv2.setValue(" ( A.return_amount = C.invoice_amount AND A.return_amount > 0 ) ");
			}else{
				kv2.setValue(" ( A.return_amount <> C.invoice_amount OR A.return_amount ISNULL OR C.invoice_amount ISNULL )");
			}
		}
		replacements[2] = kv2;
		c.setKeyValues(replacements);
		c.setCurrentPage(0);
		c.setPageLines(1);
		
		BaseCollection<BaseOnLoadAttachmentDataOfAttachment> resultData = executeQueryOnLoadAttachmentDataOfAttachment(c, c.getKeyValues());
		List<BaseOnLoadAttachmentDataOfAttachment> list = resultData.getCollections();
		if(list.size() > 0){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd ");
			String headName = BaseOnLoadAttachmentDataOfAttachment.ALL_CAPTIONS;
	    	String headNameArra [] = headName.split(",");
	    	String fileName = sdf1.format(new Date()) + "确认函列表.xls";
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
			cellStyleTitle.setWrapText(true);
			// ------------------------------------------------------------------
			HSSFCellStyle cellStyle = wb.createCellStyle();
			// 指定单元格居中对齐
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			// 指定单元格垂直居中对齐
			cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			// 指定当单元格内容显示不下时自动换行
			cellStyle.setWrapText(true);
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
			for (int i = 0; i < list.size(); i++) {
				BaseOnLoadAttachmentDataOfAttachment baseAttachment = list.get(i);
				row = sheet.createRow(i + 1);

				cell = row.createCell(0);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(baseAttachment.getAttachmentCode()));

				cell = row.createCell(1);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString("http://erp.jaid.cn" + baseAttachment.getAttachmentAddress()));

				cell = row.createCell(2);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(baseAttachment.getPerfessionRemark()));

				cell = row.createCell(3);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(baseAttachment.getAmount(), 2) + ""));

				cell = row.createCell(4);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(baseAttachment.getReturnAmount(), 2) + ""));
				
				cell = row.createCell(5);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(BaseHelpUtils.format(baseAttachment.getInvoiceAmount(), 2) + ""));
				
				cell = row.createCell(6);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString((null != baseAttachment.getPaymentSure() && baseAttachment.getPaymentSure()) ? "是" : "否"));
				
				cell = row.createCell(7);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(baseAttachment.getPaymentGradeDescription()));
				
				String employeeName = SelectValueCache.getSelectValue("employees", baseAttachment.getOperateEmployeeId() + "");
				cell = row.createCell(8);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(employeeName));
				
				cell = row.createCell(9);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(sdf.format(baseAttachment.getOperateTime())));
				
				cell = row.createCell(10);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(baseAttachment.getRemark()));
				
				cell = row.createCell(11);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(null != baseAttachment.getHaveVoucher() && baseAttachment.getHaveVoucher() ? "有" : "无"));
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
		
		
//		BaseCollection<BaseOnLoadAttachmentDataOfAttachment> result;
//		ConditionOnLoadAttachmentDataOfAttachment c = new ConditionOnLoadAttachmentDataOfAttachment();
//		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
//		QueryOnLoadAttachmentDataOfAttachment dao = new QueryOnLoadAttachmentDataOfAttachment();
//		dao.setCurrentPage(1);
//		dao.setPageLines(1);
//		result = dao.executeQuery( c.getKeyValues(), c) ;
//		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
//			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
//		}
//		dao.setCurrentPage(0);
//		result = dao.executeQuery( c.getKeyValues(), c) ;
//		try(PrintStream ps = new PrintStream(downFile, "GBK")){
//			ps.println(BaseOnLoadAttachmentDataOfAttachment.ALL_CAPTIONS);
//			for(BaseOnLoadAttachmentDataOfAttachment b : result.getCollections()){
//				ps.println(b.toCSVString());
//			}
//		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


