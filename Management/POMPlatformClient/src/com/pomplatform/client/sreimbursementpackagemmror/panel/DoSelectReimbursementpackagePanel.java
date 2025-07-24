package com.pomplatform.client.sreimbursementpackagemmror.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.reimbursementpackage.datasource.DSNewReimbursementPackage;
import com.pomplatform.client.reimbursementpackage.panel.NewReimbursementPackagePanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.KeyUpEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyUpHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class DoSelectReimbursementpackagePanel extends AbstractWizadPage implements HasHandlers {

	private static final Logger __LOGGER = Logger.getLogger("");

	private DynamicForm __infoForm; 
    private TextItem superSearchTextItem;
    private IButton superSearchIbutton;
    private HLayout superSearchLayout;

	public final static String BORDER_STYLE = "1px solid #ABABAB";
	public final static String BACKGROUND_COLOR = "azure";
	public final static String BUTTON_BACKGROUND_COLOR = "azure";
	public final static String FORM_BORDER_STYLE = "1px solid #808080";


	public DelicacyListGrid sourceGrid;
	
	private NewReimbursementPackagePanel leftPackagePanel;
	

	public DoSelectReimbursementpackagePanel() {
		setBorder(BORDER_STYLE);
		sourceGrid = new DelicacyListGrid(true);
		int idx = 0;
		ListGridField[] fields = new ListGridField[6];
		fields[idx] = new ListGridField("processType");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("code");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("employeeId");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("departmentId");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("amount");
		idx++;
		fields[idx] = new ListGridField("companyId");
		fields[idx].setShowGridSummary(false);
		sourceGrid.setFields(fields);
		sourceGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
		sourceGrid.setDataSource(DSNewReimbursementPackage.getInstance());
		sourceGrid.setShowGridSummary(true);
		sourceGrid.setSelectionType(SelectionStyle.SINGLE);
		sourceGrid.setCanEdit(false);
		sourceGrid.setCanSelectText(true);
		sourceGrid.setCanDragSelectText(true);
		sourceGrid.setShowRowNumbers(true);
		
		VLayout mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		
		superSearchLayout = new HLayout();
		superSearchLayout.setHeight(80);
		
		__infoForm = new DynamicForm();
		__infoForm.setWidth100();
		__infoForm.setHeight100();
		__infoForm.setNumCols(2);
		__infoForm.setMargin(10);
		
		ClientUtil.DynamicFormProcessAccordingToDevice(__infoForm);
    	superSearchTextItem=new TextItem("superSearchText", "扫描枪入口");
    	superSearchTextItem.setWidth(280);
    	superSearchTextItem.setHeight(26);
    	
    	VLayout vbtn=new VLayout(10);
        superSearchIbutton=new IButton("快速检索");
        superSearchIbutton.setHeight(26);
        vbtn.setLayoutTopMargin(15);
//        vbtn.addMember(superSearchIbutton);
        
        __infoForm.setFields(superSearchTextItem);
        superSearchLayout.addMember(__infoForm);
//        superSearchLayout.addMember(vbtn);
        
        superSearchTextItem.addKeyUpHandler(new KeyUpHandler() {
			
			@Override
			public void onKeyUp(KeyUpEvent event) {
				String originalCode= BaseHelpUtils.getString(__infoForm.getItem("superSearchText").getValue());
				if(originalCode.length()==13){
					//取第一位，为了兼容，当第一位为8去掉
					String first=originalCode.substring(0, 1);
					//分为2段
					String startStr=originalCode.substring(0,6),
					endStr=originalCode.substring(7, 12);
					
					String resultCode = startStr + "-" + endStr;
					if(Objects.equals(first, "8")){
						startStr=startStr.substring(1);
					}
					originalCode=resultCode;
					
					String code=originalCode;
					
					if(BaseHelpUtils.isNullOrEmpty(code)){
						SC.say("编号不能为空");
						return;
					}
					Map<Object,Object> param = new HashMap<>();
					param.put("opt_type", "getReimbursementByScanCode");
			    	param.put("code", originalCode);
			    	DBDataSource.callOperation("EP_ReimbursementPackageProcessor", param, new DSCallback() {
			            @Override
			            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
			            	
			                if (dsResponse.getStatus() >= 0) {
			                	Record [] getRecords = dsResponse.getData();
			                	Record [] allRecords = sourceGrid.getRecords();
			                	//检测是否含有重复数据
			                	for (Record record : getRecords) {
			                		boolean flag = true;
			                		for (Record __record : allRecords) {
										String checkCode = record.getAttributeAsString("code").trim();
										String oriCode = __record.getAttributeAsString("code").trim();
										if(checkCode.equals(oriCode)){
											flag = false;
											break;
										}
									}
			                		if(flag){
			                			sourceGrid.addData(record);
			                			
			                		}
			                		leftPackagePanel.removeData(record);
								}
			                	
			                	__infoForm.getItem("superSearchText").clearValue();
			                } else {
			                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
			                }
			            }
			        });
				}
				
			}
		});
    	//快速检索 btn
    	superSearchIbutton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				String code= BaseHelpUtils.getString(__infoForm.getItem("superSearchText").getValue());
				if(BaseHelpUtils.isNullOrEmpty(code)){
					SC.say("编号不能为空");
					return;
				}
				Map<Object,Object> param = new HashMap<>();
				param.put("opt_type", "getReimbursementByScanCode");
		    	param.put("code", code);
		    	DBDataSource.callOperation("EP_ReimbursementPackageProcessor", param, new DSCallback() {
		            @Override
		            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
		            	
		                if (dsResponse.getStatus() >= 0) {
		                	Record [] getRecords = dsResponse.getData();
		                	Record [] allRecords = sourceGrid.getRecords();
		                	//检测是否含有重复数据
		                	for (Record record : getRecords) {
		                		boolean flag = true;
		                		for (Record __record : allRecords) {
									String checkCode = record.getAttributeAsString("code").trim();
									String oriCode = __record.getAttributeAsString("code").trim();
									if(checkCode.equals(oriCode)){
										flag = false;
										SC.say("此报销单已经在选定的报销单之中");
										break;
									}
								}
		                		if(flag){
		                			sourceGrid.addData(record);
		                		}
							}
		                } else {
		                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
		                }
		            }
		        });
			}
		});
		
		mainLayout.addMember(superSearchLayout);
		mainLayout.addMember(sourceGrid);
		addMember(mainLayout);
	}

	
	@Override
	public Map getValuesAsMap() {
		return null;
	}

	@Override
	public boolean checkData() {
		boolean flag = true;
		ListGridRecord [] record = sourceGrid.getRecords();
		for (ListGridRecord listGridRecord : record) {
			int index =sourceGrid.getRowNum(listGridRecord);
			if(!sourceGrid.validateRow(index)){
				flag =false;
				break;
			}
		}
		return flag;
	}

	@Override
	public void startEdit() {
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


	public NewReimbursementPackagePanel getLeftPackagePanel() {
		return leftPackagePanel;
	}


	public void setLeftPackagePanel(NewReimbursementPackagePanel leftPackagePanel) {
		this.leftPackagePanel = leftPackagePanel;
	}
    
}
