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

public class OnPrintChangeSalaryTotal extends AbstractPrint {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	public static final String[] HEAD_ABELS = {};

	public static final String[] MAIN_ABELS = { "业务部门", "现薪资", "调整金额", "调整后薪资总额", "调薪比例"};

	public static final String MAIN_TITLE = "";
	
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
		int year = BaseHelpUtils.getIntValue(map, "year");
		int month = BaseHelpUtils.getIntValue(map, "month");
		HTML tital = new HTML(year+"年"+month+"月调薪汇总表");
		tital.getElement().getStyle().setFontSize(16, Style.Unit.PX);
		tital.getElement().getStyle().setFontWeight(Style.FontWeight.BOLD);
		vl.add(tital);
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
		BigDecimal originalPayTotal = BigDecimal.ZERO;
		BigDecimal changePayTotal = BigDecimal.ZERO;
		BigDecimal monthPayTotal = BigDecimal.ZERO;

		for(int r = 0;r < rows;r++){
			int plateId = BaseHelpUtils.getIntValue(records[r].getAttribute("plateId"));
			String plateName = KeyValueManager.getValue("plate_records",plateId+"");
			orderItemContent.setText(r+1, 0,plateName);
			
			BigDecimal originalPay = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("originalPay"));
			originalPayTotal = originalPayTotal.add(originalPay);
			orderItemContent.setText(r+1, 1,originalPay.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(originalPay));
			
			BigDecimal changePay = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("changePay"));
			changePayTotal = changePayTotal.add(changePay);
			orderItemContent.setText(r+1, 2,changePay.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(changePay));
			
			BigDecimal monthPay = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("monthPay"));
			monthPayTotal = monthPayTotal.add(monthPay);
			orderItemContent.setText(r+1, 3,monthPay.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(monthPay));
			
			BigDecimal percent = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("percent"));
			orderItemContent.setText(r+1, 4,percent.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(percent));
			
		}
		vl.add(orderItemContent);
		// 设置样式
		for (int y = 0; y < rows+1; y++) {
			for (int i = 0; i < cols; i++) {
				cellFormatter.getElement(y, i).getStyle().setFontSize(8, Style.Unit.PX);
				cellFormatter.getElement(y, i).getStyle().setHeight(30, Style.Unit.PX);
				if (y == 0) {// 设置第一行的样式
					cellFormatter.getElement(y, i).getStyle().setFontWeight(Style.FontWeight.BOLD);
					cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,HasVerticalAlignment.ALIGN_MIDDLE);
				} else {
					if (i == 1 || i == 2 || i == 3) {
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_RIGHT,HasVerticalAlignment.ALIGN_MIDDLE);
					} else {
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,HasVerticalAlignment.ALIGN_MIDDLE);
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
		String payPerson = BaseHelpUtils.getString(map.get("payPerson"));
		String adminPerson = BaseHelpUtils.getString(map.get("adminPerson"));
		String operatePerson = BaseHelpUtils.getString(map.get("operatePerson"));
		String hrPerson = BaseHelpUtils.getString(map.get("hrPerson"));
		
		VerticalPanel v2 = new VerticalPanel();
		v2.setWidth("100%");
		v2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		v2.setSpacing(10);

		FlexTable bottonTable = new FlexTable();
		bottonTable.setWidth("100%");
		bottonTable.setBorderWidth(0);
		bottonTable.setText(0, 0, "总经理: "+"");
		bottonTable.setText(0, 1, "部门审批: ");
		bottonTable.setText(0, 2, auditPerson);
		bottonTable.setText(0, 3, "运营审批: "+operatePerson);
		bottonTable.setText(0, 4, "人资审批: "+hrPerson);
		bottonTable.setText(0, 5, "申请人: "+payPerson);
		HTMLTable.CellFormatter bottonCellFormatter = bottonTable.getCellFormatter();
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 8; j++) {
				switch (j) {
				case 0:
					bottonCellFormatter.setAlignment(i, j, HasHorizontalAlignment.ALIGN_LEFT, HasVerticalAlignment.ALIGN_TOP);
					bottonCellFormatter.setWidth(i, j, "16%");
					break;
				case 1:
					bottonCellFormatter.setAlignment(i, j, HasHorizontalAlignment.ALIGN_LEFT, HasVerticalAlignment.ALIGN_TOP);
					bottonCellFormatter.setWidth(i, j, "7%");
					break;
				case 2:
					bottonCellFormatter.setAlignment(i, j, HasHorizontalAlignment.ALIGN_LEFT, HasVerticalAlignment.ALIGN_TOP);
					bottonCellFormatter.setWidth(i, j, "32%");
					break;
				case 3:
					bottonCellFormatter.setAlignment(i, j, HasHorizontalAlignment.ALIGN_LEFT, HasVerticalAlignment.ALIGN_TOP);
					bottonCellFormatter.setWidth(i, j, "15%");
					break;
				case 4:
					bottonCellFormatter.setAlignment(i, j, HasHorizontalAlignment.ALIGN_LEFT, HasVerticalAlignment.ALIGN_TOP);
					bottonCellFormatter.setWidth(i, j, "15%");
					break;
				case 5:
					bottonCellFormatter.setAlignment(i, j, HasHorizontalAlignment.ALIGN_LEFT, HasVerticalAlignment.ALIGN_TOP);
					bottonCellFormatter.setWidth(i, j, "15%");
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
