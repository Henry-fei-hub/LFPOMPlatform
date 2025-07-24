package com.pomplatform.client.salaryexceptions.form;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.salaryexceptions.datasource.DSSalaryException;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PersonnelBusinesDetailSalaryExceptionUpdate extends AbstractWizadPage
{

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(){
		protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
			boolean isApply = BaseHelpUtils.getBoolean(record.getAttribute("isApply"));
			if(isApply){
//				grid.getRecord(rowNum).setAttribute("enabled", false);
				grid.getRecord(rowNum).set_canEdit(true);
			}
			grid.selectRecord(grid.getRecord(rowNum));
			return null;
		};
	};

	public PersonnelBusinesDetailSalaryExceptionUpdate(){

		HLayout salaryExceptions = new HLayout();
		salaryExceptions.setWidth100();
		salaryExceptions.setHeight100();
		grid.setDataSource(DSSalaryException.getInstance());
		grid.setCanEdit(true);
		grid.setAutoFitFieldWidths(false);
		grid.setCanRemoveRecords(false);
		grid.setSelectionAppearance(SelectionAppearance.CHECKBOX);//勾选菜单
		grid.setSelectionType(SelectionStyle.SIMPLE);//设置多选属性
		salaryExceptions.addMember(grid);//取消button按钮
		VLayout salaryExceptionsControls = new VLayout();
		salaryExceptionsControls.setHeight100();
		salaryExceptionsControls.setWidth(90);
		salaryExceptionsControls.setLayoutTopMargin(15);
		salaryExceptionsControls.setLayoutLeftMargin(5);
		salaryExceptionsControls.setLayoutRightMargin(5);
		salaryExceptionsControls.setMembersMargin(10);
		addMember(salaryExceptions);
		
//		loadSalaryException();
	}

	@Override
	public void startEdit() {
		if(getPageMode() != PAGE_MODE_UPDATE) return;
		
	}
	
	public void reloadDetailTableData(Record record){
		Map condition = new HashMap();
		condition.put("personnelBusinessId", record.getAttribute("personnelBusinessId"));
		DBDataSource.callOperation("ST_SalaryException", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					if(__startLoadedDetail != null) __startLoadedDetail.execute(dsResponse, data, dsRequest);
					grid.setData(dsResponse.getData());
					if(__endLoadedDetail != null) __endLoadedDetail.execute(dsResponse, data, dsRequest);
				}
			}
		});
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("detailSalaryException");
		return res;
	}

	@Override
	public boolean isTheValuesEmpty() {
		ListGridRecord[] rows = grid.getRecords();
		return rows == null || rows.length == 0;
	}

	@Override
	public Map getValuesAsMap() {
		Map param = new HashMap();
		ListGridRecord[] rows = grid.getSelectedRecords();//插入所有勾选的数据
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailSalaryException");
		return param;
	}

	@Override
	public String getName() {
		return "工资异常申请表";
	}

	public DSCallback getStartLoadedDetail() {
		return this.__startLoadedDetail;
	}

	public void setStartLoadedDetail( DSCallback value ) {
		this.__startLoadedDetail = value;
	}

	public DSCallback getEndLoadedDetail() {
		return this.__endLoadedDetail;
	}

	public void setEndLoadedDetail( DSCallback value ) {
		this.__endLoadedDetail = value;
	}

	public DelicacyListGrid getGrid() {
		return this.grid;
	}

	public void setGrid( DelicacyListGrid value ) {
		this.grid = value;
	}
	


}

