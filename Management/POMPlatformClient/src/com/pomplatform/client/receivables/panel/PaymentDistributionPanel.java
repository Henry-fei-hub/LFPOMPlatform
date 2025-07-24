package com.pomplatform.client.receivables.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.panel.CapitalprojectSearchPanel;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.panel.McapitaldistributionlinkdepartmentdcorPanel;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.panel.McapitaldistributionlinksubcontractpcorPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class PaymentDistributionPanel extends AbstractWizadPage implements HasHandlers{
	
	
	
	private CapitalDepartmentPanel capitalDepartmentPanel;// 部门面板 
	
//	private CapitalEmployeePanel capitalEmployeePanel;//员工面板
	
//	private SsubcontractssporPanel subcontractssporPanel;//子订单面板
	
	private CapitalprojectSearchPanel capitalprojectSearchpanel;//子订单面板
	
//	private McapitalemployeeecceedorPanel mcapitalemployeeecceedorPanel;//   收款与员工面板
	
//	private McapitaldepartmentdccddorPanel mcapitaldepartmentdccddorPanel;//收款与部门面板
	
//	private McapitalsubcontractscoorPanel mcapitalsubcontractscoorPanel;//收款与子订单关联面板
	
	private McapitaldistributionlinkdepartmentdcorPanel mcapitaldistributionlinkdepartmentdcorPanel;//收款与部门面板
	
	private McapitaldistributionlinksubcontractpcorPanel mcapitaldistributionlinksubcontractpcorPanel;//收款与子订单关联面板
	
    public final static String BORDER_STYLE = "1px solid gray";
    public final static String BACKGROUND_COLOR = "azure";
    public final static String BUTTON_BACKGROUND_COLOR = "azure";
    public final static String FORM_BORDER_STYLE = "1px solid #808080";
    
	public DelicacyListGrid departmentGrid;
	
	public DelicacyListGrid employeeGrid;
	
	public DelicacyListGrid subcontractGrid;
	
	private static final Logger __LOGGER = Logger.getLogger("");
	
	public BigDecimal borrowMoney = BigDecimal.ZERO;
	public Integer capitalId ;
	
	public PaymentDistributionPanel(ListGrid __grid, int contractId){
		ListGridRecord selectRecord = __grid.getSelectedRecord();
		borrowMoney = new BigDecimal(selectRecord.getAttributeAsString("borrowMoney"));
		capitalId = selectRecord.getAttributeAsInt("capitalId"); 
//		setBorder(BORDER_STYLE);
		setBackgroundColor(BACKGROUND_COLOR);
		VLayout mainLayout = new VLayout();
		
		HLayout allH =new HLayout();
		allH.setWidth100();
		allH.setHeight100();
		allH.setMargin(5);
		
		VLayout leftLayout = new VLayout();//左边的表单
		leftLayout.setWidth("20%");
		leftLayout.setHeight100();
		
		VLayout middleLayout = new VLayout();
		middleLayout.setWidth("40%");
		middleLayout.setBorder(BORDER_STYLE);
		middleLayout.setHeight100();
		
		VLayout rightLayout = new VLayout();//右边的合同与阶段面板
		rightLayout.setWidth("40%");
		rightLayout.setBorder(BORDER_STYLE);
		rightLayout.setHeight100();
		
		//被动数据加载面板定义
		mcapitaldistributionlinkdepartmentdcorPanel = new McapitaldistributionlinkdepartmentdcorPanel();
		mcapitaldistributionlinkdepartmentdcorPanel.setHeight("40%");
		mcapitaldistributionlinkdepartmentdcorPanel.setCapitalId(capitalId);
		mcapitaldistributionlinkdepartmentdcorPanel.commonQuery();
		departmentGrid = mcapitaldistributionlinkdepartmentdcorPanel.getGrid();
//		mcapitalemployeeecceedorPanel = new McapitalemployeeecceedorPanel();
//		mcapitalemployeeecceedorPanel.setHeight("40%");
//		mcapitalemployeeecceedorPanel.setCapitalId(capitalId);
//		mcapitalemployeeecceedorPanel.commonQuery();
//		employeeGrid = mcapitalemployeeecceedorPanel.getGrid();
		
		mcapitaldistributionlinksubcontractpcorPanel = new McapitaldistributionlinksubcontractpcorPanel();
		mcapitaldistributionlinksubcontractpcorPanel.setHeight("40%");
		mcapitaldistributionlinksubcontractpcorPanel.setCapitalId(capitalId);
		mcapitaldistributionlinksubcontractpcorPanel.commonQuery();
		subcontractGrid = mcapitaldistributionlinksubcontractpcorPanel.getGrid();
		
		//主动设置数据面板加载
		capitalDepartmentPanel = new CapitalDepartmentPanel();
		capitalDepartmentPanel.setHeight("60%");
		capitalDepartmentPanel.departmentGrid = departmentGrid;
		
//		capitalEmployeePanel = new CapitalEmployeePanel();
//		capitalEmployeePanel.setHeight("60%");
//		capitalEmployeePanel.employeeGrid = employeeGrid;
		
		capitalprojectSearchpanel = new CapitalprojectSearchPanel();
		capitalprojectSearchpanel.setHeight("60%");
		capitalprojectSearchpanel.subcontractGrid = subcontractGrid;
		capitalprojectSearchpanel.setContractId(contractId);
		capitalprojectSearchpanel.commonQuery();
		
		McapitalecoosmeorViewer detailForm = new McapitalecoosmeorViewer();
		detailForm.setParentSearchForm(searchForm);
		detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
		detailForm.initComponents();
		detailForm.viewSelectedData(__grid);
		
		ToolStrip btnLayout = new ToolStrip();
		btnLayout.setVPolicy(LayoutPolicy.FILL);
		btnLayout.setPadding(5);
		btnLayout.setHeight(40);
		btnLayout.setWidth100();
		btnLayout.addFill();
		
		
		IButton saveBtn = new IButton("进行分配");
		saveBtn.setIcon("[SKIN]/actions/save.png");
		btnLayout.addMember(saveBtn);
		btnLayout.addSpacer(10);
		saveBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
							
				if(checkData()){
					SC.ask("提示", "确认分配?", new BooleanCallback() {
						
						@SuppressWarnings("rawtypes")
						@Override
						public void execute(Boolean value) {
							if(value){
								ListGridRecord [] subcontractRecords = subcontractGrid.getRecords();
								ListGridRecord [] depRecords = departmentGrid.getRecords();
								List<Map> departmentList = new ArrayList<>();
								List<Map> subcontractList = new ArrayList<>();
								for (ListGridRecord listGridRecord : subcontractRecords) {
									subcontractList.add(listGridRecord.toMap());
								}
								for (ListGridRecord listGridRecord : depRecords) {
									departmentList.add(listGridRecord.toMap());
								}
								Map<String, Object> params = new HashMap<>();
								params.put("employeeId", ClientUtil.getEmployeeId());
								params.put("capitalId", capitalId);
								params.put("departmentList", departmentList);
								params.put("subcontractList", subcontractList);
								params.put("opt_type", "collectionDistribution");
								DBDataSource.callOperation("EP_CollectionDistribution", "collectionDistribution", params, new DSCallback() {
									
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if (dsResponse.getStatus() >= 0) {
											getFatherWindow().destroy();
											DataEditEvent dee = new DataEditEvent();
				                            fireEvent(dee);
										}else{
											ClientUtil.displayErrorMessage(dsResponse);
										}
										
									}
								});
							}
						}
					});
				}
				
			}
		});
		
		IButton cancelBtn = new IButton("取消");
		cancelBtn.setIcon("[SKIN]/actions/close.png");
		btnLayout.addMember(cancelBtn);
		btnLayout.addSpacer(10);
		cancelBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				SC.ask("确认取消?", new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						if(value){
							getFatherWindow().destroy();
						}
						
					}
				});
			}
		});
		middleLayout.addMember(capitalDepartmentPanel);
		middleLayout.addMember(mcapitaldistributionlinkdepartmentdcorPanel);
		rightLayout.addMember(capitalprojectSearchpanel);
		rightLayout.addMember(mcapitaldistributionlinksubcontractpcorPanel);
		leftLayout.addMember(detailForm);
		allH.addMember(leftLayout);
		allH.addMember(middleLayout);
		allH.addMember(rightLayout);
		mainLayout.addMember(allH);
		mainLayout.addMember(btnLayout);
		addMember(mainLayout);
	}

	@Override
	public Map getValuesAsMap() {
		return null;
	}

	@Override
	public boolean checkData() {
		boolean flag = true;
		if(mcapitaldistributionlinksubcontractpcorPanel.checkData() && mcapitaldistributionlinkdepartmentdcorPanel.checkData()){
			ListGridRecord [] subcontractRecords = subcontractGrid.getRecords();
			ListGridRecord [] depRecords = departmentGrid.getRecords();
			if(subcontractRecords.length > 0 && depRecords.length > 0){
				BigDecimal depSumMoney = BigDecimal.ZERO; 
				BigDecimal subcontractSumMoney = BigDecimal.ZERO; 
				for (ListGridRecord listGridRecord : depRecords) {
					depSumMoney = depSumMoney.add(new BigDecimal(listGridRecord.getAttributeAsString("money")));
				}
				for (ListGridRecord listGridRecord : subcontractRecords) {
					subcontractSumMoney = subcontractSumMoney.add(new BigDecimal(listGridRecord.getAttributeAsString("money")));
				}
				if(borrowMoney.compareTo(depSumMoney) != 0){
					flag = false;
					SC.say("收款金额与分配给部门的总金额不想等");
				}
				if(borrowMoney.compareTo(subcontractSumMoney) < 0){
					flag = false;
					SC.say("分配给订单的总金额不想大于收款金额");
				}
			}else{
				SC.say("没有添加部门分配数据或没有添加订单分配数据");
				flag = false;
			}
		}else{
			SC.say("请按系统提示填写数据");
			flag = false;
		}
		return flag;
	}

	@Override
	public void startEdit() {
		int employeeId = ClientUtil.getEmployeeId();
		Map<String, Object> params = new HashMap<>();
		params.put("employeeId", employeeId);
		params.put("opt_type", "getApplyInitData");
		DBDataSource.callOperation("EP_CustomMinvocieapplydedaocor", "getApplyInitData", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				__form.setValues(dsResponse.getData()[0].toMap());
			}
		});
		
	}
	
	private Window fatherWindow;

	public Window getFatherWindow() {
		return fatherWindow;
	}

	public void setFatherWindow(Window fatherWindow) {
		this.fatherWindow = fatherWindow;
	}
	
	protected final HandlerManager handlerManager = new HandlerManager(this);
    protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

    @Override
    public void fireEvent(GwtEvent<?> event) {
        handlerManager.fireEvent(event);
    }

    public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
        return handlerManager.addHandler(DataEditEvent.TYPE, handler);
    }
}
