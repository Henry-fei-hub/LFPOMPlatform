package pomplatform.contractMessage.handler;

import org.apache.log4j.Logger;
import pomplatform.contractMessage.bean.BaseOnLoadContractMessageByEmployeeId;
import pomplatform.contractMessage.bean.ConditionOnLoadContractMessageByEmployeeId;
import pomplatform.contractMessage.query.QueryOnLoadContractMessageByEmployeeId;
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

public class OnLoadContractMessageByEmployeeIdHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadContractMessageByEmployeeIdHandler.class);

	public static BaseCollection<BaseOnLoadContractMessageByEmployeeId> executeQueryOnLoadContractMessageByEmployeeId(ConditionOnLoadContractMessageByEmployeeId c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadContractMessageByEmployeeId dao = new QueryOnLoadContractMessageByEmployeeId();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadContractMessageByEmployeeId> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadContractMessageByEmployeeId c = new ConditionOnLoadContractMessageByEmployeeId();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadContractMessageByEmployeeId> result = executeQueryOnLoadContractMessageByEmployeeId(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadContractMessageByEmployeeId> result;
		ConditionOnLoadContractMessageByEmployeeId c = new ConditionOnLoadContractMessageByEmployeeId();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadContractMessageByEmployeeId dao = new QueryOnLoadContractMessageByEmployeeId();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadContractMessageByEmployeeId.ALL_CAPTIONS);
			for(BaseOnLoadContractMessageByEmployeeId b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


