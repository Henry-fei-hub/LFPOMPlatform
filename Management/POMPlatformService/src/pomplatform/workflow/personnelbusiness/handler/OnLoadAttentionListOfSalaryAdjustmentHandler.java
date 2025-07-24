package pomplatform.workflow.personnelbusiness.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.personnelbusiness.bean.BaseOnLoadAttentionListOfSalaryAdjustment;
import pomplatform.workflow.personnelbusiness.bean.ConditionOnLoadAttentionListOfSalaryAdjustment;
import pomplatform.workflow.personnelbusiness.query.QueryOnLoadAttentionListOfSalaryAdjustment;
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

public class OnLoadAttentionListOfSalaryAdjustmentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadAttentionListOfSalaryAdjustmentHandler.class);

	public static BaseCollection<BaseOnLoadAttentionListOfSalaryAdjustment> executeQueryOnLoadAttentionListOfSalaryAdjustment(ConditionOnLoadAttentionListOfSalaryAdjustment c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadAttentionListOfSalaryAdjustment dao = new QueryOnLoadAttentionListOfSalaryAdjustment();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadAttentionListOfSalaryAdjustment> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadAttentionListOfSalaryAdjustment c = new ConditionOnLoadAttentionListOfSalaryAdjustment();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadAttentionListOfSalaryAdjustment> result = executeQueryOnLoadAttentionListOfSalaryAdjustment(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadAttentionListOfSalaryAdjustment> result;
		ConditionOnLoadAttentionListOfSalaryAdjustment c = new ConditionOnLoadAttentionListOfSalaryAdjustment();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadAttentionListOfSalaryAdjustment dao = new QueryOnLoadAttentionListOfSalaryAdjustment();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadAttentionListOfSalaryAdjustment.ALL_CAPTIONS);
			for(BaseOnLoadAttentionListOfSalaryAdjustment b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


