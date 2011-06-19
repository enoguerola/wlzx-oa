package system.wlims.oa.daoImpl.schedule;

import java.util.List;
import system.BaseDAOImpl;
import system.wlims.oa.dao.schedule.ScheduleDAO;
import system.wlims.oa.entity.schedule.ScheduleModel;

public class ScheduleDAOImpl extends BaseDAOImpl<ScheduleModel> implements ScheduleDAO {

	@Override
	public List<ScheduleModel> getSchedulesByConditions(String userId, String type,
			String scope, String emergence, String deparmentId, String title,
			String beginDate, String endDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
