package system.utils;


    public class CharsetConvertor {   
        
      
        public   static   String   UnicodeToGB(String   strIn)
        {
            byte[]   b;
            String   strOut   =   null;
            if(strIn   ==   null   ||   (strIn.trim()).equals( ""))
                return   strIn;
            try
            {
                b   =   strIn.getBytes( "GB2312");
                strOut   =   new   String(b, "ISO8859_1");
            }
            catch(Exception   e)
            {
                System.out.println( "unicodeToGB   exception   :   "   +   e.getMessage()   +   "\n ");
            }
            return   strOut;
        }


      //---------------------------------------------------------
      public   static   String   GBToUnicode(String   strIn)
        {
            byte[]   b;
            String   strOut   =   null;
            if(strIn   ==   null   ||   (strIn.trim()).equals( " "))
                return   strIn;
            try
            {
                b   =   strIn.getBytes("ISO8859_1");
                strOut   =   new   String(b, "GB2312");
            }
            catch(Exception   e)
            {
                System.out.println( "GBToUnicode   exception   :   "   +   e.getMessage()   +   "\n ");
            }
            return   strOut;
        } 
    }  
