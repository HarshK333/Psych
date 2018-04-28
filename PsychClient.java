import java.rmi.Naming;
import java.util.*;
import java.io.*;
public class PsychClient {

    public static void main(String[] args) {
 try { 
 	Scanner sc=new Scanner(System.in);
Psychintf c = (Psychintf)Naming.lookup("rmi://localhost//PsychService");
System.out.println("enter ur name\n");
String name=sc.next();
int z=0;
while(z!=1){
String qu=c.sendQuestion();
if(qu.equals("Game has already started"))
{System.out.println(qu);
	break;}
else{
	System.out.println("\n"+qu);
System.out.println("\nAnswer:\n");
 String answer=sc.nextLine();
answer=sc.nextLine();
 int index=c.getAnswers(answer,name);
 String Answer=c.sendAnswers();
 while(Answer.equals("0"))
{
Answer=c.sendAnswers();
}
 System.out.println(Answer);
 System.out.println("Select index of answer you like bt not your own\n");
 int in=sc.nextInt();
 while(index==in)
 {
 	System.out.println("can't select your own answer\n");
 	in=sc.nextInt();
 }
c.getIndex(in);
String winner;
winner=c.sendResult();
while(winner.equals("0"))
{
winner=c.sendResult();
}
 System.out.println("\n"+winner);
}
System.out.println("\nif you dont want to play next game enter 1,else enter any number");
z=sc.nextInt();
}
 }
 catch (Exception e) {
 System.out.println(e);
 }
 }
}