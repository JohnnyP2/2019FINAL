import javafx.application.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//Johnny Pedicone
public class DisplayCourseInfo extends Course{

	
	private static Course course = new Course();
	public static void main(String[] args) {
		double average;
		String studentFile = "students.txt";
		String gradeFile = "grades.txt";
		
		if(!course.loadStudents(studentFile)) {
			System.out.println("File not found");
		}
		if(!course.loadGrades(gradeFile)) {
			System.out.println("File not found");
		}
		
		
		launch(args);
		
	}

	
	@Override
	public void start(Stage stage) {
		Group group = new Group();
		BorderPane pane = new BorderPane();
		Scene scene = new Scene(pane, 600,600);
		stage.setScene(scene);
		
		Text text1 = new Text();
		text1.setText("Student Grades \n Grade = " + calculateAverage());
		
		Button button1 = new Button("Course Average");
		
		ListView<Student> items = new ListView<>();
		for(int i = 0; i < course.getStudents().size(); i++) {
			 items.getItems().add(course.getStudents().get(i));			
	
		}
		
		
		items.setOnMouseClicked(e ->{
			
			
			text1.setText("Student Grades \n Grade = " +items.getSelectionModel().getSelectedItem().getGrade() );
			
		});
		
		button1.setOnMouseClicked(e ->{
			text1.setText("Student Grades \n Average = "+ calculateAverage());
			System.out.println(calculateAverage());
		});
		
		group.getChildren().add(items);
		pane.setRight(text1);
		pane.setCenter(group);
		pane.setLeft(button1);
		stage.show();
	}
	/*
	 * This semester was really fun and I learned a lot of things!
	 * I hope you have a great summer and I'll see you in data structures this fall
	 * 
	 * 										-Johnny Pedicone
	 */
	
	
	
	
}
