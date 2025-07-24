package com.pomplatform.client.workflow.panel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
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
import com.pomplatform.client.workflow.projectNormalReimbursement.panel.BudgetPrintCommonHtml;
import com.pomplatform.client.workflow.projectNormalReimbursement.panel.PrintCommonHtml;
import com.smartgwt.client.data.Record;

public class EmployeeMoneyPrintPanel extends AbstractPrint {

	private static final Logger __LOGGER = Logger.getLogger("");
																					   
	public static final String[] HEAD_ABELS = {"付款单位:", "借款单号:", "部&nbsp;&nbsp;门:", "申请日期:", "申 请  人:", "单位:"};

	public static final String[] MAIN_ABELS = { "借款事由", "借款金额", "借款日期", "还款日期"};

	public static final String[] WORKFLOW_ABELS = { "审批人", "角色", "处理开始时间", "处理结束时间", "状态", "意见"};
	
	public static final String[] RECIVE_MONEY_ABELS = { "序号", "户名", "账号", "开户银行", "付款金额"};

	public static final String MAIN_TITLE = "借款申请";

	public final static String ACTIVITIES_NAME = "activities";

	public static DateTimeFormat __DF = DateTimeFormat.getFormat("yyyy-MM-dd");
	public static NumberFormat __NF = NumberFormat.getFormat("##,###,###,###,##0.00");

	@Override
	public HTML generatePrintHTML() {
		HTML layout = new HTML();
		layout.setHeight("100%");
		Map map = getPrintData();
		__LOGGER.info(map.toString());
		Record record = getProcessInformation();
		List<Map> childOne = (List<Map>) map.get("detailProjectNormalReimbursementDetail");
		List<Map> childTwo = (List<Map>) map.get("detailNormalReimbursementLinkProject");
		List<Map> budgetlist = (List<Map>) map.get("detailAboutReimbursementPayseq");
		List<Map> childThree = new ArrayList<>();
		if(null != map.get("detailSprocessbilllistpppor")){
			childThree = (List<Map>) map.get("detailSprocessbilllistpppor");
		}
		//流程节点数据
//		Record processInstance = record.getAttributeAsRecord("processInstance");
//		Record[] activities = processInstance.getAttributeAsRecordArray(ACTIVITIES_NAME);
//		if (activities == null || activities.length == 0) {
//			
//		}
		map.put("applyTime", map.get("operateTime"));
		String applyEmployeeId = ClientUtil.getStringFromMapNotNull(map, "employeeId");
		VerticalPanel vPanel = new VerticalPanel();
		vPanel.getElement().getStyle().setPosition(Position.RELATIVE);
		vPanel.setWidth("100%");
		vPanel.setHeight("100%");
		vPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vPanel.setSpacing(10);
		vPanel.add(PrintCommonHtml.headHtml(HEAD_ABELS, MAIN_TITLE, map, applyEmployeeId));
		vPanel.add(generateMianData(map));
		vPanel.add(PrintCommonHtml.generateMoneyReciveList(childThree));
		if(budgetlist.size()>0) {
			vPanel.add(BudgetPrintCommonHtml.BudgetInfoList(budgetlist));
		}
		vPanel.add(PrintCommonHtml.footHtml());
		layout.getElement().appendChild(vPanel.getElement());
		return layout;
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
		orderItemContent.setText(count, 0, ClientUtil.getStringFromMapNotNull(map, "reason"));
		orderItemContent.setText(count, 1, __NF.format(BaseHelpUtils.getDoubleValue(map.get("borrowMoney"))));
		orderItemContent.setText(count, 2, __DF.format((Date) map.get("borrowDate")));
		orderItemContent.setText(count, 3, __DF.format((Date) map.get("anticipatedDate")));
		
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
					if(i == 1){
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_RIGHT,
								HasVerticalAlignment.ALIGN_MIDDLE);
						cellFormatter.getElement(y, i).getStyle().setPaddingRight(4, Style.Unit.PX);
					}else{
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,
								HasVerticalAlignment.ALIGN_MIDDLE);
					}
				}
				if(i == 1){
					cellFormatter.getElement(y, i).getStyle().setWidth(100, Style.Unit.PX);
				}
			}
		}
		return vl;
	}
}
