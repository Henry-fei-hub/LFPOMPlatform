package pomplatform.workflow.personnelbusiness.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.personnelbusiness.bean.BaseDepartmentIdFindPlate;
import pomplatform.workflow.personnelbusiness.bean.ConditionDepartmentIdFindPlate;
import pomplatform.workflow.personnelbusiness.query.QueryDepartmentIdFindPlate;
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

public class DepartmentIdFindPlateHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(DepartmentIdFindPlateHandler.class);

	public static BaseCollection<BaseDepartmentIdFindPlate> executeQueryDepartmentIdFindPlate(ConditionDepartmentIdFindPlate c, KeyValuePair[] replacements ) throws Exception {
		QueryDepartmentIdFindPlate dao = new QueryDepartmentIdFindPlate();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseDepartmentIdFindPlate> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionDepartmentIdFindPlate c = new ConditionDepartmentIdFindPlate();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseDepartmentIdFindPlate> result = executeQueryDepartmentIdFindPlate(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseDepartmentIdFindPlate> result;
		ConditionDepartmentIdFindPlate c = new ConditionDepartmentIdFindPlate();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryDepartmentIdFindPlate dao = new QueryDepartmentIdFindPlate();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseDepartmentIdFindPlate.ALL_CAPTIONS);
			for(BaseDepartmentIdFindPlate b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


