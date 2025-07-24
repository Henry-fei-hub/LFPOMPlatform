package com.pomplatform.client.receivables.form;

import java.util.ArrayList;
import java.util.List;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.data.*;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.GenericViewWindow;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.receivables.datasource.DSMcapitalecoosmeor;

public class McapitalecoosmeorViewer extends AbstractDetailViewer
{


	private SearchForm __parentSearchForm;


	public McapitalecoosmeorViewer() {
	}

	@Override
	public void initComponents() {
		super.initComponents();
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "Mcapitalecoosmeor";
	}

	@Override
	public int getGroupCount() {
		return 3;
	}

	@Override
	public List<GroupColumn> getGroupColumnNames() {
		List<GroupColumn> gcs = new ArrayList<GroupColumn>();
		GroupColumn gc;
		gc = new GroupColumn();
		gc.setGroupName("GroupName1");
		gc.setGroupCaption("合同信息");
		gc.getColumnNames().add("moneyAttribute");
		gc.getColumnNames().add("contractId");
		gcs.add(gc);
		gc = new GroupColumn();
		gc.setGroupName("GroupName2");
		gc.setGroupCaption("收款账号及客户账号信息");
		gc.getColumnNames().add("selfName");
		gc.getColumnNames().add("selfBankName");
		gc.getColumnNames().add("selfBankAccount");
		gc.getColumnNames().add("otherName");
		gc.getColumnNames().add("otherBankName");
		gc.getColumnNames().add("otherBankAccount");
		gcs.add(gc);
		gc = new GroupColumn();
		gc.setGroupName("GroupName3");
		gc.setGroupCaption("账单金额及登记信息");
		gc.getColumnNames().add("borrowMoney");
		gc.getColumnNames().add("loanMoney");
//		gc.getColumnNames().add("operator");
		gc.getColumnNames().add("happenDate");
		gc.getColumnNames().add("createDate");
		gc.getColumnNames().add("employeeName");
		gc.getColumnNames().add("remark");
		gcs.add(gc);
		return gcs;
	}

	@Override
	public void viewSelectedData(ListGrid grid){
		super.viewSelectedData(grid);
	}

	@Override
	public DataSource getMainDataSource() {
		return DSMcapitalecoosmeor.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 0;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}


}

