package org.example;

import java.io.BufferedReader;
import java.io.IOException;

public class LastLessonTask3 {
     public static void calculateLessonEndTime(BufferedReader reader) throws IOException {
         System.out.print("Enter the lesson number (from 1 to 10): ");
         int lessonNumber = Integer.parseInt(reader.readLine());

         int totalMinutes = lessonNumber * 45 + ((lessonNumber - 1) / 2) * 20;
         int hours = 9 + totalMinutes / 60;
         int minutes = totalMinutes - (hours - 9) * 60;

         System.out.println("Lesson end time: " + hours + ":" + minutes);
     }
}
