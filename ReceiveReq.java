import java.net.*;
import java.io.*;
public class ReceiveReq {
	
	public static void main(String[] args) throws IOException {
		System.out.println(ReceiveReq.receiveReq(""));
	}
	public static String receiveReq(String get) throws IOException {
		String s = "";
		
		URL url = new URL("http://localhost:8081/" + get);
		BufferedReader in = new BufferedReader(
			        new InputStreamReader(url.openStream()));

        s += in.readLine();
        in.close();
        
        return s;
	}
}
