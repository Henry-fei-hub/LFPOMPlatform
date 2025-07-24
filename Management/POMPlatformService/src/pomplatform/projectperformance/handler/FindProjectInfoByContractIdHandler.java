package pomplatform.projectperformance.handler;

import org.apache.log4j.Logger;
import pomplatform.projectperformance.bean.BaseFindProjectInfoByContractId;
import pomplatform.projectperformance.bean.ConditionFindProjectInfoByContractId;
import pomplatform.projectperformance.query.QueryFindProjectInfoByContractId;
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

public class FindProjectInfoByContractIdHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(FindProjectInfoByContractIdHandler.class);

	public static BaseCollection<BaseFindProjectInfoByContractId> executeQueryFindProjectInfoByContractId(ConditionFindProjectInfoByContractId c, KeyValuePair[] replacements ) throws Exception {
		QueryFindProjectInfoByContractId dao = new QueryFindProjectInfoByContractId();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseFindProjectInfoByContractId> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionFindProjectInfoByContractId c = new ConditionFindProjectInfoByContractId();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseFindProjectInfoByContractId> result = executeQueryFindProjectInfoByContractId(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseFindProjectInfoByContractId> result;
		ConditionFindProjectInfoByContractId c = new ConditionFindProjectInfoByContractId();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryFindProjectInfoByContractId dao = new QueryFindProjectInfoByContractId();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseFindProjectInfoByContractId.ALL_CAPTIONS);
			for(BaseFindProjectInfoByContractId b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


