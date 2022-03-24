/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package booking.management.application;

import booking.management.application.Forms.Home;
import booking.management.application.Models.Date;
import booking.management.application.Models.Session;
import booking.management.application.Models.Lesson;
import booking.management.application.Models.TimeofDay;
import java.util.HashMap;

/**
 *
 * @author user
 */
public class BookingManagementApplication {

    /**
     * @param args the command line arguments
     */
    
    
    Lesson lesson1=new Lesson(1,"",2.3);
    Lesson lesson2=new Lesson(2,"",2.3);
    Lesson lesson3=new Lesson(3,"",2.3);
    Lesson lesson4=new Lesson(4,"",2.3);
    Lesson lesson5=new Lesson(5,"",2.3);
    Lesson lesson6=new Lesson(6,"",2.3);
    Lesson lesson7=new Lesson(7,"",2.3);
    Lesson lesson8=new Lesson(8,"",2.3);
    Lesson lesson9=new Lesson(9,"",2.3);
    Lesson lesson10=new Lesson(10,"",2.3);
    Lesson lesson11=new Lesson(11,"",2.3);
    Lesson lesson12=new Lesson(12,"",2.3);
    
    TimeofDay morning=new TimeofDay(1,"morning");
    TimeofDay afternoon=new TimeofDay(2,"afternoon");
    TimeofDay evening=new TimeofDay(3,"evening");
    
    // First Saturday

    Session ff=new Session(1,2,1);
    Session fs=new Session(2,4,2);
    Session ft=new Session(3,1,3);
    
    // First Sunday

    Session sf=new Session(4,5,1);
    Session ss=new Session(5,1,2);
    Session st=new Session(6,9,3);
     
    
    static Date d1=new Date(26,3,2022,1);
    static Date d2=new Date(27,3,2022,2);
    static Date d3=new Date(2,4,2022,3);
    static Date d4=new Date(2,4,2022,4);
    
   public static HashMap<Integer,Date> attendance=new HashMap<Integer,Date>();
    
    
    
    
    
    
    
    public static void loadDummyDate()
    {
        attendance.put(1,d1);
        attendance.put(2,d2);
        attendance.put(3,d3);
        attendance.put(4,d4);
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        loadDummyDate();
        Home h1=new Home();
        h1.setVisible(true);
    }
    
}
