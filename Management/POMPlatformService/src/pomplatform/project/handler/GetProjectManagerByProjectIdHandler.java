package pomplatform.project.handler;

import org.apache.log4j.Logger;
import pomplatform.project.bean.BaseGetProjectManagerByProjectId;
import pomplatform.project.bean.ConditionGetProjectManagerByProjectId;
import pomplatform.project.query.QueryGetProjectManagerByProjectId;
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

public class GetProjectManagerByProjectIdHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(GetProjectManagerByProjectIdHandler.class);

	public static BaseCollection<BaseGetProjectManagerByProjectId> executeQueryGetProjectManagerByProjectId(ConditionGetProjectManagerByProjectId c, KeyValuePair[] replacements ) throws Exception {
		QueryGetProjectManagerByProjectId dao = new QueryGetProjectManagerByProjectId();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseGetProjectManagerByProjectId> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionGetProjectManagerByProjectId c = new ConditionGetProjectManagerByProjectId();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseGetProjectManagerByProjectId> result = executeQueryGetProjectManagerByProjectId(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseGetProjectManagerByProjectId> result;
		ConditionGetProjectManagerByProjectId c = new ConditionGetProjectManagerByProjectId();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryGetProjectManagerByProjectId dao = new QueryGetProjectManagerByProjectId();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGetProjectManagerByProjectId.ALL_CAPTIONS);
			for(BaseGetProjectManagerByProjectId b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


