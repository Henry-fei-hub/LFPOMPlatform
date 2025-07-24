package pomplatform.bonusPayment.handler;

import org.apache.log4j.Logger;
import pomplatform.bonusPayment.bean.BaseBonusPaymentRecord;
import pomplatform.bonusPayment.bean.ConditionBonusPaymentRecord;
import pomplatform.bonusPayment.query.QueryBonusPaymentRecord;
import pomplatform.plateReportRecordDetail.bean.BasePlateReportRecordDetail;
import pomplatform.plateReportRecordDetail.bean.ConditionPlateReportRecordDetail;
import delicacy.common.KeyValuePair;
import delicacy.common.MapUtils;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;

public class BonusPaymentRecordHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(BonusPaymentRecordHandler.class);

	public static BaseCollection<BaseBonusPaymentRecord> executeQueryBonusPaymentRecord(ConditionBonusPaymentRecord c, KeyValuePair[] replacements ) throws Exception {
		QueryBonusPaymentRecord dao = new QueryBonusPaymentRecord();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseBonusPaymentRecord> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		BaseCollection<BaseBonusPaymentRecord> result = new BaseCollection<>();
		List<BaseBonusPaymentRecord> list = null;
		JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> map = (Map<String, Object>) parser.parse(new BasicHandler());
        String tempPlateIds = BaseHelpUtils.getString(map.get("plateId"));
        if(tempPlateIds.length()>0){
        	Object[] arr = tempPlateIds.split(",");
            if(null != arr && arr.length > 0){
            	int length = arr.length;
            	for(int i =0 ;i<length;i++){
            		map.put("plateId", arr[i]);
            		ConditionBonusPaymentRecord c = new ConditionBonusPaymentRecord();
            		c.setDataFromJSON(MapUtils.toJSON(map));
            		BaseCollection<BaseBonusPaymentRecord> tempResult = executeQueryBonusPaymentRecord(c, c.getKeyValues());
            		if(i==0){
            			list = tempResult.getCollections();
            		}else{
            			if(null!=list){
            				List<BaseBonusPaymentRecord> tempList = tempResult.getCollections();
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
        	ConditionBonusPaymentRecord c = new ConditionBonusPaymentRecord();
    		c.setDataFromJSON(creteria);
    		BaseCollection<BaseBonusPaymentRecord> tempResult = executeQueryBonusPaymentRecord(c, c.getKeyValues());
    		return tempResult.toJSON();
        }
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseBonusPaymentRecord> result;
		ConditionBonusPaymentRecord c = new ConditionBonusPaymentRecord();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryBonusPaymentRecord dao = new QueryBonusPaymentRecord();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseBonusPaymentRecord.ALL_CAPTIONS);
			for(BaseBonusPaymentRecord b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


