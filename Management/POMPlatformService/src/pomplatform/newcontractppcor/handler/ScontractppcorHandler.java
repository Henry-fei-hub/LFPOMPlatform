package pomplatform.newcontractppcor.handler;

import org.apache.log4j.Logger;

import pomplatform.newcontractppcor.bean.BaseScontractppcor;
import pomplatform.newcontractppcor.bean.ConditionScontractppcor;
import pomplatform.newcontractppcor.query.QueryScontractppcor;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;

public class ScontractppcorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ScontractppcorHandler.class);

	public static BaseCollection<BaseScontractppcor> executeQueryScontractppcor(ConditionScontractppcor c, KeyValuePair[] replacements ) throws Exception {
		QueryScontractppcor dao = new QueryScontractppcor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		KeyValuePair[] re =new KeyValuePair[3];
		String projectSecretaryId = BaseHelpUtils.getString(c.getProjectSecretaryId());
		if(BaseHelpUtils.isNullOrEmpty(projectSecretaryId)){
			KeyValuePair kv = new KeyValuePair();
			kv.setKey("remp.project_secretary LIKE concat ( '%', ( SELECT employee_name FROM employees WHERE employee_id =:project_secretary_id ), '%' )");
			kv.setValue( "1=1");
			re[0] = kv;
		}
		String projectManagerId = BaseHelpUtils.getString(c.getProjectManagerId());
		if(BaseHelpUtils.isNullOrEmpty(projectManagerId)){
			KeyValuePair kv = new KeyValuePair();
			kv.setKey("remp.project_manager LIKE concat ( '%', ( SELECT employee_name FROM employees WHERE employee_id =:project_manager_id ), '%' )");
			kv.setValue("1=1");
			re[1] = kv;
		}
		String projectLeaderId = BaseHelpUtils.getString(c.getProjectLeaderId());
		if(BaseHelpUtils.isNullOrEmpty(projectLeaderId)){
			KeyValuePair kv = new KeyValuePair();
			kv.setKey("remp.project_leader LIKE concat ( '%', ( SELECT employee_name FROM employees WHERE employee_id =:project_leader_id ), '%' )");
			kv.setValue("1=1");
			re[2] = kv;
		}
		BaseCollection<BaseScontractppcor> result = dao.execute( re, c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionScontractppcor c = new ConditionScontractppcor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseScontractppcor> result = executeQueryScontractppcor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseScontractppcor> result;
		ConditionScontractppcor c = new ConditionScontractppcor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryScontractppcor dao = new QueryScontractppcor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		
		KeyValuePair[] replacements =new KeyValuePair[3];
		String projectSecretaryId = BaseHelpUtils.getString(c.getProjectSecretaryId());
		if(BaseHelpUtils.isNullOrEmpty(projectSecretaryId)){
			KeyValuePair kv = new KeyValuePair();
			kv.setKey("remp.project_secretary LIKE concat ( '%', ( SELECT employee_name FROM employees WHERE 1=1 ), '%' )");
			kv.setValue( "1=1");
			replacements[0] = kv;
		}
		String projectManagerId = BaseHelpUtils.getString(c.getProjectManagerId());
		if(BaseHelpUtils.isNullOrEmpty(projectManagerId)){
			KeyValuePair kv = new KeyValuePair();
			kv.setKey("remp.project_manager LIKE concat ( '%', ( SELECT employee_name FROM employees WHERE 1=1 ), '%' )");
			kv.setValue("1=1");
			replacements[1] = kv;
		}
		String projectLeaderId = BaseHelpUtils.getString(c.getProjectLeaderId());
		if(BaseHelpUtils.isNullOrEmpty(projectLeaderId)){
			KeyValuePair kv = new KeyValuePair();
			kv.setKey("remp.project_leader LIKE concat ( '%', ( SELECT employee_name FROM employees WHERE 1=1 ), '%' )");
			kv.setValue("1=1");
			replacements[2] = kv;
		}
		result = dao.execute(replacements, c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute(replacements, c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseScontractppcor.ALL_CAPTIONS);
			for(BaseScontractppcor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


