package jiameix;

/*
 *  2014��ȥ�Ķ���������--����һ���������飬�����������������ʹ�ð���ƴ�������Ԫ�صõ���ֵ��С
 *  ʾ����[3,83,8,13,1],������֮�������Ϊ[1,13,3,83,8]�� ����ƴ�ӵõ���С����1133838
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
