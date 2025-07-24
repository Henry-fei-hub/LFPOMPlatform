package pomplatform.financialtransactionaccount.handler;

import org.apache.log4j.Logger;
import pomplatform.financialtransactionaccount.bean.BaseTransDetail;
import pomplatform.financialtransactionaccount.bean.ConditionTransDetail;
import pomplatform.financialtransactionaccount.query.QueryTransDetail;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;

public class TransDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(TransDetailHandler.class);

	public static BaseCollection<BaseTransDetail> executeQueryTransDetail(ConditionTransDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryTransDetail dao = new QueryTransDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseTransDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionTransDetail c = new ConditionTransDetail();
		c.setDataFromJSON(creteria);
		if(null == c.getStartDate()) {
			KeyValuePair kv = new KeyValuePair();
			kv.setKey("b.record_date < ? and b.delete_flag = ? and b.company_id = ?) ) k group by");
			kv.setValue("b.record_date < ? and b.delete_flag = ? and b.company_id = ? and 1<>1) ) k group by");
			KeyValuePair[] originalArr = c.getKeyValues();
			int size = 1;
			KeyValuePair[] arr = null;
			if(null != originalArr) {
				size += originalArr.length;
				arr = new KeyValuePair[size];
				for(int i = 0; i < size - 1; i++) {
					arr[i] = originalArr[i];
				}
			}else {
				arr = new KeyValuePair[size];
			}
			arr[size - 1] = kv;
			c.setKeyValues(arr);
		}else {
			c.setInitEndDate(c.getStartDate());
		}
		BaseCollection<BaseTransDetail> result = executeQueryTransDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseTransDetail> result;
		ConditionTransDetail c = new ConditionTransDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryTransDetail dao = new QueryTransDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseTransDetail.ALL_CAPTIONS);
			for(BaseTransDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


