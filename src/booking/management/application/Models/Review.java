/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
package booking.management.application.Models;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Review {
    
    //private int ID;
    private UUID BookingId;
    private String Message;
    private int Rating;
    private ArrayList<Review> reviewCollection;
    
    public Review(UUID bookingID,String message,int rating)
    {
        this.BookingId=bookingID;
        this.Message=message;
        this.Rating=rating;
    }
    
    public void saveReview(Review review)
    {
        try
        {
            DocumentBuilderFactory fact=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=fact.newDocumentBuilder();
            Document document=builder.parse(new File("C:/Users/user/Java Projects/Booking Management Application/src/booking/management/application/Models/XMLData.xml"));
        
            
//            NodeList list=document.getElementsByTagName("Review");
//            
//            // convert back to java object
//            ArrayList<Review> collections=printNode(list);
//            
            
           
            
            
            // create another node 

            Element root=document.getDocumentElement();

            Element newReview=document.createElement("Review");

            Element BookingID=document.createElement("BookingID");
            BookingID.appendChild(document.createTextNode(this.BookingId.toString()));
            newReview.appendChild(BookingID);

            Element Message=document.createElement("Message");
            Message.appendChild(document.createTextNode(this.Message.toString()));
            newReview.appendChild(Message);

            Element Rating=document.createElement("Rating");
            Rating.appendChild(document.createTextNode(Integer.toString(this.Rating)));
            newReview.appendChild(Rating);

            

            root.appendChild(newReview);
                
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source=new DOMSource(document);
                    
            StreamResult result = new StreamResult("C:\\Users\\user\\Java Projects\\Booking Management Application\\src\\booking\\management\\application\\Models\\XMLData.xml");
            
            transformer.transform(source, result);       
                    
        }
        catch(Exception ex)
        {
            
        }
    }
// nodeNames must match the nodenames in xml
    public ArrayList printNode(NodeList nList)
    {
        
        UUID ID;
        String Message="";
        int Rating=-1;
        for(int i=0;i<nList.getLength();i++)
        {
             Node node=nList.item(i);
             
             String nodeName=node.getNodeName();
   
             // add node
 
             if(node.hasChildNodes())
             {
//                if(node.getChildNodes().getLength()==1)
//                {
//                    
                    if("BookingID".equals(nodeName))
                     {
                         ID=UUID.fromString(node.getTextContent());
                        
                     }
                     else if("Rating".equals(nodeName))
                     {
                         Rating=Integer.parseInt(node.getTextContent());
                         
                     }
                     else if("Message".equals(nodeName))
                     {
                         Message=node.getTextContent();
                        
                         reviewCollection.add(new Review( this.BookingId, this.Message, this.Rating));
                         
                     }
               // }
                printNode(node.getChildNodes());
             }
        }
       return reviewCollection;
    
    }
    
    
}
