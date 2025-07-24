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
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.smartgwt.client.data.Record;

public class OnPrintSalaryBonusTotalOfPlate extends AbstractPrint {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	public static final String[] HEAD_ABELS = {"单位:","日期:","币种:"};

	public static final String[] MAIN_ABELS = { "部门", "项目奖金", "其他奖金", "奖金合计", "扣税","实发奖金"};

	public static final String MAIN_TITLE = "杰恩设计奖金汇总表";
	
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
					oneCellFormatter.setWidth(i, j, "40%");
					break;
				case 1:
					oneCellFormatter.setAlignment(i, j, HasHorizontalAlignment.ALIGN_LEFT, HasVerticalAlignment.ALIGN_TOP);
					oneCellFormatter.setWidth(i, j, "40%");
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
		BigDecimal projectBonusTotal = BigDecimal.ZERO;
		BigDecimal otherBonusTotal = BigDecimal.ZERO;
		BigDecimal shouldBonusTotal = BigDecimal.ZERO;
		BigDecimal shouldTaxTotal = BigDecimal.ZERO;
		BigDecimal factBonusTotal = BigDecimal.ZERO;

		for(int r = 0;r < rows;r++){
			int plateId = BaseHelpUtils.getIntValue(records[r].getAttribute("plateId"));
			String plateName = KeyValueManager.getValue("plate_records",plateId+"");
			orderItemContent.setText(r+1, 0,plateName);
			
			BigDecimal projectBonus = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("projectBonus"));
			projectBonusTotal = projectBonusTotal.add(projectBonus);
			orderItemContent.setText(r+1, 1,projectBonus.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(projectBonus));
			
			BigDecimal otherBonus = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("otherBonus"));
			otherBonusTotal = otherBonusTotal.add(otherBonus);
			orderItemContent.setText(r+1, 2,otherBonus.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(otherBonus));
			
			BigDecimal shouldBonus = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("shouldBonus"));
			shouldBonusTotal = shouldBonusTotal.add(shouldBonus);
			orderItemContent.setText(r+1, 3,shouldBonus.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(shouldBonus));
			
			BigDecimal shouldTax = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("shouldTax"));
			shouldTaxTotal = shouldTaxTotal.add(shouldTax);
			orderItemContent.setText(r+1, 4,shouldTax.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(shouldTax));
			
			BigDecimal factBonus = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("factBonus"));
			factBonusTotal = factBonusTotal.add(factBonus);
			orderItemContent.setText(r+1, 5,factBonus.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(factBonus));
			
		}
		//加上合计数据
		int lastRow = rows+1; 
		orderItemContent.setText(lastRow, 0,"合计");
		orderItemContent.setText(lastRow, 1,projectBonusTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(projectBonusTotal));
		orderItemContent.setText(lastRow, 2,otherBonusTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(otherBonusTotal));
		orderItemContent.setText(lastRow, 3,shouldBonusTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(shouldBonusTotal));
		orderItemContent.setText(lastRow, 4,shouldTaxTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(shouldTaxTotal));
		orderItemContent.setText(lastRow, 5,factBonusTotal.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(factBonusTotal));
		
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
