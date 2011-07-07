package system.wlims.oa;

import java.util.ArrayList;
import java.util.List;

import system.wlims.oa.entity.receipt.FileFlowModel;

public class FileFlowTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<FileFlowModel> list = new ArrayList<FileFlowModel>();
		
		FileFlowModel model = new FileFlowModel();
		model.setId("1");
		list.add(model);
		model = new FileFlowModel();
		model.setId("2");
		list.add(model);
		model = new FileFlowModel();
		model.setId("3");
		list.add(model);
		
		System.out.println(list.size());
		for(FileFlowModel object : list){
			System.out.println(object.getId());
		}
		for(FileFlowModel object : list){
			if(object.getId().equals("2"))
				list.remove(object);
		}
		System.out.print("after filter");
		System.out.println(list.size());
		for(FileFlowModel object : list){
			System.out.println(object.getId());
		}
		
	}

}
