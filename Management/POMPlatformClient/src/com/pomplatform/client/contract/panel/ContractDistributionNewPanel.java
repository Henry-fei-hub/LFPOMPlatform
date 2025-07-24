package com.pomplatform.client.contract.panel;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GenericBase;
import com.delicacy.client.ui.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.contract.datasource.DSContractDistributionChild;
import com.pomplatform.client.contract.datasource.DSContractDistributionNew;
import com.pomplatform.client.contract.form.ContractDistributionNewSearchForm;
import com.pomplatform.client.contract.form.ContractDistributionNewViewer;
import com.pomplatform.client.contract.form.TeamBuildingForm;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import java.util.*;
import java.util.logging.Logger;

public class ContractDistributionNewPanel extends AbstractExpansionRelatedPage
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ContractDistributionNewPanel cm = new ContractDistributionNewPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ContractDistributionNew";
		}

	}

//	@Override
//	public void init(){
//		super.init();
//		__controlPosition = LayoutConstant.RIGHT;
//	}

	@Override
	public void initComponents() {
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);

		//团队策划的
		IButton teamButton = new IButton("团队策划");
		controlLayout.addMember(teamButton);
		teamButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				PopupWindow pWindow = new PopupWindow();
				pWindow.setTitle("团队组建");
				pWindow.setWidth("80%");
				pWindow.setHeight("80%");
				pWindow.centerInPage();
				TeamBuildingForm vLaout = new TeamBuildingForm();
				Record record = resultGrid.getSelectedRecord();
				SC.debugger();
				if (!BaseHelpUtils.isNullOrEmpty(record)) {
					vLaout.initComponents(record.toMap());
				}
				pWindow.addItem(vLaout);
				pWindow.show();
			}
		});
		
		IButton download = new IButton("导出");
		controlLayout.addMember(download);
		download.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map<Object, Object> condition = generateCriteria();
				DBDataSource.downloadFile("DW_ContractDistributionNew", condition);
			}
		});
		controlLayout.addMember(download);
		
		commonQuery();
	}



	public void showDetail() {
		GWT.runAsync(new RunAsyncCallback() {
			@Override
			public void onFailure(Throwable reason) {
				SC.say("failure to download code");
			}
			@Override
			public void onSuccess() {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("ContractDistributionNew"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ContractDistributionNewViewer detailForm = new ContractDistributionNewViewer();
				detailForm.setParentSearchForm(searchForm);
				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
				detailForm.initComponents();
				detailForm.viewSelectedData(resultGrid);
				detail.setContent(detailForm);
				detail.centerInPage();
				detail.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		SC.debugger();
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.SHOW_CONTRACT_DISTRIBUTION_ALL_DATA)) {
			String plateIds = PomPlatformClientUtil.getRolePlateId();
			if(BaseHelpUtils.isNullOrEmpty(plateIds)){
				criteria.put("plateId", -1);
			}else{
				List<Map> keyvalues = new ArrayList<>();
				Map<String, String> kv = new HashMap<>();
				kv.put("key", "and c.contract_id =?");
				kv.put("value", " and c.contract_id =? and cd.plate_id in("+plateIds+")");
				keyvalues.add(kv);
				criteria.put("keyValues", keyvalues);
			}
		}
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ContractDistributionNewSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSContractDistributionNew.getInstance();
	}

	@Override
	public DataSource getChildDataSource() {
		return DSContractDistributionChild.getInstance();
	}

	@Override
	public void customCommonQuery(ListGridRecord record, ListGrid childGrid) {
		Integer contractId = record.getAttributeAsInt("contractId");
		Map searchValue = generateCriteria();
		String contractCode = BaseHelpUtils.getString(searchValue.get("contractCode"));
		Object temp = searchValue.get("startDate");
		Date startDate = (Date) temp;
		SC.debugger();
		Object temp2 = searchValue.get("endDate");
		Date endDate = (Date) temp2;
		HashMap<String, Object> params = new HashMap<>();
		if (null != contractId){
			params.put("contractId", contractId);
		}
		if (null != contractCode){
			params.put("contractCode", contractCode);
		}
		if (null != startDate){
			params.put("startDate", startDate);
		}
		if (null != endDate) {
			params.put("endDate", endDate);
		}
		DBDataSource.callOperation("NQ_ContractDistributionChild", "find", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
				Record[] data = dsResponse.getData();
				childGrid.setData(data);
			}
		});
	}

	@Override
	public boolean doCustomCommonQuery() {
		return true;
	}

	@Override
	public Canvas[] getChildGridOptionCanvas() {
		Canvas[] arr = new Canvas[1];
		//定义修改订单的提成系数的按钮
		IButton modifyButton = PermissionControl.createPermissionButton("修改提成系数" , ERPPermissionStatic.MODIFY_PROJECT_RATE);
		modifyButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				if (resultChildGrid.anySelected()) {
					PopupWindow popupWindow = new PopupWindow();
					popupWindow.setWidth("40%");
					popupWindow.setHeight("60%");
					popupWindow.setPadding(15);
					VLayout panel = new VLayout();
					panel.setHeight("90%");
					panel.setLayoutMargin(30);
					DynamicForm _form = new DynamicForm();

					TextItem projectIdItem = new TextItem("订单ID");
					projectIdItem.setWidth("*");
					projectIdItem.setRequired(true);
					projectIdItem.setCanEdit(false);
					projectIdItem.setHidden(false);

					TextItem projectCodeItem = new TextItem("订单编号");
					projectCodeItem.setWidth("*");
					projectCodeItem.setHidden(false);
					projectCodeItem.setRequired(true);
					projectCodeItem.setCanEdit(false);

					TextItem projectNameItem = new TextItem("订单名称");
					projectNameItem.setWidth("*");
					projectNameItem.setHidden(false);
					projectNameItem.setRequired(true);
					projectNameItem.setCanEdit(false);

					SelectItem businessTypeItem = new SelectItem("业态");
					businessTypeItem.setWidth("*");
					businessTypeItem.setHidden(false);
					businessTypeItem.setCanSelectText(true);
					businessTypeItem.setRequired(true);

					TextItem rateItem = new TextItem("提成系数");
					rateItem.setHidden(false);
					rateItem.setWidth("*");
					rateItem.setCanEdit(true);
					rateItem.setRequired(true);
					_form.setHeight("90%");
					_form.setItems(projectIdItem , projectCodeItem, projectNameItem,businessTypeItem, rateItem);
					ClientUtil.DynamicFormProcessAccordingToDevice(_form);

					ListGridRecord record = resultChildGrid.getSelectedRecord();

					Integer projectId = record.getAttributeAsInt("projectId");
					projectIdItem.setValue(projectId);
					String projectCode = record.getAttributeAsString("contractCode");
					projectCodeItem.setValue(projectCode);
					String projectName = record.getAttributeAsString("projectName");
					projectNameItem.setValue(projectName);
					Integer businessType = record.getAttributeAsInt("businessType");
					businessTypeItem.setValue(businessType);
					Integer rate = record.getAttributeAsInt("commissionsRate");
					rateItem.setValue(rate);

					HLayout controlLayout = new HLayout();
					controlLayout.setWidth("100%");
					controlLayout.setHeight("10%");
					controlLayout.setAlign(Alignment.CENTER);

					panel.addMember(_form);
					panel.addMember(controlLayout);
					popupWindow.addMember(panel);
					popupWindow.setTitle("数据维护");
					popupWindow.centerInPage();
					popupWindow.show();

				}else {
					SC.say("请选择一条数据进行修改");
				}
			}
		});
		arr[0] = modifyButton;
		return arr;
	}
}

