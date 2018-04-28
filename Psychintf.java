
public interface Psychintf extends java.rmi.Remote  {
	public String sendQuestion() throws java.rmi.RemoteException ;
	public int getAnswers(String a,String b) throws java.rmi.RemoteException;
	public String sendAnswers() throws java.rmi.RemoteException;
	public void getIndex(int i) throws java.rmi.RemoteException;
	public String sendResult() throws java.rmi.RemoteException; 
}