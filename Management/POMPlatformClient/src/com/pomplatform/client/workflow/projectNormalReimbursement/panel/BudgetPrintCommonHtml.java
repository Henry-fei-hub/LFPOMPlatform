package com.pomplatform.client.workflow.projectNormalReimbursement.panel;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.google.gwt.dom.client.Style;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.pomplatform.client.common.SyncDataUtil;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;

/**
 * 
 * @Title: BudgetPrintCommonHtml.java 
 * @Package com.pomplatform.client.workflow.projectNormalReimbursement.panel 
 * @Description: 预算打印功能模板
 * @author wzy  
 * @date 2018年10月29日
 * 
 */

public class BudgetPrintCommonHtml {
	
	private static final Logger __LOGGER = Logger.getLogger("");
	
	public static final String[] BUDGET_COLUMN = { "序号", "预算附件名称","申请付款金额", "合同预算金额", "合同已付金额","合同剩余金额", "供应商", "预算类别"};
	
	public static final String BUDGET_TITLE = "预算附件";
	
	public static NumberFormat __NF = NumberFormat.getFormat("##,###,###,###,##0.00");
	
	public static VerticalPanel BudgetInfoList(List<Map> list) {
		VerticalPanel vl = new VerticalPanel();
		vl.setWidth("100%");
		vl.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vl.setSpacing(10);
		HTML tital = new HTML(BUDGET_TITLE);
		tital.getElement().getStyle().setFontSize(16, Style.Unit.PX);
		tital.getElement().getStyle().setFontWeight(Style.FontWeight.BOLD);
		vl.add(tital);

		int length = list.size();

		FlexTable orderItemContent = new FlexTable();
		orderItemContent.setWidth("100%");
		orderItemContent.setCellPadding(0);
		orderItemContent.setCellSpacing(0);
		orderItemContent.setBorderWidth(1);
		orderItemContent.getElement().getStyle().setBorderColor("#000000");
		HTMLTable.CellFormatter cellFormatter = orderItemContent.getCellFormatter();

		for (int i = 0; i < BUDGET_COLUMN.length; i++) {
			orderItemContent.setText(0, i, BUDGET_COLUMN[i]);
		}
		double allMoney = 0;
		int count = 1;
		Map<String,Object> serchMap=new HashMap<>();
		for (Map rr : list) {
			orderItemContent.setText(count, 0, count + "");
			orderItemContent.setText(count, 1, BaseHelpUtils.getString(rr.get("attachmentName")));
			orderItemContent.setText(count, 2, __NF.format(BaseHelpUtils.getDoubleValue(rr.get("payAmount"))));
			orderItemContent.setText(count, 3, __NF.format(BaseHelpUtils.getDoubleValue(rr.get("budgetContractAmount"))));
			orderItemContent.setText(count, 4, __NF.format(BaseHelpUtils.getDoubleValue(rr.get("budgetContractAmountUse"))));
			orderItemContent.setText(count, 5, __NF.format(BaseHelpUtils.getDoubleValue(rr.get("budgetContractAmountRest"))));
			//receiveUnitManage
			int receiveUnitManageId=BaseHelpUtils.getIntValue(rr.get("receiveUnitManageId"));
			serchMap.put("receiveUnitManageId", receiveUnitManageId);
			String receiveUnit=SyncDataUtil.getValueByTableName("ST_ReceiveUnitManage", "find", serchMap).getAttributeAsString("receiveUnit");
			orderItemContent.setText(count, 6, receiveUnit);
			orderItemContent.setText(count, 7, BaseHelpUtils.getString(rr.get("bddType")));
			allMoney += BaseHelpUtils.getDoubleValue(rr.get("payAmount"));
			count++;
		}

		vl.add(orderItemContent);
		// 设置样式
		for (int y = 0; y < length + 1; y++) {
			for (int i = 0; i < BUDGET_COLUMN.length; i++) {
				cellFormatter.getElement(y, i).getStyle().setFontSize(16, Style.Unit.PX);
				if (y == 0) {// 设置第一行的样式
					cellFormatter.getElement(y, i).getStyle().setFontWeight(Style.FontWeight.BOLD);
					cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,
							HasVerticalAlignment.ALIGN_MIDDLE);
				} else {
					if(i == 4 || i== 5){
						cellFormatter.getElement(y, i).getStyle().setPaddingRight(4, Style.Unit.PX);
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_RIGHT,
								HasVerticalAlignment.ALIGN_MIDDLE);
					}else{
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,
								HasVerticalAlignment.ALIGN_MIDDLE);
					}
				}
				if(i == 4 || i== 5){
					cellFormatter.getElement(y, i).getStyle().setWidth(100, Style.Unit.PX);
				}
			}
		}
		//添加汇总模块
		vl.add(PrintCommonHtml.summaryTable(new BigDecimal(allMoney)));
		return vl;
	}
	
}
