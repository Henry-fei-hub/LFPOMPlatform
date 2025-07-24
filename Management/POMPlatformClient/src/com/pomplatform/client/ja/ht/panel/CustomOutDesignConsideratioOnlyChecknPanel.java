package com.pomplatform.client.ja.ht.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.i18n.client.NumberFormat;
import com.pomplatform.client.ja.ht.datasource.DSOutDesignConsideration;
import com.pomplatform.client.preprojects.datasource.DSMainProjectBusinessType;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DropCompleteEvent;
import com.smartgwt.client.widgets.events.DropCompleteHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.EditorExitEvent;
import com.smartgwt.client.widgets.form.fields.events.EditorExitHandler;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.grid.events.CellDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.CellDoubleClickHandler;
import com.smartgwt.client.widgets.grid.events.CellSelectionChangedEvent;
import com.smartgwt.client.widgets.grid.events.CellSelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;

public class CustomOutDesignConsideratioOnlyChecknPanel extends AbstractWizadPage {

	private static Logger __LOGGER = Logger.getLogger("");
	public DelicacyListGrid LeftGrid;
	public DelicacyListGrid RightGrid;
	private DynamicForm __infoForm;
	private TextItem totalItem;
	private TextItem quotationNameItem;

	public CustomOutDesignConsideratioOnlyChecknPanel(final String infoCode, String projectCode, final int outQuotationId) {
		//当不成功时只准许查看
		boolean onlyShow = true;
		CustomOutDesignConsideratioOnlyChecknPanel.infoCode = infoCode;
		CustomOutDesignConsideratioOnlyChecknPanel.projectCode = projectCode;
		CustomOutDesignConsideratioOnlyChecknPanel.outQuotationId = outQuotationId;
		
		//左侧
		ListGridField[] fields = new ListGridField[8];
		int idx = 0;
		fields[idx] = new ListGridField("outDesignConsiderationId");
		fields[idx].setCanEdit(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("infoCode");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("projectCode");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("mainDesignAreaName"); 
		fields[idx].setCanEdit(true);
		idx++;
		//设计面积
		fields[idx] = new ListGridField("designArea","面积");
		fields[idx].setCellFormatter(new CellFormatter() {  
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                if (value == null||BaseHelpUtils.getDoubleValue(value)<0) return null;  
                try {  
                    NumberFormat nf = NumberFormat.getFormat("#,##0.00");  
                    return "" + nf.format(((Number) value).doubleValue());  
                } catch (Exception e) {  
                    return value.toString();  
                }  
            }  
        });
		idx++;
		//单价
		fields[idx] = new ListGridField("designUnitPrice","单 价");
		fields[idx].setCellFormatter(new CellFormatter() {  
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                if (value == null||BaseHelpUtils.getDoubleValue(value)<0) return null;  
                try {  
                    NumberFormat nf = NumberFormat.getFormat("#,##0.00");  
                    return "" + nf.format(((Number) value).doubleValue());  
                } catch (Exception e) {  
                    return value.toString();  
                }  
            }  
        });
		idx++;
		//总价
		fields[idx] = new ListGridField("moneySum","总 价");
		fields[idx].setCanEdit(true);
		fields[idx].setCellFormatter(new CellFormatter() {  
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                if (value == null||BaseHelpUtils.getDoubleValue(value)<0) return null;  
                try {  
                    NumberFormat nf = NumberFormat.getFormat("#,##0.00");  
                    return "" + nf.format(((Number) value).doubleValue());  
                } catch (Exception e) {  
                    return value.toString();  
                }  
            }  
        });
		VLayout LeftBtnVLayout=new VLayout(10);
		LeftBtnVLayout.setLayoutTopMargin(50);
		LeftBtnVLayout.setWidth("6%");
		
		//右侧
		ListGridField[] aFields = new ListGridField[5];
		int a = 0;
		aFields[a] = new ListGridField("mainProjectBusinessTypeId");
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("businessType","业务类别");
		aFields[a].setCanEdit(true);
		KeyValueManager.loadValueMap("production_value_coefficient_type",aFields[a]);
		a++;
		aFields[a] = new ListGridField("area", "面积");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("outputValue", "产值");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("outQuotationId", "outQuotationId");
		aFields[a].setCanEdit(false);
		aFields[a].setHidden(true);
		
		VLayout RightBtnVLayout=new VLayout(10);
		RightBtnVLayout.setLayoutTopMargin(50);
		RightBtnVLayout.setWidth("6%");
		
		//底部
		__infoForm = new DynamicForm();
		__infoForm.setWidth100();
		__infoForm.setHeight("16%");
		__infoForm.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__infoForm);
		quotationNameItem = new TextItem("quotationName","报价单标题  ");
		quotationNameItem.setCanEdit(false);
		quotationNameItem.setWidth("*");
		
		totalItem = new TextItem("xxxx","报价单汇总  ");
		totalItem.setCanEdit(false);
		totalItem.setWidth("*");
		__infoForm.setFields(quotationNameItem,totalItem);
		
		LeftGrid = new DelicacyListGrid();
		LeftGrid.setCanDragSelectText(true);
		LeftGrid.setAutoFitFieldWidths(false);
		LeftGrid.setDataSource(DSOutDesignConsideration.getInstance());
		LeftGrid.setCanEdit(false);
		LeftGrid.setFields(fields);
		LeftGrid.setHeaderHeight(60);  
		LeftGrid.setHeaderSpans(new HeaderSpan[] {
				   new HeaderSpan("合同报价", new String[] {"mainDesignAreaName","designArea","designUnitPrice","moneySum"})
			    });
				
		LeftGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
		
		
		RightGrid = new DelicacyListGrid();
		RightGrid.setCanDragSelectText(true);
		RightGrid.setAutoFitFieldWidths(false);
		RightGrid.setDataSource(DSMainProjectBusinessType.getInstance());
		RightGrid.setCanEdit(false);
		RightGrid.setFields(aFields);
		RightGrid.setHeaderHeight(60);  
		RightGrid.setHeaderSpans(new HeaderSpan[] {
				   new HeaderSpan("产值", new String[] {"businessType", "area", "outputValue","outQuotationId"})
			    });
				
		RightGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
		
		HLayout secondLayout = new HLayout();
		secondLayout.setWidth100();
		secondLayout.setHeight100();
		
		HLayout leftLayout = new HLayout();
		leftLayout.setWidth("94%");
		leftLayout.setHeight("90%");
		leftLayout.setLayoutTopMargin(10);
		leftLayout.setLayoutRightMargin(5);
		leftLayout.setMembersMargin(10);
		
		HLayout rightLayout = new HLayout();
		rightLayout.setWidth("94%");
		rightLayout.setHeight("90%");
		rightLayout.setLayoutTopMargin(10);
		rightLayout.setLayoutRightMargin(5);
		rightLayout.setMembersMargin(10);
		
		leftLayout.addMember(LeftGrid);
		leftLayout.addMember(LeftBtnVLayout);
		
		rightLayout.addMember(RightGrid);
		rightLayout.addMember(RightBtnVLayout);
		
		secondLayout.addMember(leftLayout);
		secondLayout.addMember(rightLayout);
		
		VLayout mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.setLayoutTopMargin(10);
		mainLayout.setLayoutRightMargin(5);
		mainLayout.setMembersMargin(10);
		mainLayout.addMember(secondLayout);
		mainLayout.addMember(__infoForm);
		addMember(mainLayout);
	}

	@Override
	public void startEdit() {
		__LOGGER.info(
				"CustomOutDesigneConsiderationHandler start load infoCode=" + infoCode + " projectCode=" + projectCode);

		if (!BaseHelpUtils.isNullOrEmpty(infoCode) && !BaseHelpUtils.isNullOrEmpty(projectCode)
				&& BaseHelpUtils.getIntValue(outQuotationId) > 0) {
			Map<String, Object> searchMap = new HashMap<>();
			searchMap.put("opt_type", "getMainProjectBusinessType");
			searchMap.put("projectCode", projectCode);
			searchMap.put("infoCode", infoCode);
			searchMap.put("outQuotationId", outQuotationId);
			DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", "", searchMap, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if (dsResponse.getStatus() >= 0) {
						RightGrid.setData(dsResponse.getData());
					}
				}
			});
			Map<String, Object> condition = new HashMap<>();
			condition.put("opt_type", "getBusinessTypeQueryData");
			condition.put("infoCode", infoCode);
			condition.put("projectCode", projectCode);
			condition.put("outQuotationId", outQuotationId);
			condition.put("employeeId", ClientUtil.getEmployeeId());
			DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", "", condition, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getData().length>0) {
						quotationNameItem.setValue(dsResponse.getData()[0].getAttribute("newCreateQuotationName"));
					}
					LeftGrid.setData(dsResponse.getData());
					// 设置汇总信息
					Object o = dsResponse.getErrors().get("errorMsg");
					String[] val = BaseHelpUtils.getString(o).split("-");
					totalItem.setValue(BaseHelpUtils.getString(val[0]).substring(1));
				}
			});
			
		}
	}

	// 效验数据
	@Override
	public boolean checkData() {
		boolean isFlag = true;
		return isFlag;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("customOutDesignConsideration");
		return res;
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	public Map getValuesAsMap() {
		return null;
	}

	private static String infoCode;
	private static String projectCode;
	private static int outQuotationId;
	private static String quotationName;


	private PopupWindow pw;

	public PopupWindow getPw() {
		return pw;
	}

	public void setPw(PopupWindow pw) {
		this.pw = pw;
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
