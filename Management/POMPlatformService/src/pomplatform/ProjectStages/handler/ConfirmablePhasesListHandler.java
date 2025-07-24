package pomplatform.ProjectStages.handler;

import org.apache.log4j.Logger;
import pomplatform.ProjectStages.bean.BaseConfirmablePhasesList;
import pomplatform.ProjectStages.bean.ConditionConfirmablePhasesList;
import pomplatform.ProjectStages.query.QueryConfirmablePhasesList;
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

public class ConfirmablePhasesListHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ConfirmablePhasesListHandler.class);

	public static BaseCollection<BaseConfirmablePhasesList> executeQueryConfirmablePhasesList(ConditionConfirmablePhasesList c, KeyValuePair[] replacements ) throws Exception {
		QueryConfirmablePhasesList dao = new QueryConfirmablePhasesList();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseConfirmablePhasesList> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionConfirmablePhasesList c = new ConditionConfirmablePhasesList();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseConfirmablePhasesList> result = executeQueryConfirmablePhasesList(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseConfirmablePhasesList> result;
		ConditionConfirmablePhasesList c = new ConditionConfirmablePhasesList();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryConfirmablePhasesList dao = new QueryConfirmablePhasesList();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseConfirmablePhasesList.ALL_CAPTIONS);
			for(BaseConfirmablePhasesList b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


