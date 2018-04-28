import java.rmi.*;
import java.util.*;
import java.math.*;
import java.util.Random;
public class PsychImpl extends java.rmi.server.UnicastRemoteObject implements Psychintf
{
	static String answers[] = new String[100];
	static String name[] = new String[100];
	static String allAns = "";
	static int ans=0,j2=0;
	static int nm=0,j1=0,i1=0,i=0,i3=0,flag=0;
	static int selected[] = new int[100];
	static String quest[]={"Who will win the elections in 2019?","Who is the best teacher in IT?","Which method will you choose to commit suicide?","If you have one bullet,who will you shoot?","Favourite dialouge?"};
	public PsychImpl() throws RemoteException
	{
		super();
	}

	public String sendQuestion() throws RemoteException
	{
if(flag==1)
	return "Game has already started";
      i3++;

Random rand = new Random();


		if(i1==0)
		{i = rand.nextInt(5);
		i1++;}
		while(quest[i].equals("0")){
			i=(i+1)%5;
		}
	    
		
	
	     String Q=quest[i];
		return Q;

	}
	public int getAnswers(String a,String b) throws RemoteException
	{
		flag=1;
        quest[i]="0";
		answers[ans]=a;
		allAns = allAns +"\n"+ans+"."+a;
		name[ans]=b;
		ans++;
		return (ans-1);
	}
	public String sendAnswers() throws RemoteException
	{
		if(ans<i3){return "0";}
		return allAns;
	}
	public void getIndex(int i) throws RemoteException
	{
		selected[i]++;
		j1++;
	}
	public String sendResult() throws RemoteException
	 {
	 	if(j1<i3){return "0";}
	 	j2++;
	 	int j=0;
	 	if(j2==1){
	 	int max=0;
	 	for (int i=0;i<i3 ;i++ ) {
	 		if(max<selected[i])
	 		{
	 			max=selected[i];
	 			j=i;
	 		}
	 		selected[i]=0;

	 	}}

	 	String winner="winner is "+name[j]+" with answer:"+answers[j];
	 		 	if(j2==i3){
	 	nm=0;
	 	j1=0;
	 	i1=0;
	 	i=0;
	 	ans=0;
	 	allAns = "";
	 	j2=0;
	 	i3=0;
	 	flag=0;}
	 	return winner;
	}
}