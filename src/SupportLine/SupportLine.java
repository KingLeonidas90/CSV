package SupportLine;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SupportLine {
public static void main(String[] args){
	Responder myresponder = new Responder();
	System.out.println("willkommen zum support system 4.0");
	String eingabe = " ";
	
	
	while (!eingabe.equals("bye")){
	//System.out.println(myresponder.generateResponse(null));
	System.out.println(myresponder.generateResponse(eingabe));
	eingabe = InputReader();
	}
	
}

public static String InputReader(){
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(isr);
	
	try {
		return br.readLine();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
}
