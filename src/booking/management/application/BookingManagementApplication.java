/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package booking.management.application;

import java.io.IOException;
import java.util.Scanner;
import booking.management.application.Forms.Home;
import booking.management.application.Models.Booking;
import booking.management.application.Models.BookingCollection;
import booking.management.application.Models.Date;
import booking.management.application.Models.Session;
import booking.management.application.Models.Lesson;
import booking.management.application.Models.TimeofDay;
import java.io.InputStreamReader;
import java.util.HashMap;
import booking.management.application.Models.Timetable;
import com.google.gson.Gson;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import org.json.simple.JSONArray;
import booking.management.application.Models.Student;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileReader;
import java.util.Collection;
import java.util.UUID;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author user
 */
public class BookingManagementApplication {

    /**
     * @param args the command line arguments
     */
    
    static int lessonCount=0;
    static ArrayList<Booking> bookingCollection=new ArrayList<Booking>();
    private static Lesson lesson1=new Lesson(1,"hgj",2.3);
    private static Lesson lesson2=new Lesson(12,"gjk",2.3);
    private static Lesson lesson3=new Lesson(3,"kgu",2.3);
    private static Lesson lesson4=new Lesson(4,"",2.3);
    private static Lesson lesson5=new Lesson(5,"",2.3);
    private static Lesson lesson6=new Lesson(6,"",2.3);
    private static Lesson lesson7=new Lesson(7,"",2.3);
    private static Lesson lesson8=new Lesson(8,"",2.3);
    private static Lesson lesson9=new Lesson(9,"",2.3);
    private static Lesson lesson10=new Lesson(10,"",2.3);
    private static Lesson lesson11=new Lesson(11,"",2.3);
    private static Lesson lesson12=new Lesson(12,"",2.3);
   
    TimeofDay morning=new TimeofDay(1,"morning");
    TimeofDay afternoon=new TimeofDay(2,"afternoon");
    TimeofDay evening=new TimeofDay(3,"evening");
    
    static Student[] students=null;
    
    // First Saturday

    static Session ff=new Session(1,1);
    static Session fs=new Session(2,2);
     static Session ft=new Session(3,3);
    
    // First Sunday

    static Session sf=new Session(4,1);
    static Session ss=new Session(5,2);
    static Session st=new Session(6,3);
    
    
     
    static ArrayList<Session> s1=new ArrayList<Session>();
    static ArrayList<Session> s2=new ArrayList<Session>();
    static ArrayList<Session> s3=new ArrayList<Session>();
    static ArrayList<Session> s4=new ArrayList<Session>();
    
    
    
    static Date d1=new Date(1,26,3,2022,1);
    
    static Date d2=new Date(2,27,3,2022,2);
    static Date d3=new Date(3,2,4,2022,1);
    static Date d4=new Date(4,2,4,2022,2);
    
   public static HashMap<Integer,Date> attendance=new HashMap<Integer,Date>();
   public static HashMap<Integer,Lesson> Lessons=new HashMap<Integer,Lesson>();
     
   static int studentId=0;
    
    
    
     
    
    public static void loadDummyDate()
    {
        Student firstStudent=new Student();
        firstStudent.setName(1, "Toheeb", "Kolawole");
        Student secondStudent=new Student();
        secondStudent.setName(2, "Yusuf", "Oladapo");
        Student thirdStudent=new Student();
        thirdStudent.setName(3, "Yusuf", "Ahmed");
        Student fourthStudent=new Student();
        fourthStudent.setName(4, "Taofeek", "Olorunishola");
        
        students=new Student[]{firstStudent,secondStudent,thirdStudent,fourthStudent};
        
        attendance.put(1,d1);
        attendance.put(2,d2);
        attendance.put(3,d3);
        attendance.put(4,d4);
//        attendance.put(4,d5);
//        attendance.put(4,d6);
        Lessons.put(1, lesson1);
        Lessons.put(2, lesson2);
        Lessons.put(3, lesson3);
        Lessons.put(4, lesson4);
        Lessons.put(5, lesson5);
        Lessons.put(6, lesson6);
        
        ff.AddLesson(lesson1);
        fs.AddLesson(lesson2);
        ft.AddLesson(lesson3);
        
        sf.AddLesson(lesson4);
        ss.AddLesson(lesson5);
        st.AddLesson(lesson6);
        
        s1.add(ff);
        s1.add(fs);
        s1.add(ft);
        
        s2.add(sf);
        s2.add(ss);
        s2.add(st);
        
        d1.AddSessions(s1);
        d2.AddSessions(s2);
        
        
    }
    
    
    public static void main(String[] args) throws IOException  {
        // TODO code application logic here
        loadDummyDate();
        
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("Log in as ");
        
        for(int i=0;i<students.length;i++)
        {
           System.out.println(Integer.toString(i+1)+ "for "+ students[i].getName());
        }
        
        studentId=scanner.nextInt();
        //System.out.println("Logged in as
        
        System.out.println("For booking, enter 1. Enter 2 for records ");
        
        
       // System.out.println("User Input from console: " + input);
        //System.out.println("Reading int from console in Java: ");
        
        // System.out.println("Integer input: " + number);
        
       Timetable timetable=new Timetable();
       int number = scanner.nextInt();
       if(number==1)
       {
           System.out.println("To create a booking, press 1. Press 2 to ");
           number = scanner.nextInt();
            
            if(number==1)
            {
                System.out.println("To check timetable by day, enter 1. Enter 2 to check by exercise name ");
                number = scanner.nextInt();
                if(number==1)
                {
                    System.out.println(timetable.getTimetable(attendance));
                    System.out.println("Select Lesson by day ");
                    number=0;
                    number=scanner.nextInt();
                    Date day=timetable.getADay(number, attendance);

                    // get sessions

                    System.out.println(day.getDay());
                    ArrayList<Session> Sessions=day.getSession();
                    Lesson[] lessons=new Lesson[3];
                    //for(Session session:Sessions)
                    for(int i=0;i<Sessions.size();i++)
                    {
                        Lesson lesson=Sessions.get(i).getLesson();
                        lessons[i]=lesson;
                        lesson.studentBooked();
                        lessonCount=lesson.studentCount();
                        
            // working
//                         JSONObject s=new JSONObject();
//                         s.put("name", "toheeb");
//                         s.put("lessonid", 1);
//                         s.put("studentid", 2);
//                         s.put("status", false);
//                         
//                         JSONArray lessonArray=new JSONArray();
//                         lessonArray.add(new Lesson(1,"les1",2.3));
//                         lessonArray.add(new Lesson(2,"les2",2.6));
//                         lessonArray.add(new Lesson(3,"les3",2.4));
//                         
//                         s.put("lessons",lessonArray);
//                         Gson g=new Gson();
//                         String d=g.toJson(s);
//                         
////                         Booking b=new Booking(1,3);
////                         String booking=g.toJson(b);
//                        // b.CreateBooking(1,1);
//                        try {
//
//                            // Writing to a file
//                            Path path=Path.of("C:\\Users\\user\\Java Projects\\Booking Management Application\\src\\booking\\management\\application\\Models\\data.json");
//                            String spath=path.toString();
//                            File file=new File(spath);
//                            file.createNewFile();
//                            FileWriter fileWriter = new FileWriter(file);
//                            System.out.println("Writing JSON object to file");
//                            System.out.println("-----------------------");
//                            System.out.print(d);
//
//                            fileWriter.write(d);
//                            fileWriter.flush();
//                            fileWriter.close();
//
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                        
                        // working
                        System.out.println("To book "+Sessions.get(i).getPeriod()+ "session for " + lesson.ReturnLesson()+", click "+ Integer.toString(i)+" and press enter" );
                       
                        
                    }
                    
                        number=scanner.nextInt();
                        Booking booking=new Booking();
                        int lessonId=0;
                        switch(number)
                        {
                            case 0: lessonId=lessons[0].getLessonID();
                            break; 
                            case 1:lessonId=lessons[1].getLessonID(); 
                            break;
                            case 2:lessonId=lessons[2].getLessonID(); 
                            break;
                        }
                        //json.put("bookings", studentArray);
                        //Booking booking=new Booking();
                        //booking.CreateBooking(lessonId,studentId);
                        String bookingId=saveBooking(lessonId,studentId); 
                        
                        if(bookingId.equals("already booked"))
                        {
                           System.out.println("You are already booked for this lesson");
                        
                        }
                        else if(bookingId.isEmpty())
                        {
                          System.out.println("This lesson is fully booked");
                       
                        }
                        else
                        {
                            System.out.println("Booking successful."+ "\n" +" Booking Id is: "+bookingId);
                       
                        }
                        
                     //   XStream xstream = new XStream();
//                        XStream xstream = new XStream(new StaxDriver());
//                        FileReader reader = new FileReader("C:\\Users\\user\\Java Projects\\Booking Management Application\\src\\booking\\management\\application\\Models\\XMLData.xml"); 
//                         Booking bookings = (Booking)xstream.fromXML(reader);
//                        System.out.print(bookings.getBooking());
                        

// write to xml


//                        String xml = xstream.toXML(booking);
//                        System.out.print(xml);
//                        
//                        Path path=Path.of("C:\\Users\\user\\Java Projects\\Booking Management Application\\src\\booking\\management\\application\\Models\\XMLData.xml");
//                            String spath=path.toString();
//                            File file=new File(spath);
//                            file.createNewFile();
//                            FileWriter fileWriter = new FileWriter(file,true);
//                            System.out.println("Writing JSON object to file");
//                            System.out.println("-----------------------");
//                            System.out.print(xml);
//                            
//                            fileWriter.write(xml);
//                            fileWriter.flush();
//                            fileWriter.close();


                        // read bookings from xml file
//                        DocumentBuilderFactory fact=DocumentBuilderFactory.newInstance();
//                        try
//                        {
//                            DocumentBuilder builder=fact.newDocumentBuilder();
//                            Document doc=builder.parse("C:\\Users\\user\\Java Projects\\Booking Management Application\\src\\booking\\management\\application\\Models\\XMLData.xml");
//                            NodeList list=doc.getChildNodes();
//                            ArrayList<Booking> collections=printNode(list);
//                            
//                            for(int i=0;i<collections.size();i++)
//                            {
//                                System.out.println(collections.get(i).getBooking());
//                            }
//                        }
//                        catch(Exception ex)
//                        {
//                            
//                        }
                        
                        
                        // read bookings from xml file
//                        String xml = xstream.toXML(booking);
//                        System.out.print(xml);
//                        
//                        Path path=Path.of("C:\\Users\\user\\Java Projects\\Booking Management Application\\src\\booking\\management\\application\\Models\\XMLData.xml");
//                            String spath=path.toString();
//                            File file=new File(spath);
//                            file.createNewFile();
//                            FileWriter fileWriter = new FileWriter(file,true);
//                            System.out.println("Writing JSON object to file");
//                            System.out.println("-----------------------");
//                            System.out.print(xml);
//                            
//                            fileWriter.write(xml);
//                            fileWriter.flush();
//                            fileWriter.close();
                            
//                          ArrayList<Booking> bookings=(ArrayList<Booking>)xstream.fromXML(xml);
//                          
//                                  for(int i=0;i<bookings.size();i++)
//                                  {
//                                    System.out.println(bookings.get(i));
//                                  }
//                        Scanner sc = new Scanner(new FileReader("\"C:\\\\Users\\\\user\\\\Java Projects\\\\Booking Management Application\\\\src\\\\booking\\\\management\\\\application\\\\Models\\\\data.json"))
//                         .useDelimiter("}");
//                        
//                         String str;
//       
//        // checking end of file
//        while (sc.hasNext()) {
//            str = sc.next();
//           
//            // adding each string to arraylist
//            listOfStrings.add(str);
//        }
//       
//        // convert any arraylist to array
//        String[] array
//            = listOfStrings.toArray(new String[0]);
//       
//        // print each string in array
//        for (String eachString : array) {
//            System.out.println(eachString);
//        }
//                        
//                        
//                        JSONObject json=new JSONObject();
//                        JSONArray studentArray=new JSONArray();
//                        
//                        Gson gson = new Gson();
//
//                        //Booking bookingObject = gson.fromJson(b, Booking.class);  
//                        
//                         
//                        json.put("bookings", studentArray);
//                        //json.put("bookings", booking);
//                        
//                        booking.CreateBooking(lessonId,studentId);
//                        studentArray.add(booking);
//                        Gson g=new Gson();
//                        String b=g.toJson(studentArray); 
//                        
//                       Path path=Path.of("C:\\Users\\user\\Java Projects\\Booking Management Application\\src\\booking\\management\\application\\Models\\data.json");
//                            String spath=path.toString();
//                            File file=new File(spath);
//                            file.createNewFile();
//                            FileWriter fileWriter = new FileWriter(file,true);
//                            System.out.println("Writing JSON object to file");
//                            System.out.println("-----------------------");
//                            System.out.print(b);
//                            
//                            fileWriter.write(b);
//                            //fileWriter.
//                            fileWriter.flush();
//                            fileWriter.close();
                            
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        //working
//                        JSONObject json=new JSONObject();
//                        JSONArray studentArray=new JSONArray();
//                        
//                        Gson gson = new Gson();
//
//                        //Booking bookingObject = gson.fromJson(b, Booking.class);  
//                        
//                         
//                        json.put("bookings", studentArray);
//                        //json.put("bookings", booking);
//                        
//                        booking.CreateBooking(lessonId,studentId);
//                        studentArray.add(booking);
//                        Gson g=new Gson();
//                        String b=g.toJson(studentArray); 
//                        
//                       Path path=Path.of("C:\\Users\\user\\Java Projects\\Booking Management Application\\src\\booking\\management\\application\\Models\\data.json");
//                            String spath=path.toString();
//                            File file=new File(spath);
//                            file.createNewFile();
//                            FileWriter fileWriter = new FileWriter(file,true);
//                            System.out.println("Writing JSON object to file");
//                            System.out.println("-----------------------");
//                            System.out.print(b);
//                            
//                            fileWriter.write(b);
//                            //fileWriter.
//                            fileWriter.flush();
//                            fileWriter.close();
                            
//working
                }
                else
                {
                    System.out.println(" by exercise name ");

                }
            }
            else if(number==2)
            {
                System.out.println("Integer inputs: " + number);
            }

       }
       
       
       
    }
    
    
    
    public static String saveBooking(int lId,int sId)
    {
        Booking book=new Booking();
        String bookingId=book.CreateBooking(lId, sId);
        UUID id=UUID.fromString(bookingId);
        try
        {
            DocumentBuilderFactory fact=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=fact.newDocumentBuilder();
            Document document=builder.parse(new File("C:/Users/user/Java Projects/Booking Management Application/src/booking/management/application/Models/XMLData.xml"));
        
            
            NodeList list=document.getChildNodes();
            ArrayList<Booking> collections=printNode(list);
                           
            for(int i=0;i<collections.size();i++)
            {
                Booking booking=collections.get(i);
                
                if(booking.getStudentId()==sId && booking.getLessonId()==lId)
                {
                    return "already booked";
                }
                if(booking.getLessonId()==lId)
                {
                    lessonCount++;
                }
                //System.out.println(collections.get(i).getBooking());
            }
            
            if(lessonCount>4)
            {
                return "";
            }
            
            
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
    
    
    public static ArrayList<Booking> printNode(NodeList nList)
    {
        
        String id="";
        int lId=0;
        int sId=0;
        for(int i=0;i<nList.getLength();i++)
        {
             Node node=nList.item(i);
             
             String nodeName=node.getNodeName();
   
             // add node
 //            node.insertBefore(node.getLastChild(), node.appendChild(node))
             if(node.hasChildNodes())
             {
                   System.out.println("\n"+ nodeName);
//                 if(node.hasAttributes())
//                 {
//                     System.out.println("\n"+ node.getAttributes().item(0));
//                 }
                 if(node.getChildNodes().getLength()==1)
                 {
                     //System.out.println("\n"+ node.setUserData("1", s1, arg2));
                     System.out.println("\n"+ node.getTextContent());
                     
                     if("ID".equals(nodeName))
                     {
                         id=node.getTextContent();
                        
                     }
                     else if("LessonID".equals(nodeName))
                     {
                         lId=Integer.parseInt(node.getTextContent());
                         
                     }
                     else if("StudentID".equals(nodeName))
                     {
                         sId=Integer.parseInt(node.getTextContent());
                        
                         bookingCollection.add(new Booking(UUID.fromString(id), lId, sId));
                         
                     }
                     
                 }
                 printNode(node.getChildNodes());
             }
        }
       return bookingCollection;
    }
    
}
