package com.pomplatform.client.receivables.panel;

import com.smartgwt.client.widgets.*;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.pomplatform.client.receivables.datasource.DSIncomeMoneyForWeek;
import com.pomplatform.client.receivables.form.IncomeMoneyForWeekSearchForm;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.Map;
import java.util.logging.Logger;

public class IncomeMoneyForWeekPanel extends AbstractSearchPanel
{

	private static final Logger __LOGGER = Logger.getLogger("");
	protected IncomeMoneyForWeekForm detailForm;
	
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			IncomeMoneyForWeekPanel cm = new IncomeMoneyForWeekPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "IncomeMoneyForWeek";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
	}

	@Override
	public Canvas getViewPanel() {
		detailForm = new IncomeMoneyForWeekForm();
		detailForm.setKeepInParentRect(true);
		detailForm.startEdit();
		return detailForm;
	}
	
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new IncomeMoneyForWeekSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSIncomeMoneyForWeek.getInstance();
	}


}

