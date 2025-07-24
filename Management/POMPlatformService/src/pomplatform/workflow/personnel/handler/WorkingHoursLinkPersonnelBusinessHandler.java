package pomplatform.workflow.personnel.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.personnel.bean.BaseWorkingHoursLinkPersonnelBusiness;
import pomplatform.workflow.personnel.bean.ConditionWorkingHoursLinkPersonnelBusiness;
import pomplatform.workflow.personnel.query.QueryWorkingHoursLinkPersonnelBusiness;
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

public class WorkingHoursLinkPersonnelBusinessHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(WorkingHoursLinkPersonnelBusinessHandler.class);

	public static BaseCollection<BaseWorkingHoursLinkPersonnelBusiness> executeQueryWorkingHoursLinkPersonnelBusiness(ConditionWorkingHoursLinkPersonnelBusiness c, KeyValuePair[] replacements ) throws Exception {
		QueryWorkingHoursLinkPersonnelBusiness dao = new QueryWorkingHoursLinkPersonnelBusiness();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseWorkingHoursLinkPersonnelBusiness> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionWorkingHoursLinkPersonnelBusiness c = new ConditionWorkingHoursLinkPersonnelBusiness();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseWorkingHoursLinkPersonnelBusiness> result = executeQueryWorkingHoursLinkPersonnelBusiness(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseWorkingHoursLinkPersonnelBusiness> result;
		ConditionWorkingHoursLinkPersonnelBusiness c = new ConditionWorkingHoursLinkPersonnelBusiness();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryWorkingHoursLinkPersonnelBusiness dao = new QueryWorkingHoursLinkPersonnelBusiness();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseWorkingHoursLinkPersonnelBusiness.ALL_CAPTIONS);
			for(BaseWorkingHoursLinkPersonnelBusiness b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


