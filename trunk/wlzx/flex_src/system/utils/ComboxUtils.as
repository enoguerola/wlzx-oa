// ActionScript file
package system.utils
{
	import mx.collections.ArrayCollection;
	public class ComboxUtils
	{
		public static function findIndex(whichArray:ArrayCollection, whichItem :Object):int
		{
			var index:int = 0;
			for(var i in whichArray)
			{
				if(whichArray[i].data == whichItem)
				{
					return index;
				}
				index ++;
			}
			return index;
		}
		public static function findIndexById(whichArray:ArrayCollection, whichItem :Object):int
		{
			var index:int = 0;
			for(var i in whichArray)
			{
				if(whichArray[i].id == whichItem)
				{
					return index;
				}
				index ++;
			}
			return index;
		}
	}
}
