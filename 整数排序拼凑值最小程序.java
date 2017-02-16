package jiameix;

/*
 *  2014年去哪儿网笔试题--给定一个整型数组，对这个整型数组排序，使得按序拼接数组各元素得到的值最小
 *  示例：[3,83,8,13,1],被排序之后的数组为[1,13,3,83,8]。 依次拼接得到最小的数1133838
 */
public class IntSort{
public static void main(String[] args) {
	int[] array=new int[]{42,12,1,3,8,142,242,442};
	String[] string=new String[array.length];
	for(int i=0;i<array.length;i++){
		string[i]=Integer.toString(array[i]);
	}
	for(int i=0;i<array.length;i++){
		for (int j = i; j < string.length; j++) {
					String ab = string[i] + string[j];  
		            String ba = string[j] + string[i];  
		            if(ab.compareTo(ba)>0){
						String temp=string[i];
						string[i]=string[j];
						string[j]=temp;}				
			}
		}	
	for(int i=0;i<array.length;i++){
		System.out.println(string[i]);
	}
}
}
