/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package booking.management.application;


import booking.management.application.Controllers.BookingController;
import java.util.Scanner;
import booking.management.application.Models.Booking;
import booking.management.application.Models.Date;
import booking.management.application.Models.Session;
import booking.management.application.Models.Lesson;
import booking.management.application.Models.SessionCollection;
import booking.management.application.Models.TimeofDay;
import java.io.InputStreamReader;
import java.util.HashMap;
import booking.management.application.Models.Timetable;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.IOException;
import booking.management.application.Models.Student;
import booking.management.application.Views.BookingView;
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

/**
 *
 * @author user
 */
public class BookingManagementApplication {

    /**
     * @param args the command line arguments
     */
    
    public static class Helper {
        
        static Scanner scanner=new Scanner(new InputStreamReader(System.in));
       
        public static void print(String text)
        {
            
            System.out.println(text);
        }
        
        public static String readLine()
        {
            //scanner=new Scanner(new InputStreamReader(System.in));
            return scanner.nextLine();
        }
        
        public static int readInt()
        {
            return scanner.nextInt();
        }
        public <T> ArrayList<T> printNode(NodeList nList)
        {
            ArrayList<T> TCollection=new ArrayList();
            String id="";
            int lId=0;
            int sId=0;
            for(int i=0;i<nList.getLength();i++)
            {
                 Node node=nList.item(i);

                 String nodeName=node.getNodeName();

                 // add node

                 if(node.hasChildNodes())
                 {
                    if(node.getChildNodes().getLength()==1)
                    {

                    }
                    printNode(node.getChildNodes());
                 }
            }
           return TCollection;

        }
    }
    static int lessonCount=0;
    static String bookingId="";
    static Scanner scanner = new Scanner(new InputStreamReader(System.in));
    static Timetable timetable=new Timetable();
    static int number=0;
    static int lessonId=0;
    static String stringScanner;
    static ArrayList<Booking> bookingCollection=new ArrayList<Booking>();
    private static final Lesson lesson1=new Lesson(1,"football",12.3);
    private static Lesson lesson2=new Lesson(2,"tennis",2.3);
    private static Lesson lesson3=new Lesson(3,"volleyball",2.3);
    private static Lesson lesson4=new Lesson(4,"chess",2.3);
    private static Lesson lesson5=new Lesson(5,"volleyball",2.3);
    private static Lesson lesson6=new Lesson(6,"scrabble",2.3);
    private static Lesson lesson7=new Lesson(7,"whot",2.3);
    private static Lesson lesson8=new Lesson(8,"football",64.3);
    private static Lesson lesson9=new Lesson(9,"draft",2.3);
    private static Lesson lesson10=new Lesson(10,"running",2.3);
    private static Lesson lesson11=new Lesson(11,"football",2.3);
    private static Lesson lesson12=new Lesson(12,"football",32.3);
   
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
    
    // second saturday

    static Session tf=new Session(7,1);
    static Session ts=new Session(8,2);
    static Session tt=new Session(9,3);
    
    // second saturday

    static Session fof=new Session(10,1);
    static Session fos=new Session(11,2);
    static Session fot=new Session(12,3);
    
    
     
    static ArrayList<Session> s1=new ArrayList<Session>();
    static ArrayList<Session> s2=new ArrayList<Session>();
    static ArrayList<Session> s3=new ArrayList<Session>();
    static ArrayList<Session> s4=new ArrayList<Session>();
    
    
    
    static Date d1=new Date(1,26,3,2022,1);
    
    static Date d2=new Date(2,27,3,2022,2);
    static Date d3=new Date(3,2,4,2022,1);
    static Date d4=new Date(4,3,4,2022,2);
    
   public static HashMap<Integer,Date> attendance=new HashMap<Integer,Date>();
   public static HashMap<Integer,Lesson> Lessons=new HashMap<Integer,Lesson>();
   public static SessionCollection sessionCollection=null;
   static int studentId=0;
    
    
    
     
    
    public static void loadDummyDate()
    {
//        Lesson[] lessons=new Lesson[]{lesson1,lesson2,lesson3,lesson4,
//                                      lesson5,lesson6,lesson7,lesson8,
//                                      lesson9,lesson10,lesson11,lesson12};
        
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
        Lessons.put(7, lesson7);
        Lessons.put(8, lesson8);
        Lessons.put(9, lesson9);
        Lessons.put(10, lesson10);
        Lessons.put(11, lesson11);
        Lessons.put(12, lesson12);
        
        ff.AddLesson(lesson1);
        fs.AddLesson(lesson2);
        ft.AddLesson(lesson3);
        
        sf.AddLesson(lesson4);
        ss.AddLesson(lesson5);
        st.AddLesson(lesson6);
        
        tf.AddLesson(lesson7);
        ts.AddLesson(lesson8);
        tt.AddLesson(lesson9);
        
        fof.AddLesson(lesson10);
        fos.AddLesson(lesson11);
        fot.AddLesson(lesson12);
        
        s1.add(ff);
        s1.add(fs);
        s1.add(ft);
        
        s2.add(sf);
        s2.add(ss);
        s2.add(st);
        
        s3.add(tf);
        s3.add(ts);
        s3.add(tt);
        
        s4.add(fof);
        s4.add(fos);
        s4.add(fot);
        
        d1.AddSessions(s1);
        d2.AddSessions(s2);
        d3.AddSessions(s3);
        d4.AddSessions(s4);
        
        Session[] sessions=new Session[]{ff,fs,ft,sf,ss,st,tf,ts,tt,fof,fos,fot};
        
        sessionCollection=new SessionCollection(new ArrayList<>(Arrays.asList(sessions)));
        
        
    }
    
    
    public static void main(String[] args) throws IOException  {
        // TODO code application logic here
        loadDummyDate();
        
        Booking bModel=new Booking();
        BookingView bView=new BookingView();
        BookingController bookingController=new BookingController(bModel,bView);
        bookingController.CreateNewBooking(attendance, timetable);
        Helper.print("Log in as ");
        
        for(int i=0;i<students.length;i++)
        {
            Helper.print(Integer.toString(i+1)+ "for "+ students[i].getName());
        }
       // String x=Helper.readLine();
        studentId=Helper.readInt();
        //System.out.println("Logged in as
        
        System.out.println("For booking, enter 1. Enter 2 for records ");
        
        
       // System.out.println("User Input from console: " + input);
        //System.out.println("Reading int from console in Java: ");
        
        // System.out.println("Integer input: " + number);
        
       
       number = scanner.nextInt(); 
       if(number==1)
       {
           // booking starts here
           System.out.println("To create a booking, press 1. Press 2 to change a booking ");
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
                        
         
                        System.out.println("To book "+Sessions.get(i).getPeriod()+ "session for " + lesson.ReturnLesson()+", click "+ Integer.toString(i)+" and press enter" );
                       
                        
                    }
                    
                        number=scanner.nextInt();
                        Booking booking=new Booking();
                        
                        switch(number)
                        {
                            case 0: lessonId=lessons[0].getLessonID();
                            break; 
                            case 1:lessonId=lessons[1].getLessonID(); 
                            break;
                            case 2:lessonId=lessons[2].getLessonID(); 
                            break;
                        }
                        createBooking(lessonId,studentId);
                }
                else
                {
                   System.out.println("Enter exercise name, then click enter ");
                   scanner.nextLine();
                   ArrayList<Session> filteredSessions=new ArrayList();
                   
                   
                   do
                   {
                       
                       stringScanner=scanner.nextLine();
                       filteredSessions=sessionCollection.getSessions(stringScanner);
                       if(filteredSessions.size()<1)
                           System.out.println("Exercise not found. Please, try again");
                    
                   }while(filteredSessions.size()<1);
                   
                    Lesson[] lessons=new Lesson[20];
                    for(int i=1;i<=attendance.size();i++)
                    {
                        try
                        {
                            for(int j=0;j<attendance.get(i).getSession().size();j++)
                            {
                                for(Session session:filteredSessions)
                                {
                                    Session tSession=attendance.get(i).getSession().get(j);
                                    if(tSession.equals(session))
                                    {
                                          Lesson lesson=tSession.getLesson();
//                                        lessons[j]=lesson;
//                                        lesson.studentBooked();
//                                        lessonCount=lesson.studentCount();

                                       
                                        System.out.println("To book "+attendance.get(i).ReturnDate() +" " +filteredSessions.get(j).getPeriod()+ "session for " + lesson.ReturnLesson()+", click "+ lesson.getLessonID()+" and press enter" );
                                        
                                        
                                        
                                    }
                                }
                            }
                        }
                        
                        catch(Exception ex)
                        {
                            
                        }


                    }
                    number=scanner.nextInt();
                    lessonId=number;
                    createBooking(lessonId,studentId);
                    
                    //for(Session session:Sessions)
//                    for(int i=0;i<filteredSessions.size();i++)
//                    {
//                        Lesson lesson=filteredSessions.get(i).getLesson();
//                        lessons[i]=lesson;
//                        lesson.studentBooked();
//                        lessonCount=lesson.studentCount();
//                        
//         
//                        System.out.println("To book "+filteredSessions.get(i).getPeriod()+ "session for " + lesson.ReturnLesson()+", click "+ Integer.toString(i)+" and press enter" );
//                       
//                        
//                    }
                    
                   
                   
                }
            }
            else if(number==2)
            {   
                scanner.nextLine();
                Booking booking=null;
                do{
                    System.out.println("Enter your booking Id");
                    stringScanner=scanner.nextLine();

                    try
                    {
                        DocumentBuilderFactory fact=DocumentBuilderFactory.newInstance();
                        DocumentBuilder builder=fact.newDocumentBuilder();
                        Document document=builder.parse(new File("C:/Users/user/Java Projects/Booking Management Application/src/booking/management/application/Models/XMLData.xml"));


                        NodeList list=document.getChildNodes();
                        ArrayList<Booking> collections=printNode(list);
                        
                        for(int i=0;i<collections.size();i++)
                        {
                            booking=collections.get(i);
                            bookingId=trimId(booking.getBookingId());
                            if(!trimId(booking.getBookingId()).equals(stringScanner))
                            {
                               booking=null;
                              
                            }
                            
                        }

                    }
//                   
                    catch(Exception ex)
                    {

                    }
                    if(booking==null)System.out.println("Booking Id not found. Please, try again");
                    else break;
                }
                while(booking==null);
                    
                BookByDay();
               // System.out.println("we outside");
                
       
//                if(trimId(UUID.fromString("166cc2a3-e705-46dc-ac70-62931f5e663a")).equalsIgnoreCase(stringScanner))
//                {
//                   System.out.println("166cc2a3-e705-46dc-ac70-62931f5e663a"); 
//                }
            }

       }
       
       
       
    }
    
    public static String trimId(UUID id)
    {
       String stringId=id.toString();
       bookingId=stringId.substring(24);
       return bookingId;
    }
    
    public static void BookByDay()
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
                        
         
            System.out.println("To book "+Sessions.get(i).getPeriod()+ "session for " + lesson.ReturnLesson()+", click "+ Integer.toString(i)+" and press enter" );
                       
                        
        }
                    
        number=scanner.nextInt();
        Booking booking=new Booking();
                        
        switch(number)
        {
            case 0: lessonId=lessons[0].getLessonID();
            break; 
            case 1:lessonId=lessons[1].getLessonID(); 
            break;
            case 2:lessonId=lessons[2].getLessonID(); 
            break;
        }
        createBooking(lessonId,studentId);
    }
    
    public static String saveBooking(int lId,int sId)
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
    
    public static void createBooking(int lessonId,int studentId)
    {
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
    }
    
    public static ArrayList<Booking> printNode(NodeList nList)
    {
        
        String ID="";
        int LessonID=0;
        int StudentID=0;
        for(int i=0;i<nList.getLength();i++)
        {
             Node node=nList.item(i);
             
             String nodeName=node.getNodeName();
   
             // add node
 //            node.insertBefore(node.getLastChild(), node.appendChild(node))
             if(node.hasChildNodes())
             {
                  // System.out.println("\n"+ nodeName);
//                 if(node.hasAttributes())
//                 {
//                     System.out.println("\n"+ node.getAttributes().item(0));
//                 }
                 if(node.getChildNodes().getLength()==1)
                 {
                     //System.out.println("\n"+ node.setUserData("1", s1, arg2));
                    // System.out.println("\n"+ node.getTextContent());
                     
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
    
}
