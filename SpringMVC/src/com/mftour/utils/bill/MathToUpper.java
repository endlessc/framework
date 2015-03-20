package com.mftour.utils.bill;


/**
 * @author 康文亮
 *
 */
public class MathToUpper {
	  
	/**
     * 将输入金额num转换为汉字大写格式
     * @param num 输入金额（小于10000000）
     * @return 金额的大写格式
     */
    public static void main(String[] args) {
    	System.out.println(MathToUpper.mathToUpper(4001010.62));
	}
    public static String mathToUpper(double num){
        String[] upChinese={"零","壹","贰","叁","肆","伍","陆","柒","捌","玖",};
        String[] upChinese2={"分","角","圆","拾","佰","仟","萬","拾","佰","仟","亿","拾","佰","仟","兆"};
        StringBuffer result=new StringBuffer();
        int count=0;
        int zeroflag=0;
        boolean mantissa=false;
        if(num<0){                      //输入值小于零
            return "输入金额不能为负数！";
        }
        if(num==0){                     //输入值等于零
            return "零";
        }
        if(String.valueOf(num).indexOf('E')!=-1){ //输入值过大转为科学计数法本方法无法转换
            return "您输入的金额过大";
        }
        int tem=(int)(num*100);
        if(tem%100==0){                           //金额为整时
            if(tem==0)
            	return "您输入的数值过小！";         //输入额为e:0.0012小于分计量单位时  
            result.insert(0, "整");
            tem=tem/100;
            count=2;
            mantissa=true;
        }
        while(tem>0){
              
            int t=(int)tem%10;                    //取得最后一位
            if(t!=0){                             //最后一位不为零时  
                if(zeroflag>=1){                  //对该位前的单个或多个零位进行处理  
                    if(((!mantissa)&&count==1)){                    //不是整数金额且分为为零
                        
                    }else if(count>2&&count-zeroflag<2){            //输入金额为400.04小数点前后都有零
                        
                            result.insert(1,"零");
                       
                    }else if(count>6&&count-zeroflag<6&&count<10){  //万位后为零且万位为零
                        if(count-zeroflag==2){                      //输入值如400000
                            result.insert(0,"萬");
                        }else{
                            result.insert(0,"萬零");                 //输入值如400101 
                        }
                    }else if(count>10&&count-zeroflag<10){
                        if(count-zeroflag==2){
                            result.insert(0,"亿");
                        }else{
                            result.insert(0,"亿零");
                        }
                        
           
                    }else if(((count-zeroflag)==2)){                //个位为零
                        
                    }else if(count>6&&count-zeroflag==6&&count<10){ //以万位开始出现零如4001000
                        result.insert(0,"萬");
                    }else if(count==11&&zeroflag==1){               
                        result.insert(0,"亿");
                    }else{
                        result.insert(0,"零");
                    }
                    
                }           
                result.insert(0,upChinese[t]+ upChinese2[count]); 
                zeroflag=0;
                
            }else{
                if(count==2){
                    result.insert(0,upChinese2[count]);             //个位为零补上"圆"字
                }
                zeroflag++;
            }
            tem/=10;
            //System.out.println("count="+count+"---zero="+zeroflag+"----"+result.toString());
            count++;
            
            if(count>20)break;      
        }
        return result.toString();
        
    }
    
}