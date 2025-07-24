package pomplatform.departmentDirector.handler;

import org.apache.log4j.Logger;
import pomplatform.departmentDirector.bean.BaseMDepartmentDirector;
import pomplatform.departmentDirector.bean.ConditionMDepartmentDirector;
import pomplatform.departmentDirector.query.QueryMDepartmentDirector;
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

public class MDepartmentDirectorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MDepartmentDirectorHandler.class);

	public static BaseCollection<BaseMDepartmentDirector> executeQueryMDepartmentDirector(ConditionMDepartmentDirector c, KeyValuePair[] replacements ) throws Exception {
		QueryMDepartmentDirector dao = new QueryMDepartmentDirector();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMDepartmentDirector> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMDepartmentDirector c = new ConditionMDepartmentDirector();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMDepartmentDirector> result = executeQueryMDepartmentDirector(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMDepartmentDirector> result;
		ConditionMDepartmentDirector c = new ConditionMDepartmentDirector();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMDepartmentDirector dao = new QueryMDepartmentDirector();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMDepartmentDirector.ALL_CAPTIONS);
			for(BaseMDepartmentDirector b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


