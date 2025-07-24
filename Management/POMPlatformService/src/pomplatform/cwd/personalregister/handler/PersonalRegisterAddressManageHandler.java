package pomplatform.cwd.personalregister.handler;

import org.apache.log4j.Logger;
import pomplatform.cwd.personalregister.bean.BasePersonalRegisterAddressManage;
import pomplatform.cwd.personalregister.bean.ConditionPersonalRegisterAddressManage;
import pomplatform.cwd.personalregister.query.QueryPersonalRegisterAddressManage;
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

public class PersonalRegisterAddressManageHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(PersonalRegisterAddressManageHandler.class);

	public static BaseCollection<BasePersonalRegisterAddressManage> executeQueryPersonalRegisterAddressManage(ConditionPersonalRegisterAddressManage c, KeyValuePair[] replacements ) throws Exception {
		QueryPersonalRegisterAddressManage dao = new QueryPersonalRegisterAddressManage();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasePersonalRegisterAddressManage> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionPersonalRegisterAddressManage c = new ConditionPersonalRegisterAddressManage();
		c.setDataFromJSON(creteria);
		BaseCollection<BasePersonalRegisterAddressManage> result = executeQueryPersonalRegisterAddressManage(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasePersonalRegisterAddressManage> result;
		ConditionPersonalRegisterAddressManage c = new ConditionPersonalRegisterAddressManage();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryPersonalRegisterAddressManage dao = new QueryPersonalRegisterAddressManage();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasePersonalRegisterAddressManage.ALL_CAPTIONS);
			for(BasePersonalRegisterAddressManage b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


