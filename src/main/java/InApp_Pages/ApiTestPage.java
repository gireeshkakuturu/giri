package InApp_Pages;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.codec.binary.Base64;


public class ApiTestPage 
{	
	public void sendPost(String body) throws Exception
	{
		String url = "https://mobile-events.eservice.emarsys.net/v3/devices/40666337/events";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		String userpassword = "EMS35-14B3E:Interview2020!";
		Base64 encoder = new Base64();
		
		byte[] encodedAuthorizationBytes = encoder.encode( userpassword.getBytes() );
		String encodedAuthorization = new String(encodedAuthorizationBytes);
		//add request header
		con.setRequestMethod("POST");		
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Authorization", "Basic "+encodedAuthorization);	
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(body);
		wr.flush();
		wr.close();
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + body);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null)
		{
			response.append(inputLine);
			System.out.println(inputLine);
		}
		in.close();
		//print result
		System.out.println(response.toString());
	}
}
