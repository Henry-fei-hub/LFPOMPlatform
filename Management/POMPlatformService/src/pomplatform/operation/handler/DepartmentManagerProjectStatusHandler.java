package pomplatform.operation.handler;

import org.apache.log4j.Logger;
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
import pomplatform.operation.bean.BaseDepartmentManagerProjectStatus;
import pomplatform.operation.bean.ConditionDepartmentManagerProjectStatus;
import pomplatform.operation.query.QueryDepartmentManagerProjectStatus;

public class DepartmentManagerProjectStatusHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(DepartmentManagerProjectStatusHandler.class);

	public static BaseCollection<BaseDepartmentManagerProjectStatus> executeQueryDepartmentManagerProjectStatus(ConditionDepartmentManagerProjectStatus c, KeyValuePair[] replacements ) throws Exception {
		QueryDepartmentManagerProjectStatus dao = new QueryDepartmentManagerProjectStatus();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseDepartmentManagerProjectStatus> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionDepartmentManagerProjectStatus c = new ConditionDepartmentManagerProjectStatus();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseDepartmentManagerProjectStatus> result = executeQueryDepartmentManagerProjectStatus(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseDepartmentManagerProjectStatus> result;
		ConditionDepartmentManagerProjectStatus c = new ConditionDepartmentManagerProjectStatus();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryDepartmentManagerProjectStatus dao = new QueryDepartmentManagerProjectStatus();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseDepartmentManagerProjectStatus.ALL_CAPTIONS);
			for(BaseDepartmentManagerProjectStatus b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


