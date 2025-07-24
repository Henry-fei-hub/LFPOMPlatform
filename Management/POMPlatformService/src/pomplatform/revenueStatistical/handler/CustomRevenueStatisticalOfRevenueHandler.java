package pomplatform.revenueStatistical.handler;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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

import com.pomplatform.db.bean.BaseProjectStage;
import com.pomplatform.db.bean.BaseRevenueStatisticalRecord;
import com.pomplatform.db.dao.ProjectStage;
import com.pomplatform.db.dao.RevenueStatisticalRecord;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.KeyValuePair;
import delicacy.date.util.DateUtil;
import pomplatform.common.utils.StaticUtils;
import pomplatform.revenueStatistical.bean.BaseRevenueStatisticalOfRevenue;
import pomplatform.revenueStatistical.bean.ConditionRevenueStatisticalOfRevenue;
import pomplatform.revenueStatistical.query.CustomQueryRevenueStatisticalOfRevenue;
import pomplatform.revenueStatistical.query.QueryRevenueStatisticalOfRevenue;

public class CustomRevenueStatisticalOfRevenueHandler extends RevenueStatisticalOfRevenueHandler {

	private static final Logger __logger = Logger.getLogger(CustomRevenueStatisticalOfRevenueHandler.class);

	public static BaseCollection<BaseRevenueStatisticalOfRevenue> executeQueryRevenueStatisticalOfRevenue(ConditionRevenueStatisticalOfRevenue c, KeyValuePair[] replacements ) throws Exception {
		return getResult(c);
	}
	
	public static BaseCollection<BaseRevenueStatisticalOfRevenue> getResult(ConditionRevenueStatisticalOfRevenue c) throws SQLException, ParseException{
		//获取年份和月份
		int year = c.getYear();
		int month = c.getMonth();
		//检索当前年月份的数据是否加锁
		RevenueStatisticalRecord rdDao = new RevenueStatisticalRecord();
		rdDao.setConditionYear("=",year);
		rdDao.setConditionMonth("=",month);
		rdDao.setConditionIsLocked("=",Boolean.TRUE);
		if(rdDao.isExist()){//说明有加锁
			CustomQueryRevenueStatisticalOfRevenue cDao = new CustomQueryRevenueStatisticalOfRevenue();
			cDao.setCurrentPage(c.getCurrentPage());
			cDao.setPageLines(c.getPageLines());
			BaseCollection<BaseRevenueStatisticalOfRevenue> result = cDao.executeQuery( c.getKeyValues(), c) ;
			if(!BaseHelpUtils.isNullOrEmpty(result)){
				for(BaseRevenueStatisticalOfRevenue e : result.getCollections()){
					e.setSheetPercentStr(getPercent(e.getSheetPercent()));
					e.setModifyPercentStr(getPercent(e.getModifyPercent()));
					e.setTotalPercentStr(getPercent(e.getTotalPercent()));
				}
			}
			return result;
		}
		QueryRevenueStatisticalOfRevenue dao = new QueryRevenueStatisticalOfRevenue();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR,year);
		calendar.set(Calendar.MONTH,month-1);
		calendar.set(Calendar.DATE, 1);
		//获取截止日期
		Date endDate = calendar.getTime();
		//设置为月最后一天
		endDate = DateUtil.getLastDay(endDate);
		c.setEndDate(endDate);
		BaseCollection<BaseRevenueStatisticalOfRevenue> result = dao.executeQuery( c.getKeyValues(), c) ;
		//检索上一月的年度营收表数据集
		RevenueStatisticalRecord revenueDao = new RevenueStatisticalRecord();
		if(month==1){
			revenueDao.setConditionYear("=",year-1);
			revenueDao.setConditionMonth("=",12);
		}else{
			revenueDao.setConditionYear("=",year);
			revenueDao.setConditionMonth("=",month-1);
		}
		List<BaseRevenueStatisticalRecord> listBeans = revenueDao.conditionalLoad();
		//如果不为空，则检索本月营收的数据为空，则说明本月未保存营收的数据，则以订单积分确认的完工比为准
		if(!BaseHelpUtils.isNullOrEmpty(result)){
			//获取当前日期的年月份
			Date date = new Date();
			int currentYear = DateUtil.getYear(date);
			int currentMonth = DateUtil.getMonth(date);
			ProjectStage psDao = new ProjectStage();
			for(BaseRevenueStatisticalOfRevenue e : result.getCollections()){
				e.setYear(year);
				e.setMonth(month);
				//获取订单id
				int projectId = e.getProjectId();
				//如果当前计算年月就是计算年月，则订单合同金额和项目积分都是以订单表的最新数据为准
				BigDecimal oldSheetAmount = BaseHelpUtils.getBigDecimalValue(e.getOldSheetAmount());
				BigDecimal newSheetAmonut = BaseHelpUtils.getBigDecimalValue(e.getSheetAmount());
				BigDecimal oldProjectIntegral = BaseHelpUtils.getBigDecimalValue(e.getOldProjectIntegral());
				BigDecimal newProjectIntegral = BaseHelpUtils.getBigDecimalValue(e.getProjectIntegral());
				//设置订单的合同金额和项目积分
				BigDecimal sheetAmount = BigDecimal.ZERO;
				BigDecimal projectIntegral = BigDecimal.ZERO;
				if(year == currentYear && month == currentMonth){//说明是计算当月数据
					sheetAmount = oldSheetAmount;
					projectIntegral = oldProjectIntegral;
				}else{
					sheetAmount = newSheetAmonut.compareTo(BigDecimal.ZERO)==0?oldSheetAmount:newSheetAmonut;
					projectIntegral = newProjectIntegral.compareTo(BigDecimal.ZERO)==0?oldProjectIntegral:newProjectIntegral;
				}
				e.setSheetAmount(sheetAmount);
				e.setProjectIntegral(projectIntegral);
				//获取订单确认积分
				BigDecimal sureIntegral = BaseHelpUtils.getBigDecimalValue(e.getSureIntegral());
				//设置订单确认的百分比=确认积分/项目积分
				BigDecimal sheetPercent = projectIntegral.compareTo(BigDecimal.ZERO)==0?BigDecimal.ZERO:sureIntegral.divide(projectIntegral, 4,BigDecimal.ROUND_HALF_UP);
				//如果订单生成百分比大于1，则设置为1
				if(sheetPercent.compareTo(BigDecimal.ONE) > 0){
					sheetPercent = BigDecimal.ONE;
				}
				//加载订单的累计确认百分比
				psDao.clear();
				psDao.setConditionProjectId("=",projectId);
				List<BaseProjectStage> psList = psDao.conditionalLoad(" order by "+BaseProjectStage.CS_PROJECT_STAGE_ID);
				//初始累计确认百分比为0
				BigDecimal totalSurePercent = BigDecimal.ZERO;
				if(!BaseHelpUtils.isNullOrEmpty(psList) && psList.size() > 0){
					for(BaseProjectStage psBean : psList){
						//获取阶段比例
						BigDecimal stagePercent = BaseHelpUtils.getBigDecimalValue(psBean.getPercent()).divide(BigDecimal.valueOf(100));
						stagePercent = stagePercent.add(totalSurePercent);
						if(sheetPercent.compareTo(stagePercent) >= 0){
							totalSurePercent = stagePercent.multiply(BigDecimal.valueOf(100));
						}else{
							break;
						}
					}
				}
    			//设置累计确认营收=累计百分比*订单合同金额/1.06
    			BigDecimal totalSureRevenue = totalSurePercent.multiply(sheetAmount).divide(BigDecimal.valueOf(106),2,BigDecimal.ROUND_DOWN);
    			e.setTotalSurePercentStr(totalSurePercent+"%");
    			e.setTotalSureRevenue(totalSureRevenue);
				//获取税率
				BigDecimal ratePercent = e.getRatePercent()==null?BigDecimal.valueOf(1.06):e.getRatePercent();
				e.setSheetPercentStr(getPercent(sheetPercent));
				e.setRatePercentStr(getPercent(ratePercent));
				//设置本月营收，即当月累计营收-上月累计营收
				Map<String,Object> map = getLastRevenue(listBeans, month, projectId);
				//获取上月累计营收
				BigDecimal lastRevenue = BaseHelpUtils.getBigDecimalValue(map.get("lastRevenue"));
				//获取上月运营调节百分比
				BigDecimal lastModifyPercent = BigDecimal.ZERO;
				BigDecimal modifyPercent = e.getModifyPercent()==null?BigDecimal.ZERO:e.getModifyPercent();
				//如果是16年之前的数据则累计百分比不变化
				if(year < 2016){
					BigDecimal totalPercent = e.getTotalPercent()==null?BigDecimal.ZERO:e.getTotalPercent();
					e.setModifyPercentStr(getPercent(modifyPercent));
					e.setTotalPercentStr(getPercent(totalPercent));
				//从2016年开始，如果上月运营调节百分比不为0，则本月的运营调节百分比为上月的运营调节百分比
				}else{
					lastModifyPercent = BaseHelpUtils.getBigDecimalValue(map.get("lastModifyPercent"));
					//获取本月运营调节百分比，if本月运营调节百分比大于0，则以本月运营调节百分比为准，else再看上月运营调节百分比，如果上月运营调节百分比大于0，则以上月运营调节百分比为准，否则以当月订单生成百分比为准
					//如果本月运营调节百分比大于0且上月运营调节百分比小于100，以本月运营调节百分比为准
					if(modifyPercent.compareTo(BigDecimal.ZERO) > 0 && lastModifyPercent.compareTo(new BigDecimal("100")) < 0){
						e.setModifyPercentStr(getPercent(modifyPercent));
						e.setTotalPercent(modifyPercent);
						e.setTotalPercentStr(getPercent(modifyPercent));
					}else{
						if(lastModifyPercent.compareTo(BigDecimal.ZERO) > 0){//以上月运营调节百分比为准
							e.setModifyPercent(lastModifyPercent);
							e.setModifyPercentStr(getPercent(lastModifyPercent));
							e.setTotalPercent(lastModifyPercent);
							e.setTotalPercentStr(getPercent(lastModifyPercent));
						}else{//以本月订单生成百分比为准
							e.setModifyPercent(BigDecimal.ZERO);
							e.setModifyPercentStr(getPercent(BigDecimal.ZERO));
							e.setTotalPercent(sheetPercent);
							e.setTotalPercentStr(getPercent(sheetPercent));
						}
					}
				}
				
				//获取最终计算的百分比
				BigDecimal totalPercent = e.getTotalPercent()==null?BigDecimal.ZERO:e.getTotalPercent();
				//设置累计含税营收，即订单金额*累计百分比（订单生成百分比）
				BigDecimal totalTaxRevenue = BaseHelpUtils.format(sheetAmount.multiply(totalPercent),2);
				e.setTotalTaxRevenue(totalTaxRevenue);
				//设置累计营收(不含税营收)，即累计含税营收/税率
				e.setTotalRevenue(sheetAmount.multiply(totalPercent).divide(ratePercent,2,BigDecimal.ROUND_DOWN));
				e.setCurrentRevenue(e.getTotalRevenue().subtract(lastRevenue));
				//设置上月累计营收
				e.setLastMonthRevenue(lastRevenue);
				
				//计算合同存量 = (订单金额 - 累计含税营收) / 1.6
				BigDecimal contractSave = (sheetAmount.subtract(totalTaxRevenue)).divide(BigDecimal.valueOf(1.06),2,BigDecimal.ROUND_DOWN);
				e.setContractSave(contractSave);
				switch(BaseHelpUtils.getIntValue(e.getStatus())) {
				case StaticUtils.PROJECT_STATUS_2:
				case StaticUtils.PROJECT_STATUS_5:
					e.setContractSaveActive(contractSave);
					break;
				case StaticUtils.PROJECT_STATUS_16:
				case StaticUtils.PROJECT_STATUS_17:
					e.setContractSaveActiveUn(contractSave);
					break;
				case StaticUtils.PROJECT_STATUS_10:
					e.setContractSaveActivePause(contractSave);
					break;
				case StaticUtils.PROJECT_STATUS_4:
					e.setContractSaveActiveNever(contractSave);
					break;
				case StaticUtils.PROJECT_STATUS_11:
				case StaticUtils.PROJECT_STATUS_13:
				case StaticUtils.PROJECT_STATUS_14:
				case StaticUtils.PROJECT_STATUS_15:
				case StaticUtils.PROJECT_STATUS_18:
					e.setContractSaveOther(contractSave);
					break;
				default:
					break;
				}
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionRevenueStatisticalOfRevenue c = new ConditionRevenueStatisticalOfRevenue();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseRevenueStatisticalOfRevenue> result = executeQueryRevenueStatisticalOfRevenue(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ConditionRevenueStatisticalOfRevenue c = new ConditionRevenueStatisticalOfRevenue();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseRevenueStatisticalOfRevenue> result = getResult(c) ;
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if(!BaseHelpUtils.isNullOrEmpty(result)){
			String headName = BaseRevenueStatisticalOfRevenue.CUSTOM_CAPTIONS;
	    	String headNameArra [] = headName.split(",");
	    	String fileName = format.format(date) + "导出的营收统计.xls";
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
			List<BaseRevenueStatisticalOfRevenue> downloadList = result.getCollections();
			int size = downloadList.size();
			for (int i = 0; i < size; i++) {
				BaseRevenueStatisticalOfRevenue bean = downloadList.get(i);
				row = sheet.createRow(i + 1);
				int j = 0;
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(bean.getPlateId()))));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getSheetCode()+""));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getSheetName() + ""));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getYear()+""));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getMonth()+""));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getSheetAmount()+""));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getRatePercentStr()));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getSheetPercentStr()));

				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getModifyPercentStr() + ""));

				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getTotalPercentStr()+ ""));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getTotalTaxRevenue()+""));

				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getTotalRevenue() + ""));

				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getCurrentRevenue() + ""));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getTotalSurePercentStr()));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getTotalSureRevenue()+""));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getContractSave()+""));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getContractSaveActive()+""));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getContractSaveActiveUn()+""));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getContractSaveActivePause()+""));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getContractSaveActiveNever()+""));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_4", String.valueOf(bean.getStatus()))));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(bean.getProjectManageId()))));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				Map<Integer,String> map = new HashMap<>();
				map.put(1,"已保存");
				map.put(2,"未保存");
				cell.setCellValue(new HSSFRichTextString(map.get(bean.getFlag())));
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
	
	/**
	 * 获取上月累计营收
	 * @param listBeans
	 * @param month
	 * @param projectId
	 * @return
	 */
	public static Map<String,Object> getLastRevenue(List<BaseRevenueStatisticalRecord> listBeans,int month,int projectId){
		Map<String,Object> map = new HashMap<>();
		//上月累计营收
		BigDecimal lastRevenue = BigDecimal.ZERO;
		//上月运营调节百分比
		BigDecimal lastModifyPercent = BigDecimal.ZERO;
		if(!BaseHelpUtils.isNullOrEmpty(listBeans) && !listBeans.isEmpty()){
			for(BaseRevenueStatisticalRecord e : listBeans){
				if(projectId == e.getProjectId()){
					lastRevenue = e.getTotalRevenue()==null?BigDecimal.ZERO:e.getTotalRevenue();
					lastModifyPercent = e.getModifyPercent()==null?BigDecimal.ZERO:e.getModifyPercent();
					break;
				}
			}
		}
		map.put("lastRevenue", lastRevenue);
		map.put("lastModifyPercent", lastModifyPercent);
		return map;
	}
	
	/**
	 * 获取完工比的字符串格式
	 * @param finishPercent
	 * @return
	 */
	public static String getPercent(BigDecimal finishPercent){
		if(finishPercent == null || finishPercent.compareTo(BigDecimal.ZERO) == 0){
			return "0%";
		}else{
			BigDecimal mul = new BigDecimal(100);
			String finishPercentStr = String.format("%1$s%2$s", finishPercent.multiply(mul).doubleValue(),"%");
			return finishPercentStr;
		}
	}
	
}


