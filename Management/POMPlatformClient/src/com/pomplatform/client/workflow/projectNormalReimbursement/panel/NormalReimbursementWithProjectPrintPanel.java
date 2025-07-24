package com.pomplatform.client.workflow.projectNormalReimbursement.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
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
import com.pomplatform.client.common.SyncDataUtil;
import com.smartgwt.client.data.Record;

public class NormalReimbursementWithProjectPrintPanel extends AbstractPrint {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	public static final String[] HEAD_ABELS = {"付款单位:", "报销单号:", "部&nbsp;&nbsp;门:", "申请日期:", "报 销 人:", "单位:"};

	public static final String[] MAIN_ABELS = { "起草人", "主题", "报销金额", "冲账金额", "实付金额" };

	public static final String[] CHILD_ONE_ABELS = { "序号", "摘要", "报销科目", "报销选项", "报销金额" };

	public static final String[] CHILD_TWO_ABELS = { "序号", "项目", "订单编号", "业务部门", "进项税", "成本", "费用"  };

	public static final String[] WORKFLOW_ABELS = { "审批人", "角色", "处理开始时间", "处理结束时间", "状态", "意见" };

	public static final String[] RECIVE_MONEY_ABELS = { "序号", "户名", "账号", "开户银行", "付款金额" };

	public static final String MAIN_TITLE = "项目日常报销";

	public static final String CHILD_ONE_TITLE = "费用明细清单";

	public static final String CHILD_TWO_TITLE = "每个项目承担的费用";

	public static final String RECIVE_MONEY_TITLE = "收款方信息";

	public final static String ACTIVITIES_NAME = "activities";

	public static DateTimeFormat __DF = DateTimeFormat.getFormat("yyyy-MM-dd");
	public static NumberFormat __NF = NumberFormat.getFormat("##,###,###,###,##0.00");

	@Override
	public HTML generatePrintHTML() {
		HTML layout = new HTML();
		layout.setHeight("100%");
		Map map = getPrintData();
		Record record = getProcessInformation();
		List<Map> childOne = (List<Map>) map.get("detailProjectNormalReimbursementDetail");
		List<Map> childTwo = (List<Map>) map.get("detailNormalReimbursementLinkProject");
		List<Map> childThree = new ArrayList<>();
		double balanceAmount = 0;//冲账金额
		if(null != map.get("detailSprocessbilllistpppor")){
			childThree = (List<Map>) map.get("detailSprocessbilllistpppor");
			for (Map __map : childThree) {
				balanceAmount += BaseHelpUtils.getDoubleValue(__map.get("balanceAmount"));
			}
		}
		List<Map> budgetlist = (List<Map>) map.get("detailAboutReimbursementPayseq");
		map.put("balanceAmount", balanceAmount);
		// 流程节点数据
		// Record processInstance =
		// record.getAttributeAsRecord("processInstance");
		// Record[] activities =
		// processInstance.getAttributeAsRecordArray(ACTIVITIES_NAME);
		// if (activities == null || activities.length == 0) {
		//
		// }
//		Record processInstance = getProcessInformation().getAttributeAsRecord("processInstance"); 
//		DrawPane draw = ShowPanelUtils.generateDetailProcessPane(processInstance);
//		draw.getPrintHTML(new PrintProperties(), new PrintHTMLCallback(){
//
//			@Override
//			public void setHTML(String html) {
//				__LOGGER.info(html);
//			}
//			
//		});
		String applyEmployeeId = ClientUtil.getStringFromMapNotNull(map, "employeeId");
		
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
		if(budgetlist.size()>0) {
			vPanel.add(BudgetPrintCommonHtml.BudgetInfoList(budgetlist));
		}
		vPanel.add(PrintCommonHtml.footHtml());
		layout.getElement().appendChild(vPanel.getElement());
		
		return layout;
	}

	/**
	 * 
	 * @Title: generateChildTwoList @Description: 每个项目承担的费用详细数据 @param @param
	 * childTwoList @param @return @return VerticalPanel @throws
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
			String projects = BaseHelpUtils.getString(rr.get("projectId"));
			String contractCode = BaseHelpUtils.getString(rr.get("contractCode"));
			String plateId = BaseHelpUtils.getString(rr.get("plateId"));
			orderItemContent.setText(count, 0, count + "");
			String projectName = SyncDataUtil.getProjectName(BaseHelpUtils.getIntValue(projects));
//			orderItemContent.setText(count, 1, KeyValueManager.getValueMap("projects").get(projects));
			orderItemContent.setText(count, 1, projectName);
			orderItemContent.setText(count, 2, contractCode);
			orderItemContent.setText(count, 3, KeyValueManager.getValueMap("system_dictionary_1").get(plateId));
			orderItemContent.setText(count, 4, __NF.format(BaseHelpUtils.getDoubleValue(rr.get("inputTax"))));
			orderItemContent.setText(count, 5, __NF.format(BaseHelpUtils.getDoubleValue(rr.get("finalAmount"))));
			orderItemContent.setText(count, 6, __NF.format(BaseHelpUtils.getDoubleValue(rr.get("amount"))));
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
					if(i == 4 || i == 5 || i ==6){
						cellFormatter.getElement(y, i).getStyle().setPaddingRight(4, Style.Unit.PX);
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_RIGHT,
								HasVerticalAlignment.ALIGN_MIDDLE);
					}else{
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,
								HasVerticalAlignment.ALIGN_MIDDLE);
					}
				}
				
				switch (i) {
				case 2:
					cellFormatter.getElement(y, i).getStyle().setWidth(200, Style.Unit.PX);
					break;
				case 3:
					cellFormatter.getElement(y, i).getStyle().setWidth(84, Style.Unit.PX);
					break;	
				case 4:
				case 5:
				case 6:
					cellFormatter.getElement(y, i).getStyle().setWidth(80, Style.Unit.PX);
					break;
				}
			}
		}
		// 添加汇总模块
		vl.add(PrintCommonHtml.summaryTable(new BigDecimal(allMoney)));

		return vl;
	}

	/**
	 * 
	 * @Title: generateChildOneList @Description: 费用明细清单表详细数据 @param @param
	 * childOneList @param @return @return VerticalPanel @throws
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
			String mainItemId = rr.get("mainItemId").toString();
			String subItemId = rr.get("subItemId").toString();
			orderItemContent.setText(count, 0, count + "");
			orderItemContent.setText(count, 1, BaseHelpUtils.getString(rr.get("remark")));
			orderItemContent.setText(count, 2, KeyValueManager.getValueMap("parent_subject_types").get(mainItemId));
			orderItemContent.setText(count, 3, KeyValueManager.getValueMap("subject_types").get(subItemId));
			orderItemContent.setText(count, 4, __NF.format(BaseHelpUtils.getDoubleValue(rr.get("amount"))));
			allMoney += BaseHelpUtils.getDoubleValue(rr.get("amount"));
			count++;
		}

		vl.add(orderItemContent);

		// 设置样式
		for (int y = 0; y < length + 1; y++) {
			for (int i = 0; i < CHILD_ONE_ABELS.length; i++) {
				cellFormatter.getElement(y, i).getStyle().setFontSize(16, Style.Unit.PX);
				if (y == 0) {// 设置第一行的样式
					cellFormatter.getElement(y, i).getStyle().setFontWeight(Style.FontWeight.BOLD);
					cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,
							HasVerticalAlignment.ALIGN_MIDDLE);
				} else {
					if (i == 4) {
						cellFormatter.getElement(y, i).getStyle().setPaddingRight(4, Style.Unit.PX);
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_RIGHT,
								HasVerticalAlignment.ALIGN_MIDDLE);
					} else {
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,
								HasVerticalAlignment.ALIGN_MIDDLE);
					}
				}
				if (i == 4) {
					cellFormatter.getElement(y, i).getStyle().setWidth(100, Style.Unit.PX);
				}
			}
		}
		// 添加汇总模块
		vl.add(PrintCommonHtml.summaryTable(new BigDecimal(allMoney)));
		return vl;
	}

	/**
	 * 
	 * @Title: generateMianData @Description: 主表数据HTML构建 @param @param
	 * map @param @return @return VerticalPanel @throws
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
		orderItemContent.setText(count, 0, KeyValueManager.getValueMap("employees")
				.get(ClientUtil.getStringFromMapNotNull(map, "applyEmployeeId")));
		orderItemContent.setText(count, 1, ClientUtil.getStringFromMapNotNull(map, "reimbursementName"));
		orderItemContent.setText(count, 2, __NF.format(BaseHelpUtils.getDoubleValue(map.get("amount"))));
//		orderItemContent.setText(count, 3, "true".equals(map.get("strikeABalance").toString()) ? "是" : "否");
		orderItemContent.setText(count, 3, __NF.format(balanceAmount));
		orderItemContent.setText(count, 4, __NF.format(amount - balanceAmount));
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
					if (i == 2 || i == 3 || i == 4) {
						cellFormatter.getElement(y, i).getStyle().setPaddingRight(4, Style.Unit.PX);
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_RIGHT,
								HasVerticalAlignment.ALIGN_MIDDLE);
					} else {
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,
								HasVerticalAlignment.ALIGN_MIDDLE);
					}
				}
				if (i == 2 || i == 3 || i == 4) {
					cellFormatter.getElement(y, i).getStyle().setWidth(100, Style.Unit.PX);
				}
			}
		}
		return vl;
	}
}
