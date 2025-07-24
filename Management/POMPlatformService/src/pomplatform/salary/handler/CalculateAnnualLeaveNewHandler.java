package pomplatform.salary.handler;

import org.apache.log4j.Logger;
import pomplatform.salary.bean.BaseCalculateAnnualLeaveNew;
import pomplatform.salary.bean.ConditionCalculateAnnualLeaveNew;
import pomplatform.salary.query.QueryCalculateAnnualLeaveNew;
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

public class CalculateAnnualLeaveNewHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CalculateAnnualLeaveNewHandler.class);

	public static BaseCollection<BaseCalculateAnnualLeaveNew> executeQueryCalculateAnnualLeaveNew(ConditionCalculateAnnualLeaveNew c, KeyValuePair[] replacements ) throws Exception {
		QueryCalculateAnnualLeaveNew dao = new QueryCalculateAnnualLeaveNew();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCalculateAnnualLeaveNew> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCalculateAnnualLeaveNew c = new ConditionCalculateAnnualLeaveNew();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseCalculateAnnualLeaveNew> result = executeQueryCalculateAnnualLeaveNew(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCalculateAnnualLeaveNew> result;
		ConditionCalculateAnnualLeaveNew c = new ConditionCalculateAnnualLeaveNew();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryCalculateAnnualLeaveNew dao = new QueryCalculateAnnualLeaveNew();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseCalculateAnnualLeaveNew.ALL_CAPTIONS);
			for(BaseCalculateAnnualLeaveNew b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


