package com.pomplatform.client.receivables.panel;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.ui.AbstractPrint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.DateUtil;

public class OnPrintIncomeMoneyForWeek extends AbstractPrint {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	public static final String[] HEAD_ABELS = {};

	public static final String[] MAIN_ABELS = { "项目", "金额", "备注"};

	public static final String MAIN_TITLE = "";
	
	public static final String[] BOTTOM_ABELS = {"审核","制表人"};
	
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
		layout.getElement().appendChild(generateMianData(map).getElement());
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
		Date startDate = (Date) map.get("startDate");
		Date endDate = (Date) map.get("endDate");
		int year = startDate.getYear()+1900;
		int month = startDate.getMonth()+1;
		int startDay = startDate.getDate();
		int endDay = endDate.getDate();
		title = year+"年"+month+"月"+startDay+"-"+endDay+"日现金流收入报表";
		HTML logo = new HTML();
		logo.setHTML("<img src = '/images/companyLogo/JA.png' style='float:left; height:42px;'/>");
		vl.add(logo);
		HTML tital = new HTML(title);
		tital.getElement().getStyle().setFontSize(24, Style.Unit.PX);
		tital.getElement().getStyle().setFontWeight(Style.FontWeight.BOLD);
		vl.add(tital);
		HTML day = new HTML(DateUtil.format(endDate)+"");
		day.getElement().getStyle().setTextAlign(TextAlign.RIGHT);
		day.getElement().getStyle().setHeight(10, Style.Unit.PX);
		day.getElement().getStyle().setMarginRight(10, Style.Unit.PX);
		vl.add(day);
		return vl;
	}

	/**
	 * 
	 * @Title: generateMianData @Description: 主表数据HTML构建 @param @param
	 * map @param @return @return VerticalPanel @throws
	 */
	public VerticalPanel generateMianData(Map<String,Object> map) {
		VerticalPanel vl = new VerticalPanel();
		vl.setWidth("100%");
		vl.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vl.setSpacing(10);
		int rows = records.length;
		int cols = MAIN_ABELS.length;
		Date endDate = (Date) map.get("endDate");
		Date startDate = (Date) map.get("startDate");
		int endDay = endDate.getDate();
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

		BigDecimal contractMoney = BigDecimal.ZERO;
		BigDecimal otherMoney = BigDecimal.ZERO;
		BigDecimal subsidyMoney = BigDecimal.ZERO;
		BigDecimal total = BigDecimal.ZERO;
		
		for(int r = 0;r < rows;r++){
			int moneyAttribute = BaseHelpUtils.getIntValue(records[r].getAttribute("moneyAttribute"));
			String name = "";
			BigDecimal borrowMoney = BaseHelpUtils.getBigDecimalValue(records[r].getAttribute("borrowMoney"));
			if(moneyAttribute == 1 || moneyAttribute == 11 || moneyAttribute == 12 || moneyAttribute == 13){
				name = BaseHelpUtils.getString(records[r].getAttribute("contractName"));
				contractMoney = contractMoney.add(borrowMoney);
			}else if(moneyAttribute == 2){
				name = BaseHelpUtils.getString(records[r].getAttribute("otherName")); 
				otherMoney = otherMoney.add(borrowMoney);
			}else if(moneyAttribute == 7){
				name = BaseHelpUtils.getString(records[r].getAttribute("otherName")); 
				subsidyMoney = subsidyMoney.add(borrowMoney);
			}
			orderItemContent.setText(r+1, 0,name);
			
			orderItemContent.setText(r+1, 1,borrowMoney.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(borrowMoney));
			
			String remark = BaseHelpUtils.getString(records[r].getAttribute("remark"));
			orderItemContent.setText(r+1, 2,remark);
			
			total = total.add(borrowMoney);
		}
		int x = 1;
		orderItemContent.setText(rows+x, 0,"小计");
		orderItemContent.setText(rows+x, 1,total.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(total));
		orderItemContent.setText(rows+x, 2,"");
		x++;
		orderItemContent.setText(rows+x, 0,"其中：收设计费");
		orderItemContent.setText(rows+x, 1,contractMoney.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(contractMoney));
		orderItemContent.setText(rows+x, 2,"");
		if(otherMoney.compareTo(BigDecimal.ZERO) > 0){
			x++;
			orderItemContent.setText(rows+x, 0,"收房租费用等");
			orderItemContent.setText(rows+x, 1,otherMoney.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(otherMoney));
			orderItemContent.setText(rows+x, 2,"");
		}
		if(subsidyMoney.compareTo(BigDecimal.ZERO) > 0){
			x++;
			orderItemContent.setText(rows+x, 0,"政府补贴");
			orderItemContent.setText(rows+x, 1,subsidyMoney.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(subsidyMoney));
			orderItemContent.setText(rows+x, 2,"");
		}
		
		BigDecimal totalContractMoney = BaseHelpUtils.getBigDecimalValue(map.get("contractMoney"));
		BigDecimal totalRentMoney = BaseHelpUtils.getBigDecimalValue(map.get("rentMoney"));
		BigDecimal totalSubsidyMoney = BaseHelpUtils.getBigDecimalValue(map.get("subsidyMoney"));
		BigDecimal totalMoney = totalContractMoney.add(totalRentMoney).add(totalSubsidyMoney);
		
		int year = endDate.getYear();
		int month = endDate.getMonth()+1;
		Date lastDate = new Date(year,month,0);
        String lastday = __DF.format(lastDate);  
		String theEndDate = __DF.format(endDate);
		int days = endDate.getDate()-startDate.getDate();
		if((startDate.getDate() > 1 && lastday != theEndDate) || (lastday == theEndDate && days != lastDate.getDate()-1)){
			x++;
			orderItemContent.setText(rows+x, 0,"1-"+endDay+"日小计");
			orderItemContent.setText(rows+x, 1,totalMoney.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(totalMoney));
			orderItemContent.setText(rows+x, 2,"");
			x++;
			orderItemContent.setText(rows+x, 0,"其中：收设计费");
			orderItemContent.setText(rows+x, 1,totalContractMoney.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(totalContractMoney));
			orderItemContent.setText(rows+x, 2,"");
			
			if(totalRentMoney.compareTo(BigDecimal.ZERO) > 0){
				x++;
				orderItemContent.setText(rows+x, 0,"收房租费用等");
				orderItemContent.setText(rows+x, 1,totalRentMoney.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(totalRentMoney));
				orderItemContent.setText(rows+x, 2,"");
			}
			if(totalSubsidyMoney.compareTo(BigDecimal.ZERO) > 0){
				x++;
				orderItemContent.setText(rows+x, 0,"政府补贴");
				orderItemContent.setText(rows+x, 1,totalSubsidyMoney.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(totalSubsidyMoney));
				orderItemContent.setText(rows+x, 2,"");
			}
		}
		
		BigDecimal yearTotalContractMoney = BaseHelpUtils.getBigDecimalValue(map.get("yearContractMoney"));
		BigDecimal yearTotalRentMoney = BaseHelpUtils.getBigDecimalValue(map.get("yearRentMoney"));
		BigDecimal yearTotalSubsidyMoney = BaseHelpUtils.getBigDecimalValue(map.get("yearSubsidyMoney"));
		BigDecimal yearTotalMoney = yearTotalContractMoney.add(yearTotalRentMoney).add(yearTotalSubsidyMoney);
		
		//如果不是1月份的话，则汇总年度金额
//		if(month != 1){
			x++;
			orderItemContent.setText(rows+x, 0,"当年累计");
			orderItemContent.setText(rows+x, 1,yearTotalMoney.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(yearTotalMoney));
			orderItemContent.setText(rows+x, 2,"");
			x++;
			orderItemContent.setText(rows+x, 0,"其中：收设计费");
			orderItemContent.setText(rows+x, 1,yearTotalContractMoney.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(yearTotalContractMoney));
			orderItemContent.setText(rows+x, 2,"");
			
			if(yearTotalRentMoney.compareTo(BigDecimal.ZERO) > 0){
				x++;
				orderItemContent.setText(rows+x, 0,"收房租费用等");
				orderItemContent.setText(rows+x, 1,yearTotalRentMoney.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(yearTotalRentMoney));
				orderItemContent.setText(rows+x, 2,"");
			}
			if(yearTotalSubsidyMoney.compareTo(BigDecimal.ZERO) > 0){
				x++;
				orderItemContent.setText(rows+x, 0,"政府补贴");
				orderItemContent.setText(rows+x, 1,yearTotalSubsidyMoney.compareTo(BigDecimal.ZERO) == 0 ?  _KG : __NF.format(yearTotalSubsidyMoney));
				orderItemContent.setText(rows+x, 2,"");
			}
//		}
		
		vl.add(orderItemContent);
		
		// 设置样式
		for (int y = 0; y < rows+x+1; y++) {
			for (int i = 0; i < cols; i++) {
				cellFormatter.getElement(y, i).getStyle().setFontSize(14, Style.Unit.PX);
				cellFormatter.getElement(y, i).getStyle().setHeight(30, Style.Unit.PX);
				cellFormatter.getElement(y, i).getStyle().setFontWeight(Style.FontWeight.LIGHTER);
				if (y == 0) {// 设置第一行的样式
					cellFormatter.getElement(y, i).getStyle().setFontSize(16, Style.Unit.PX);
					cellFormatter.getElement(y, i).getStyle().setFontWeight(Style.FontWeight.BOLD);
					cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,HasVerticalAlignment.ALIGN_MIDDLE);
					cellFormatter.getElement(y, i).getStyle().setHeight(34, Style.Unit.PX);
				} else{
					if (i == 0) {
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_LEFT,HasVerticalAlignment.ALIGN_MIDDLE);
						cellFormatter.setWidth(y, i, "60%");
					} else if(i == 1){
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_RIGHT,HasVerticalAlignment.ALIGN_MIDDLE);
						cellFormatter.setWidth(y, i, "15%");
					}else {
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_LEFT,HasVerticalAlignment.ALIGN_MIDDLE);
						cellFormatter.setWidth(y, i, "25%");
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
		VerticalPanel v2 = new VerticalPanel();
		v2.setWidth("100%");
		v2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		v2.setSpacing(10);

		FlexTable bottonTable = new FlexTable();
		bottonTable.setWidth("100%");
		bottonTable.setBorderWidth(0);
		bottonTable.setText(0, 0, "审核: "+"");
		bottonTable.setText(0, 1, "制表人: "+"");
		HTMLTable.CellFormatter bottonCellFormatter = bottonTable.getCellFormatter();
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 8; j++) {
				switch (j) {
				case 0:
					bottonCellFormatter.setAlignment(i, j, HasHorizontalAlignment.ALIGN_LEFT, HasVerticalAlignment.ALIGN_TOP);
					bottonCellFormatter.setWidth(i, j, "50%");
					break;
				case 1:
					bottonCellFormatter.setAlignment(i, j, HasHorizontalAlignment.ALIGN_LEFT, HasVerticalAlignment.ALIGN_TOP);
					bottonCellFormatter.setWidth(i, j, "50%");
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
