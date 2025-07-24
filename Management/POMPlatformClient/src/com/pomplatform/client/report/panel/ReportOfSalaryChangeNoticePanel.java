package com.pomplatform.client.report.panel;

import com.smartgwt.client.widgets.*;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.Map;
import java.util.logging.Logger;

public class ReportOfSalaryChangeNoticePanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	protected ReportOfSalaryChangeNoticeForm detailForm;
	
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ReportOfSalaryChangeNoticePanel cm = new ReportOfSalaryChangeNoticePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ReportPayChangeOnboardEmp";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}
	
	@Override
	public Canvas getViewPanel() {
		detailForm = new ReportOfSalaryChangeNoticeForm();
		detailForm.setKeepInParentRect(true);
		detailForm.startEdit();
		return detailForm;
	}

	@Override
	public void initComponents() {
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by employee_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return null;
	}


}

