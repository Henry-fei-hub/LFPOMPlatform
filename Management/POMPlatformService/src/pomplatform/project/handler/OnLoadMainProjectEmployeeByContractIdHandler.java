package pomplatform.project.handler;

import org.apache.log4j.Logger;
import pomplatform.project.bean.BaseOnLoadMainProjectEmployeeByContractId;
import pomplatform.project.bean.ConditionOnLoadMainProjectEmployeeByContractId;
import pomplatform.project.query.QueryOnLoadMainProjectEmployeeByContractId;
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

public class OnLoadMainProjectEmployeeByContractIdHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadMainProjectEmployeeByContractIdHandler.class);

	public static BaseCollection<BaseOnLoadMainProjectEmployeeByContractId> executeQueryOnLoadMainProjectEmployeeByContractId(ConditionOnLoadMainProjectEmployeeByContractId c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadMainProjectEmployeeByContractId dao = new QueryOnLoadMainProjectEmployeeByContractId();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadMainProjectEmployeeByContractId> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadMainProjectEmployeeByContractId c = new ConditionOnLoadMainProjectEmployeeByContractId();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadMainProjectEmployeeByContractId> result = executeQueryOnLoadMainProjectEmployeeByContractId(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadMainProjectEmployeeByContractId> result;
		ConditionOnLoadMainProjectEmployeeByContractId c = new ConditionOnLoadMainProjectEmployeeByContractId();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadMainProjectEmployeeByContractId dao = new QueryOnLoadMainProjectEmployeeByContractId();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadMainProjectEmployeeByContractId.ALL_CAPTIONS);
			for(BaseOnLoadMainProjectEmployeeByContractId b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


