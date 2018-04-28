import java.rmi.Naming;
public class PsychServer {
 public PsychServer() {
 try {
 Psychintf c = new PsychImpl();
 Naming.rebind("rmi://localhost:1099//PsychService", c);
 } 
catch (Exception e) {
 System.out.println("Trouble: " + e);
 }
 }
 public static void main(String args[]) {	
 new PsychServer();
 }
} 