package jiameix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestMap {
	public static void main(String[] args) throws IOException {
		File file1=new File("test.txt");
		FileReader fr=new FileReader(file1);
		BufferedReader br=new BufferedReader(fr);
		Map<String, Integer> map1=new HashMap<String, Integer>();
		String b;
		while((b=br.readLine())!=null){
			String str[]=b.split(" ");//split用空格分割数据
			for(String s:str){
				if(!map1.containsKey(s))
					map1.put(s,1);
				else 
					map1.put(s,map1.get(s)+1);
			}
		}
	System.out.println(map1);	
	br.close();
	}

}
