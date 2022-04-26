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
import booking.management.application.Models.Date;
import booking.management.application.Models.Session;
import booking.management.application.Models.SessionCollection;
import booking.management.application.Models.Timetable;
import java.util.ArrayList;
import java.util.HashMap;

public class BookingController {
    
    private Booking booking;
    private BookingView view;
    private int number=0;
    private int lessonCount=0;
    private int lessonId=0;
    private int studentId=0;
    SessionCollection sCollection;
    ArrayList<Session> Sessions;
    String stringScanner;
    public BookingController(Booking model, BookingView view )
    {
        this.view=view;
        this.booking=model;
    }
    
    
    
    public void CreateNewBooking(HashMap<Integer,Date> attendance,Timetable timetable,int studentId)
    {
       // System.out.println("To create a booking, press 1. Press 2 to change a booking ");
        this.studentId=studentId;
        this.view.printView("To create a booking, press 1. Press 2 to change a booking ");
        number = Helper.readInt();
        
        if(number==1)
        {
            this.view.printView("To check timetable by day, enter 1. Enter 2 to check by exercise name ");
            number = Helper.readInt();
            if(number==1)
            {
                this.view.printView(timetable.getTimetable(attendance));
                this.view.printView("Select Lesson by day ");
                number=0;
                number=Helper.readInt();
                Date day=timetable.getADay(number, attendance);
                
                this.view.printView(day.getDay());
                Sessions=day.getSession();
                sCollection=new SessionCollection(Sessions);
                lessonId=sCollection.BookFromMultipleSessions();

                Booking booking=new Booking();
                this.booking.createBooking(lessonId,studentId);
            }
            else if(number==2)
            {
               this.view.printView("Enter exercise name, then click enter ");
               Helper.readLine();
               Sessions=new ArrayList();
               sCollection=new SessionCollection(Sessions);
               sCollection.filterSessionsByLessonName(attendance);

               number=Helper.readInt();
               lessonId=number;
               this.booking.createBooking(lessonId,studentId);


            }
        
                
        }
        
        else if(number==2)
        {
           Helper.readLine();
           do
           {
                Helper.print("Enter your booking Id");
                stringScanner=Helper.readLine();
                booking=this.booking.getBooking(stringScanner,studentId,"booked");
                if(booking==null)Helper.print("Booking Id not found for this student. Please, try again");
                else break;
           }
           while(booking==null);
            Helper.print(timetable.getTimetable(attendance));
            Helper.print("Select Lesson by day ");
            number=0;
            number=Helper.readInt();
            Date day=timetable.getADay(number, attendance);
            Helper.print(day.getDay());
            Sessions=day.getSession();
            sCollection=new SessionCollection(Sessions);
            int lessonId=sCollection.filterSessionByDay(attendance);
            this.booking.createBooking(lessonId,studentId);
        }
    }    
    
}
