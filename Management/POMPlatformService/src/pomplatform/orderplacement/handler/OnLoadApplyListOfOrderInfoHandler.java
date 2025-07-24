package pomplatform.orderplacement.handler;

import org.apache.log4j.Logger;
import pomplatform.orderplacement.bean.BaseOnLoadApplyListOfOrderInfo;
import pomplatform.orderplacement.bean.ConditionOnLoadApplyListOfOrderInfo;
import pomplatform.orderplacement.query.QueryOnLoadApplyListOfOrderInfo;
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

public class OnLoadApplyListOfOrderInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadApplyListOfOrderInfoHandler.class);

	public static BaseCollection<BaseOnLoadApplyListOfOrderInfo> executeQueryOnLoadApplyListOfOrderInfo(ConditionOnLoadApplyListOfOrderInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadApplyListOfOrderInfo dao = new QueryOnLoadApplyListOfOrderInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadApplyListOfOrderInfo> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadApplyListOfOrderInfo c = new ConditionOnLoadApplyListOfOrderInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadApplyListOfOrderInfo> result = executeQueryOnLoadApplyListOfOrderInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadApplyListOfOrderInfo> result;
		ConditionOnLoadApplyListOfOrderInfo c = new ConditionOnLoadApplyListOfOrderInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadApplyListOfOrderInfo dao = new QueryOnLoadApplyListOfOrderInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadApplyListOfOrderInfo.ALL_CAPTIONS);
			for(BaseOnLoadApplyListOfOrderInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


