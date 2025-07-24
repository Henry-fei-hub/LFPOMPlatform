package pomplatform.projectEmployee.handler;

import org.apache.log4j.Logger;
import pomplatform.projectEmployee.bean.BaseOnLoadProjectEmpByProcess;
import pomplatform.projectEmployee.bean.ConditionOnLoadProjectEmpByProcess;
import pomplatform.projectEmployee.query.QueryOnLoadProjectEmpByProcess;
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

public class OnLoadProjectEmpByProcessHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadProjectEmpByProcessHandler.class);

	public static BaseCollection<BaseOnLoadProjectEmpByProcess> executeQueryOnLoadProjectEmpByProcess(ConditionOnLoadProjectEmpByProcess c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadProjectEmpByProcess dao = new QueryOnLoadProjectEmpByProcess();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadProjectEmpByProcess> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadProjectEmpByProcess c = new ConditionOnLoadProjectEmpByProcess();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadProjectEmpByProcess> result = executeQueryOnLoadProjectEmpByProcess(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadProjectEmpByProcess> result;
		ConditionOnLoadProjectEmpByProcess c = new ConditionOnLoadProjectEmpByProcess();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadProjectEmpByProcess dao = new QueryOnLoadProjectEmpByProcess();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadProjectEmpByProcess.ALL_CAPTIONS);
			for(BaseOnLoadProjectEmpByProcess b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


