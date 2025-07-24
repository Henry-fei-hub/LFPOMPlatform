package com.pomplatform.client.workflow.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractPrint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.pomplatform.client.workflow.projectNormalReimbursement.panel.PrintCommonHtml;
import com.smartgwt.client.data.Record;

public class TravelReimbursementsPrintPanel extends AbstractPrint {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	public static final String[] HEAD_ABELS = {"付款单位:", "报销单号:", "部&nbsp;&nbsp;门:", "申请日期:", "报 销 人:", "单位:"};

	public static final String[] MAIN_ABELS = { "起草人", "主题", "报销金额", "冲账金额", "实付金额", "出差开始日期", "出差结束日期"};

	public static final String[] CHILD_ONE_ABELS = {"序号", "摘要", "开始日期", "结束日期", "出发地", "目的地", "天数", "机票", "车船费", "市内交通费", "托运费", "住宿费", "自驾车费", "出差补助", "小计" };

	public static final String[] CHILD_TWO_ABELS = { "序号", "部门", "进项税", "成本", "费用" };
	
	public static final String[] WORKFLOW_ABELS = { "审批人", "角色", "处理开始时间", "处理结束时间", "状态", "意见"};
	
	public static final String[] RECIVE_MONEY_ABELS = { "序号", "户名", "账号", "开户银行", "付款金额"};

	public static final String MAIN_TITLE = "普通差旅报销";

	public static final String CHILD_ONE_TITLE = "费用明细清单";

	public static final String CHILD_TWO_TITLE = "每个部门承担的费用";
	
	public static final String RECIVE_MONEY_TITLE = "收款方信息";
	
	public final static String ACTIVITIES_NAME = "activities";

	public static DateTimeFormat __DF = DateTimeFormat.getFormat("yyyy-MM-dd");
	public static NumberFormat __NF = NumberFormat.getFormat("##,###,###,###,##0.00");

	@Override
	public HTML generatePrintHTML() {
		
		HTML layout = new HTML();
		layout.setHeight("100%");
		Map map = getPrintData();
		String applyEmployeeId = ClientUtil.getStringFromMapNotNull(map, "applicant");
		__LOGGER.info(map.toString());
		Record record = getProcessInformation();
		__LOGGER.info(record+"");
		List<Map> childOne = (List<Map>) map.get("detailTravelReimbursementDetail");
		List<Map> childTwo = (List<Map>) map.get("detailTravelReimbursementLinkDepartment");
		List<Map> childThree = new ArrayList<>();
		double balanceAmount = 0;//冲账金额
		if(null != map.get("detailSprocessbilllistpppor")){
			childThree = (List<Map>) map.get("detailSprocessbilllistpppor");
			for (Map __map : childThree) {
				balanceAmount += BaseHelpUtils.getDoubleValue(__map.get("balanceAmount"));
			}
		}
		map.put("balanceAmount", balanceAmount);
		//流程节点数据
//		Record processInstance = record.getAttributeAsRecord("processInstance");
//		Record[] activities = processInstance.getAttributeAsRecordArray(ACTIVITIES_NAME);
//		if (activities == null || activities.length == 0) {
//			
//		}
		VerticalPanel vPanel = new VerticalPanel();
		vPanel.getElement().getStyle().setPosition(Position.RELATIVE);
		vPanel.setWidth("100%");
		vPanel.setHeight("100%");
		vPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vPanel.setSpacing(10);
		vPanel.add(PrintCommonHtml.headHtml(HEAD_ABELS, MAIN_TITLE, map, applyEmployeeId));
		vPanel.add(generateMianData(map));
		vPanel.add(generateChildOneList(childOne));
		vPanel.add(generateChildTwoList(childTwo));
		vPanel.add(PrintCommonHtml.generateReciveList(childThree));
		vPanel.add(PrintCommonHtml.footHtml());
		layout.getElement().appendChild(vPanel.getElement());
		return layout;
	}
	

	/**
	 * 
	 * @Title: generateChildTwoList 
	 * @Description: 每个部门承担的费用详细数据 
	 * @param @param childTwoList 
	 * @param @return 
	 * @return VerticalPanel 
	 * @throws
	 */
	public static VerticalPanel generateChildTwoList(List<Map> childTwoList) {
		VerticalPanel vl = new VerticalPanel();
		vl.setWidth("100%");
		vl.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vl.setSpacing(10);
		HTML tital = new HTML(CHILD_TWO_TITLE);
		tital.getElement().getStyle().setFontSize(16, Style.Unit.PX);
		tital.getElement().getStyle().setFontWeight(Style.FontWeight.BOLD);
		vl.add(tital);

		int length = childTwoList.size();

		FlexTable orderItemContent = new FlexTable();
		orderItemContent.setWidth("100%");
		orderItemContent.setCellPadding(0);
		orderItemContent.setCellSpacing(0);
		orderItemContent.setBorderWidth(1);
		orderItemContent.getElement().getStyle().setBorderColor("#000000");
		HTMLTable.CellFormatter cellFormatter = orderItemContent.getCellFormatter();

		for (int i = 0; i < CHILD_TWO_ABELS.length; i++) {
			orderItemContent.setText(0, i, CHILD_TWO_ABELS[i]);
		}
		double allMoney = 0;
		int count = 1;
		for (Map rr : childTwoList) {
			String departmentId = BaseHelpUtils.getString(rr.get("departmentId"));
			orderItemContent.setText(count, 0, count + "");
			orderItemContent.setText(count, 1, KeyValueManager.getValueMap("departments").get(departmentId));
			orderItemContent.setText(count, 2, __NF.format(BaseHelpUtils.getDoubleValue(rr.get("inputTax"))));
			orderItemContent.setText(count, 3, __NF.format(BaseHelpUtils.getDoubleValue(rr.get("finalAmount"))));
			orderItemContent.setText(count, 4, __NF.format(BaseHelpUtils.getDoubleValue(rr.get("amount"))));
			allMoney += BaseHelpUtils.getDoubleValue(rr.get("amount"));
			count++;
		}

		vl.add(orderItemContent);
		// 设置样式
		for (int y = 0; y < length + 1; y++) {
			for (int i = 0; i < CHILD_TWO_ABELS.length; i++) {
				cellFormatter.getElement(y, i).getStyle().setFontSize(16, Style.Unit.PX);
				if (y == 0) {// 设置第一行的样式
					cellFormatter.getElement(y, i).getStyle().setFontWeight(Style.FontWeight.BOLD);
					cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,
							HasVerticalAlignment.ALIGN_MIDDLE);
				} else {
					if(i == 2 || i == 3 || i == 4){
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_RIGHT,
								HasVerticalAlignment.ALIGN_MIDDLE);
						cellFormatter.getElement(y, i).getStyle().setPaddingRight(4, Style.Unit.PX);
					}else{
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,
								HasVerticalAlignment.ALIGN_MIDDLE);
					}
				}
				
			}
		}
		//添加汇总模块
		vl.add(PrintCommonHtml.summaryTable(new BigDecimal(allMoney)));
		
		return vl;
	}

	/**
	 * 
	 * @Title: generateChildOneList 
	 * @Description: 费用明细清单表详细数据 
	 * @param @param childOneList 
	 * @param @return 
	 * @return VerticalPanel 
	 * @throws
	 */
	public static VerticalPanel generateChildOneList(List<Map> childOneList) {
		VerticalPanel vl = new VerticalPanel();
		vl.setWidth("100%");
		vl.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vl.setSpacing(10);
		HTML tital = new HTML(CHILD_ONE_TITLE);
		tital.getElement().getStyle().setFontSize(16, Style.Unit.PX);
		tital.getElement().getStyle().setFontWeight(Style.FontWeight.BOLD);
		vl.add(tital);

		int length = childOneList.size();

		FlexTable orderItemContent = new FlexTable();
		orderItemContent.setWidth("100%");
		orderItemContent.setCellPadding(0);
		orderItemContent.setCellSpacing(0);
		orderItemContent.setBorderWidth(1);
		orderItemContent.getElement().getStyle().setBorderColor("#000000");
		HTMLTable.CellFormatter cellFormatter = orderItemContent.getCellFormatter();

		for (int i = 0; i < CHILD_ONE_ABELS.length; i++) {
			orderItemContent.setText(0, i, CHILD_ONE_ABELS[i]);
		}

		double allMoney = 0;
		int count = 1;
		for (Map rr : childOneList) {
			orderItemContent.setText(count, 0, count + "");
			orderItemContent.setText(count, 1, BaseHelpUtils.getString(rr.get("remark")));
			orderItemContent.setText(count, 2, __DF.format((Date) rr.get("startDate")));
			orderItemContent.setText(count, 3, __DF.format((Date) rr.get("endDate")));
			orderItemContent.setText(count, 4, BaseHelpUtils.getString(rr.get("startAddress")));
			orderItemContent.setText(count, 5, BaseHelpUtils.getString(rr.get("arrivingAddress")));
			orderItemContent.setText(count, 6, BaseHelpUtils.getString(rr.get("travelDays")));
			orderItemContent.setText(count, 7, __NF.format(BaseHelpUtils.getDoubleValue(rr.get("airfare"))));
			orderItemContent.setText(count, 8, __NF.format(BaseHelpUtils.getDoubleValue(rr.get("carBoatFee"))));
			orderItemContent.setText(count, 9, __NF.format(BaseHelpUtils.getDoubleValue(rr.get("cityTransportation"))));
			orderItemContent.setText(count, 10, __NF.format(BaseHelpUtils.getDoubleValue(rr.get("shippingFee"))));
			orderItemContent.setText(count, 11, __NF.format(BaseHelpUtils.getDoubleValue(rr.get("accommodationFee"))));
			orderItemContent.setText(count, 12, __NF.format(BaseHelpUtils.getDoubleValue(rr.get("drivingFee"))));
			orderItemContent.setText(count, 13, __NF.format(BaseHelpUtils.getDoubleValue(rr.get("travelAllowance"))));
			orderItemContent.setText(count, 14, __NF.format(BaseHelpUtils.getDoubleValue(rr.get("sum"))));
			allMoney += BaseHelpUtils.getDoubleValue(rr.get("sum"));
			count++;
		}

		vl.add(orderItemContent);

		// 设置样式
		for (int y = 0; y < length + 1; y++) {
			for (int i = 0; i < CHILD_ONE_ABELS.length; i++) {
				cellFormatter.getElement(y, i).getStyle().setFontSize(12, Style.Unit.PX);
				if (y == 0) {// 设置第一行的样式
					cellFormatter.getElement(y, i).getStyle().setFontWeight(Style.FontWeight.BOLD);
					cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,
							HasVerticalAlignment.ALIGN_MIDDLE);
				} else {
					if(i == 14){
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_RIGHT,
								HasVerticalAlignment.ALIGN_MIDDLE);
						cellFormatter.getElement(y, i).getStyle().setPaddingRight(4, Style.Unit.PX);
					}else{
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,
								HasVerticalAlignment.ALIGN_MIDDLE);
					}
				}
				if(i == 14){
					cellFormatter.getElement(y, i).getStyle().setWidth(55, Style.Unit.PX);
				}
				if(i== 2 || i ==3 ){
					cellFormatter.getElement(y, i).getStyle().setWidth(65, Style.Unit.PX);
				}
			}
		}
		//添加汇总模块
		vl.add(PrintCommonHtml.summaryTable(new BigDecimal(allMoney)));
		return vl;
	}

	/**
	 * 
	 * @Title: generateMianData 
	 * @Description: 主表数据HTML构建 
	 * @param @param map 
	 * @param @return 
	 * @return VerticalPanel 
	 * @throws
	 */
	public static VerticalPanel generateMianData(Map map) {
		
		VerticalPanel vl = new VerticalPanel();
		vl.setWidth("100%");
		vl.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vl.setSpacing(10);
		int length = 1;

		FlexTable orderItemContent = new FlexTable();
		orderItemContent.setWidth("100%");
		orderItemContent.setCellPadding(0);
		orderItemContent.setCellSpacing(0);
		orderItemContent.setBorderWidth(1);
		orderItemContent.getElement().getStyle().setBorderColor("#000000");
		HTMLTable.CellFormatter cellFormatter = orderItemContent.getCellFormatter();
		// 设置表头
		for (int i = 0; i < MAIN_ABELS.length; i++) {
			orderItemContent.setText(0, i, MAIN_ABELS[i]);
		}
		// 第二行数据
		int count = 1;
		double amount = BaseHelpUtils.getDoubleValue(map.get("amount"));
		double balanceAmount = BaseHelpUtils.getDoubleValue(map.get("balanceAmount"));
		orderItemContent.setText(count, 0,
				KeyValueManager.getValueMap("employees").get(ClientUtil.getStringFromMapNotNull(map, "drafter")));
		orderItemContent.setText(count, 1, ClientUtil.getStringFromMapNotNull(map, "title"));
//		orderItemContent.setText(count, 2, KeyValueManager.getValueMap("departments").get(departmentId));
		orderItemContent.setText(count, 2, __NF.format(amount));
//		orderItemContent.setText(count, 3, "true".equals(map.get("strikeABalance").toString()) ? "是" : "否");
		orderItemContent.setText(count, 3, __NF.format(balanceAmount));
		orderItemContent.setText(count, 4, __NF.format(amount - balanceAmount));
		orderItemContent.setText(count, 5, __DF.format((Date) map.get("startDate")));
		orderItemContent.setText(count, 6, __DF.format((Date) map.get("endDate")));
		vl.add(orderItemContent);

		// 设置样式
		for (int y = 0; y < length + 1; y++) {
			for (int i = 0; i < MAIN_ABELS.length; i++) {
				cellFormatter.getElement(y, i).getStyle().setFontSize(16, Style.Unit.PX);
				if (y == 0) {// 设置第一行的样式
					cellFormatter.getElement(y, i).getStyle().setFontWeight(Style.FontWeight.BOLD);
					cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,
							HasVerticalAlignment.ALIGN_MIDDLE);
				} else {
					if(i == 2 || i == 3 || i == 4){
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_RIGHT,
								HasVerticalAlignment.ALIGN_MIDDLE);
						cellFormatter.getElement(y, i).getStyle().setPaddingRight(4, Style.Unit.PX);
					}else{
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,
								HasVerticalAlignment.ALIGN_MIDDLE);
					}
				}
				if(i == 2 || i == 3 || i == 4){
					cellFormatter.getElement(y, i).getStyle().setWidth(100, Style.Unit.PX);
				}
			}
		}
		return vl;
	}
}
