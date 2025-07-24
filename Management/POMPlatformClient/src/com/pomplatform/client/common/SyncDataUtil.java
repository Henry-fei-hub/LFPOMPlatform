package com.pomplatform.client.common;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueTime;
import com.delicacy.client.websocket.SyncHttpRequest;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;

import java.util.*;

public class SyncDataUtil {


    /**
     * 根据tableName 查询一条数据
     * @param action
     * @param subaction
     * @return
     */
    public static Record getValueByTableName(final String action, String subaction, Map<String, Object> criteria){
        SyncHttpRequest req = new SyncHttpRequest();
        String requestData = DBDataSource.generateParameterString(action, subaction, MapUtils.toJSON(criteria));
        String resp = req.getData(requestData);
        try {
            DSResponse dsr = DBDataSource.processHttpResponse(resp);
            Record[] records = dsr.getData();
            if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
                return dsr.getData()[0];
            }
            return null;
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * @param null
     * @return
     * @author liubin
     * @creed: write code
     * @date 2020-04-17 11:42
     * @describe: 查询报价的标题
     */
    public static String getOutQuotationTitle(int outQuotationId) {
        String outQuotationTitle = "";
        Map<String, Object> params = new HashMap<>();
        params.put("outQuotationId", outQuotationId);
        Record record = getValueByTableName("ST_OutDesignConsideration", "find", params);
        if(null != record){
            outQuotationTitle = record.getAttribute("newCreateQuotationName");
        }
        return  outQuotationTitle;
    }

    /**
     * 根据projectId查询ProjectName
     * @param projectId
     * @return
     */
    public static String getProjectName(int projectId){
        String projectName = "";
        Map<String, Object> params = new HashMap<>();
        params.put("projectId", projectId);
        Record record = getValueByTableName("ST_Project", "find", params);
        if(null != record){
            projectName = record.getAttribute("projectName");
        }
        return  projectName;
    }

    /**
     * 根据projectId查询contractCode
     * @param projectId
     * @return
     */
    public static String getContractCode(int projectId){
        String contractCode = "";
        Map<String, Object> params = new HashMap<>();
        params.put("projectId", projectId);
        Record record = getValueByTableName("ST_Project", "find", params);
        if(null != record){
            contractCode = record.getAttribute("contractCode");
        }
        return  contractCode;
    }

    /**
     * 根据projectId查询projectCode
     * @param projectId
     * @return
     */
    public static String getProjectCode(int projectId){
        String projectCode = "";
        Map<String, Object> params = new HashMap<>();
        params.put("projectId", projectId);
        Record record = getValueByTableName("ST_Project", "find", params);
        if(null != record){
            projectCode = record.getAttribute("projectCode");
        }
        return  projectCode;
    }

    /**
     * 根据contractCode查询contractName
     * @param contractCode
     * @return
     */
    public static String getContractName(String contractCode) {
    	String contractName = "";
    	Map<String, Object> params = new HashMap<>();
        params.put("contractCode", contractCode);
        Record record = getValueByTableName("ST_Contract", "find", params);
        if(null != record){
        	contractName = record.getAttribute("contractName");
        }
        return contractName;
    }

    /**
     * 根据contractCode查询contractId
     * @param contractCode
     * @return
     */
    public static Integer getContractId(String contractCode){
        Integer contractId = null;
        Map<String, Object> params = new HashMap<>();
        params.put("contractCode", contractCode);
        Record record = getValueByTableName("ST_Contract", "find", params);
        if(null != record){
            contractId = BaseHelpUtils.getIntValue(record.getAttribute("contractId"));
        }
        return contractId;
    }
    
    public static String getPreProjectName(Integer preProjectId) {
    	String projectName = "";
    	Map<String, Object> params = new HashMap<>();
        params.put("preProjectId", preProjectId);
        Record record = getValueByTableName("ST_PreProject", "find", params);
        if(null != record){
        	projectName = record.getAttribute("projectName");
        }
        return projectName;
    }
    
    /**
     * 根据tableName 查询数据
     * @param action
     * @param subaction
     * @return Record[]
     */
    public static Record[] getValueByTableNames(final String action, String subaction, Map<String, Object> criteria){
        SyncHttpRequest req = new SyncHttpRequest();
        String requestData = DBDataSource.generateParameterString(action, subaction, MapUtils.toJSON(criteria));
        String resp = req.getData(requestData);
        try {
            DSResponse dsr = DBDataSource.processHttpResponse(resp);
            Record[] records = dsr.getData();
            if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
                return dsr.getData();
            }
            return null;
        } catch (Exception ex) {
            return null;
        }
    }
    
    /**
               * 同步验证数据
     * @param action
     * @param subaction
     * @return 
     */
    public static DSResponse checkValue(final String action, String subaction, Map<String, Object> criteria){
        SyncHttpRequest req = new SyncHttpRequest();
        String requestData = DBDataSource.generateParameterString(action, subaction, MapUtils.toJSON(criteria));
        String resp = req.getData(requestData);
        try {
            DSResponse dsr = DBDataSource.processHttpResponse(resp);
            return dsr;
        } catch (Exception ex) {
            return null;
        }
    }
    
    
    /**
     * 获取下拉值
     * @param action
     * @param subaction
     * @return 
     */
    @SuppressWarnings("unchecked")
	public static LinkedHashMap<Integer, String> getValues(final String action, String subaction, Map<String, Object> criteria){
    	LinkedHashMap<Integer, String> linkMap=new LinkedHashMap<>();
    	SyncHttpRequest req = new SyncHttpRequest();
        String requestData = DBDataSource.generateParameterString(action, subaction, MapUtils.toJSON(criteria));
        String resp = req.getData(requestData);
        try {
            DSResponse dsr = DBDataSource.processHttpResponse(resp);
            linkMap = (LinkedHashMap<Integer, String>) BaseHelpUtils.getResponseUserData(dsr);
            return linkMap;
        } catch (Exception ex) {
            return null;
        }
    }

}
