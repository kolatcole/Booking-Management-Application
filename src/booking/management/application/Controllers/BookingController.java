/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */



package booking.management.application.Controllers;

import booking.management.application.Models.Booking;
import booking.management.application.Views.BookingView;
import booking.management.application.BookingManagementApplication.Helper;
import static booking.management.application.BookingManagementApplication.attendance;
import static booking.management.application.BookingManagementApplication.createBooking;
import booking.management.application.Models.Date;
import booking.management.application.Models.Lesson;
import booking.management.application.Models.Session;
import booking.management.application.Models.Timetable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class BookingController {
    
    private Booking booking;
    private BookingView view;
    private int number=0;
    private int lessonCount=0;
    private int lessonId=0;
    private int studentId=0;
    
    public BookingController(Booking model, BookingView view )
    {
        this.view=view;
        this.booking=model;
    }
    
    
    
    public void CreateNewBooking(HashMap<Integer,Date> attendance,Timetable timetable)
    {
       // System.out.println("To create a booking, press 1. Press 2 to change a booking ");
        this.view.printView("To create a booking, press 1. Press 2 to change a booking ");
        number = Helper.readInt();
        
        if(number==1)
        {
                //System.out.println("To check timetable by day, enter 1. Enter 2 to check by exercise name ");
                this.view.printView("To check timetable by day, enter 1. Enter 2 to check by exercise name ");
                number = Helper.readInt();
                if(number==1)
                {
//                    System.out.println(timetable.getTimetable(attendance));
//                    System.out.println("Select Lesson by day ");
                    this.view.printView(timetable.getTimetable(attendance));
                    this.view.printView("Select Lesson by day ");
                    number=0;
                    number=Helper.readInt();
                    Date day=timetable.getADay(number, attendance);
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
                    
                        number=Helper.readInt();
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
                    
                }
        }
        
    }    
    
}
