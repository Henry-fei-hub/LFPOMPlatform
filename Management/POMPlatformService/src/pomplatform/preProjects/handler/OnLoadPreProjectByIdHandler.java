package pomplatform.preProjects.handler;

import org.apache.log4j.Logger;

import pomplatform.preProjects.bean.BaseOnLoadPreProjectById;
import pomplatform.preProjects.bean.ConditionOnLoadPreProjectById;
import pomplatform.preProjects.query.QueryOnLoadPreProjectById;
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
import delicacy.common.BaseHelpUtils;

public class OnLoadPreProjectByIdHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadPreProjectByIdHandler.class);

	public static BaseCollection<BaseOnLoadPreProjectById> executeQueryOnLoadPreProjectById(ConditionOnLoadPreProjectById c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadPreProjectById dao = new QueryOnLoadPreProjectById();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadPreProjectById> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadPreProjectById c = new ConditionOnLoadPreProjectById();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadPreProjectById> result = executeQueryOnLoadPreProjectById(c, c.getKeyValues());
		if(!BaseHelpUtils.isNullOrEmpty(result)&&result.getCollections().size()>0) {
			BaseOnLoadPreProjectById baseOnLoadPreProjectById = result.getCollections().get(0);
			String businessTypes = baseOnLoadPreProjectById.getBusinessTypes();
			if(!BaseHelpUtils.isNullOrEmpty(businessTypes)&&!businessTypes.equals("[]")) {
				String split = businessTypes.replace("[", "").replace("]", "").replaceAll("\\s", "");
				baseOnLoadPreProjectById.setBusinessTypes(split);
			}else {
				baseOnLoadPreProjectById.setBusinessTypes("");
			}
		}
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadPreProjectById> result;
		ConditionOnLoadPreProjectById c = new ConditionOnLoadPreProjectById();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadPreProjectById dao = new QueryOnLoadPreProjectById();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadPreProjectById.ALL_CAPTIONS);
			for(BaseOnLoadPreProjectById b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}
	
	
	public static void main(String[] args) throws Exception {
		

		ConditionOnLoadPreProjectById c = new ConditionOnLoadPreProjectById();
		c.setPreProjectId(2884);
		BaseCollection<BaseOnLoadPreProjectById> result = executeQueryOnLoadPreProjectById(c, c.getKeyValues());
		if(!BaseHelpUtils.isNullOrEmpty(result)&&result.getCollections().size()>0) {
			BaseOnLoadPreProjectById baseOnLoadPreProjectById = result.getCollections().get(0);
			String businessTypes = baseOnLoadPreProjectById.getBusinessTypes();
			if(!BaseHelpUtils.isNullOrEmpty(businessTypes)&&!businessTypes.equals("[]")) {
				String split = businessTypes.replace("[", "").replace("]", "").replaceAll("\\s", "");
				baseOnLoadPreProjectById.setBusinessTypes(split);
			}else {
				baseOnLoadPreProjectById.setBusinessTypes("");
			}
		}
	
	}
	
}


