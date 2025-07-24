package com.pomplatform.client.payment.panel;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractPrint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.*;
import com.smartgwt.client.data.Record;

import java.math.BigDecimal;
import java.util.Map;
import java.util.logging.Logger;

public class OnCompanySalaryPanel extends AbstractPrint {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	public static final String[] HEAD_ABELS = {"单位:","日期:","币种:"};

	public static final String[] MAIN_ABELS = { "归属公司","应付工资", "离职补偿","应付奖金","应付合计","代扣个税","代扣社保","代扣公积金","代扣补贴","代扣重疾险","实发工资","工资发放人数","单位社保"};

	public static final String MAIN_TITLE = "工资总表";

	public static DateTimeFormat __DF = DateTimeFormat.getFormat("yyyy-MM-dd");
	public static NumberFormat __NF = NumberFormat.getFormat("##,###,###,###,##0.00");
	public static String _KG = "-　";
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public HTML generatePrintHTML() {
		HTML layout = new HTML();
		layout.setHeight("100%");
		Map map = getPrintData();
		layout.getElement().appendChild(headHtml(HEAD_ABELS, MAIN_TITLE,map).getElement());
		layout.getElement().appendChild(generateMianData().getElement());
		return layout;
	}
	
	/**
	 * 
	 * @Title: headHtml 
	 * @Description: 公用头部
	 * @param @param title
	 * @param @param map
	 * @param @return   
	 * @return VerticalPanel   
	 * @throws
	 */
	public static VerticalPanel headHtml(String [] headAbels, String title,Map<String,Object> map){
		VerticalPanel vl = new VerticalPanel();
		vl.setWidth("100%");
		vl.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vl.setSpacing(10);
		String companyId = ClientUtil.getStringFromMap(map, "companyId");
		int year = BaseHelpUtils.getIntValue(map, "year");
		int month = BaseHelpUtils.getIntValue(map, "month");
		HTML tital = new HTML(title);
		tital.getElement().getStyle().setFontSize(16, Style.Unit.PX);
		tital.getElement().getStyle().setFontWeight(Style.FontWeight.BOLD);
		vl.add(tital);

		FlexTable threeRowTable = new FlexTable();
		threeRowTable.setWidth("100%");
		threeRowTable.setBorderWidth(0);
		threeRowTable.setText(0, 0,"单位:"+KeyValueManager.getValue("system_dictionary_26",companyId+""));
		threeRowTable.setText(0, 1, year+"年"+month+"月");
		threeRowTable.setText(0, 2, "币种:人民币");
		HTMLTable.CellFormatter oneCellFormatter = threeRowTable.getCellFormatter();
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 8; j++) {
				switch (j) {
				case 0:
					oneCellFormatter.setAlignment(i, j, HasHorizontalAlignment.ALIGN_LEFT, HasVerticalAlignment.ALIGN_TOP);
					oneCellFormatter.setWidth(i, j, "50%");
					break;
				case 1:
					oneCellFormatter.setAlignment(i, j, HasHorizontalAlignment.ALIGN_LEFT, HasVerticalAlignment.ALIGN_TOP);
					oneCellFormatter.setWidth(i, j, "30%");
					break;
				case 2:
					oneCellFormatter.setAlignment(i, j, HasHorizontalAlignment.ALIGN_LEFT, HasVerticalAlignment.ALIGN_TOP);
					oneCellFormatter.setWidth(i, j, "20%");
					break;
				}
			}
		}
		vl.add(threeRowTable);
		return vl;
	}

	/**
	 * 
	 * @Title: generateMianData @Description: 主表数据HTML构建 @param @param
	 * map @param @return @return VerticalPanel @throws
	 */
	public VerticalPanel generateMianData() {
		VerticalPanel vl = new VerticalPanel();
		vl.setWidth("100%");
		vl.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vl.setSpacing(10);
		int rows = records.length;
		int cols = MAIN_ABELS.length;
		FlexTable orderItemContent = new FlexTable();
		orderItemContent.setWidth("100%");
		orderItemContent.setCellPadding(0);
		orderItemContent.setCellSpacing(0);
		orderItemContent.setBorderWidth(1);
		orderItemContent.getElement().getStyle().setBorderColor("#000000");
		HTMLTable.CellFormatter cellFormatter = orderItemContent.getCellFormatter();
		// 设置表头
		for (int i = 0; i < cols; i++) {
			orderItemContent.setText(0, i, MAIN_ABELS[i]);
		}
		// 第二行数据
		Integer plateId = 0;
		Integer year = 0;
		Integer month = 0;
		BigDecimal shouldSalary = BigDecimal.ZERO;//应付工资
		BigDecimal leaveAdvance = BigDecimal.ZERO;//离职补偿
		BigDecimal shouldBonus = BigDecimal.ZERO;//应付奖金
		BigDecimal shouldTotal = BigDecimal.ZERO;//应付合计
		BigDecimal shouldTax = BigDecimal.ZERO;//代扣个税
		BigDecimal totalInsurance = BigDecimal.ZERO;//代扣社保
		BigDecimal totalFund = BigDecimal.ZERO;//代扣公积金
		BigDecimal insteadDeduct = BigDecimal.ZERO;//代扣补贴
		BigDecimal insteadDeductIll = BigDecimal.ZERO;//待扣重疾险
		BigDecimal factSalary = BigDecimal.ZERO;//实发工资
		BigDecimal num = BigDecimal.ZERO;//工资发放人数
		BigDecimal unitTotalInsurance = BigDecimal.ZERO;//单位社保

		for(int r = 0;r < rows;r++){
			plateId = BaseHelpUtils.getIntValue(records[r].getAttribute("plateId"));
			String plateName = KeyValueManager.getValue("system_dictionary_1",plateId+"");
			orderItemContent.setText(r+1, 0,plateName);
//
//			year = BaseHelpUtils.getIntValue(records[r].getAttribute("year"));
//			orderItemContent.setText(r+1, 1,year == 0 ?  _KG : __NF.format(year));
//
//			month = BaseHelpUtils.getIntValue(records[r].getAttribute("month"));
//			orderItemContent.setText(r+1, 2,month == 0 ?  _KG : __NF.format(month));

			shouldSalary = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("shouldSalary"));
			orderItemContent.setText(r+1, 1,shouldSalary.compareTo(BigDecimal.ZERO) == 0 ?  "0.00" : __NF.format(shouldSalary));

			leaveAdvance = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("leaveAdvance"));
			orderItemContent.setText(r+1, 2,leaveAdvance.compareTo(BigDecimal.ZERO) == 0 ?  "0.00" : __NF.format(leaveAdvance));

			shouldBonus = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("shouldBonus"));
			orderItemContent.setText(r+1, 3,shouldBonus.compareTo(BigDecimal.ZERO) == 0 ?  "0.00" : __NF.format(shouldBonus));

			shouldTotal = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("shouldTotal"));
			orderItemContent.setText(r+1, 4,shouldTotal.compareTo(BigDecimal.ZERO) == 0 ?  "0.00" :__NF.format(shouldTotal));

			shouldTax = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("shouldTax"));
			orderItemContent.setText(r+1, 5,shouldTax.compareTo(BigDecimal.ZERO) == 0 ?  "0.00" : __NF.format(shouldTax));

			totalInsurance = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("totalInsurance"));
			orderItemContent.setText(r+1, 6,totalInsurance.compareTo(BigDecimal.ZERO) == 0 ?  "0.00" : __NF.format(totalInsurance));

			totalFund = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("totalFund"));
			orderItemContent.setText(r+1, 7,totalFund.compareTo(BigDecimal.ZERO) == 0 ?  "0.00" : __NF.format(totalFund));

			insteadDeduct = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("insteadDeduct"));
			orderItemContent.setText(r+1, 8,insteadDeduct.compareTo(BigDecimal.ZERO) == 0 ?  "0.00" : __NF.format(insteadDeduct));

			insteadDeductIll = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("insteadDeductIll"));
			orderItemContent.setText(r+1, 9,insteadDeductIll.compareTo(BigDecimal.ZERO) == 0 ?  "0.00" : __NF.format(insteadDeductIll));

			factSalary = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("factSalary"));
			orderItemContent.setText(r+1, 10,factSalary.compareTo(BigDecimal.ZERO) == 0 ?  "0.00" : __NF.format(factSalary));

			num = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("num"));
			orderItemContent.setText(r+1, 11,num.compareTo(BigDecimal.ZERO) == 0 ?  "0" : __NF.format(num));

			unitTotalInsurance = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("unitTotalInsurance"));
			orderItemContent.setText(r+1, 12,unitTotalInsurance.compareTo(BigDecimal.ZERO) == 0 ?  "0.00" : __NF.format(unitTotalInsurance));

		}
//		//加上合计数据
//		int lastRow = rows+1;
//		orderItemContent.setText(lastRow, 0,"合计");
//		orderItemContent.setText(lastRow, 1,totalFundTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(totalFundTotal));
//		orderItemContent.setText(lastRow, 2,unitTotalFundTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(unitTotalFundTotal));
//		orderItemContent.setText(lastRow, 3,personalTotalFundTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(personalTotalFundTotal));
//		orderItemContent.setText(lastRow, 4,totalInsuranceTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(totalInsuranceTotal));
//		orderItemContent.setText(lastRow, 5,unitTotalInsuranceTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(unitTotalInsuranceTotal));
//		orderItemContent.setText(lastRow, 6,personalTotalInsuranceTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(personalTotalInsuranceTotal));
//		orderItemContent.setText(lastRow, 7,unitPensionTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(unitPensionTotal));
//		orderItemContent.setText(lastRow, 8,unitMedicalInsuranceTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(unitMedicalInsuranceTotal));
//		orderItemContent.setText(lastRow, 9,unitInjuryInsuranceTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(unitInjuryInsuranceTotal));
//		orderItemContent.setText(lastRow, 10,unitUnemploymentInsuranceTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(unitUnemploymentInsuranceTotal));
//		orderItemContent.setText(lastRow, 11,unitGiveBirthInsuranceTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(unitGiveBirthInsuranceTotal));
//		orderItemContent.setText(lastRow, 12,unitLargeMedicalInsuranceTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(unitLargeMedicalInsuranceTotal));
//		orderItemContent.setText(lastRow, 13,personalPensionTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(personalPensionTotal));
//		orderItemContent.setText(lastRow, 14,personalMedicalInsuranceTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(personalMedicalInsuranceTotal));
//		orderItemContent.setText(lastRow, 15,personalUnemploymentInsuranceTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(personalUnemploymentInsuranceTotal));
//		orderItemContent.setText(lastRow, 16,personalLargeMedicalInsuranceTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(personalLargeMedicalInsuranceTotal));
//		orderItemContent.setText(lastRow, 17,personalHeatingTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(personalHeatingTotal));
//
		vl.add(orderItemContent);
		// 设置样式
		for (int y = 0; y < rows+1; y++) {
			for (int i = 0; i < cols; i++) {
				cellFormatter.getElement(y, i).getStyle().setFontSize(8, Style.Unit.PX);
				if (y == 0) {// 设置第一行的样式
					cellFormatter.getElement(y, i).getStyle().setFontWeight(Style.FontWeight.BOLD);
					cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,HasVerticalAlignment.ALIGN_MIDDLE);
				} else {
					if (i == 0) {
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_LEFT,HasVerticalAlignment.ALIGN_MIDDLE);
					} else {
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_RIGHT,HasVerticalAlignment.ALIGN_MIDDLE);
					}
				}
				if (i == 0) {
					cellFormatter.getElement(y, i).getStyle().setWidth(100, Style.Unit.PX);
				}
			}
		}
		return vl;
	}
	
	private Record[] records = null;

	public Record[] getRecords() {
		return records;
	}

	public void setRecords(Record[] records) {
		this.records = records;
	}

	
}
