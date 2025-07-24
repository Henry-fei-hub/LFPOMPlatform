package pomplatform.department.handler;

import org.apache.log4j.Logger;
import pomplatform.department.bean.BaseOnLoadDepartmentByParentId;
import pomplatform.department.bean.ConditionOnLoadDepartmentByParentId;
import pomplatform.department.query.QueryOnLoadDepartmentByParentId;
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

public class OnLoadDepartmentByParentIdHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadDepartmentByParentIdHandler.class);

	public static BaseCollection<BaseOnLoadDepartmentByParentId> executeQueryOnLoadDepartmentByParentId(ConditionOnLoadDepartmentByParentId c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadDepartmentByParentId dao = new QueryOnLoadDepartmentByParentId();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadDepartmentByParentId> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadDepartmentByParentId c = new ConditionOnLoadDepartmentByParentId();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadDepartmentByParentId> result = executeQueryOnLoadDepartmentByParentId(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadDepartmentByParentId> result;
		ConditionOnLoadDepartmentByParentId c = new ConditionOnLoadDepartmentByParentId();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadDepartmentByParentId dao = new QueryOnLoadDepartmentByParentId();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadDepartmentByParentId.ALL_CAPTIONS);
			for(BaseOnLoadDepartmentByParentId b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


