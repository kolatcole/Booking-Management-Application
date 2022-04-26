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
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class Booking {
    
    private UUID UUIDID;
    private int ExerciseID;
    private int StudentID;
    private Boolean Status;
    private int lessonCount=0;
    private LessonCollection Lessons;
    ArrayList<Booking> bookingCollection=new ArrayList();
    String bookingId;
    String ID="";
    int sid=-1;
    int lid=-1;
    
    public Booking()
    {
    }
    public Booking(UUID id,int lId,int sId)
    {
        this.UUIDID=id;
        this.ExerciseID=lId;
        this.StudentID=sId;
        this.Status=false;
        this.Lessons=new LessonCollection(new ArrayList<Lesson>());
        
        
    }
    
    public String CreateBookingId(int lessonId,int studentId)
    {
        UUIDID=UUID.randomUUID();
        ExerciseID=lessonId;
        StudentID=studentId;
                
        return UUIDID.toString();
    }
    
    private Boolean ChangeBooking()
    {
        
        
        return true;
    }
    
    public String getBooking()
    {
        return this.UUIDID+" "+this.StudentID+" "+this.ExerciseID;
    }
    
    public int getExerciseId()
    {
        return this.ExerciseID;
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
        //Node nodes=nList.item(1).getNextSibling();
        String ID="";
        int ExerciseID=0;
        int StudentID=0;
        for(int i=0;i<nList.getLength();i++)
        {
             Node node=nList.item(i);
             
             String nodeName=node.getNodeName();
   
             // add node
 // nodename==reviewnode 
             
             if(node.hasChildNodes())
             {
                if(node.getChildNodes().getLength()==1)
                {
                    
                    if("ID".equals(nodeName))
                     {
                         ID=node.getTextContent();
                        
                     }
                     else if("ExerciseID".equals(nodeName))
                     {
                         ExerciseID=Integer.parseInt(node.getTextContent());
                         
                     }
                     else if("StudentID".equals(nodeName))
                     {
                         StudentID=Integer.parseInt(node.getTextContent());
                        
                         bookingCollection.add(new Booking(UUID.fromString(ID), ExerciseID, StudentID));
                         
                     }
                }
                printNode(node.getChildNodes());
             }
             
             // see how the node gotten differs from review
        }
       return bookingCollection;
     
    }
    
    public String saveNewBooking(int eId,int sId)
    {
        int lessonCount=0;
        Booking book=new Booking();
        String bookingId=book.CreateBookingId(eId, sId);
        UUID id=UUID.fromString(bookingId);
        try
        {
            DocumentBuilderFactory fact=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=fact.newDocumentBuilder();
            Document document=builder.parse(new File("C:/Users/user/Java Projects/Booking Management Application/src/booking/management/application/Models/XMLData.xml"));
        
            NodeList bookingList=document.getElementsByTagName("Booking");
            for(int i=0;i<bookingList.getLength();i++)
            {
                Node childList=bookingList.item(i);
                NodeList bookingNodes=childList.getChildNodes();
                for(int j=0;j<bookingNodes.getLength();j++)
                {
                    Node exerciseNode=bookingNodes.item(3);
                    Node studentNode=bookingNodes.item(5);
                   // String statusNodeName=statusNode.getNodeName();
                    
                    
                   // String _nodeName=node.getNodeName();
   
                     
                   int d=Integer.parseInt(studentNode.getTextContent());
                  // String b=idNode.getTextContent();
                   int c=Integer.parseInt(exerciseNode.getTextContent());
                   try
                   {
                      
                       if(c==eId  && d==sId)
                       {
                         return "already booked";
                       } 
                       else if(c==eId)
                       {
                           lessonCount++;
                           break;
                           
                       }
                   }
                   catch(Exception ex)
                   {
                       
                   }
                    
                        
                    
                     
                }
             
            
             

            }
            if(lessonCount>=4)return "fully booked";
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            //NodeList list=document.getChildNodes();
            
//            NodeList list=document.getElementsByTagName("Booking");
//            
//            // convert back to java object
//
//            ArrayList<Booking> collections=printNode(list);
//            
//            String bookingStat=iterateForFirstTimeBooking(collections,lId,sId);
//                
//            if(bookingStat.equals("already booked"))
//            {
//                return "already booked";
//            }
//            else if(bookingStat.equals("fully booked"))
//            {
//                return "fully booked";
//            }
            
           
            
            
            // create another node 

            Element root=document.getDocumentElement();
            

            Element newBooking=document.createElement("Booking");

            Element ID=document.createElement("ID");
            ID.appendChild(document.createTextNode(id.toString()));
            newBooking.appendChild(ID);

            Element ExerciseID=document.createElement("ExerciseID");
            ExerciseID.appendChild(document.createTextNode(Integer.toString(eId)));
            newBooking.appendChild(ExerciseID);
            Element StudentID=document.createElement("StudentID");
            StudentID.appendChild(document.createTextNode(Integer.toString(sId)));
            newBooking.appendChild(StudentID);

            Element Status=document.createElement("Status");
          
            Status.appendChild(document.createTextNode("booked")); 
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
    Booking booking=null;
    public Node getBooking(String stringScanner,int studentId,String nodeValue)
    {
        Node node=null;
        
        
        try
        {
            DocumentBuilderFactory fact=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=fact.newDocumentBuilder();
            Document document=builder.parse(new File("C:/Users/user/Java Projects/Booking Management Application/src/booking/management/application/Models/XMLData.xml"));
        
              
          NodeList bookingList=document.getElementsByTagName("Booking");
          
            
            for(int i=0;i<bookingList.getLength();i++)
            {
                Node childList=bookingList.item(i);
                NodeList bookingNodes=childList.getChildNodes();
                for(int j=0;j<bookingNodes.getLength();j++)
                {
                    Node statusNode=bookingNodes.item(7);
                    Node studentNode=bookingNodes.item(5);
                   // String statusNodeName=statusNode.getNodeName();
                    
                    Node idNode=bookingNodes.item(1);
                    String _nodeName1=idNode.getNodeName();
                   // String _nodeName=node.getNodeName();
   
                     
                   int d=Integer.parseInt(studentNode.getTextContent());
                   String b=idNode.getTextContent();
                   String c=statusNode.getTextContent();
                   try
                   {
                      UUID a=UUID.fromString(b);
                      String x=trimId(a);
                        // if(nodeName.equalsIgnoreCase(_nodeName1)&&x.equalsIgnoreCase(stringScanner))
                    
                        if(x.equalsIgnoreCase(stringScanner) && c.equalsIgnoreCase(nodeValue) && d==studentId)
                        {
                           //node=bookingNodes.item(j);
                             node=bookingList.item(i);
                             
                            // bookingNodes.item(j).setTextContent("213");
//                           int p=-1;
//                           int q=-1;
//                            try
//                            {
//                                q=node2.getChildNodes().getLength();
//                                p=node.getChildNodes().getLength();
//                            }
//                            catch(Exception ex)
//                            {
//
//                            }
                            break;
                                   
                           
                           

                      } 
                   }
                   catch(Exception ex)
                   {
                       
                   }
                    
                        
                    
                     
                }
             
            
             

            }
           
           
           
           
           
           
           
           TransformerFactory transformerFactory = TransformerFactory.newInstance();
           Transformer transformer = transformerFactory.newTransformer();
           DOMSource source=new DOMSource(document);
                    
           StreamResult result = new StreamResult("C:\\Users\\user\\Java Projects\\Booking Management Application\\src\\booking\\management\\application\\Models\\XMLData.xml");
            
           transformer.transform(source, result); 
           
           
           
            
            
            
        }
        catch(Exception ex)
        {
            
        }
        return node;
    }
    
    
    
//    Booking booking=null;
//    public Booking getBooking(String stringScanner,int studentId,String nodeValue)
//    {
//        
//        
//        
//        try
//        {
//            DocumentBuilderFactory fact=DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder=fact.newDocumentBuilder();
//            Document document=builder.parse(new File("C:/Users/user/Java Projects/Booking Management Application/src/booking/management/application/Models/XMLData.xml"));
//        
//              
//          NodeList bookingList=document.getElementsByTagName("Booking");
//          
//            
//            for(int i=0;i<bookingList.getLength();i++)
//            {
//                Node childList=bookingList.item(i);
//                NodeList bookingNodes=childList.getChildNodes();
//                for(int j=0;j<bookingNodes.getLength();j++)
//                {
//                    Node statusNode=bookingNodes.item(7);
//                    Node studentNode=bookingNodes.item(5);
//                   // String statusNodeName=statusNode.getNodeName();
//                    Node node=bookingNodes.item(j);
//                    Node idNode=bookingNodes.item(1);
//                    String _nodeName1=idNode.getNodeName();
//                    String _nodeName=node.getNodeName();
//   
//                     
//                   int d=Integer.parseInt(studentNode.getTextContent());
//                   String b=idNode.getTextContent();
//                   String c=statusNode.getTextContent();
//                   try
//                   {
//                      UUID a=UUID.fromString(b);
//                      String x=trimId(a);
//                        // if(nodeName.equalsIgnoreCase(_nodeName1)&&x.equalsIgnoreCase(stringScanner))
//                    
//                        if(x.equalsIgnoreCase(stringScanner) && c.equalsIgnoreCase(nodeValue) && d==studentId)
//                        {
//                           
//
//                                   if("ID".equals(_nodeName))
//                                    {
//                                        ID=node.getTextContent();
//
//                                    }
//                                    else if("ExerciseID".equals(_nodeName))
//                                    {
//                                        lid=Integer.parseInt(node.getTextContent());
//
//                                    }
//                                    else if("StudentID".equals(_nodeName))
//                                    {
//                                        sid=Integer.parseInt(node.getTextContent());
//
//                                        booking=new Booking(UUID.fromString(ID), lid, sid);
//                                        break;
//                                    }
//                             //  }
//                               
//                           // }
//
//                           //statusNode.setTextContent(nodeValue); 
//                           
//
//                      } 
//                   }
//                   catch(Exception ex)
//                   {
//                       
//                   }
//                    
//                        
//                    
//                     
//                }
//             
//            
//             
//
//            }
//           
//           
//           
//           
//           
//           
//           
//           TransformerFactory transformerFactory = TransformerFactory.newInstance();
//           Transformer transformer = transformerFactory.newTransformer();
//           DOMSource source=new DOMSource(document);
//                    
//           StreamResult result = new StreamResult("C:\\Users\\user\\Java Projects\\Booking Management Application\\src\\booking\\management\\application\\Models\\XMLData.xml");
//            
//           transformer.transform(source, result); 
//           
//           
//           
//            
//            
//            
//        }
//        catch(Exception ex)
//        {
//            
//        }
//        return booking;
//    }
    
    
    // should be getBooking for changing booking status
//    public Booking getBooking(String stringScanner,String nodeName,String nodeValue)
//    {
//        
//        Booking booking=null;
//        
//        try
//        {
//            DocumentBuilderFactory fact=DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder=fact.newDocumentBuilder();
//            Document document=builder.parse(new File("C:/Users/user/Java Projects/Booking Management Application/src/booking/management/application/Models/XMLData.xml"));
//        
//              
//          NodeList bookingList=document.getElementsByTagName("Booking");
//          
//            
//            for(int i=0;i<bookingList.getLength();i++)
//            {
//                Node childList=bookingList.item(i);
//                NodeList bookingNodes=childList.getChildNodes();
//                for(int j=0;j<bookingNodes.getLength();j++)
//                {
//                    
//                    Node node=bookingNodes.item(j);
//                    Node statusNode=bookingNodes.item(7);
//                    String _nodeName1=statusNode.getNodeName();
//                    String _nodeName=node.getNodeName();
//   
//                     
//
//                   String b=node.getTextContent();
//                   try
//                   {
//                      UUID a=UUID.fromString(b);
//                      String x=trimId(a); 
//                      if(nodeName.equalsIgnoreCase(_nodeName1)&&x.equalsIgnoreCase(stringScanner))
//                      {
//                          
//                           statusNode.setTextContent(nodeValue); 
//                           
//
//                      } 
//                   }
//                   catch(Exception ex)
//                   {
//                       
//                   }
//                    
//                        
//                    
//                     
//                }
//             
//            
//             
//
//            }
//           
//           
//           
//           
//           
//           
//           
//           TransformerFactory transformerFactory = TransformerFactory.newInstance();
//           Transformer transformer = transformerFactory.newTransformer();
//           DOMSource source=new DOMSource(document);
//                    
//           StreamResult result = new StreamResult("C:\\Users\\user\\Java Projects\\Booking Management Application\\src\\booking\\management\\application\\Models\\XMLData.xml");
//            
//           transformer.transform(source, result); 
//           
//           
//           
//            
//            
//            
//        }
//        catch(Exception ex)
//        {
//            
//        }
//        return booking;
//    }
    
    //update booking
//    public String saveNewBooking(int lId,int sId)
//    {
//        Booking book=new Booking();
//        String bookingId=book.CreateBookingId(lId, sId);
//        UUID id=UUID.fromString(bookingId);
//        try
//        {
//            DocumentBuilderFactory fact=DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder=fact.newDocumentBuilder();
//            Document document=builder.parse(new File("C:/Users/user/Java Projects/Booking Management Application/src/booking/management/application/Models/XMLData.xml"));
//        
//            
//            //NodeList list=document.getChildNodes();
//            
//            NodeList list=document.getElementsByTagName("Booking");
//            
//            // convert back to java object
//
//            ArrayList<Booking> collections=printNode(list);
//            
//            String bookingStat=iterateForFirstTimeBooking(collections,lId,sId);
//                
//            if(bookingStat.equals("already booked"))
//            {
//                return "already booked";
//            }
//            else if(bookingStat.equals("fully booked"))
//            {
//                return "fully booked";
//            }
//            
//           
//            
//            
//            // create another node 
//
//            Element root=document.getDocumentElement();
//            
//
//            Element newBooking=document.createElement("Booking");
//
//            Element ID=document.createElement("ID");
//            ID.appendChild(document.createTextNode(id.toString()));
//            newBooking.appendChild(ID);
//
//            Element ExerciseID=document.createElement("ExerciseID");
//            ExerciseID.appendChild(document.createTextNode(Integer.toString(lId)));
//            newBooking.appendChild(ExerciseID);
//            Element StudentID=document.createElement("StudentID");
//            StudentID.appendChild(document.createTextNode(Integer.toString(sId)));
//            newBooking.appendChild(StudentID);
//
//            Element Status=document.createElement("Status");
//          
//            Status.appendChild(document.createTextNode("booked")); 
//            newBooking.appendChild(Status);
//
//            root.appendChild(newBooking);
//                
//            TransformerFactory transformerFactory = TransformerFactory.newInstance();
//            Transformer transformer = transformerFactory.newTransformer();
//            DOMSource source=new DOMSource(document);
//                    
//            StreamResult result = new StreamResult("C:\\Users\\user\\Java Projects\\Booking Management Application\\src\\booking\\management\\application\\Models\\XMLData.xml");
//            
//            transformer.transform(source, result);       
//                    
//        }
//        catch(Exception ex)
//        {
//            
//        }
//        return bookingId;
//    }
    
    public String UpdateBooking(String status,int lessonId,Node node,int studentId,String bookingId)
    {
        String bookingStatus="";
        
        try
        {
            DocumentBuilderFactory fact=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=fact.newDocumentBuilder();
            Document document=builder.parse(new File("C:/Users/user/Java Projects/Booking Management Application/src/booking/management/application/Models/XMLData.xml"));
            
            
            NodeList bookingList=document.getElementsByTagName("Booking");
            for(int i=0;i<bookingList.getLength();i++)
            {
                Node childList=bookingList.item(i);
                NodeList bookingNodes=childList.getChildNodes();
                Node _node;
                for(int j=0;j<bookingNodes.getLength();j++)
                {
//                    Node _idNode=childList.getChildNodes().item(j);
//                    String _id=trimId(UUID.fromString(_idNode.getTextContent()));
                        _node=bookingNodes.item(j);
                        String _nodeName=_node.getNodeName();
                        Node idNode=bookingNodes.item(1);
                        String id=trimId(UUID.fromString(idNode.getTextContent()));

                        Node exerciseNode=bookingNodes.item(3);
                        Node studentNode=bookingNodes.item(5);

                        int d=Integer.parseInt(studentNode.getTextContent());
                      // String b=idNode.getTextContent();
                       int c=Integer.parseInt(exerciseNode.getTextContent());
                       try
                       {

                           if(c==lessonId  && d==studentId)
                           {
                             return "already booked";
                           } 
                           else if(c==lessonId)
                           {
                               lessonCount++;
                               break;

                           }
                       }
                       catch(Exception ex)
                       {

                       }

                        if(lessonCount>=4)return "fully booked";
                         if("ExerciseID".equals(_nodeName) && id.equalsIgnoreCase(bookingId))
                        {

                               String exerciseId=_node.getTextContent();
                               XPath xPath = XPathFactory.newInstance().newXPath();
                               _node = (Node) xPath.compile("/Collection/Booking//ExerciseID[text()="+exerciseId+"] | StudentID[text()="+Integer.toString(studentId)+"]").evaluate(document, XPathConstants.NODE);

                               ///bookstore/book[price>35.00]
                               _node.setTextContent(Integer.toString(lessonId));


                           bookingStatus="changed";
                           break;

                        }
                }
//                else if("Status".equals(_nodeName) && (!"".equals(status)) )
//                {
//                    XPath xPath = XPathFactory.newInstance().newXPath();
//                    _node = (Node) xPath.compile("/Collection/Booking/Status").evaluate(document, XPathConstants.NODE);
//                    _node.setTextContent(status);
//                    updateStatus=true;
//                    break;
//                    
//                }
            
            }
            
             
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source=new DOMSource(document);
                    
            StreamResult result = new StreamResult("C:\\Users\\user\\Java Projects\\Booking Management Application\\src\\booking\\management\\application\\Models\\XMLData.xml");
            
            transformer.transform(source, result);     
                    
        }
        catch(Exception ex)
        {
            
        }
        return bookingStatus;
    }
    
    //public Boolean check
    public void createBooking(int lessonId,int studentId)
    {
        String bookingId=saveNewBooking(lessonId,studentId); 
                        
//        switch (bookingId) {
//            case "already booked":
//                System.out.println("You are already booked for this lesson");
//                break;
//            case "fully booked":
//                System.out.println("This lesson is fully booked");
//                break;
//            default:
//                System.out.println("Booking successful."+ "\n" +" Booking Id is: "+bookingId);
//                break;
//        }
    }
    public String iterateForFirstTimeBooking(ArrayList<Booking> collections,int lessonId,int studentId)
    {
        for(int i=0;i<collections.size();i++)
        {
            Booking booking=collections.get(i);

            if(booking.getStudentId()==studentId && booking.getExerciseId()==lessonId)
            {
                return "already booked";
            }
            if(booking.getExerciseId()==lessonId)
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
