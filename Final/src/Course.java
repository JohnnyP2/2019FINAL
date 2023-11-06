import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.*;
public class Course extends Application{
	
	
	public Course() {
		
	}
	private static ArrayList<Student> students = new ArrayList<>(); //a list that holds the students
	private static ArrayList<Double> scores = new ArrayList<>(); // a list that holds the grades
	private static ArrayList<Integer> ids = new ArrayList<>(); // a list that holds the ids from the grades files (used later to match the grades witht the students)
// Identifiers
	String line;
	String[] splitLine;
	String name;
	 
	int id;
	double score;
	
	public boolean loadStudents(String file) {// it looks ugly but it works
		File student = new File(file);
		if(!student.exists()) {
			
			return false;
		}
		try { 
			Scanner fileReader = new Scanner(student);
			while(fileReader.hasNextLine()) {
				
				line = fileReader.nextLine();
				splitLine = line.split(" "); // splits line into multiple substrings
				id = Character.getNumericValue(splitLine[0].charAt(0)); // stores the id number as an int
				name = splitLine[1] +" " + splitLine[2]; // makes a name for the student using splitLine and 2
				Student newStudent = new Student(name,18); //I wasnt sure where age was in the project so im just going to make them all 18
				newStudent.setId(id);
				students.add(newStudent);
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return true;
		
		
	}
	public boolean loadGrades(String gradeFile) {
		
		File gradeRead = new File(gradeFile);
		if(!gradeRead.exists()) {
			
			return false;
		}
		try {
			Scanner fileReader = new Scanner(gradeRead);
			while(fileReader.hasNextLine()) {
				
				line = fileReader.nextLine();
				splitLine = line.split(" ");
				id = Character.getNumericValue(splitLine[0].charAt(0)); //gets the id
				ids.add(id);
				score = Double.valueOf(splitLine[1]); // converts the substring to a double
				scores.add(score);
				
			
			}
			for(int i = 0; i < students.size(); i++) {// matches the ids up with the students so they can have the right score
							
				if(ids.get(i) == students.get(i).getId()) {
					
					students.get(i).setGrade(scores.get(i));
					
				}else if(students.get(i).getId() < ids.get(i) ) {
					
					students.get(i + 1).setGrade(scores.get(i));
					
				}else if(students.get(i).getId() > ids.get(i) ) {
					
					students.get(i - 1).setGrade(scores.get(i));
				}
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return true;

	}
	
	public static  double calculateAverage(){// calculates the average 
		double sum = 0;
		double finalAverage;
		for(int i = 0; i < students.size();i++) {
			
			sum += students.get(i).getGrade();
			
		}
	
		
		finalAverage = (sum / students.size() );
		return finalAverage;
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
	}
	// Getters and setters
	public ArrayList<Double> getScores() {
		return scores;
	}
	public void setScores(ArrayList<Double> scores) {
		this.scores = scores;
	}
	public ArrayList<Student> getStudents() {
		return students;
	}
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	public ArrayList<Integer> getIds() {
		return ids;
	}
	public void setIds(ArrayList<Integer> ids) {
		this.ids = ids;
	}
	
	
}
