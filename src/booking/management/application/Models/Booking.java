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
public class Booking {
    
    private UUID UUIDID;
    private int LessonID;
    private int StudentID;
    private Boolean Status;
    private int lessonCount=0;
    private SessionCollection Sessions;
    ArrayList<Booking> bookingCollection=new ArrayList();
    String bookingId;
    public Booking()
    {
    }
    public Booking(UUID id,int lId,int sId)
    {
        this.UUIDID=id;
        this.LessonID=lId;
        this.StudentID=sId;
        this.Status=false;
        this.Sessions=new SessionCollection(new ArrayList<Session>());
        
        
    }
    
    public String CreateBookingId(int lessonId,int studentId)
    {
        UUIDID=UUID.randomUUID();
        LessonID=lessonId;
        StudentID=studentId;
                
        return UUIDID.toString();
    }
    
    private Boolean ChangeBooking()
    {
        
        
        return true;
    }
    
    public String getBooking()
    {
        return this.UUIDID+" "+this.StudentID+" "+this.LessonID;
    }
    
    public int getLessonId()
    {
        return this.LessonID;
    }
    public int getStudentId()
    {
        return this.StudentID;
    }
    
    public UUID getBookingId()
    {
        return this.UUIDID;
    }
    
    // nodeNames must match the nodenames in xml
    public ArrayList printNode(NodeList nList)
    {
        
        String ID="";
        int LessonID=0;
        int StudentID=0;
        for(int i=0;i<nList.getLength();i++)
        {
             Node node=nList.item(i);
             
             String nodeName=node.getNodeName();
   
             // add node
 
             if(node.hasChildNodes())
             {
                if(node.getChildNodes().getLength()==1)
                {
                    
                    if("ID".equals(nodeName))
                     {
                         ID=node.getTextContent();
                        
                     }
                     else if("LessonID".equals(nodeName))
                     {
                         LessonID=Integer.parseInt(node.getTextContent());
                         
                     }
                     else if("StudentID".equals(nodeName))
                     {
                         StudentID=Integer.parseInt(node.getTextContent());
                        
                         bookingCollection.add(new Booking(UUID.fromString(ID), LessonID, StudentID));
                         
                     }
                }
                printNode(node.getChildNodes());
             }
        }
       return bookingCollection;
    
    }
    public Booking saveBooking(String stringScanner)
    {
        
        Booking booking=null;
        
        try
        {
            DocumentBuilderFactory fact=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=fact.newDocumentBuilder();
            Document document=builder.parse(new File("C:/Users/user/Java Projects/Booking Management Application/src/booking/management/application/Models/XMLData.xml"));
        
            
            NodeList list=document.getChildNodes();
            ArrayList<Booking> collections=printNode(list);
            booking=iterateForChangingBooking(collections,stringScanner);
       
            
        }
        catch(Exception ex)
        {
            
        }
        return booking;
    }
    public String saveBooking(int lId,int sId)
    {
        Booking book=new Booking();
        String bookingId=book.CreateBookingId(lId, sId);
        UUID id=UUID.fromString(bookingId);
        try
        {
            DocumentBuilderFactory fact=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=fact.newDocumentBuilder();
            Document document=builder.parse(new File("C:/Users/user/Java Projects/Booking Management Application/src/booking/management/application/Models/XMLData.xml"));
        
            
            NodeList list=document.getChildNodes();
            
            // convert back to java object
            ArrayList<Booking> collections=printNode(list);
            
            String bookingStatus=iterateForFirstTimeBooking(collections,lId,sId);
                
            if(bookingStatus.equals("already booked"))
            {
                return "already booked";
            }
            else if(bookingStatus.equals("fully booked"))
            {
                return "fully booked";
            }
            
           
            
            
            // create another node 

            Element root=document.getDocumentElement();

            Element newBooking=document.createElement("Booking");

            Element ID=document.createElement("ID");
            ID.appendChild(document.createTextNode(id.toString()));
            newBooking.appendChild(ID);

            Element LessonID=document.createElement("LessonID");
            LessonID.appendChild(document.createTextNode(Integer.toString(lId)));
            newBooking.appendChild(LessonID);

            Element StudentID=document.createElement("StudentID");
            StudentID.appendChild(document.createTextNode(Integer.toString(sId)));
            newBooking.appendChild(StudentID);

            Element Status=document.createElement("Status");
            Status.appendChild(document.createTextNode("false"));
            newBooking.appendChild(Status);

            root.appendChild(newBooking);
                
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source=new DOMSource(document);
                    
            StreamResult result = new StreamResult("C:\\Users\\user\\Java Projects\\Booking Management Application\\src\\booking\\management\\application\\Models\\XMLData.xml");
            
            transformer.transform(source, result);       
                    
        }
        catch(Exception ex)
        {
            
        }
        return bookingId;
    }
    
    public void createBooking(int lessonId,int studentId)
    {
        String bookingId=saveBooking(lessonId,studentId); 
                        
        switch (bookingId) {
            case "already booked":
                System.out.println("You are already booked for this lesson");
                break;
            case "fully booked":
                System.out.println("This lesson is fully booked");
                break;
            default:
                System.out.println("Booking successful."+ "\n" +" Booking Id is: "+bookingId);
                break;
        }
    }
    public String iterateForFirstTimeBooking(ArrayList<Booking> collections,int lessonId,int studentId)
    {
        for(int i=0;i<collections.size();i++)
        {
            Booking booking=collections.get(i);

            if(booking.getStudentId()==studentId && booking.getLessonId()==lessonId)
            {
                return "already booked";
            }
            if(booking.getLessonId()==lessonId)
            {
                lessonCount++;
            }
        }

        if(lessonCount>=4)
        {
            return "fully booked";
        }
        return "";  
    }
    
    public Booking iterateForChangingBooking(ArrayList<Booking> collections,String stringScanner)
    {
        Booking booking=null;
        for(int i=0;i<collections.size();i++)
        {
            booking=collections.get(i);
            bookingId=trimId(booking.getBookingId());
            if(!trimId(booking.getBookingId()).equals(stringScanner))
            {
               booking=null;

            }
            else
            {
                booking=collections.get(i);
                break;
            }
            
        }
        return booking;
    }
    public String trimId(UUID id)
    {
       String stringId=id.toString();
       bookingId=stringId.substring(24);
       return bookingId;
    }
    
}
