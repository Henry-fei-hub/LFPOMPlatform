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

public class OnPrintFiveInsuranceOneGoldByPlatePanel extends AbstractPrint {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	public static final String[] HEAD_ABELS = {"单位:","日期:","币种:"};

	public static final String[] MAIN_ABELS = { "部门", "公积金合计", "公积金单位", "公积金个人", "社保合计","社保单位合计","社保个人合计","养老单位","医疗单位","工伤单位","失业单位","生育单位","大额单位","养老个人","医疗个人","失业个人","大额个人","采暖费个人" };

	public static final String MAIN_TITLE = "社保公积金汇总表";

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
		BigDecimal totalFundTotal = BigDecimal.ZERO;
		BigDecimal unitTotalFundTotal = BigDecimal.ZERO;
		BigDecimal personalTotalFundTotal = BigDecimal.ZERO;
		BigDecimal totalInsuranceTotal = BigDecimal.ZERO;
		BigDecimal unitTotalInsuranceTotal = BigDecimal.ZERO;
		BigDecimal personalTotalInsuranceTotal = BigDecimal.ZERO;
		BigDecimal unitPensionTotal = BigDecimal.ZERO;
		BigDecimal unitMedicalInsuranceTotal = BigDecimal.ZERO;
		BigDecimal unitInjuryInsuranceTotal = BigDecimal.ZERO;
		BigDecimal unitUnemploymentInsuranceTotal = BigDecimal.ZERO;
		BigDecimal unitGiveBirthInsuranceTotal = BigDecimal.ZERO;
		BigDecimal unitLargeMedicalInsuranceTotal = BigDecimal.ZERO;
		BigDecimal personalPensionTotal = BigDecimal.ZERO;
		BigDecimal personalMedicalInsuranceTotal = BigDecimal.ZERO;
		BigDecimal personalUnemploymentInsuranceTotal = BigDecimal.ZERO;
		BigDecimal personalLargeMedicalInsuranceTotal = BigDecimal.ZERO;
		BigDecimal personalHeatingTotal = BigDecimal.ZERO;

		for(int r = 0;r < rows;r++){
			int plateId = BaseHelpUtils.getIntValue(records[r].getAttribute("plateId"));
			String plateName = KeyValueManager.getValue("system_dictionary_1",plateId+"");
			orderItemContent.setText(r+1, 0,plateName);
			
			BigDecimal totalFund = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("totalFund"));
			totalFundTotal = totalFundTotal.add(totalFund);
			orderItemContent.setText(r+1, 1,totalFund.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(totalFund));
			
			BigDecimal unitTotalFund = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("unitTotalFund"));
			unitTotalFundTotal = unitTotalFundTotal.add(unitTotalFund);
			orderItemContent.setText(r+1, 2,unitTotalFund.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(unitTotalFund));
			
			BigDecimal personalTotalFund = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("personalTotalFund"));
			personalTotalFundTotal = personalTotalFundTotal.add(personalTotalFund);
			orderItemContent.setText(r+1, 3,personalTotalFund.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(personalTotalFund));
			
			BigDecimal totalInsurance = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("totalInsurance"));
			totalInsuranceTotal = totalInsuranceTotal.add(totalInsurance);
			orderItemContent.setText(r+1, 4,totalInsurance.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(totalInsurance));
			
			BigDecimal unitTotalInsurance = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("unitTotalInsurance"));
			unitTotalInsuranceTotal = unitTotalInsuranceTotal.add(unitTotalInsurance);
			orderItemContent.setText(r+1, 5,unitTotalInsurance.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(unitTotalInsurance));
			
			BigDecimal personalTotalInsurance = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("personalTotalInsurance"));
			personalTotalInsuranceTotal = personalTotalInsuranceTotal.add(personalTotalInsurance);
			orderItemContent.setText(r+1, 6,personalTotalInsurance.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(personalTotalInsurance));
			
			BigDecimal unitPension = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("unitPension"));
			unitPensionTotal = unitPensionTotal.add(unitPension);
			orderItemContent.setText(r+1, 7,unitPension.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(unitPension));
			
			BigDecimal unitMedicalInsurance = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("unitMedicalInsurance"));
			unitMedicalInsuranceTotal = unitMedicalInsuranceTotal.add(unitMedicalInsurance);
			orderItemContent.setText(r+1, 8,unitMedicalInsurance.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(unitMedicalInsurance));
			
			BigDecimal unitInjuryInsurance = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("unitInjuryInsurance"));
			unitInjuryInsuranceTotal = unitInjuryInsuranceTotal.add(unitInjuryInsurance);
			orderItemContent.setText(r+1, 9,unitInjuryInsurance.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(unitInjuryInsurance));
			
			BigDecimal unitUnemploymentInsurance = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("unitUnemploymentInsurance"));
			unitUnemploymentInsuranceTotal = unitUnemploymentInsuranceTotal.add(unitUnemploymentInsurance);
			orderItemContent.setText(r+1, 10,unitUnemploymentInsurance.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(unitUnemploymentInsurance));
			
			BigDecimal unitGiveBirthInsurance = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("unitGiveBirthInsurance"));
			unitGiveBirthInsuranceTotal = unitGiveBirthInsuranceTotal.add(unitGiveBirthInsurance);
			orderItemContent.setText(r+1, 11,unitGiveBirthInsurance.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(unitGiveBirthInsurance));
			
			BigDecimal unitLargeMedicalInsurance = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("unitLargeMedicalInsurance"));
			unitLargeMedicalInsuranceTotal = unitLargeMedicalInsuranceTotal.add(unitLargeMedicalInsurance);
			orderItemContent.setText(r+1, 12,unitLargeMedicalInsurance.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(unitLargeMedicalInsurance));
			
			BigDecimal personalPension = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("personalPension"));
			personalPensionTotal = personalPensionTotal.add(personalPension);
			orderItemContent.setText(r+1, 13,personalPension.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(personalPension));
			
			BigDecimal personalMedicalInsurance = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("personalMedicalInsurance"));
			personalMedicalInsuranceTotal = personalMedicalInsuranceTotal.add(personalMedicalInsurance);
			orderItemContent.setText(r+1, 14,personalMedicalInsurance.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(personalMedicalInsurance));
			
			BigDecimal personalUnemploymentInsurance = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("personalUnemploymentInsurance"));
			personalUnemploymentInsuranceTotal = personalUnemploymentInsuranceTotal.add(personalUnemploymentInsurance);
			orderItemContent.setText(r+1, 15,personalUnemploymentInsurance.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(personalUnemploymentInsurance));
			
			BigDecimal personalLargeMedicalInsurance = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("personalLargeMedicalInsurance"));
			BigDecimal personalSeriousIllInsurance = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("personalSeriousIllInsurance"));
			BigDecimal add = personalSeriousIllInsurance.add(personalLargeMedicalInsurance);
			personalLargeMedicalInsuranceTotal = personalLargeMedicalInsuranceTotal.add(add);
			orderItemContent.setText(r+1, 16,add.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(add));
			
			BigDecimal personalHeating = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("personalHeating"));
			personalHeatingTotal = personalHeatingTotal.add(personalHeating);
			orderItemContent.setText(r+1, 17,personalHeating.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(personalHeating));
			
			
		}
		//加上合计数据
		int lastRow = rows+1; 
		orderItemContent.setText(lastRow, 0,"合计");
		orderItemContent.setText(lastRow, 1,totalFundTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(totalFundTotal));
		orderItemContent.setText(lastRow, 2,unitTotalFundTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(unitTotalFundTotal));
		orderItemContent.setText(lastRow, 3,personalTotalFundTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(personalTotalFundTotal));
		orderItemContent.setText(lastRow, 4,totalInsuranceTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(totalInsuranceTotal));
		orderItemContent.setText(lastRow, 5,unitTotalInsuranceTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(unitTotalInsuranceTotal));
		orderItemContent.setText(lastRow, 6,personalTotalInsuranceTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(personalTotalInsuranceTotal));
		orderItemContent.setText(lastRow, 7,unitPensionTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(unitPensionTotal));
		orderItemContent.setText(lastRow, 8,unitMedicalInsuranceTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(unitMedicalInsuranceTotal));
		orderItemContent.setText(lastRow, 9,unitInjuryInsuranceTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(unitInjuryInsuranceTotal));
		orderItemContent.setText(lastRow, 10,unitUnemploymentInsuranceTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(unitUnemploymentInsuranceTotal));
		orderItemContent.setText(lastRow, 11,unitGiveBirthInsuranceTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(unitGiveBirthInsuranceTotal));
		orderItemContent.setText(lastRow, 12,unitLargeMedicalInsuranceTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(unitLargeMedicalInsuranceTotal));
		orderItemContent.setText(lastRow, 13,personalPensionTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(personalPensionTotal));
		orderItemContent.setText(lastRow, 14,personalMedicalInsuranceTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(personalMedicalInsuranceTotal));
		orderItemContent.setText(lastRow, 15,personalUnemploymentInsuranceTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(personalUnemploymentInsuranceTotal));
		orderItemContent.setText(lastRow, 16,personalLargeMedicalInsuranceTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(personalLargeMedicalInsuranceTotal));
		orderItemContent.setText(lastRow, 17,personalHeatingTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(personalHeatingTotal));
		
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
