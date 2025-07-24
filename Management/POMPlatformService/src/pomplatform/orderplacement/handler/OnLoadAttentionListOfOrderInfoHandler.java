package pomplatform.orderplacement.handler;

import org.apache.log4j.Logger;
import pomplatform.orderplacement.bean.BaseOnLoadAttentionListOfOrderInfo;
import pomplatform.orderplacement.bean.ConditionOnLoadAttentionListOfOrderInfo;
import pomplatform.orderplacement.query.QueryOnLoadAttentionListOfOrderInfo;
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

public class OnLoadAttentionListOfOrderInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadAttentionListOfOrderInfoHandler.class);

	public static BaseCollection<BaseOnLoadAttentionListOfOrderInfo> executeQueryOnLoadAttentionListOfOrderInfo(ConditionOnLoadAttentionListOfOrderInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadAttentionListOfOrderInfo dao = new QueryOnLoadAttentionListOfOrderInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadAttentionListOfOrderInfo> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadAttentionListOfOrderInfo c = new ConditionOnLoadAttentionListOfOrderInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadAttentionListOfOrderInfo> result = executeQueryOnLoadAttentionListOfOrderInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadAttentionListOfOrderInfo> result;
		ConditionOnLoadAttentionListOfOrderInfo c = new ConditionOnLoadAttentionListOfOrderInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadAttentionListOfOrderInfo dao = new QueryOnLoadAttentionListOfOrderInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadAttentionListOfOrderInfo.ALL_CAPTIONS);
			for(BaseOnLoadAttentionListOfOrderInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


