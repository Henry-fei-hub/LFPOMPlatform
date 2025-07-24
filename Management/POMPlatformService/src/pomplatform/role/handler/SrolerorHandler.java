package pomplatform.role.handler;

import org.apache.log4j.Logger;
import pomplatform.role.bean.BaseSroleror;
import pomplatform.role.bean.ConditionSroleror;
import pomplatform.role.query.QuerySroleror;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pomplatform.db.bean.BaseRoleFunction;
import com.pomplatform.db.dao.RoleFunction;
import delicacy.common.BaseCollection;

public class SrolerorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SrolerorHandler.class);

	public static BaseCollection<BaseSroleror> executeQuerySroleror(ConditionSroleror c, KeyValuePair[] replacements ) throws Exception {
		QuerySroleror dao = new QuerySroleror();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSroleror> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			RoleFunction daoRoleFunction = new RoleFunction();
			for(BaseSroleror bean : result.getCollections()){
				daoRoleFunction.setConditionRoleId("=", bean.getRoleId());
				bean.setDetailRoleFunction(daoRoleFunction.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSroleror c = new ConditionSroleror();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSroleror> result = executeQuerySroleror(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSroleror> result;
		ConditionSroleror c = new ConditionSroleror();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySroleror dao = new QuerySroleror();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "UTF-8")){
			ps.println(BaseSroleror.ALL_CAPTIONS);
			for(BaseSroleror b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


