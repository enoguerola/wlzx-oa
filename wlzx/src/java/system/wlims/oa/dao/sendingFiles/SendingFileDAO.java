package system.wlims.oa.dao.sendingFiles;

import java.util.List;

import system.BaseDAO;
import system.wlims.oa.entity.sendingFiles.SendingFileModel;

public interface SendingFileDAO extends BaseDAO<SendingFileModel> {
	  List<SendingFileModel> getByConditions(String dispatchWord,String dispatchYear,String dispatchNumber,String title,String auspiceDepartment,String beginDate,String endDate,String states);

}
