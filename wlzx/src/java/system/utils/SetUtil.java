package system.utils;

import java.util.Set;

public class SetUtil {

	public static Set merge(Set mainSet, Set subSet){
		if(subSet != null && subSet.size() > 0){
			for(Object object: subSet){
				mainSet.add(object);
			}
		}
		return mainSet;
	}
}
