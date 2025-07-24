package pomplatform.EmployeeDetail.handler;

import org.apache.log4j.Logger;
import pomplatform.EmployeeDetail.bean.BaseProjectCostDetail;
import pomplatform.EmployeeDetail.bean.ConditionProjectCostDetail;
import pomplatform.EmployeeDetail.query.QueryProjectCostDetail;
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

public class ProjectCostDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ProjectCostDetailHandler.class);

	public static BaseCollection<BaseProjectCostDetail> executeQueryProjectCostDetail(ConditionProjectCostDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryProjectCostDetail dao = new QueryProjectCostDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseProjectCostDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionProjectCostDetail c = new ConditionProjectCostDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseProjectCostDetail> result = executeQueryProjectCostDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseProjectCostDetail> result;
		ConditionProjectCostDetail c = new ConditionProjectCostDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryProjectCostDetail dao = new QueryProjectCostDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseProjectCostDetail.ALL_CAPTIONS);
			for(BaseProjectCostDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


