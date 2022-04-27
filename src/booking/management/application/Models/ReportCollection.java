/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package booking.management.application.Models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

/**
 *
 * @author user
 */
public class ReportCollection {

    ReviewCollection reviews = new ReviewCollection();
    BookingCollection bookings = new BookingCollection();
    ArrayList<String> reportArray = new ArrayList();
    static int bookingIterator = 0;
    static int reviewIterator = 0;

    public ArrayList<String> showReportAfterFourWeeks(HashMap<Integer, Date> attendance) {
        ArrayList<Lesson> collection = new ArrayList();
        for (Date date : new ArrayList<Date>(attendance.values())) {
            collection.addAll(date.getLesson());
        }

        LessonCollection lessonCollection = new LessonCollection(collection);

        Review[] allReviews = reviews.getAllReviews().toArray(new Review[reviews.count()]);

        Booking[] allBookings = bookings.getAllBookings().toArray(new Booking[bookings.count()]);

        Date[] dates = null;
        dates = attendance.values().toArray(new Date[20]);

        if (dates != null) {
            for (int i = 0; i < dates.length; i++) {

                Date date = dates[i];
                if (date != null) {

                    int rating = 0;
                    Lesson lesson = null;
                    String display = "SHOWING REPORTS FOR: \n";

                    display += date.getDay() + ") " + date.ReturnDate() + "\n";

                    
                    for (int j = reviewIterator++; j < allReviews.length; j++) {
                        if (allReviews[j] != null) {
                            int count = 0;

                            //check everyone that attended this particular lesson and send
                            // feedback out where status is attended and exerciseId match lessonId
                            if (allBookings != null) {
                                for (int k = bookingIterator++; k < allBookings.length; k++) {
                                    if (allBookings[k] != null && allReviews[j].getBookingId().toString().trim().equalsIgnoreCase(allBookings[k].getBookingId().toString().trim())) {
                                        Booking booking = allBookings[k];
                                        Review review = allReviews[j];

                                        int lessonId = booking.getExerciseId();

                                        lesson = lessonCollection.getLessonById(lessonId);
                                        //Lesson lesson=date.getLesson().get(lessonId);
                                        
                                       // if(_lesson!=null)
                                        Exercise exercise = lesson.getExercise();
                                        int eid = exercise.getExerciseID();

                                        for (int l = 0; l < allBookings.length; l++) {
                                            String bookingId = allBookings[l].getBookingId().toString();
                                            if (allBookings[l].getExerciseId() == lessonId && allBookings[l].getStatus().trim().equals("attended")) {
                                                Review _review = reviews.getReviewById(bookingId);

                                                rating += _review.getRating();
                                                lesson.increaseCount();
                                            }
                                        }

                                        
                                        
                                        display += "A total of " + lesson.Count() + " people attended the " + lesson.getPeriod()
                                            + lesson.getExercise().getExerciseName() + " lesson, and the average rating was"
                                            + Integer.toString(rating / lesson.Count());

                                    reportArray.add(display);
                                    break;

                                    }
                                    
                                    break;
                                }

                                break;
                            }
                        }
                        break;
                    }

                    
                    
                         }

            }
        }

        return reportArray;
    }

}


//                    for (int j = 0; j < allReviews.length; j++) {
//                        if (allReviews[j] != null) {
//                            int count = 0;
//
//                            //check everyone that attended this particular lesson and send
//                            // feedback out where status is attended and exerciseId match lessonId
//                            if (allBookings != null) {
//                                for (int k = 0; k < allBookings.length; k++) {
//                                    if (allBookings[k] != null && allReviews[j].getBookingId().toString().trim().equalsIgnoreCase(allBookings[k].getBookingId().toString().trim())) {
//                                        Booking booking = allBookings[k];
//                                        Review review = allReviews[j];
//
//                                        int lessonId = booking.getExerciseId();
//
//                                        lesson = lessonCollection.getLessonById(lessonId);
//                                        //Lesson lesson=date.getLesson().get(lessonId);
//                                        Exercise exercise = lesson.getExercise();
//                                        int eid = exercise.getExerciseID();
//
//                                        for (int l = 0; l < allBookings.length; l++) {
//                                            String bookingId = allBookings[l].getBookingId().toString();
//                                            if (allBookings[l].getExerciseId() == lessonId && allBookings[l].getStatus().trim().equals("attended")) {
//                                                Review _review = reviews.getReviewById(bookingId);
//
//                                                rating = _review.getRating();
//                                                lesson.increaseCount();
//                                            }
//                                        }
//
//                                        break;
//
//                                    }
//
//                                    break;
//                                }
//
//                                break;
//                            }
//                        }
//                        break;
//                    }
//
//                    display += "A total of " + lesson.Count() + " people attended the " + lesson.getPeriod()
//                            + lesson.getExercise().getExerciseName() + " lesson, and the average rating was"
//                            + Integer.toString(rating / lesson.Count());
//
//                    reportArray.add(display);
           
//                    for (int j = 0; j < allReviews.length; j++) {
//                        if (allReviews[j] != null) {
//                            int count = 0;
//                            int rating = 0;
//
//                            //check everyone that attended this particular lesson and send
//                            // feedback out
//                            
//                            if (allBookings != null) {
//                                for (int k = 0; k < allBookings.length; k++) {
//                                    if (allBookings[k] != null && allReviews[j].getBookingId().toString().trim().equalsIgnoreCase(allBookings[k].getBookingId().toString().trim())) {
//                                        Booking booking = allBookings[k];
//                                        Review review = allReviews[j];
//
//                                        int lessonId = booking.getExerciseId();
//
//                                        Lesson lesson = lessonCollection.getLessonById(lessonId);
//                                        //Lesson lesson=date.getLesson().get(lessonId);
//                                        Exercise exercise = lesson.getExercise();
//                                        int eid = exercise.getExerciseID();
//                                        
//                                        
//                                            rating = review.getRating();
//                                            lesson.increaseCount();
//
//                                            display += "A total of " + lesson.Count() + " people attended the " + lesson.getPeriod()
//                                                    + lesson.getExercise().getExerciseName() + " lesson, and the average rating was"
//                                                    + Integer.toString(rating / lesson.Count());
//
//                                            reportArray.add(display);
//
//                                        
//                                        
//                                    }
//
//                                    
//                                }
//
//                            }
//                        }
//                        break;
//                    }

