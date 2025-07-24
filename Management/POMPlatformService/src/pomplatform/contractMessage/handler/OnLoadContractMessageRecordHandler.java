package pomplatform.contractMessage.handler;

import org.apache.log4j.Logger;
import pomplatform.contractMessage.bean.BaseOnLoadContractMessageRecord;
import pomplatform.contractMessage.bean.ConditionOnLoadContractMessageRecord;
import pomplatform.contractMessage.query.QueryOnLoadContractMessageRecord;
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

public class OnLoadContractMessageRecordHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadContractMessageRecordHandler.class);

	public static BaseCollection<BaseOnLoadContractMessageRecord> executeQueryOnLoadContractMessageRecord(ConditionOnLoadContractMessageRecord c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadContractMessageRecord dao = new QueryOnLoadContractMessageRecord();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadContractMessageRecord> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadContractMessageRecord c = new ConditionOnLoadContractMessageRecord();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadContractMessageRecord> result = executeQueryOnLoadContractMessageRecord(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadContractMessageRecord> result;
		ConditionOnLoadContractMessageRecord c = new ConditionOnLoadContractMessageRecord();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadContractMessageRecord dao = new QueryOnLoadContractMessageRecord();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadContractMessageRecord.ALL_CAPTIONS);
			for(BaseOnLoadContractMessageRecord b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


