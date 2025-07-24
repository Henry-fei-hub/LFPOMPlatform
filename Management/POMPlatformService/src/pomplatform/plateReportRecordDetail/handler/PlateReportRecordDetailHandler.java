package pomplatform.plateReportRecordDetail.handler;

import org.apache.log4j.Logger;

import com.pomplatform.db.dao.SystemLog;

import pomplatform.plateReportRecordDetail.bean.BasePlateReportRecordDetail;
import pomplatform.plateReportRecordDetail.bean.ConditionPlateReportRecordDetail;
import pomplatform.plateReportRecordDetail.query.QueryPlateReportRecordDetail;
import delicacy.common.KeyValuePair;
import delicacy.common.MapUtils;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.servlet.HttpCookie;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.io.StringReader;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;

public class PlateReportRecordDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(PlateReportRecordDetailHandler.class);

	public static BaseCollection<BasePlateReportRecordDetail> executeQueryPlateReportRecordDetail(ConditionPlateReportRecordDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryPlateReportRecordDetail dao = new QueryPlateReportRecordDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasePlateReportRecordDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		return findWithPermission(creteria).toJSON();
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpCookie cookie = new HttpCookie(request);
		SystemLog logDao = new SystemLog();
        logDao.setLogContent("导出了事业部的部门账户数据");
        logDao.setOperator(cookie.getOperatorId());
        logDao.setOperatorName(cookie.getOperatorName());
        logDao.setFromHost(request.getRemoteAddr());
        logDao.setLogTime(new Date());
        logDao.save();
		BaseCollection<BasePlateReportRecordDetail> result = findWithPermission(creteria);
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasePlateReportRecordDetail.ALL_CAPTIONS);
			for(BasePlateReportRecordDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

	public BaseCollection<BasePlateReportRecordDetail> findWithPermission(String creteria) throws Exception {
		BaseCollection<BasePlateReportRecordDetail> result = new BaseCollection<>();
		List<BasePlateReportRecordDetail> list = null;
		JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> map = (Map<String, Object>) parser.parse(new BasicHandler());
        String tempPlateIds = BaseHelpUtils.getString(map.get("plateId"));
        if(tempPlateIds.length()>0){
        	Object[] arr = tempPlateIds.split(",");
            if(null != arr && arr.length > 0){
            	int length = arr.length;
            	for(int i =0 ;i<length;i++){
            		map.put("plateId", arr[i]);
            		ConditionPlateReportRecordDetail c = new ConditionPlateReportRecordDetail();
            		c.setDataFromJSON(MapUtils.toJSON(map));
            		BaseCollection<BasePlateReportRecordDetail> tempResult = executeQueryPlateReportRecordDetail(c, c.getKeyValues());
            		if(i==0){
            			list = tempResult.getCollections();
            		}else{
            			if(null!=list){
            				List<BasePlateReportRecordDetail> tempList = tempResult.getCollections();
            				if(null!=tempList&&!tempList.isEmpty()){
            					list.addAll(tempList);
            				}
            			}else{
            				list = tempResult.getCollections();
            			}
            		}
            	}
            	result.setCollections(list);
            }
        }else{
        	ConditionPlateReportRecordDetail c = new ConditionPlateReportRecordDetail();
    		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
    		BaseCollection<BasePlateReportRecordDetail> tempResult = executeQueryPlateReportRecordDetail(c, c.getKeyValues());
    		return tempResult;
        }
		return result;
	}
}


