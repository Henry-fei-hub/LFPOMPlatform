package pomplatform.capitaldistribution.handler;

import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import delicacy.date.util.DateUtil;
import pomplatform.capitaldistribution.bean.BaseCapitalDistributionOfDepartment;
import pomplatform.capitaldistribution.bean.ConditionCapitalDistributionOfDepartment;
import pomplatform.capitaldistribution.query.QueryCapitalDistributionOfDepartment;

public class CapitalDistributionOfDepartmentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CapitalDistributionOfDepartmentHandler.class);

	public static BaseCollection<BaseCapitalDistributionOfDepartment> executeQueryCapitalDistributionOfDepartment(ConditionCapitalDistributionOfDepartment c, KeyValuePair[] replacements ) throws Exception {
		QueryCapitalDistributionOfDepartment dao = new QueryCapitalDistributionOfDepartment();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCapitalDistributionOfDepartment> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCapitalDistributionOfDepartment c = new ConditionCapitalDistributionOfDepartment();
		c.setDataFromJSON(creteria);
		if(null != c.getStartDate()){
			c.setStartDate(DateUtil.getNextDayOfDay(c.getStartDate(), 0));
		}
		if(null != c.getEndDate()){
			c.setEndDate(DateUtil.getNextDayOfDay(c.getEndDate(), 1));
		}
		BaseCollection<BaseCapitalDistributionOfDepartment> result = executeQueryCapitalDistributionOfDepartment(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCapitalDistributionOfDepartment> result;
		ConditionCapitalDistributionOfDepartment c = new ConditionCapitalDistributionOfDepartment();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		if(null != c.getStartDate()){
			c.setStartDate(DateUtil.getNextDayOfDay(c.getStartDate(), 0));
		}
		if(null != c.getEndDate()){
			c.setEndDate(DateUtil.getNextDayOfDay(c.getEndDate(), 1));
		}
		QueryCapitalDistributionOfDepartment dao = new QueryCapitalDistributionOfDepartment();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseCapitalDistributionOfDepartment.DOWN_CAPTIONS);
			for(BaseCapitalDistributionOfDepartment b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


