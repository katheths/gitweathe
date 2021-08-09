package apiget;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalTime;
import java.util.Scanner;

import org.json.JSONObject;
public class Parcingproject {
	
public static void main(String args[])
{
	try 
	{
     var url ="http://api.weatherapi.com/v1/current.json?key=e3ac81bc8fd84b7cb4461201210308&q="+getLocation()+"&aqi=no";
     var request=HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
     var client = HttpClient.newBuilder().build();
     var response=client.send(request, HttpResponse.BodyHandlers.ofString());
     var store=response.body();
      System.out.println(" Information regarding your request is----");
      JSONObject jsnobj=new JSONObject(store).getJSONObject("location");
      String s1=jsnobj.getString("name");
      String s2=jsnobj.getString("region");
      String s3=jsnobj.getString("country");
      Double s4=jsnobj.getDouble("lat");
      Double s5=jsnobj.getDouble("lon");
      String s6=jsnobj.getString("tz_id");
      String s7=jsnobj.getString("localtime");
     
      System.out.println("name  :  " + s1);
      System.out.println("region  :  " + s2);
      System.out.println("country  :  " + s3);
      System.out.println("lat  :  " + s4);
      System.out.println("lon  :  " + s5);
      System.out.println("tz_id  :  " + s6);
      System.out.println("localtime:  " + s7);
      System.out.println("current sitatuation in your city is following as--");
      JSONObject jsoncurrent=new JSONObject(store).getJSONObject("current");
      
      Double dcurrent=jsoncurrent.getDouble("last_updated_epoch");
   
      String scurrent=jsoncurrent.getString("last_updated");
      Double dcurrent1=jsoncurrent.getDouble("temp_c");
      Double dcurrent2=jsoncurrent.getDouble("temp_f");
      Double dcurrent3=jsoncurrent.getDouble("is_day");
      System.out.println("last_updated_epoch " + dcurrent);
      System.out.println("last_updated " + scurrent);
      System.out.println("temp_c" +dcurrent1);
      System.out.println("temp_f" + dcurrent2);
      System.out.println("is_day" + dcurrent3);
     
     
     JSONObject jsonconditon=jsoncurrent.getJSONObject("condition");
     String scondtion=jsonconditon.getString("text"); 
     String scondtion1=jsonconditon.getString("icon"); 
     Double scondtion2=jsonconditon.getDouble("code"); 
     
     System.out.println("text" + scondtion);
     System.out.println("icon" + scondtion1);
     System.out.println("code" + scondtion2);
     
     }
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

public static String getLocation() {
	String s;
    System.out.println("enter the location where you want to visit-----");
    
	Scanner in = new Scanner(System.in);  
    String name=in.next();
    
	return name;
}}