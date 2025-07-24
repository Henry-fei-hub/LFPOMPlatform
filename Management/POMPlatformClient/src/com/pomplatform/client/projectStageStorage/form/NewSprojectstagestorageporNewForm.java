package com.pomplatform.client.projectStageStorage.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.projectStageStorage.datasource.DSSprojectstagestoragepor;
import com.pomplatform.client.stage.datasource.DSSsystemdictionaryor;

public class NewSprojectstagestorageporNewForm extends AbstractWizadPage
{

    private  DelicacyListGrid grid = new DelicacyListGrid();
    private  DelicacyListGrid SourceGrid = new DelicacyListGrid();
	private  TextItem projectIdItem;
	private  TextItem stageIdItem;
	private  TextItem percentItem;
	private  TextItem projectAmountItem;
	private  TextItem stageNameItem;
	private  TextItem remarkItem;
	

	public NewSprojectstagestorageporNewForm(Map <String,Object> map) {
		 VLayout SearchSourceLayout = new VLayout();
	        SearchSourceLayout.setWidth("50%");
	        SearchSourceLayout.setHeight100();
	        SearchSourceLayout.setLayoutTopMargin(10);
	        SearchSourceLayout.setLayoutRightMargin(5);
	        SearchSourceLayout.setMembersMargin(10);
	        SearchSourceLayout.setShowResizeBar(false);
	        
	        HLayout SourceLayout = new HLayout(5);
	        SourceLayout.setWidth100();
	        SourceLayout.setHeight100();
	        SearchSourceLayout.addMember(SourceLayout);
	        SourceGrid.setAutoFitFieldWidths(false);
	        SourceGrid.setDataSource(DSSprojectstagestoragepor.getInstance());
	        SourceLayout.addMember(SourceGrid);
	        addMember(SearchSourceLayout);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSprojectstagestoragepor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
