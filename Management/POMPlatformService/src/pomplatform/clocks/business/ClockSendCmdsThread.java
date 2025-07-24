package pomplatform.clocks.business;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseClock;
import com.pomplatform.db.dao.Clock;
import com.pomplatform.db.dao.ClockRecevieCmd;

import delicacy.common.BaseHelpUtils;

public class ClockSendCmdsThread extends Thread {
	private static Logger log = Logger.getLogger(ClockSendCmdsThread.class);
	private String sn;
	private String content;

	public ClockSendCmdsThread() {
	}

	public ClockSendCmdsThread(String sn, String content) {
		this.sn = sn;
		this.content = content;
	}

	@Override
	public void run() {
		String[] returnsCmd = content.split("\n");
		synchronized (returnsCmd) {
			for (int i = 0; i < returnsCmd.length; i++) {
				String[] key = { "ID", "Return", "CMD" };
				key = getAttrubute("&", returnsCmd[i], key);
				//Info 命令返回值
				if (key[2].equals("INFO")) {
					String[] mactype = { "~DeviceName", "TransactionCount", "FWVersion" };
					String[] m = { "", "", "" };
					for (int j = 1; j < returnsCmd.length; j++) {
						int index = returnsCmd[j].indexOf("=");
						if (index >= 0) {
							String k = returnsCmd[j].substring(0, index);
							for (int a = 0; a < mactype.length; a++) {
								if (k.equalsIgnoreCase(mactype[a])) {
									m[a] = returnsCmd[j].substring(index + 1);
								}

							}
						}
					}
					try {
						Clock clockDao = new Clock();
						clockDao.setConditionSn("=",sn);
						BaseClock clock = clockDao.executeQueryOneRow();
						if(!BaseHelpUtils.isNullOrEmpty(clock)){
							if (clock.getEnabled() == 1) {
								clock.setDeviceName(m[0]);
								clock.setTransactionCount(Integer.valueOf(m[1]));
								clock.setLastActivity(new Timestamp(System.currentTimeMillis()));
								clock.setFwVersion(m[2]);
								clock.setUpdateDb("1111101011");
								clockDao.clear();
								clockDao.setDataFromBase(clock);
								clockDao.update();
								//更新返回指令状态
								ClockRecevieCmd dao = new ClockRecevieCmd();
								dao.setClockRecevieCmdId(BaseHelpUtils.getIntValue(key[0]));
								if(dao.load()){
									dao.setSuccessFlag(Short.valueOf(key[1]));
									dao.setCmdReturn(BaseHelpUtils.getIntValue(key[1]));
									dao.setStatus(Short.valueOf(key[1]));
									dao.setCmdOverTime(new Date());
									dao.update();
								}
							}
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else {
					if(!BaseHelpUtils.isNullOrEmpty(key[0]) && !key[0].equals("ID")){
						try {
							ClockRecevieCmd dao = new ClockRecevieCmd();
							dao.setClockRecevieCmdId(BaseHelpUtils.getIntValue(key[0]));
							if(dao.load()){
								if (key[1].equals("1")) {
									dao.setSuccessFlag(Short.valueOf("0"));
									dao.setCmdReturn(0);
									dao.setStatus(Short.valueOf("0"));
								}else{
									dao.setSuccessFlag(Short.valueOf(key[1]));
									dao.setCmdReturn(BaseHelpUtils.getIntValue(key[1]));
									dao.setStatus(Short.valueOf(key[1]));
								}
								dao.setCmdOverTime(new Date());
								dao.update();
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}

	}

	private String[] getAttrubute(String split, String str, String[] key) {
		final String s = str;
		String arr[] = s.split(split);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].trim().equals("")) {
				continue;
			}
			int index = arr[i].indexOf("=");
			if (index > 0) {
				String k = arr[i].substring(0, index);
				for (int j = 0; j < key.length; j++) {
					if (key[j].equalsIgnoreCase(k)) {
						key[j] = arr[i].substring(index + 1);
					}
				}
			}

		}
		return key;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}