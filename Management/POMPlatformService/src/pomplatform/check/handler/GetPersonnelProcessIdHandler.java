package pomplatform.check.handler;

import org.apache.log4j.Logger;
import pomplatform.check.bean.BaseGetPersonnelProcessId;
import pomplatform.check.bean.ConditionGetPersonnelProcessId;
import pomplatform.check.query.QueryGetPersonnelProcessId;
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

public class GetPersonnelProcessIdHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(GetPersonnelProcessIdHandler.class);

	public static BaseCollection<BaseGetPersonnelProcessId> executeQueryGetPersonnelProcessId(ConditionGetPersonnelProcessId c, KeyValuePair[] replacements ) throws Exception {
		QueryGetPersonnelProcessId dao = new QueryGetPersonnelProcessId();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseGetPersonnelProcessId> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionGetPersonnelProcessId c = new ConditionGetPersonnelProcessId();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseGetPersonnelProcessId> result = executeQueryGetPersonnelProcessId(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseGetPersonnelProcessId> result;
		ConditionGetPersonnelProcessId c = new ConditionGetPersonnelProcessId();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryGetPersonnelProcessId dao = new QueryGetPersonnelProcessId();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGetPersonnelProcessId.ALL_CAPTIONS);
			for(BaseGetPersonnelProcessId b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


