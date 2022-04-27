/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package booking.management.application;


import booking.management.application.Controllers.BookingController;
import booking.management.application.Controllers.ReportController;
import booking.management.application.Controllers.ReviewController;
import java.util.Scanner;
import booking.management.application.Models.Booking;
import booking.management.application.Models.Date;
import booking.management.application.Models.Exercise;
import booking.management.application.Models.Lesson;
import booking.management.application.Models.Exercise;
import booking.management.application.Models.Review;
import booking.management.application.Models.LessonCollection;
import booking.management.application.Models.ReportCollection;
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
import booking.management.application.Views.ReportView;
import booking.management.application.Views.ReviewView;
import java.util.UUID;
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
       
        
        
    public static String Path()
    {
        String filePath = "src\\booking\\management\\application\\Models\\XMLData.xml";
//        File file = new File(filePath);
//        String path = file.getPath();
        return filePath;
    }

        
        
        public static void print(String text)
        {
            
            System.out.println(text);
        }
        
        public static String readLine()
        {
            //scanner=new Scanner(new InputStreamReader(System.in));
            return scanner.nextLine();
        }
        
    public static String trimId(UUID id)
    {
       String stringId=id.toString();
       bookingId=stringId.substring(24);
       return bookingId;
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
    private static final Exercise exercise1=new Exercise(1,"football",129.3);
    private static Exercise exercise2=new Exercise(2,"tennis",2.53);
    private static Exercise exercise3=new Exercise(3,"volleyball",1.23);
    private static Exercise exercise4=new Exercise(4,"chess",11.4);
    private static Exercise exercise5=new Exercise(5,"volleyball",5.0);
    private static Exercise exercise6=new Exercise(6,"scrabble",6.4);
    
//    private static Exercise exercise7=new Exercise(7,"whot",2.3);
//    private static Exercise exercise8=new Exercise(8,"football",64.3);
//    private static Exercise exercise9=new Exercise(9,"draft",2.3);
//    private static Exercise exercise10=new Exercise(10,"running",2.3);
//    private static Exercise exercise11=new Exercise(11,"football",2.3);
//    private static Exercise exercise12=new Exercise(12,"football",32.3);
   
    TimeofDay morning=new TimeofDay(1,"morning");
    TimeofDay afternoon=new TimeofDay(2,"afternoon");
    TimeofDay evening=new TimeofDay(3,"evening");
    
    static Student[] students=null;
    
    // First Saturday

    static Lesson ff=new Lesson(1,1);
    static Lesson fs=new Lesson(2,2);
     static Lesson ft=new Lesson(3,3);
    
    // First Sunday

    static Lesson sf=new Lesson(4,1);
    static Lesson ss=new Lesson(5,2);
    static Lesson st=new Lesson(6,3);
    
    // second saturday

    static Lesson tf=new Lesson(7,1);
    static Lesson ts=new Lesson(8,2);
    static Lesson tt=new Lesson(9,3);
    
    // second sunday

    static Lesson fof=new Lesson(10,1);
    static Lesson fos=new Lesson(11,2);
    static Lesson fot=new Lesson(12,3);
    
    
    // third Saturday

    static Lesson fif=new Lesson(13,1);
    static Lesson fis=new Lesson(14,2);
     static Lesson fit=new Lesson(15,3);
    
    // third Sunday

    static Lesson sif=new Lesson(16,1);
    static Lesson sis=new Lesson(17,2);
    static Lesson sit=new Lesson(18,3);
    
    // fourth saturday

    static Lesson sef=new Lesson(19,1);
    static Lesson ses=new Lesson(20,2);
    static Lesson set=new Lesson(21,3);
    
    // fourth sunday
        //eighth day
    static Lesson ef=new Lesson(22,1);
    static Lesson es=new Lesson(23,2);
    static Lesson et=new Lesson(24,3);
    
   // print record after 24 or > has been changed to attended
     // fifth Saturday
    //ninth day

    static Lesson nf=new Lesson(25,1);
    static Lesson ns=new Lesson(26,2);
     static Lesson nt=new Lesson(27,3);
    
    /// fifth sunday
    //tenth day

    static Lesson tef=new Lesson(28,1);
    static Lesson tes=new Lesson(29,2);
    static Lesson tet=new Lesson(30,3);
    
    // sixth Saturday
    //eleventh day

    static Lesson elf=new Lesson(31,1);
    static Lesson els=new Lesson(32,2);
    static Lesson elt=new Lesson(33,3);
    
    // sixth sunday
    //twelfth day

    static Lesson twf=new Lesson(34,1);
    static Lesson tws=new Lesson(35,2);
    static Lesson twt=new Lesson(36,3);
    
    
    // seventh Saturday
    //thirteenth day

    static Lesson thf=new Lesson(37,1);
    static Lesson ths=new Lesson(38,2);
     static Lesson tht=new Lesson(39,3);
    
    // seventh sunday
    //fourteen day

    static Lesson fouf=new Lesson(40,1);
    static Lesson fous=new Lesson(41,2);
    static Lesson fout=new Lesson(42,3);
    
    // eighth Saturday
    //fifteenth day

    static Lesson fitf=new Lesson(43,1);
    static Lesson fits=new Lesson(44,2);
    static Lesson fitt=new Lesson(45,3);
    
    // second saturday

    static Lesson sixf=new Lesson(46,1);
    static Lesson sixs=new Lesson(47,2);
    static Lesson sixt=new Lesson(48,3);
     
    static ArrayList<Lesson> s1=new ArrayList<Lesson>();
    static ArrayList<Lesson> s2=new ArrayList<Lesson>();
    static ArrayList<Lesson> s3=new ArrayList<Lesson>();
    static ArrayList<Lesson> s4=new ArrayList<Lesson>();
    
    static ArrayList<Lesson> s5=new ArrayList<Lesson>();
    static ArrayList<Lesson> s6=new ArrayList<Lesson>();
    static ArrayList<Lesson> s7=new ArrayList<Lesson>();
    static ArrayList<Lesson> s8=new ArrayList<Lesson>();
    
    static ArrayList<Lesson> s9=new ArrayList<Lesson>();
    static ArrayList<Lesson> s10=new ArrayList<Lesson>();
    static ArrayList<Lesson> s11=new ArrayList<Lesson>();
    static ArrayList<Lesson> s12=new ArrayList<Lesson>();
    
    static ArrayList<Lesson> s13=new ArrayList<Lesson>();
    static ArrayList<Lesson> s14=new ArrayList<Lesson>();
    static ArrayList<Lesson> s15=new ArrayList<Lesson>();
    static ArrayList<Lesson> s16=new ArrayList<Lesson>();
    
    
    
    static Date d1=new Date(1,26,3,2022,1);
    static Date d2=new Date(2,27,3,2022,2);
    static Date d3=new Date(3,2,4,2022,1);
    static Date d4=new Date(4,3,4,2022,2);
    static Date d5=new Date(5,9,4,2022,1);
    static Date d6=new Date(6,10,4,2022,2);
    static Date d7=new Date(7,16,4,2022,1);
    static Date d8=new Date(8,17,4,2022,2);
    static Date d9=new Date(9,23,4,2022,1);
    static Date d10=new Date(10,24,4,2022,2);
    static Date d11=new Date(11,30,4,2022,1);
    static Date d12=new Date(12,1,5,2022,2);
    static Date d13=new Date(13,7,5,2022,1);
    static Date d14=new Date(14,8,5,2022,2);
    static Date d15=new Date(15,14,5,2022,1);
    static Date d16=new Date(16,15,5,2022,2);
    
    
//    static Date d17=new Date(17,21,5,2022,1);
//    static Date d18=new Date(18,22,5,2022,2);
//    static Date d19=new Date(19,28,5,2022,1);
//    static Date d20=new Date(20,29,5,2022,2);
//    static Date d21=new Date(21,4,6,2022,1);
//    static Date d22=new Date(22,5,6,2022,2);
//    static Date d23=new Date(23,11,6,2022,1);
//    static Date d24=new Date(24,12,6,2022,2);
//    static Date d25=new Date(25,18,6,2022,1);
//    static Date d26=new Date(26,19,6,2022,2);
//    static Date d27=new Date(27,25,6,2022,1);
//    static Date d28=new Date(28,26,6,2022,2);
//    static Date d29=new Date(29,2,7,2022,1);
//    static Date d30=new Date(30,3,7,2022,2);
//    static Date d31=new Date(31,9,7,2022,1);
//    static Date d32=new Date(32,10,7,2022,2);
//    static Date d33=new Date(33,16,7,2022,1);
//    static Date d34=new Date(34,17,7,2022,2);
//    static Date d35=new Date(35,23,7,2022,1);
//    static Date d36=new Date(36,24,7,2022,2);
//    static Date d37=new Date(37,30,7,2022,1);
//    static Date d38=new Date(38,31,7,2022,2);
//    static Date d39=new Date(39,6,8,2022,1);
//    static Date d40=new Date(40,7,8,2022,2);
//    static Date d41=new Date(41,13,8,2022,1);
//    static Date d42=new Date(42,14,8,2022,2);
//    static Date d43=new Date(43,20,8,2022,1);
//    static Date d44=new Date(44,21,8,2022,2);
//    static Date d45=new Date(45,27,8,2022,1);
//    static Date d46=new Date(46,28,8,2022,2);
//    static Date d47=new Date(47,3,9,2022,1);
//    static Date d48=new Date(48,4,9,2022,2);
    
    
    
   public static HashMap<Integer,Date> attendance=new HashMap<Integer,Date>();
   public static HashMap<Integer,Exercise> Exercises=new HashMap<Integer,Exercise>();
   public static LessonCollection sessionCollection=null;
   static int studentId=0;
    
    
    
     
    
    public static void loadDummyDate()
    {
//        Exercise[] lessons=new Exercise[]{lesson1,lesson2,lesson3,lesson4,
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
        Student fifthStudent=new Student();
        fifthStudent.setName(5, "Bashir", "Kolawole");
        Student sixthStudent=new Student();
        sixthStudent.setName(6, "Basit", "Kolawole");
        Student seventhStudent=new Student();
        seventhStudent.setName(7, "Rofiat", "Kolawole");
        Student eighthStudent=new Student();
        eighthStudent.setName(8, "Azeezat", "Kolawole");
        Student ninthStudent=new Student();
        ninthStudent.setName(9, "Toheeb", "Kolawole");
        Student tenthStudent=new Student();
        tenthStudent.setName(10, "Sunkanmi", "Bello");
        Student eleventhStudent=new Student();
        eleventhStudent.setName(11, "Sodiq", "Ahmed");
        Student twelfthStudent=new Student();
        twelfthStudent.setName(12, "Jamiu", "Akanbi");
        
        students=new Student[]{firstStudent,secondStudent,thirdStudent,fourthStudent,fifthStudent
        ,sixthStudent,seventhStudent,eighthStudent,ninthStudent,tenthStudent,eleventhStudent,twelfthStudent};
        
        attendance.put(1,d1);
        attendance.put(2,d2);
        attendance.put(3,d3);
        attendance.put(4,d4);
        attendance.put(5,d5);
        attendance.put(6,d6);
        attendance.put(7,d7);
        attendance.put(8,d8);
        attendance.put(9,d9);
        attendance.put(10,d10);
        attendance.put(11,d11);
        attendance.put(12,d12);
        attendance.put(13,d13);
        attendance.put(14,d14);
        attendance.put(15,d15);
        attendance.put(16,d16);
//        attendance.put(4,d5);
//        attendance.put(4,d6);
        Exercises.put(1, exercise1);
        Exercises.put(2, exercise2);
        Exercises.put(3, exercise3);
        Exercises.put(4, exercise4);
        Exercises.put(5, exercise5);
        Exercises.put(6, exercise6);
        
        // first weekend
        
        Exercises.put(7, exercise1);
        Exercises.put(8, exercise3);
        Exercises.put(9, exercise6);
        Exercises.put(10, exercise1);
        Exercises.put(11, exercise4);
        Exercises.put(12, exercise2);
        
        // second weekend
        
        
        Exercises.put(13, exercise3);
        Exercises.put(14, exercise2);
        Exercises.put(15, exercise6);
        Exercises.put(16, exercise6);
        Exercises.put(17, exercise1);
        Exercises.put(18, exercise5);
        // third weekend
        
        
        
        Exercises.put(19, exercise6);
        Exercises.put(20, exercise1);
        Exercises.put(21, exercise3);
        Exercises.put(22, exercise1);
        Exercises.put(23, exercise4);
        Exercises.put(24, exercise2);
        
        // fourth weekend
        
        Exercises.put(25, exercise1);
        Exercises.put(26, exercise6);
        Exercises.put(27, exercise1);
        Exercises.put(28, exercise2);
        Exercises.put(29, exercise5);
        Exercises.put(30, exercise2);
        
        // fifth weekend
        
        Exercises.put(31, exercise1);
        Exercises.put(32, exercise5);
        Exercises.put(33, exercise3);
        Exercises.put(34, exercise3);
        Exercises.put(35, exercise4);
        Exercises.put(36, exercise6);
        
        // sixth weekend
        
        
        Exercises.put(37, exercise1);
        Exercises.put(38, exercise3);
        Exercises.put(39, exercise2);
        Exercises.put(40, exercise1);
        Exercises.put(41, exercise4);
        Exercises.put(42, exercise2);
        // seventh weekend
        
        
        
        Exercises.put(43, exercise4);
        Exercises.put(44, exercise2);
        Exercises.put(45, exercise6);
        Exercises.put(46, exercise2);
        Exercises.put(47, exercise5);
        Exercises.put(48, exercise1);
        
        // eigth weekend
        ff.AddExercise(exercise1);
        fs.AddExercise(exercise2);
        ft.AddExercise(exercise3);
        
        sf.AddExercise(exercise4);
        ss.AddExercise(exercise5);
        st.AddExercise(exercise6);
        
        tf.AddExercise(exercise1);
        ts.AddExercise(exercise3);
        tt.AddExercise(exercise6);
        
        fof.AddExercise(exercise1);
        fos.AddExercise(exercise4);
        fot.AddExercise(exercise2);
        
        fif.AddExercise(exercise1);
        fis.AddExercise(exercise2);
        fit.AddExercise(exercise3);
        
        sif.AddExercise(exercise4);
        sis.AddExercise(exercise5);
        sit.AddExercise(exercise6);
        
        sef.AddExercise(exercise1);
        ses.AddExercise(exercise3);
        set.AddExercise(exercise6);
        
        ef.AddExercise(exercise1);
        es.AddExercise(exercise4);
        et.AddExercise(exercise2);
        
        
        
        
        
        nf.AddExercise(exercise1);
        ns.AddExercise(exercise2);
        nt.AddExercise(exercise3);
        
        tef.AddExercise(exercise4);
        tes.AddExercise(exercise5);
        tet.AddExercise(exercise6);
        
        elf.AddExercise(exercise1);
        els.AddExercise(exercise3);
        elt.AddExercise(exercise6);
        
        twf.AddExercise(exercise1);
        tws.AddExercise(exercise4);
        twt.AddExercise(exercise2);
        
        thf.AddExercise(exercise1);
        ths.AddExercise(exercise2);
        tht.AddExercise(exercise3);
        
        fouf.AddExercise(exercise4);
        fous.AddExercise(exercise5);
        fout.AddExercise(exercise6);
        
        fitf.AddExercise(exercise1);
        fits.AddExercise(exercise3);
        fitt.AddExercise(exercise6);
        
        sixf.AddExercise(exercise1);
        sixs.AddExercise(exercise4);
        sixt.AddExercise(exercise2);
        
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
        
        s5.add(fif);
        s5.add(fis);
        s5.add(fit);
        
        s6.add(sif);
        s6.add(sis);
        s6.add(sit);
        
        s7.add(sef);
        s7.add(ses);
        s7.add(set);
        
        s8.add(ef);
        s8.add(es);
        s8.add(et);
        
        
        
        s9.add(nf);
        s9.add(ns);
        s9.add(nt);
        
        s10.add(tef);
        s10.add(tes);
        s10.add(tet);
        
        s11.add(elf);
        s11.add(els);
        s11.add(elt);
        
        s12.add(twf);
        s12.add(tws);
        s12.add(twt);
        
        s13.add(thf);
        s13.add(ths);
        s13.add(tht);
        
        s14.add(fouf);
        s14.add(fous);
        s14.add(fout);
        
        s15.add(fitf);
        s15.add(fits);
        s15.add(fitt);
        
        s16.add(sixf);
        s16.add(sixs);
        s16.add(sixt);
        
        
        
        d1.AddLessons(s1);
        d2.AddLessons(s2);
        d3.AddLessons(s3);
        d4.AddLessons(s4);
        d5.AddLessons(s5);
        d6.AddLessons(s6);
        d7.AddLessons(s7);
        d8.AddLessons(s8);
        d9.AddLessons(s9);
        d10.AddLessons(s10);
        d11.AddLessons(s11);
        d12.AddLessons(s12);
        d13.AddLessons(s13);
        d14.AddLessons(s14);
        d15.AddLessons(s15);
        d16.AddLessons(s16);
        
        Lesson[] sessions=new Lesson[]{ff,fs,ft,sf,ss,st,tf,ts,tt,fof,fos,fot,fif,fis,fit,sif,sis,sit,sef,ses,set,ef,es,et,nf,ns,nt,
        tef,tes,tet,elf,els,elt,twf,tws,twt,thf,ths,tht,fouf,fous,fout,fitf,fits,fitt,sixf,sixs,sixt};
        
        sessionCollection=new LessonCollection(new ArrayList<>(Arrays.asList(sessions)));
        
        
    }
    
    
    public static void main(String[] args) throws IOException  {
        
        
    // TODO code application logic here
        loadDummyDate();
        
        Booking bModel=new Booking();
        BookingView bView=new BookingView();
        BookingController bookingController=new BookingController(bModel,bView);
        Review rModel=new Review();
        ReviewView rView=new ReviewView();
        ReviewController reviewController=new ReviewController(rModel,rView,bModel);
        ReportController reportController=new ReportController(new ReportCollection(),new ReportView());
        Helper.print("Log in as ");
        
        for(int i=0;i<students.length;i++)
        {
            Helper.print(Integer.toString(i+1)+ " for "+ students[i].getName());
        }
       // String x=Helper.readLine();
        studentId=Helper.readInt();
        //System.out.println("Logged in as
        
        System.out.println("For booking, enter 1. Enter 2 for records,3 to attend a lesson");
        
        
       
       number = scanner.nextInt(); 
       if(number==1)
       {
           //CREATENEWBOOKING FROM CONTROLLER
           bookingController.CreateNewBooking(attendance, timetable,studentId);
        
  
       }
       
       else if(number==2)
       {
           reportController.reportsAfterFourthWeekend(attendance);
       }
       
       else if(number==3)
       {
           reviewController.CreateReview(studentId);
       }
       
       
       
    }
    
    public static String trimId(UUID id)
    {
       String stringId=id.toString();
       bookingId=stringId.substring(24);
       return bookingId;
    }
    
//    public static void BookByDay()
//    {
//        System.out.println(timetable.getTimetable(attendance));
//        System.out.println("Select Exercise by day ");
//        number=0;
//        number=scanner.nextInt();
//        Date day=timetable.getADay(number, attendance);
//
//                    // get sessions
//
//        System.out.println(day.getDay());
//        ArrayList<Lesson> Lessons=day.getLesson();
//        Exercise[] lessons=new Exercise[3];
//                    //for(Lesson session:Lessons)
//        for(int i=0;i<Lessons.size();i++)
//        {
//            Exercise lesson=Lessons.get(i).getExercise();
//            lessons[i]=lesson;
//            lesson.studentBooked();
//            lessonCount=lesson.studentCount();
//                        
//         
//            System.out.println("To book "+Lessons.get(i).getPeriod()+ "session for " + lesson.ReturnExercise()+", click "+ Integer.toString(i)+" and press enter" );
//                       
//                        
//        }
//                    
//        number=scanner.nextInt();
//        Booking booking=new Booking();
//                        
//        switch(number)
//        {
//            case 0: lessonId=lessons[0].getExerciseID();
//            break; 
//            case 1:lessonId=lessons[1].getExerciseID(); 
//            break;
//            case 2:lessonId=lessons[2].getExerciseID(); 
//            break;
//        }
//        createBooking(lessonId,studentId);
//    }
    
//    public static String saveBooking(int lId,int sId)
//    {
//        Booking book=new Booking();
//        String bookingId=book.CreateBookingId(lId, sId);
//        UUID id=UUID.fromString(bookingId);
//        try
//        {
//            DocumentBuilderFactory fact=DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder=fact.newDocumentBuilder();
//            Document document=builder.parse(BookingManagementApplication.Helper.Path()));
//        
//            
//            NodeList list=document.getChildNodes();
//            ArrayList<Booking> collections=printNode(list);
//                           
//            for(int i=0;i<collections.size();i++)
//            {
//                Booking booking=collections.get(i);
//                
//                if(booking.getStudentId()==sId && booking.getExerciseId()==lId)
//                {
//                    return "already booked";
//                }
//                if(booking.getExerciseId()==lId)
//                {
//                    lessonCount++;
//                }
//                //System.out.println(collections.get(i).getBooking());
//            }
//            
//            if(lessonCount>4)
//            {
//                return "";
//            }
//            
//            
//            Element root=document.getDocumentElement();
//
//                    Element newBooking=document.createElement("Booking");
//
//                    Element ID=document.createElement("ID");
//                    ID.appendChild(document.createTextNode(id.toString()));
//                    newBooking.appendChild(ID);
//
//                    Element ExerciseID=document.createElement("ExerciseID");
//                    ExerciseID.appendChild(document.createTextNode(Integer.toString(lId)));
//                    newBooking.appendChild(ExerciseID);
//
//                    Element StudentID=document.createElement("StudentID");
//                    StudentID.appendChild(document.createTextNode(Integer.toString(sId)));
//                    newBooking.appendChild(StudentID);
//
//                    Element Status=document.createElement("Status");
//                    Status.appendChild(document.createTextNode("false"));
//                    newBooking.appendChild(Status);
//
//                    root.appendChild(newBooking);
//                
//                TransformerFactory transformerFactory = TransformerFactory.newInstance();
//                Transformer transformer = transformerFactory.newTransformer();
//                DOMSource source=new DOMSource(document);
//                StreamResult result = new StreamResult("C:\\Users\\user\\Java Projects\\Booking Management Application\\src\\booking\\management\\application\\Models\\XMLData.xml");
//                transformer.transform(source, result);
//        }
//        catch(Exception ex)
//        {
//            
//        }
//        return bookingId;
//    }
    
//    public static void createBooking(int lessonId,int studentId)
//    {
//        String bookingId=saveBooking(lessonId,studentId); 
//                        
//        if(bookingId.equals("already booked"))
//        {
//            System.out.println("You are already booked for this lesson");
//                        
//        }
//        else if(bookingId.isEmpty())
//        {
//            System.out.println("This lesson is fully booked");
//                       
//        }
//        else
//        {
//            System.out.println("Booking successful."+ "\n" +" Booking Id is: "+bookingId);
//                       
//        }
//    }
    
//    public static ArrayList<Booking> printNode(NodeList nList)
//    {
//        
//        String ID="";
//        int ExerciseID=0;
//        int StudentID=0;
//        for(int i=0;i<nList.getLength();i++)
//        {
//             Node node=nList.item(i);
//             
//             String nodeName=node.getNodeName();
//   
//             // add node
// //            node.insertBefore(node.getLastChild(), node.appendChild(node))
//             if(node.hasChildNodes())
//             {
//                  // System.out.println("\n"+ nodeName);
////                 if(node.hasAttributes())
////                 {
////                     System.out.println("\n"+ node.getAttributes().item(0));
////                 }
//                 if(node.getChildNodes().getLength()==1)
//                 {
//                     //System.out.println("\n"+ node.setUserData("1", s1, arg2));
//                    // System.out.println("\n"+ node.getTextContent());
//                     
//                     if("ID".equals(nodeName))
//                     {
//                         ID=node.getTextContent();
//                        
//                     }
//                     else if("ExerciseID".equals(nodeName))
//                     {
//                         ExerciseID=Integer.parseInt(node.getTextContent());
//                         
//                     }
//                     else if("StudentID".equals(nodeName))
//                     {
//                         StudentID=Integer.parseInt(node.getTextContent());
//                        
//                         bookingCollection.add(new Booking(UUID.fromString(ID), ExerciseID, StudentID));
//                         
//                     }
//                     
//                 }
//                 printNode(node.getChildNodes());
//             }
//        }
//       return bookingCollection;
//    }
    
}
