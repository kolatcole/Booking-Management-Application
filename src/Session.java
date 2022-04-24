/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class Session {
    
    private int ID;
    private int LessonID;
    private String TimeofDay;
    
    private Session(int id,int lessonId,String time)
    {
        
        ID=id;
        LessonID=lessonId;
        TimeofDay=time;
    }
    
}
