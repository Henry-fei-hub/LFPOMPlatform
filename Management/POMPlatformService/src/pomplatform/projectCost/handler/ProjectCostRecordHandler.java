package pomplatform.projectCost.handler;

import org.apache.log4j.Logger;
import pomplatform.projectCost.bean.BaseProjectCostRecord;
import pomplatform.projectCost.bean.ConditionProjectCostRecord;
import pomplatform.projectCost.query.QueryProjectCostRecord;
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

public class ProjectCostRecordHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ProjectCostRecordHandler.class);

	public static BaseCollection<BaseProjectCostRecord> executeQueryProjectCostRecord(ConditionProjectCostRecord c, KeyValuePair[] replacements ) throws Exception {
		QueryProjectCostRecord dao = new QueryProjectCostRecord();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseProjectCostRecord> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionProjectCostRecord c = new ConditionProjectCostRecord();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseProjectCostRecord> result = executeQueryProjectCostRecord(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseProjectCostRecord> result;
		ConditionProjectCostRecord c = new ConditionProjectCostRecord();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryProjectCostRecord dao = new QueryProjectCostRecord();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseProjectCostRecord.ALL_CAPTIONS);
			for(BaseProjectCostRecord b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


