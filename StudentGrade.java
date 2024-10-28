package StudentGrade;

import java.util.Scanner;

public class StudentGrade {

	
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	       
	        int totalMarks = 0;
	        int numSubjects = 5;  

	        
	        for (int i = 1; i <= numSubjects; i++) {
	            System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
	            totalMarks += sc.nextInt();
	        }

	        double averagePercentage = totalMarks / (double) numSubjects;
	        
	        String grade;
	        if (averagePercentage >= 90) {
	            grade = "A";
	        } else if (averagePercentage >= 80) {
	            grade = "B";
	        } else if (averagePercentage >= 70) {
	            grade = "C";
	        } else if (averagePercentage >= 60) {
	            grade = "D";
	        } else {
	            grade = "F";
	        }

	        System.out.println("\nResults:");
	        System.out.println("Total Marks: " + totalMarks + " / " + (numSubjects * 100));
	        System.out.println("Average Percentage: " + averagePercentage + "%");
	        System.out.println("Grade: " + grade);

	    }
	}



