package system.utils
{
	import mx.collections.ArrayCollection;
	public class HashMap
	{
		private var arrayCollection:ArrayCollection = null;
		public function HashMap ()
		{
			this.arrayCollection = new ArrayCollection();
		}
		public function gets ( key:String ):Object
		{
			for each ( var obj:MapObject in this.arrayCollection )
			
			{
				
				if ( obj.key == key )
					
				{
					return obj.value;
					
				}
				
			}
			
			return null;
			
		}
		public function puts ( key:String , value:Object ):void
		{
			if ( !this.arrayCollection.contains( value ))
			{
				this.arrayCollection.addItem( new MapObject( key , value ));
			}
		}
		public function remove ( key:String ):Boolean
		{
			var mo:MapObject = null;
			for ( var i:int = 0 ; i < this.arrayCollection.length ; ++i )
			{
				mo = MapObject( this.arrayCollection.getItemAt( i ));
				if ( mo.key == key )
				{
					this.arrayCollection.removeItemAt( i );
					return true;
				}
				
			}
			
			return false;
			
		}
		public function contains ( key:String ):Boolean
			
		{
			
			for each ( var obj:MapObject in this.arrayCollection )
			
			{
				
				if ( obj.key == key )
					
				{
					
					return true;
					
				}
				
			}
			
			return false;
			
		}
		public function size():int{
			if(arrayCollection==null)return 0;
			return arrayCollection.length;
		}
		
	}
	
}
