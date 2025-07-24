package com.pomplatform.client.designer.panel;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.pomplatform.client.designer.datasource.DSDesignerBaseInfo;
import com.pomplatform.client.designer.form.DesignerBaseInfoUpdateForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author guanxgun
 */
public class DesignMessagePanel extends DelicacyPanel {

	private static Logger __logger = Logger.getLogger("");
	protected DesignerBaseInfoUpdateForm detailForm;

	@Override
	public Canvas getViewPanel() {
		detailForm = new DesignerBaseInfoUpdateForm();
		detailForm.setKeepInParentRect(true);
		commonQuery();
		return detailForm;
	}

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			DesignMessagePanel cm = new DesignMessagePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "SemployeeNew";
		}

	}

	public Map generateCriteria() {
		Map condition = new HashMap();
		if (!checkSearchCriteria(condition)) {
			return null;
		}
		return condition;
	}

	public void commonQuery() {
		Map condition = generateCriteria();
		if (condition == null) {
			return;
		}
		DBDataSource ds = (DBDataSource) getDataSource();
		String operationName = ds.getActionMode() + ds.getActionName();
		DBDataSource.callOperation(operationName, condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					detailForm.setRecord(dsResponse.getData()[0]);
					detailForm.startEdit();
				} else {
					SC.say(dsResponse.getErrors().get("errorMsg").toString());
				}
			}
		});
	}

	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("employeeId", ClientUtil.getEmployeeId());
		ClientUtil.addReplacement(criteria, "and plate_id <> 0", "");
		return true;
	}

	public DataSource getDataSource() {
		return DSDesignerBaseInfo.getInstance();
	}

}
