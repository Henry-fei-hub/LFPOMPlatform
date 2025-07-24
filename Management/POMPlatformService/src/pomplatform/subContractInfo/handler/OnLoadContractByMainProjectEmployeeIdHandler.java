package pomplatform.subContractInfo.handler;

import org.apache.log4j.Logger;
import pomplatform.subContractInfo.bean.BaseOnLoadContractByMainProjectEmployeeId;
import pomplatform.subContractInfo.bean.ConditionOnLoadContractByMainProjectEmployeeId;
import pomplatform.subContractInfo.query.QueryOnLoadContractByMainProjectEmployeeId;
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

public class OnLoadContractByMainProjectEmployeeIdHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadContractByMainProjectEmployeeIdHandler.class);

	public static BaseCollection<BaseOnLoadContractByMainProjectEmployeeId> executeQueryOnLoadContractByMainProjectEmployeeId(ConditionOnLoadContractByMainProjectEmployeeId c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadContractByMainProjectEmployeeId dao = new QueryOnLoadContractByMainProjectEmployeeId();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadContractByMainProjectEmployeeId> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadContractByMainProjectEmployeeId c = new ConditionOnLoadContractByMainProjectEmployeeId();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadContractByMainProjectEmployeeId> result = executeQueryOnLoadContractByMainProjectEmployeeId(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadContractByMainProjectEmployeeId> result;
		ConditionOnLoadContractByMainProjectEmployeeId c = new ConditionOnLoadContractByMainProjectEmployeeId();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadContractByMainProjectEmployeeId dao = new QueryOnLoadContractByMainProjectEmployeeId();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadContractByMainProjectEmployeeId.ALL_CAPTIONS);
			for(BaseOnLoadContractByMainProjectEmployeeId b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


