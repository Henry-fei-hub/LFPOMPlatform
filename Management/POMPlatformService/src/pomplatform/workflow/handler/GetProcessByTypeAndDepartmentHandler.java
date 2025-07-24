package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BaseGetProcessByTypeAndDepartment;
import pomplatform.workflow.bean.ConditionGetProcessByTypeAndDepartment;
import pomplatform.workflow.query.QueryGetProcessByTypeAndDepartment;
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

public class GetProcessByTypeAndDepartmentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(GetProcessByTypeAndDepartmentHandler.class);

	public static BaseCollection<BaseGetProcessByTypeAndDepartment> executeQueryGetProcessByTypeAndDepartment(ConditionGetProcessByTypeAndDepartment c, KeyValuePair[] replacements ) throws Exception {
		QueryGetProcessByTypeAndDepartment dao = new QueryGetProcessByTypeAndDepartment();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseGetProcessByTypeAndDepartment> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionGetProcessByTypeAndDepartment c = new ConditionGetProcessByTypeAndDepartment();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseGetProcessByTypeAndDepartment> result = executeQueryGetProcessByTypeAndDepartment(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseGetProcessByTypeAndDepartment> result;
		ConditionGetProcessByTypeAndDepartment c = new ConditionGetProcessByTypeAndDepartment();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryGetProcessByTypeAndDepartment dao = new QueryGetProcessByTypeAndDepartment();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGetProcessByTypeAndDepartment.ALL_CAPTIONS);
			for(BaseGetProcessByTypeAndDepartment b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


