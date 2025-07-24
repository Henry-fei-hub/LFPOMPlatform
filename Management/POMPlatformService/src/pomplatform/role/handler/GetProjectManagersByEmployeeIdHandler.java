package pomplatform.role.handler;

import org.apache.log4j.Logger;
import pomplatform.role.bean.BaseGetProjectManagersByEmployeeId;
import pomplatform.role.bean.ConditionGetProjectManagersByEmployeeId;
import pomplatform.role.query.QueryGetProjectManagersByEmployeeId;
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

public class GetProjectManagersByEmployeeIdHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(GetProjectManagersByEmployeeIdHandler.class);

	public static BaseCollection<BaseGetProjectManagersByEmployeeId> executeQueryGetProjectManagersByEmployeeId(ConditionGetProjectManagersByEmployeeId c, KeyValuePair[] replacements ) throws Exception {
		QueryGetProjectManagersByEmployeeId dao = new QueryGetProjectManagersByEmployeeId();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseGetProjectManagersByEmployeeId> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionGetProjectManagersByEmployeeId c = new ConditionGetProjectManagersByEmployeeId();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseGetProjectManagersByEmployeeId> result = executeQueryGetProjectManagersByEmployeeId(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseGetProjectManagersByEmployeeId> result;
		ConditionGetProjectManagersByEmployeeId c = new ConditionGetProjectManagersByEmployeeId();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryGetProjectManagersByEmployeeId dao = new QueryGetProjectManagersByEmployeeId();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGetProjectManagersByEmployeeId.ALL_CAPTIONS);
			for(BaseGetProjectManagersByEmployeeId b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


