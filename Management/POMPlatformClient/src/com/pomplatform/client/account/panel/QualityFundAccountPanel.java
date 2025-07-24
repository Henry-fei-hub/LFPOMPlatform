package com.pomplatform.client.account.panel;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.Canvas;  
  
public class QualityFundAccountPanel extends DelicacyPanel {

	@Override
	public Canvas getViewPanel() {
		AccountDesignPanel panel = new AccountDesignPanel();
		int accountTypeId = 3;
		int accountId = 0;
		//加载品质基金实时余额
		Map<Object, Object> param = new HashMap<>();
		param.put("accountTypeId", accountTypeId);
		param.put("accountId",accountId);
		DBDataSource.callOperation("NQ_OnLoadLeftIntegralOfAccount", param, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				BigDecimal leftIntegral = BigDecimal.ZERO;
				if (dsResponse.getStatus() >= 0) {
					Record record = dsResponse.getData()[0];
					if(!BaseHelpUtils.isNullOrEmpty(record)){
						leftIntegral = BaseHelpUtils.getBigDecimalValue(record.getAttribute("leftIntegral"));
					}
				}
				panel.setAccountTypeId(accountTypeId);
				panel.setAccountId(accountId);
				panel.setLeftIntegral(leftIntegral);
				panel.initComponents();
			}
		});
		return panel;
	}

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			QualityFundAccountPanel cm = new QualityFundAccountPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "QualityFundAccountPanel";
		}

	}

}