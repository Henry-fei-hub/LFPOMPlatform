package pomplatform.workflow.personnelbusiness.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.personnelbusiness.bean.BaseOnLoadApplyListOfSalaryAdjustment;
import pomplatform.workflow.personnelbusiness.bean.ConditionOnLoadApplyListOfSalaryAdjustment;
import pomplatform.workflow.personnelbusiness.query.QueryOnLoadApplyListOfSalaryAdjustment;
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

public class OnLoadApplyListOfSalaryAdjustmentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadApplyListOfSalaryAdjustmentHandler.class);

	public static BaseCollection<BaseOnLoadApplyListOfSalaryAdjustment> executeQueryOnLoadApplyListOfSalaryAdjustment(ConditionOnLoadApplyListOfSalaryAdjustment c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadApplyListOfSalaryAdjustment dao = new QueryOnLoadApplyListOfSalaryAdjustment();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadApplyListOfSalaryAdjustment> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadApplyListOfSalaryAdjustment c = new ConditionOnLoadApplyListOfSalaryAdjustment();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadApplyListOfSalaryAdjustment> result = executeQueryOnLoadApplyListOfSalaryAdjustment(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadApplyListOfSalaryAdjustment> result;
		ConditionOnLoadApplyListOfSalaryAdjustment c = new ConditionOnLoadApplyListOfSalaryAdjustment();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadApplyListOfSalaryAdjustment dao = new QueryOnLoadApplyListOfSalaryAdjustment();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadApplyListOfSalaryAdjustment.ALL_CAPTIONS);
			for(BaseOnLoadApplyListOfSalaryAdjustment b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


