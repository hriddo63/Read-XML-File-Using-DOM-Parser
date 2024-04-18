package readXML;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class parseXML {

	public static void main(String[] args) throws SAXException, IOException {
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			File xmlFile = new File("src/note.xml");
			Document docu = builder.parse(xmlFile);
			docu.getDocumentElement().normalize();
			
			System.out.println("Root element: " + docu.getDocumentElement().getNodeName());
			NodeList nList = docu.getElementsByTagName("employee");
			
			for(int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element aElement = (Element) node;
					
					System.out.println("Employee ID: " + aElement.getAttribute("id"));
                    System.out.println("First Name: " + aElement.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Last Name: " + aElement.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("Age: " + aElement.getElementsByTagName("age").item(0).getTextContent());
				}
			}
			
		} 
		
		
		catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
