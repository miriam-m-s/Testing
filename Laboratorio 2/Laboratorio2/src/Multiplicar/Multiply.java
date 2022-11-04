package Multiplicar;

public class Multiply {
	
	public Multiply(){
		
	}
	
	public int[] multiplica(int[] array1, int[] array2) throws Exception{
		if(array1 == null || array2 == null) throw new NullPointerException();
		int maxLong, minLong;
		
		int longArray[];
		if(array1.length>array2.length) {
			maxLong=array1.length;
			longArray = array1;
			minLong=array2.length;
		}
		else { 
			maxLong=array2.length;
			longArray = array2;
			minLong=array1.length;
		}
		int solo[] = new int[maxLong];
		int i=0;
		for(;i<minLong;i++)
			solo[i]=array1[i]*array2[i];
		
		for(;i<maxLong;i++)
			solo[i]= longArray[i];
		return solo;
		
	}
}
