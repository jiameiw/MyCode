package gamework;
public class TestGame {
public static void main(String[] args) {
	TestGame t=new TestGame();	
    t.game();	
  }
public int getrand(){
	return (int)(Math.random()*101);
}
public void prints(Person[] p){
	for (int i = 0; i < p.length; i++) {
		System.out.println("第"+i+"个个体的支付值为："+p[i].getS());
	}
}
public void oldtonew(Person[] p){//淘汰适应性低的个体，并复制适应性高的个体，包括突变情况
	int d=20;//死亡人数
	//得分高低排序
int[][] a=new int[200][2];
for (int i = 0; i < a.length; i++) {
    a[i][0]=i;
	a[i][1]=p[i].getS();	
}
	for (int i = 0; i < a.length-1; i++) {
		for (int j = i; j < a.length; j++) {
			if(a[i][1]>a[j][1]){
				int t=a[i][1];
				a[i][1]=a[j][1];
				a[j][1]=t;
				t=a[i][0];
				a[i][0]=a[j][0];
				a[j][0]=t;	
			}
		}
		}   
	int r1=(int)(Math.random()*9);//复制oldtonew
	p[a[r1][0]].setS(getrand());
	for (int i = 0; i <d; i++) {
	if(i!=r1 )
		p[a[i][0]].setS(p[a[199-i][0]].getS());
	}
}
public int tongjigeshu(Person[] p){//统计每个支付值的个数
int[] g=new int[102];
	for (int i = 0; i < p.length; i++) {
		g[p[i].getS()]+=1;	
	}
	return g[50];
}
public void game(){
	Person[] p=new Person[200];
for (int i = 0; i < p.length; i++) {//给每个个体赋予支付值
		p[i]=new Person(i);
		p[i].setS(getrand());	
	}
int[] shuju=new int[10000];
for (int i = 0; i < 10000; i++) {//10000期博弈

	suijipipei(p);//随机匹配	
	//gengxinzhifu(p);
	oldtonew(p);//繁殖	
	
	shuju[i]=tongjigeshu(p);
	System.out.print(shuju[i]/200.0+"\n");
}

}
public void suijipipei(Person[] p){//随机匹配
	 int s[] = new int[200];   
     int t1,t2,t3;   
     for(int i = 0;i < s.length;i++){
         s[i] = i;
     }    
     //随机交换s.length次   
     for(int i = 0;i < s.length;i++){   
    	 t1=(int)(Math.random()*199);
    	 t2=(int)(Math.random()*199);
          if(t1 != t2){
             t3 = s[t1];   
             s[t1] = s[t2];   
             s[t2] = t3;
         } 
     }       
     for (int i = 0; i < s.length; i++) {//进行博弈
			if(p[i].getS()+p[s[i]].getS()>101)
			{
				p[i].setS(0);
				p[s[i]].setS(0);
			}
		}
}
}
