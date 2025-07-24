package com.pomplatform.client.financialtransactionaccount.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractPrint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.smartgwt.client.data.Record;

public class TransDetailSummaryPrintPanel extends AbstractPrint {
	private static final Logger logger = Logger.getLogger("");
	@Override
	public HTML generatePrintHTML() {
//		String[] columnTitle = {"行号", "账户类型", "账户编号", "名称", "账户状态", "期初借", "期初贷", "借方发生额", "贷方发生额", "期末借", "期末贷"};
		String[] columnTitle = {"账户类型", "账户编号", "名称", "期初借", "期初贷", "借方发生额", "贷方发生额", "期末借", "期末贷"};
		HTML layout = new HTML();
		layout.setHeight("100%");
		Map map = getPrintData();
		Record[] records = (Record[])map.get("records");
		for(Record r : records) {
			logger.info(r.toMap().toString());
		}
		VerticalPanel vPanel = new VerticalPanel();
		vPanel.getElement().getStyle().setPosition(Position.RELATIVE);
		vPanel.setWidth("100%");
		vPanel.setHeight("100%");
		vPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vPanel.setSpacing(10);
		HTML title = new HTML("往来汇总表");
		title.getElement().getStyle().setFontSize(32, Style.Unit.PX);
		title.getElement().getStyle().setFontWeight(Style.FontWeight.BOLD);
		vPanel.add(title);
		layout.getElement().appendChild(vPanel.getElement());
		
		FlexTable content = new FlexTable();
		content.setWidth("100%");
		content.setCellPadding(0);
		content.setCellSpacing(0);
		content.setBorderWidth(1);
		content.getElement().getStyle().setBorderColor("#000000");
		HTMLTable.CellFormatter cellFormatter = content.getCellFormatter();

		for (int i = 0; i < columnTitle.length; i++) {
			content.setText(0, i, columnTitle[i]);
		}
		
		int length = records.length;
		NumberFormat __NF = NumberFormat.getFormat("##,###,###,###,##0.00");
		int count = 1;
		for (Record rr : records) {
//			"账户类型", "账户编号", "名称", "账户状态", "期初借", "期初贷", "借方发生额", "贷方发生额", "期末借", "期末贷"
			int column = 0;
//			content.setText(count, column++, count + "");
			content.setText(count, column++, KeyValueManager.getValueMap("system_dictionary_230").get(BaseHelpUtils.getString(rr.getAttribute("accountType"))));
			content.setText(count, column++, BaseHelpUtils.getString(rr.getAttribute("financeNo")));
			content.setText(count, column++, BaseHelpUtils.getString(rr.getAttribute("accountName")));
//			content.setText(count, column++, KeyValueManager.getValueMap("system_dictionary_217").get(BaseHelpUtils.getString(rr.getAttribute("accountStatus"))));
			content.setText(count, column++, __NF.format(BaseHelpUtils.getDoubleValue(rr.getAttribute("initStandardDebit"))));
			content.setText(count, column++, __NF.format(BaseHelpUtils.getDoubleValue(rr.getAttribute("initStandardCredit"))));
			content.setText(count, column++, __NF.format(BaseHelpUtils.getDoubleValue(rr.getAttribute("standardDebit"))));
			content.setText(count, column++, __NF.format(BaseHelpUtils.getDoubleValue(rr.getAttribute("standardCredit"))));
			content.setText(count, column++, __NF.format(BaseHelpUtils.getDoubleValue(rr.getAttribute("endingStandardDebit"))));
			content.setText(count, column, __NF.format(BaseHelpUtils.getDoubleValue(rr.getAttribute("endingStandardCredit"))));
			count++;
		}

		vPanel.add(content);

		// 设置样式
		for (int y = 0; y < length + 1; y++) {
			for (int i = 0; i < columnTitle.length; i++) {
				cellFormatter.getElement(y, i).getStyle().setFontSize(12, Style.Unit.PX);
				if (y == 0) {// 设置第一行的样式
					cellFormatter.getElement(y, i).getStyle().setFontWeight(Style.FontWeight.BOLD);
					cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,
							HasVerticalAlignment.ALIGN_MIDDLE);
				} else {
					if(i >= 3){
						Style style = cellFormatter.getElement(y, i).getStyle();
						style.setPaddingRight(4, Style.Unit.PX);
						style.setPaddingLeft(4, Style.Unit.PX);
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_RIGHT,
								HasVerticalAlignment.ALIGN_MIDDLE);
					}else{
						cellFormatter.setAlignment(y, i, HasHorizontalAlignment.ALIGN_CENTER,
								HasVerticalAlignment.ALIGN_MIDDLE);
					}
				}
			}
		}
		return layout;
	}
}
