package com.pomplatform.client.subjecttype.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.company.datasource.DSCompanyReportIntegralDataSource;
import com.pomplatform.client.subjecttype.datasource.DSDepartment;
import com.pomplatform.client.subjecttype.datasource.DSSubjectLinkProcessType;
import com.pomplatform.client.subjecttype.datasource.DSSubjectType;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.AutoFitWidthApproach;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;

public class SubjectTypeLinkDepartmentDesignPanel extends AbstractWizadPage {
    private final Logger __logger = Logger.getLogger("");
    private HLayout hLayout;
    private VLayout vLayout;
    
    //定义左边的汇总数据集的gird开始***********************
    
    //报销科目grid
    private TreeGrid subjectTypeGrid;
    //部门grid
    private TreeGrid departmentGrid;
    //流程列表gird
    private TreeGrid processTypeGrid;
    //定义左边的汇总数据集的gird结束***********************
    
    public SubjectTypeLinkDepartmentDesignPanel() {
    	
    	hLayout = new HLayout();
    	hLayout.setWidth100();
    	hLayout.setHeight100();
    	hLayout.setBackgroundColor("#e2e2e2");
    	hLayout.setMargin(10);
    	hLayout.setMembersMargin(20);
        
    	//报销科目grid
    	subjectTypeGrid = new TreeGrid();
    	subjectTypeGrid.setWidth("40%");
    	TreeGridField[] fields = new TreeGridField[1];
    	int idx = 0;
		fields[idx] = new TreeGridField("subjectName");
		fields[idx].setCanEdit(false);
		idx ++;
		subjectTypeGrid.setFields(fields);
		subjectTypeGrid.setShowFilterEditor(false);
		subjectTypeGrid.setFilterOnKeypress(false);
    	DSSubjectType subjectTypeDataSource = DSSubjectType.getInstance();
    	subjectTypeGrid.setDataSource(subjectTypeDataSource);
    	
    	vLayout = new VLayout();
    	vLayout.setMargin(10);
    	vLayout.setMembersMargin(20);
    	vLayout.setHeight100();
    	vLayout.setWidth("60%");
        
    	//部门grid
    	departmentGrid = new TreeGrid();
    	departmentGrid.setHeight("50%");
    	departmentGrid.setSaveLocally(true);
    	departmentGrid.setAutoFetchData(false);
    	departmentGrid.setAutoFitWidthApproach(AutoFitWidthApproach.BOTH);
    	departmentGrid.setAutoFitFieldWidths(true);
    	departmentGrid.setShowHeaderContextMenu(false);
    	departmentGrid.setShowHeaderMenuButton(false);
    	departmentGrid.setCanEdit(true);
    	departmentGrid.setCanReparentNodes(true);
        TreeGridField[] field1s = new TreeGridField[4];
        int idx1 = 0;
        field1s[idx1] = new TreeGridField(" ");
        field1s[idx1].setWidth(1);
        field1s[idx1].setCanEdit(false);
        idx1++;
        field1s[idx1] = new TreeGridField("hasSelected");
        field1s[idx1].setCanEdit(false);
        field1s[idx1].setWidth(20);
        idx1++;
        field1s[idx1] = new TreeGridField("departmentName");
        field1s[idx1].setCanEdit(false);
//        field1s[idx1].setFrozen(true);
        idx1++;
        
        field1s[idx1] = new TreeGridField("parentId");
        field1s[idx1].setCanEdit(false);
        field1s[idx1].setHidden(true);
        idx1++;
        
		departmentGrid.setFields(field1s);
		DSDepartment departmentDataSource = DSDepartment.getInstance();
        departmentGrid.setDataSource(departmentDataSource);
        
        //流程类别grid
        processTypeGrid = new TreeGrid();
        processTypeGrid.setHeight("50%");
        processTypeGrid.setSaveLocally(true);
        processTypeGrid.setAutoFetchData(false);
        processTypeGrid.setAutoFitWidthApproach(AutoFitWidthApproach.BOTH);
        processTypeGrid.setAutoFitFieldWidths(true);
        processTypeGrid.setShowHeaderContextMenu(false);
        processTypeGrid.setShowHeaderMenuButton(false);
        processTypeGrid.setCanEdit(true);
        processTypeGrid.setCanReparentNodes(true);
        TreeGridField[] field2s = new TreeGridField[4];
        int idx2 = 0;
        
        field2s[idx2] = new TreeGridField(" ");
        field2s[idx2].setWidth(1);
        field2s[idx2].setCanEdit(false);
        idx2++;
        
        field2s[idx2] = new TreeGridField("parentProcessTypeId");
        field2s[idx2].setHidden(true);
        idx2++;
        
        field2s[idx2] = new TreeGridField("hasSelected");
        field2s[idx2].setWidth(20);
        field2s[idx2].setCanEdit(false);
        idx2++;
        
        field2s[idx2] = new TreeGridField("processTypeName");
//        field2s[idx2].setFrozen(true);
        field2s[idx2].setCanEdit(false);
        idx2++;
        
        processTypeGrid.setFields(field2s);
		DSSubjectLinkProcessType processTypeDataSource = DSSubjectLinkProcessType.getInstance();
		processTypeGrid.setDataSource(processTypeDataSource);
		
		vLayout.addMember(departmentGrid);
		vLayout.addMember(processTypeGrid);
    	
        hLayout.addMember(subjectTypeGrid);
        hLayout.addMember(vLayout);
    	
    	addMember(hLayout);
    	
    	//左边grid双击事件处理开始**********************************
    	subjectTypeGrid.addCellClickHandler(new CellClickHandler() {
			@Override
			public void onCellClick(CellClickEvent event) {
				ListGridRecord[] selected = subjectTypeGrid.getSelectedRecords();
				//获取报销科目名称
				int subjectTypeId = BaseHelpUtils.getIntValue(selected[0].getAttribute("subjectTypeId"));
				setSubjectTypeId(subjectTypeId);
				loadDepartment();
				loadProcessType();
			}
		});
        
        departmentGrid.addCellClickHandler(new CellClickHandler() {
			@Override
			public void onCellClick(CellClickEvent event) {
				if(subjectTypeId == 0){
            		SC.say("提示","未指定报销科目,请选择一条报销科目");
            		return;
            	}else{
            		TreeNode currentNode = departmentGrid.getRecord(event.getRowNum());
            		boolean hasSelected = BaseHelpUtils.getBoolean(currentNode.getAttribute("hasSelected"));
            		onDepartmentGridClick(currentNode,hasSelected);
            	}
			}
		});
        
        processTypeGrid.addCellClickHandler(new CellClickHandler() {
			@Override
			public void onCellClick(CellClickEvent event) {
				if(subjectTypeId == 0){
            		SC.say("提示","未指定报销科目,请选择一条报销科目");
            		return;
            	}else{
            		TreeNode currentNode = processTypeGrid.getRecord(event.getRowNum());
            		boolean hasSelected = BaseHelpUtils.getBoolean(currentNode.getAttribute("hasSelected"));
            		onProcessTypeGridClick(currentNode,hasSelected);
            	}
			}
		});
        
    }
    
    /**
     * 递归取消节点
     * @param tree
     * @param node
     * @param param
     */
    public void cancelSubjectTypeLinkProcessType(Tree tree,TreeNode node,Map<Integer,Integer> param){
    	//获取所有子级节点
    	TreeNode[] childNodes = tree.getChildren(node);
    	if(childNodes.length > 0){
    		for(TreeNode childNode : childNodes){
    			//获取是否选中的状态值
    			boolean hasSelected = BaseHelpUtils.getBoolean(childNode.getAttribute("hasSelected"));
    			if(hasSelected){//如果是选中，则需取消
    				childNode.setAttribute("hasSelected",Boolean.FALSE);
    				processTypeGrid.updateData(childNode);
    				param.put(BaseHelpUtils.getIntValue(childNode.getAttribute("processTypeId")),subjectTypeId);
    				cancelSubjectTypeLinkProcessType(tree, childNode,param);
    			}
    		}
    	}
    }
    
    /**
     * 递归选中节点
     * @param tree
     * @param node
     * @param param
     */
    public void selectSubjectTypeLinkProcessType(Tree tree,TreeNode node,Map<Integer,Integer> param){
    	//获取所有子级节点
    	TreeNode[] childNodes = tree.getChildren(node);
    	if(childNodes.length > 0){
    		for(TreeNode childNode : childNodes){
    			//获取是否选中的状态值
    			boolean hasSelected = BaseHelpUtils.getBoolean(childNode.getAttribute("hasSelected"));
    			if(!hasSelected){//如果是没有选中，则需选中
    				childNode.setAttribute("hasSelected",Boolean.TRUE);
    				processTypeGrid.updateData(childNode);
    				param.put(BaseHelpUtils.getIntValue(childNode.getAttribute("processTypeId")),subjectTypeId);
    				selectSubjectTypeLinkProcessType(tree, childNode,param);
    			}
    		}
    	}
    }
    
    /**
     * 递归取消节点
     * @param tree
     * @param node
     * @param param
     */
    public void cancelSubjectTypeLinkDepartment(Tree tree,TreeNode node,Map<Integer,Integer> param){
    	//获取所有子级节点
    	TreeNode[] childNodes = tree.getChildren(node);
    	if(childNodes.length > 0){
    		for(TreeNode childNode : childNodes){
    			//获取是否选中的状态值
    			boolean hasSelected = BaseHelpUtils.getBoolean(childNode.getAttribute("hasSelected"));
    			if(hasSelected){//如果是选中，则需取消
    				childNode.setAttribute("hasSelected",Boolean.FALSE);
    				departmentGrid.updateData(childNode);
    				param.put(BaseHelpUtils.getIntValue(childNode.getAttribute("departmentId")),subjectTypeId);
    				cancelSubjectTypeLinkDepartment(tree, childNode,param);
    			}
    		}
    	}
    }
    
    //部门操作
    public void onDepartmentGridClick(TreeNode currentNode,boolean hasSelected){
    	Tree tree = departmentGrid.getData();
		if(!hasSelected){//选中操作
			//定义一个map来存放选中的id,key为流程列表的id，value为科目id
			Map<Integer,Integer> param = new HashMap<>();
			currentNode.setAttribute("hasSelected", Boolean.TRUE);
			departmentGrid.updateData(currentNode);
			param.put(BaseHelpUtils.getIntValue(currentNode.getAttribute("departmentId")),subjectTypeId);
			//检索父级,如果父级有存在未选中的，则选中
			TreeNode[] parentNodes = tree.getParents(currentNode);
			if(parentNodes.length > 0){
				for(TreeNode parentNode : parentNodes){
					//获取当前节点是否选中
					boolean hasSelectedParent = BaseHelpUtils.getBoolean(parentNode.getAttribute("hasSelected"));
					if(!hasSelectedParent){//如果没有选中，则选中更新
						parentNode.setAttribute("hasSelected", Boolean.TRUE);
						departmentGrid.updateData(parentNode);
						param.put(BaseHelpUtils.getIntValue(parentNode.getAttribute("departmentId")),subjectTypeId);
					}
				}
			}
			//检索子级，如果子级存在未选中的，则选中
			selectSubjectTypeLinkDepartment(tree, currentNode,param);
			String departmentIds ="";
			if(!param.isEmpty()){
				for(Integer id : param.keySet()){
					if(!BaseHelpUtils.isNullOrEmpty(departmentIds)){
						departmentIds += ",";
					}
					departmentIds += id;
				}
			}
			Map<String,Object> condition = new HashMap<>();
			condition.put("optType", "onSaveSubjectTypeLinkDepartment");
			condition.put("subjectTypeId", subjectTypeId);
			condition.put("departmentIds", departmentIds);
			DBDataSource.callOperation("OnAboutSubjectType", "save", condition, new DSCallback() {
              @Override
              public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                  if (dsResponse.getStatus() < 0) {
                      ClientUtil.displayErrorMessage(dsResponse);
                  } 
              }
          });
		}else{//取消操作
			//定义一个map来存放选中的id,key为流程列表的id，value为科目id
			Map<Integer,Integer> param = new HashMap<>();
			currentNode.setAttribute("hasSelected", Boolean.FALSE);
			departmentGrid.updateData(currentNode);
			param.put(BaseHelpUtils.getIntValue(currentNode.getAttribute("departmentId")),subjectTypeId);
			//检索父级，并判断父级的子级是否有选中，如果选中，则不需做任何操作，如果子级没有选中的，则取消，并向上依次类推
			boolean canForeach = true;
			TreeNode node = currentNode;
			while(canForeach){
				//获取当前节点是否是跟节点，如果是跟节点，则跳出
				int parentId = BaseHelpUtils.getIntValue(node.getAttribute("parentId"));
				if(parentId == 0){//当前节点是根节点，则不需做任何操作
					canForeach = false;
				}else{//当前节点不是根节点，则需判断父级节点是否有选中子级，如果没有选中的子级，则需取消父级节点
					TreeNode parentNode = tree.getParent(node);
					//检索父级节点的其它子级节点
					TreeNode[] childNodesOfParentNode = tree.getChildren(parentNode);
					if(childNodesOfParentNode.length > 0){
						//初始化该父级下的子级没有选中的
						boolean childHasSelected = false;
						for(TreeNode childNodeOfParentNode : childNodesOfParentNode){
							if(BaseHelpUtils.getBoolean(childNodeOfParentNode.getAttribute("hasSelected"))){
								canForeach = false;
								childHasSelected = true;
								break;
							}
						}
						if(!childHasSelected){//表示没有选中的
							parentNode.setAttribute("hasSelected",Boolean.FALSE);
							departmentGrid.updateData(parentNode);
							param.put(BaseHelpUtils.getIntValue(parentNode.getAttribute("departmentId")),subjectTypeId);
							node = parentNode;
						}
					}
				}
			}
			
			//检索子级，并取消操作
			cancelSubjectTypeLinkDepartment(tree, currentNode,param);
			String departmentIds ="";
			if(!param.isEmpty()){
				for(Integer id : param.keySet()){
					if(!BaseHelpUtils.isNullOrEmpty(departmentIds)){
						departmentIds += ",";
					}
					departmentIds += id;
				}
			}
			Map<String,Object> condition = new HashMap<>();
			condition.put("optType", "onDeleteSubjectTypeLinkDepartment");
			condition.put("subjectTypeId", subjectTypeId);
			condition.put("departmentIds", departmentIds);
			DBDataSource.callOperation("OnAboutSubjectType", "delete", condition, new DSCallback() {
              @Override
              public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                  if (dsResponse.getStatus() < 0) {
                      ClientUtil.displayErrorMessage(dsResponse);
                  } 
              }
          });
		}
		departmentGrid.redraw();
    }
    
    //流程类别操作
    public void onProcessTypeGridClick(TreeNode currentNode,boolean hasSelected){
    	Tree tree = processTypeGrid.getData();
		if(!hasSelected){//选中操作
			//定义一个map来存放选中的id,key为流程列表的id，value为科目id
			Map<Integer,Integer> param = new HashMap<>();
			currentNode.setAttribute("hasSelected", Boolean.TRUE);
			processTypeGrid.updateData(currentNode);
			param.put(BaseHelpUtils.getIntValue(currentNode.getAttribute("processTypeId")),subjectTypeId);
			//检索父级,如果父级有存在未选中的，则选中
			TreeNode[] parentNodes = tree.getParents(currentNode);
			if(parentNodes.length > 0){
				for(TreeNode parentNode : parentNodes){
					//获取当前节点是否选中
					boolean hasSelectedParent = BaseHelpUtils.getBoolean(parentNode.getAttribute("hasSelected"));
					if(!hasSelectedParent){//如果没有选中，则选中更新
						parentNode.setAttribute("hasSelected", Boolean.TRUE);
						processTypeGrid.updateData(parentNode);
						param.put(BaseHelpUtils.getIntValue(parentNode.getAttribute("processTypeId")),subjectTypeId);
					}
				}
			}
			//检索子级，如果子级存在未选中的，则选中
			selectSubjectTypeLinkProcessType(tree, currentNode,param);
			String processTypeIds ="";
			if(!param.isEmpty()){
				for(Integer id : param.keySet()){
					if(!BaseHelpUtils.isNullOrEmpty(processTypeIds)){
						processTypeIds += ",";
					}
					processTypeIds += id;
				}
			}
			Map<String,Object> condition = new HashMap<>();
			condition.put("optType", "onSaveSubjectTypeLinkProcessType");
			condition.put("subjectTypeId", subjectTypeId);
			condition.put("processTypeIds", processTypeIds);
			DBDataSource.callOperation("OnAboutSubjectType", "save", condition, new DSCallback() {
              @Override
              public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                  if (dsResponse.getStatus() < 0) {
                      ClientUtil.displayErrorMessage(dsResponse);
                  } 
              }
          });
		}else{//取消操作
			//定义一个map来存放选中的id,key为流程列表的id，value为科目id
			Map<Integer,Integer> param = new HashMap<>();
			currentNode.setAttribute("hasSelected", Boolean.FALSE);
			processTypeGrid.updateData(currentNode);
			param.put(BaseHelpUtils.getIntValue(currentNode.getAttribute("processTypeId")),subjectTypeId);
			//检索父级，并判断父级的子级是否有选中，如果选中，则不需做任何操作，如果子级没有选中的，则取消，并向上依次类推
			boolean canForeach = true;
			TreeNode node = currentNode;
			while(canForeach){
				//获取当前节点是否是跟节点，如果是跟节点，则跳出
				int parentProcessTypeId = BaseHelpUtils.getIntValue(node.getAttribute("parentProcessTypeId"));
				if(parentProcessTypeId == 0){//当前节点是根节点，则不需做任何操作
					canForeach = false;
				}else{//当前节点不是根节点，则需判断父级节点是否有选中子级，如果没有选中的子级，则需取消父级节点
					TreeNode parentNode = tree.getParent(node);
					//检索父级节点的其它子级节点
					TreeNode[] childNodesOfParentNode = tree.getChildren(parentNode);
					if(childNodesOfParentNode.length > 0){
						//初始化该父级下的子级没有选中的
						boolean childHasSelected = false;
						for(TreeNode childNodeOfParentNode : childNodesOfParentNode){
							if(BaseHelpUtils.getBoolean(childNodeOfParentNode.getAttribute("hasSelected"))){
								canForeach = false;
								childHasSelected = true;
								break;
							}
						}
						if(!childHasSelected){//表示没有选中的
							parentNode.setAttribute("hasSelected",Boolean.FALSE);
							processTypeGrid.updateData(parentNode);
							param.put(BaseHelpUtils.getIntValue(parentNode.getAttribute("processTypeId")),subjectTypeId);
							node = parentNode;
						}
					}
				}
			}
			
			//检索子级，并取消操作
			cancelSubjectTypeLinkProcessType(tree, currentNode,param);
			String processTypeIds ="";
			if(!param.isEmpty()){
				for(Integer id : param.keySet()){
					if(!BaseHelpUtils.isNullOrEmpty(processTypeIds)){
						processTypeIds += ",";
					}
					processTypeIds += id;
				}
			}
			Map<String,Object> condition = new HashMap<>();
			condition.put("optType", "onDeleteSubjectTypeLinkProcessType");
			condition.put("subjectTypeId", subjectTypeId);
			condition.put("processTypeIds", processTypeIds);
			DBDataSource.callOperation("OnAboutSubjectType", "delete", condition, new DSCallback() {
              @Override
              public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                  if (dsResponse.getStatus() < 0) {
                      ClientUtil.displayErrorMessage(dsResponse);
                  } 
              }
          });
		}
		processTypeGrid.redraw();
    }
    
    /**
     * 递归选中节点
     * @param tree
     * @param node
     * @param param
     */
    public void selectSubjectTypeLinkDepartment(Tree tree,TreeNode node,Map<Integer,Integer> param){
    	//获取所有子级节点
    	TreeNode[] childNodes = tree.getChildren(node);
    	if(childNodes.length > 0){
    		for(TreeNode childNode : childNodes){
    			//获取是否选中的状态值
    			boolean hasSelected = BaseHelpUtils.getBoolean(childNode.getAttribute("hasSelected"));
    			if(!hasSelected){//如果是没有选中，则需选中
    				childNode.setAttribute("hasSelected",Boolean.TRUE);
    				departmentGrid.updateData(childNode);
    				param.put(BaseHelpUtils.getIntValue(childNode.getAttribute("departmentId")),subjectTypeId);
    				selectSubjectTypeLinkDepartment(tree, childNode,param);
    			}
    		}
    	}
    }

    @Override
    public void startEdit() {
    	onLoadData();
    }
    
    //搜索方法
    private void onLoadData(){
    	//加载报销科目信息
    	loadSubjectType();
    }
    
    //加载业态表信息
    public void loadSubjectType(){
    	DSSubjectType ds = DSSubjectType.getInstance();
    	String operationName = ds.getActionMode() + ds.getActionName();
    	Map condition = new HashMap<>();
    	DBDataSource.callOperation(operationName, "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    fetchDataCallback(dsResponse, data);
                } else {
                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
                }
            }
        });
    }
    
    public void fetchDataCallback(DSResponse response, Object rawData) {
		int len = response.getData().length;
		TreeNode[] nodes = new TreeNode[len];
		for (int i = 0; i < len; i++) {
			nodes[i] = new TreeNode();
			DBDataSource.copyRecord(response.getData()[i], nodes[i]);
		}
		Tree tree = new Tree();
		tree.setModelType(TreeModelType.PARENT);
		tree.setRootValue("0");
		tree.setIdField("subjectTypeId");
		tree.setParentIdField("parentId");
		tree.setData(nodes);
		subjectTypeGrid.setData(tree);
		subjectTypeGrid.selectSingleRecord(0);
		TreeNode selectedNode = subjectTypeGrid.getSelectedRecord();
		if(selectedNode != null){
			subjectTypeGrid.openFolder(selectedNode);
			int subjectTypeIdValue = BaseHelpUtils.getIntValue(selectedNode.getAttribute("subjectTypeId"));
			setSubjectTypeId(subjectTypeIdValue);
			loadDepartment();
			loadProcessType();
		}
	}
    
    //加载报销科目应用的部门信息
    public void loadDepartment(){
    	Map<String,Object> param = new HashMap<>();
    	param.put("optType", "onLoadSubjectTypeLinkDepartment");
    	param.put("subjectTyepId", getSubjectTypeId());
		DBDataSource.callOperation("OnAboutSubjectType","find",param, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					fetchDepartmentDataCallback(dsResponse, data);
				} else {
					SC.say(dsResponse.getErrors().get("errorMsg").toString());
				}
			}
		});
    }
    
    public void fetchDepartmentDataCallback(DSResponse response, Object rawData) {
		int len = response.getData().length;
		TreeNode[] nodes = new TreeNode[len];
		for (int i = 0; i < len; i++) {
			nodes[i] = new TreeNode();
			DBDataSource.copyRecord(response.getData()[i], nodes[i]);
			departmentGrid.selectRecord(response.getData()[i]);
		}
		Tree tree = new Tree();
		tree.setModelType(TreeModelType.PARENT);
		tree.setRootValue("0");
		tree.setIdField("departmentId");
		tree.setParentIdField("parentId");
		tree.setNameProperty("departmentName");
		tree.setData(nodes);
		departmentGrid.setData(tree);
		TreeNode selectedNode = departmentGrid.getRecord(0);
		if(selectedNode != null) departmentGrid.openFolder(selectedNode);
	}
    
    //加载报销科目应用的流程类别信息
    public void loadProcessType(){
    	Map<String,Object> param = new HashMap<>();
    	param.put("optType", "onLoadSubjectTypeLinkProcessType");
    	param.put("subjectTyepId", getSubjectTypeId());
		DBDataSource.callOperation("OnAboutSubjectType","find",param, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					fetchProcessTypeDataCallback(dsResponse, data);
				} else {
					SC.say(dsResponse.getErrors().get("errorMsg").toString());
				}
			}
		});
    }
    
    public void fetchProcessTypeDataCallback(DSResponse response, Object rawData) {
		int len = response.getData().length;
		TreeNode[] nodes = new TreeNode[len];
		for (int i = 0; i < len; i++) {
			nodes[i] = new TreeNode();
			DBDataSource.copyRecord(response.getData()[i], nodes[i]);
		}
		Tree tree = new Tree();
		tree.setModelType(TreeModelType.PARENT);
		tree.setRootValue("0");
		tree.setIdField("processTypeId");
		tree.setParentIdField("parentProcessTypeId");
		tree.setNameProperty("processTypeName");
		tree.setData(nodes);
		processTypeGrid.setData(tree);
		TreeNode selectedNode = processTypeGrid.getRecord(0);
		if(selectedNode != null) processTypeGrid.openFolder(selectedNode);
	}
    

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSCompanyReportIntegralDataSource.getInstance());
        manager.addMember(__form);
    }

    @Override
    public boolean checkData() {
        return true;
    }

    @Override
    public java.util.Map getValuesAsMap() {
        Map values = __form.getValues();
        return values;
    }

    public String getActionName() {
        // 需要根据实际业务修改
        return "ST_SubjectType";
    }
    
    public int subjectTypeId;

	public int getSubjectTypeId() {
		return subjectTypeId;
	}

	public void setSubjectTypeId(int subjectTypeId) {
		this.subjectTypeId = subjectTypeId;
	}
    
}
