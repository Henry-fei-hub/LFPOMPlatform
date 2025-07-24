package com.pomplatform.client.payment.panel;

import java.math.BigDecimal;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractPrint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.smartgwt.client.data.Record;

public class OnLoadSalaryPaymentByPlatePrintPanel extends AbstractPrint {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	public static final String[] HEAD_ABELS = {"单位:", "类型:", "日期:","币种:"};

	public static final String[] MAIN_ABELS = { "部门", "应发工资", "离职补偿", "应付奖金", "应付合计","代扣个税","代扣社保","代扣养老","代扣医疗","代扣失业","代扣大额","代扣采暖","代扣公积金","代扣其他","重疾险","实发工资","发放人数" };

	public static final String MAIN_TITLE = "工资汇总表";
	
	public static final String[] BOTTOM_ABELS = {"制表:","审核:","批准:"};

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
		layout.getElement().appendChild(generateBottonHtml(map).getElement());
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
		int type = BaseHelpUtils.getIntValue(map, "type");
		int month = BaseHelpUtils.getIntValue(map, "month");
		HTML tital = new HTML(title);
		tital.getElement().getStyle().setFontSize(16, Style.Unit.PX);
		tital.getElement().getStyle().setFontWeight(Style.FontWeight.BOLD);
		vl.add(tital);

		FlexTable threeRowTable = new FlexTable();
		threeRowTable.setWidth("100%");
		threeRowTable.setBorderWidth(0);
		threeRowTable.setText(0, 0,"单位:"+KeyValueManager.getValue("system_dictionary_26",companyId+""));
		threeRowTable.setText(0, 1, KeyValueManager.getValue("system_dictionary_124",type+""));
		threeRowTable.setText(0, 2, year+"年"+month+"月");
		threeRowTable.setText(0, 3, "币种:人民币");
		HTMLTable.CellFormatter oneCellFormatter = threeRowTable.getCellFormatter();
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 8; j++) {
				switch (j) {
				case 0:
					oneCellFormatter.setAlignment(i, j, HasHorizontalAlignment.ALIGN_LEFT, HasVerticalAlignment.ALIGN_TOP);
					oneCellFormatter.setWidth(i, j, "40%");
					break;
				case 1:
					oneCellFormatter.setAlignment(i, j, HasHorizontalAlignment.ALIGN_LEFT, HasVerticalAlignment.ALIGN_TOP);
					oneCellFormatter.setWidth(i, j, "20%");
					break;
				case 2:
					oneCellFormatter.setAlignment(i, j, HasHorizontalAlignment.ALIGN_LEFT, HasVerticalAlignment.ALIGN_TOP);
					oneCellFormatter.setWidth(i, j, "20%");
					break;
				case 3:
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
		BigDecimal shouldSalaryTotal = BigDecimal.ZERO;
		BigDecimal leaveAdvanceTotal = BigDecimal.ZERO;
		BigDecimal shouldBonusTotal = BigDecimal.ZERO;
		BigDecimal shouldTotalTotal = BigDecimal.ZERO;
		BigDecimal shouldTaxTotal = BigDecimal.ZERO;
		BigDecimal totalInsuranceTotal = BigDecimal.ZERO;
		BigDecimal personalPensionTotal = BigDecimal.ZERO;
		BigDecimal personalMedicalInsuranceTotal = BigDecimal.ZERO;
		BigDecimal personalUnemploymentInsuranceTotal = BigDecimal.ZERO;
		BigDecimal personalLargeMedicalInsuranceTotal = BigDecimal.ZERO;
		BigDecimal personalHeatingTotal = BigDecimal.ZERO;
		BigDecimal totalFundTotal = BigDecimal.ZERO;
		BigDecimal insteadDeductTotal = BigDecimal.ZERO;
		BigDecimal insteadDeductIllTotal = BigDecimal.ZERO;
		BigDecimal factSalaryTotal = BigDecimal.ZERO;
		int numTotal = 0;
		for(int r = 0;r < rows;r++){
			int plateId = BaseHelpUtils.getIntValue(records[r].getAttribute("plateId"));
			String plateName = KeyValueManager.getValue("system_dictionary_1",plateId+"");
			orderItemContent.setText(r+1, 0,plateName);
			BigDecimal shouldSalary = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("shouldSalary"));
			shouldSalaryTotal = shouldSalaryTotal.add(shouldSalary);
			orderItemContent.setText(r+1, 1,shouldSalary.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(shouldSalary));
			
			BigDecimal leaveAdvance = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("leaveAdvance"));
			leaveAdvanceTotal = leaveAdvanceTotal.add(leaveAdvance);
			orderItemContent.setText(r+1, 2,leaveAdvance.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(leaveAdvance));
			
			BigDecimal shouldBonus = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("shouldBonus"));
			shouldBonusTotal = shouldBonusTotal.add(shouldBonus);
			orderItemContent.setText(r+1, 3,shouldBonus.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(shouldBonus));
			
			BigDecimal shouldTotal = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("shouldTotal"));
			shouldTotalTotal = shouldTotalTotal.add(shouldTotal);
			orderItemContent.setText(r+1, 4,shouldTotal.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(shouldTotal));
			
			BigDecimal shouldTax = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("shouldTax"));
			shouldTaxTotal = shouldTaxTotal.add(shouldTax);
			orderItemContent.setText(r+1, 5,shouldTax.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(shouldTax));
			
			BigDecimal totalInsurance = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("totalInsurance"));
			totalInsuranceTotal = totalInsuranceTotal.add(totalInsurance);
			orderItemContent.setText(r+1, 6,totalInsurance.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(totalInsurance));
			
			BigDecimal personalPension = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("personalPension"));
			personalPensionTotal = personalPensionTotal.add(personalPension);
			orderItemContent.setText(r+1, 7,personalPension.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(personalPension));
			
			BigDecimal personalMedicalInsurance = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("personalMedicalInsurance"));
			personalMedicalInsuranceTotal = personalMedicalInsuranceTotal.add(personalMedicalInsurance);
			orderItemContent.setText(r+1, 8,personalMedicalInsurance.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(personalMedicalInsurance));
			
			BigDecimal personalUnemploymentInsurance = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("personalUnemploymentInsurance"));
			personalUnemploymentInsuranceTotal = personalUnemploymentInsuranceTotal.add(personalUnemploymentInsurance);
			orderItemContent.setText(r+1, 9,personalUnemploymentInsurance.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(personalUnemploymentInsurance));
			
			BigDecimal personalLargeMedicalInsurance = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("personalLargeMedicalInsurance"));
			personalLargeMedicalInsuranceTotal = personalLargeMedicalInsuranceTotal.add(personalLargeMedicalInsurance);
			orderItemContent.setText(r+1, 10,personalLargeMedicalInsurance.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(personalLargeMedicalInsurance));
			
			BigDecimal personalHeating = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("personalHeating"));
			personalHeatingTotal = personalHeatingTotal.add(personalHeating);
			orderItemContent.setText(r+1, 11,personalHeating.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(personalHeating));
			
			BigDecimal totalFund = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("totalFund"));
			totalFundTotal = totalFundTotal.add(totalFund);
			orderItemContent.setText(r+1, 12,totalFund.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(totalFund));
			
			BigDecimal insteadDeduct = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("insteadDeduct"));
			insteadDeductTotal = insteadDeductTotal.add(insteadDeduct);
			orderItemContent.setText(r+1, 13,insteadDeduct.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(insteadDeduct));
			
			BigDecimal insteadDeductIll = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("insteadDeductIll"));
			insteadDeductIllTotal = insteadDeductIllTotal.add(insteadDeductIll);
			orderItemContent.setText(r+1, 14,insteadDeductIll.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(insteadDeductIll));
			
			BigDecimal factSalary = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("factSalary"));
			factSalaryTotal = factSalaryTotal.add(factSalary);
			orderItemContent.setText(r+1, 15,factSalary.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(factSalary));
			
			int num = BaseHelpUtils.getIntValue(records[r].getAttribute("num"));
			numTotal = numTotal+num;
			orderItemContent.setText(r+1, 16,num+"");
		}
		//加上合计数据
		int lastRow = rows+1; 
		orderItemContent.setText(lastRow, 0,"合计");
		orderItemContent.setText(lastRow, 1,shouldSalaryTotal.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(shouldSalaryTotal));
		orderItemContent.setText(lastRow, 2,leaveAdvanceTotal.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(leaveAdvanceTotal));
		orderItemContent.setText(lastRow, 3,shouldBonusTotal.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(shouldBonusTotal));
		orderItemContent.setText(lastRow, 4,shouldTotalTotal.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(shouldTotalTotal));
		orderItemContent.setText(lastRow, 5,shouldTaxTotal.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(shouldTaxTotal));
		orderItemContent.setText(lastRow, 6,totalInsuranceTotal.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(totalInsuranceTotal));
		orderItemContent.setText(lastRow, 7,personalPensionTotal.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(personalPensionTotal));
		orderItemContent.setText(lastRow, 8,personalMedicalInsuranceTotal.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(personalMedicalInsuranceTotal));
		orderItemContent.setText(lastRow, 9,personalUnemploymentInsuranceTotal.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(personalUnemploymentInsuranceTotal));
		orderItemContent.setText(lastRow, 10,personalLargeMedicalInsuranceTotal.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(personalLargeMedicalInsuranceTotal));
		orderItemContent.setText(lastRow, 11,personalHeatingTotal.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(personalHeatingTotal));
		orderItemContent.setText(lastRow, 12,totalFundTotal.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(totalFundTotal));
		orderItemContent.setText(lastRow, 13,insteadDeductTotal.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(insteadDeductTotal));
		orderItemContent.setText(lastRow, 14,insteadDeductIllTotal.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(insteadDeductIllTotal));
		orderItemContent.setText(lastRow, 15,factSalaryTotal.compareTo(BigDecimal.ZERO) == 0?_KG:__NF.format(factSalaryTotal));
		orderItemContent.setText(lastRow, 16,numTotal+"");
		
		vl.add(orderItemContent);
		// 设置样式
		for (int y = 0; y < rows+2; y++) {
			for (int i = 0; i < cols; i++) {
				cellFormatter.getElement(y, i).getStyle().setFontSize(8, Style.Unit.PX);
				if (y == 0) {// 设置第一行的样式
					cellFormatter.getElement(y, i).getStyle().setFontWeight(Style.FontWeight.BOLD);
					cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,HasVerticalAlignment.ALIGN_MIDDLE);
				} else {
					if (i == 0) {
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,HasVerticalAlignment.ALIGN_MIDDLE);
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
	
	
	/**
	 * 底部
	 * @return
	 */
	private VerticalPanel generateBottonHtml(Map<String,Object> map) {
		String auditPerson = BaseHelpUtils.getString(map.get("auditPerson"));
		String formPerson = BaseHelpUtils.getString(map.get("formPerson"));
		String adminPerson = BaseHelpUtils.getString(map.get("adminPerson"));
		
		VerticalPanel v2 = new VerticalPanel();
		v2.setWidth("100%");
		v2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		v2.setSpacing(10);

		FlexTable bottonTable = new FlexTable();
		bottonTable.setWidth("100%");
		bottonTable.setBorderWidth(0);
		bottonTable.setText(0, 0, "制表:"+formPerson);
		bottonTable.setText(0, 1, "审核:"+auditPerson);
		bottonTable.setText(0, 2, "批准:"+adminPerson);
		HTMLTable.CellFormatter bottonCellFormatter = bottonTable.getCellFormatter();
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 8; j++) {
				switch (j) {
				case 0:
					bottonCellFormatter.setAlignment(i, j, HasHorizontalAlignment.ALIGN_LEFT, HasVerticalAlignment.ALIGN_TOP);
					bottonCellFormatter.setWidth(i, j, "30%");
					break;
				case 1:
					bottonCellFormatter.setAlignment(i, j, HasHorizontalAlignment.ALIGN_LEFT, HasVerticalAlignment.ALIGN_TOP);
					bottonCellFormatter.setWidth(i, j, "50%");
					break;
				case 2:
					bottonCellFormatter.setAlignment(i, j, HasHorizontalAlignment.ALIGN_LEFT, HasVerticalAlignment.ALIGN_TOP);
					bottonCellFormatter.setWidth(i, j, "20%");
					break;
				}
			}
		}
		v2.add(bottonTable);
		return v2;
	}
	
	private Record[] records = null;

	public Record[] getRecords() {
		return records;
	}

	public void setRecords(Record[] records) {
		this.records = records;
	}

	
}
