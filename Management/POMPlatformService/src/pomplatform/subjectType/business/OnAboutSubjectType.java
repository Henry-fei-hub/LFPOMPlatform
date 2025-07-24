package pomplatform.subjectType.business;

import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSubjectDepartment;
import com.pomplatform.db.bean.BaseSubjectProcessType;
import com.pomplatform.db.dao.SubjectDepartment;
import com.pomplatform.db.dao.SubjectProcessType;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.json.ParseException;
import pomplatform.subjectType.bean.BaseSubjectLinkSystemProcessType;
import pomplatform.subjectType.bean.BaseSubjectTypeLinkDepartment;
import pomplatform.subjectType.bean.ConditionSubjectLinkSystemProcessType;
import pomplatform.subjectType.bean.ConditionSubjectTypeLinkDepartment;
import pomplatform.subjectType.query.QuerySubjectLinkSystemProcessType;
import pomplatform.subjectType.query.QuerySubjectTypeLinkDepartment;

/**
 * 计算公司账户项目信息
 * @author lxf
 */
public class OnAboutSubjectType implements GenericProcessor {
    private static Logger __logger = Logger.getLogger("");
    //操作类型
    private static final String OPT_TYPE = "optType";
    //加载科目关联部门信息
    private static final String ON_LOAD_SUBJECT_TYPE_LINK_DEPARTMENT = "onLoadSubjectTypeLinkDepartment";
    //加载科目关联流程类别信息
    private static final String ON_LOAD_SUBJECT_TYPE_LINK_PROCESS_TYPE = "onLoadSubjectTypeLinkProcessType";
    //保存科目关联流程类别信息
    private static final String ON_SAVE_SUBJECT_TYPE_LINK_PROCESS_TYPE = "onSaveSubjectTypeLinkProcessType";
    //删除科目关联流程类别信息
    private static final String ON_DELETE_SUBJECT_TYPE_LINK_PROCESS_TYPE = "onDeleteSubjectTypeLinkProcessType";
    //保存科目关联部门信息
    private static final String ON_SAVE_SUBJECT_TYPE_LINK_DEPARTMENT = "onSaveSubjectTypeLinkDepartment";
    //删除科目关联部门信息
    private static final String ON_DELETE_SUBJECT_TYPE_LINK_DEPARTMENT = "onDeleteSubjectTypeLinkDepartment";
    

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(param,OPT_TYPE);
        if(ON_LOAD_SUBJECT_TYPE_LINK_DEPARTMENT.equals(optType)){
        	return OnLoadSubjectTypeLinkDepartment(param);
        }else if(ON_LOAD_SUBJECT_TYPE_LINK_PROCESS_TYPE.equals(optType)){
        	return OnLoadSubjectTypeLinkProcessType(param);
        }else if(ON_SAVE_SUBJECT_TYPE_LINK_PROCESS_TYPE.equals(optType)){
        	return onSaveSubjectTypeLinkProcessType(param);
        }else if(ON_DELETE_SUBJECT_TYPE_LINK_PROCESS_TYPE.equals(optType)){
        	return onDeleteSubjectTypeLinkProcessType(param);
        }else if(ON_SAVE_SUBJECT_TYPE_LINK_DEPARTMENT.equals(optType)){
        	return onSaveSubjectTypeLinkDepartment(param);
        }else if(ON_DELETE_SUBJECT_TYPE_LINK_DEPARTMENT.equals(optType)){
        	return onDeleteSubjectTypeLinkDepartment(param);
        }
        return null;
    }
    
    /**
     * 加载科目关联部门信息
     * @return
     * @throws SQLException 
     */
    public String OnLoadSubjectTypeLinkDepartment(Map<String, Object> param) throws SQLException{
        //获取报销科目ID
        int subjectTyepId = BaseHelpUtils.getIntValue(param,"subjectTyepId");
        ConditionSubjectTypeLinkDepartment condition = new ConditionSubjectTypeLinkDepartment();
        condition.setSubjectTypeId(subjectTyepId);
        QuerySubjectTypeLinkDepartment dao = new QuerySubjectTypeLinkDepartment();
        BaseCollection<BaseSubjectTypeLinkDepartment> result = dao.executeQuery(null, condition);
        return result.toJSON(null);
    }
    
    /**
     * 加载科目关联流程类别信息
     * @return
     * @throws SQLException 
     */
    public String OnLoadSubjectTypeLinkProcessType(Map<String, Object> param) throws SQLException{
        //获取报销科目ID
        int subjectTyepId = BaseHelpUtils.getIntValue(param,"subjectTyepId");
        ConditionSubjectLinkSystemProcessType condition = new ConditionSubjectLinkSystemProcessType();
        condition.setSubjectTypeId(subjectTyepId);
        QuerySubjectLinkSystemProcessType dao = new QuerySubjectLinkSystemProcessType();
        BaseCollection<BaseSubjectLinkSystemProcessType> result = dao.executeQuery(null, condition);
        return result.toJSON(null);
    }
    
    /**
     * 保存科目关联流程类别信息
     * @param param
     * @return
     * @throws SQLException
     * @throws ParseException
     */
    public String onSaveSubjectTypeLinkProcessType(Map<String, Object> param) throws SQLException, ParseException{
    	//获取科目列表id
    	int subjectTypeId = BaseHelpUtils.getIntValue(param, "subjectTypeId");
    	//获取流程类别ids
    	String processTypeIds = BaseHelpUtils.getStringValue(param, "processTypeIds");
    	String[] ids = processTypeIds.split(",");
    	SubjectProcessType dao = new SubjectProcessType();
        if(ids.length > 0){
        	BaseSubjectProcessType bean;
        	List<BaseSubjectProcessType> list = new ArrayList<>();
        	for(String processTypeId : ids){
        		if(BaseHelpUtils.getIntValue(processTypeId) >0){
        			bean = new BaseSubjectProcessType();
        			bean.setSubjectTypeId(subjectTypeId);
        			bean.setProcessTypeId(BaseHelpUtils.getIntValue(processTypeId));
        			list.add(bean);
        		}
        	}
        	if(!list.isEmpty()){
        		dao.save(list);
        	}
        }
        return dao.generateBase().toOneLineJSON(0, null);
    }
    
    /**
     * 删除科目关联流程类别信息
     * @param param
     * @return
     * @throws SQLException
     * @throws ParseException
     */
    public String onDeleteSubjectTypeLinkProcessType(Map<String, Object> param) throws SQLException, ParseException{
    	//获取科目列表id
    	int subjectTypeId = BaseHelpUtils.getIntValue(param, "subjectTypeId");
    	//获取流程类别ids
    	String processTypeIds = BaseHelpUtils.getStringValue(param, "processTypeIds");
    	String[] ids = processTypeIds.split(",");
    	int len = ids.length;
    	Object[] idArr = new Object[len];
        if(len > 0){
        	int i = 0;
        	for(String processTypeId : ids){
        		idArr[i] = BaseHelpUtils.getIntValue(processTypeId);
        		i++;
        	}
        }
        SubjectProcessType dao = new SubjectProcessType();
    	dao.setConditionSubjectTypeId("=",subjectTypeId);
    	dao.addCondition(BaseSubjectProcessType.CS_PROCESS_TYPE_ID,"in", idArr);
    	dao.conditionalDelete();
    	return dao.generateBase().toOneLineJSON(0, null);
    }
    
    
    /**
     * 保存科目关联部门信息
     * @param param
     * @return
     * @throws SQLException
     * @throws ParseException
     */
    public String onSaveSubjectTypeLinkDepartment(Map<String, Object> param) throws SQLException, ParseException{
    	//获取科目列表id
    	int subjectTypeId = BaseHelpUtils.getIntValue(param, "subjectTypeId");
    	//获取部门ids
    	String departmentIds = BaseHelpUtils.getStringValue(param, "departmentIds");
    	String[] ids = departmentIds.split(",");
    	SubjectDepartment dao = new SubjectDepartment();
        if(ids.length > 0){
        	BaseSubjectDepartment bean;
        	List<BaseSubjectDepartment> list = new ArrayList<>();
        	for(String departmentId : ids){
        		if(BaseHelpUtils.getIntValue(departmentId) >0){
        			bean = new BaseSubjectDepartment();
        			bean.setSubjectTypeId(subjectTypeId);
        			bean.setDepartmentId(BaseHelpUtils.getIntValue(departmentId));
        			list.add(bean);
        		}
        	}
        	if(!list.isEmpty()){
        		dao.save(list);
        	}
        }
        return dao.generateBase().toOneLineJSON(0, null);
    }
    
    /**
     * 删除科目关联部门信息
     * @param param
     * @return
     * @throws SQLException
     * @throws ParseException
     */
    public String onDeleteSubjectTypeLinkDepartment(Map<String, Object> param) throws SQLException, ParseException{
    	//获取科目列表id
    	int subjectTypeId = BaseHelpUtils.getIntValue(param, "subjectTypeId");
    	//获取部门ids
    	String departmentIds = BaseHelpUtils.getStringValue(param, "departmentIds");
    	String[] ids = departmentIds.split(",");
    	int len = ids.length;
    	Object[] idArr = new Object[len];
        if(len > 0){
        	int i = 0;
        	for(String departmentId : ids){
        		idArr[i] = BaseHelpUtils.getIntValue(departmentId);
        		i++;
        	}
        }
        SubjectDepartment dao = new SubjectDepartment();
    	dao.setConditionSubjectTypeId("=",subjectTypeId);
    	dao.addCondition(BaseSubjectDepartment.CS_DEPARTMENT_ID,"in", idArr);
    	dao.conditionalDelete();
    	return dao.generateBase().toOneLineJSON(0, null);
    }
    
  
}
