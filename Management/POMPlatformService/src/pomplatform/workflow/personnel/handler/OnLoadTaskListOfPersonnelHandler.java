package pomplatform.workflow.personnel.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.personnel.bean.BaseOnLoadTaskListOfPersonnel;
import pomplatform.workflow.personnel.bean.ConditionOnLoadTaskListOfPersonnel;
import pomplatform.workflow.personnel.query.QueryOnLoadTaskListOfPersonnel;
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

public class OnLoadTaskListOfPersonnelHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadTaskListOfPersonnelHandler.class);

	public static BaseCollection<BaseOnLoadTaskListOfPersonnel> executeQueryOnLoadTaskListOfPersonnel(ConditionOnLoadTaskListOfPersonnel c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadTaskListOfPersonnel dao = new QueryOnLoadTaskListOfPersonnel();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadTaskListOfPersonnel> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadTaskListOfPersonnel c = new ConditionOnLoadTaskListOfPersonnel();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadTaskListOfPersonnel> result = executeQueryOnLoadTaskListOfPersonnel(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadTaskListOfPersonnel> result;
		ConditionOnLoadTaskListOfPersonnel c = new ConditionOnLoadTaskListOfPersonnel();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadTaskListOfPersonnel dao = new QueryOnLoadTaskListOfPersonnel();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadTaskListOfPersonnel.ALL_CAPTIONS);
			for(BaseOnLoadTaskListOfPersonnel b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


