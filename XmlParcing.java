import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class XmlParcing 
		{
		    public static void main(String[] args) 
		    {


		    	File xmlFile = new File("/home/sanjay/xmlfileparcing/xmlparce.xml");

		       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

		        DocumentBuilder dBuilder;

		        try {

		       	dBuilder = dbFactory.newDocumentBuilder();


		        Document doc=dBuilder.parse(xmlFile);
		        System.out.print("Root Elemen"+doc.getDocumentElement().getNodeName());

		          NodeList nodeList = doc.getElementsByTagName("user");  


		          for (int itr = 0; itr < nodeList.getLength(); itr++)   

		          { 	  
		        	  Node node = nodeList.item(itr);

		              String str=node.getTextContent();
		          	  System.out.println("\nNode Name :" + node.getNodeName());


		        	 if (node.getNodeType() == Node.ELEMENT_NODE)   

		        	  {  
		        		 Element eElement = (Element) node;  

		        		  System.out.println(" yourid is "+ eElement.getAttribute("idno"));  

		            System.out.println("First Name: "+ eElement.getElementsByTagName("firstname").item(0).getTextContent());
		            System.out.println("Last Name: "+ eElement.getElementsByTagName("lastname").item(0).getTextContent());  
		            System.out.println("city: "+ eElement.getElementsByTagName("city").item(0).getTextContent());  


		           	   }   	  
		        	  }
		        }
		            catch (Exception e)   
		            {  
		            e.printStackTrace();  
		            }

	}}




