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
		System.out.println("��"+i+"�������֧��ֵΪ��"+p[i].getS());
	}
}
public void oldtonew(Person[] p){//��̭��Ӧ�Ե͵ĸ��壬��������Ӧ�Ըߵĸ��壬����ͻ�����
	int d=20;//��������
	//�÷ָߵ�����
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
	int r1=(int)(Math.random()*9);//����oldtonew
	p[a[r1][0]].setS(getrand());
	for (int i = 0; i <d; i++) {
	if(i!=r1 )
		p[a[i][0]].setS(p[a[199-i][0]].getS());
	}
}
public int tongjigeshu(Person[] p){//ͳ��ÿ��֧��ֵ�ĸ���
int[] g=new int[102];
	for (int i = 0; i < p.length; i++) {
		g[p[i].getS()]+=1;	
	}
	return g[50];
}
public void game(){
	Person[] p=new Person[200];
for (int i = 0; i < p.length; i++) {//��ÿ�����帳��֧��ֵ
		p[i]=new Person(i);
		p[i].setS(getrand());	
	}
int[] shuju=new int[10000];
for (int i = 0; i < 10000; i++) {//10000�ڲ���

	suijipipei(p);//���ƥ��	
	//gengxinzhifu(p);
	oldtonew(p);//��ֳ	
	
	shuju[i]=tongjigeshu(p);
	System.out.print(shuju[i]/200.0+"\n");
}

}
public void suijipipei(Person[] p){//���ƥ��
	 int s[] = new int[200];   
     int t1,t2,t3;   
     for(int i = 0;i < s.length;i++){
         s[i] = i;
     }    
     //�������s.length��   
     for(int i = 0;i < s.length;i++){   
    	 t1=(int)(Math.random()*199);
    	 t2=(int)(Math.random()*199);
          if(t1 != t2){
             t3 = s[t1];   
             s[t1] = s[t2];   
             s[t2] = t3;
         } 
     }       
     for (int i = 0; i < s.length; i++) {//���в���
			if(p[i].getS()+p[s[i]].getS()>101)
			{
				p[i].setS(0);
				p[s[i]].setS(0);
			}
		}
}
}
