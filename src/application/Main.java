//Author Sean Adam Holland R00162740
package application;
	
import java.sql.Connection;

import controller.schoolController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	Scene scene, scene2, scene3;
	Button editStudentGrade, addGrade, removeStudentModule, addStudentModule, addStudentToClass, add, remove, listStudents, listTeachers, addStudent, addTeacher, addModule, removeStudent, removeTeacher, removeClass, removeModule, changeScene, changeScene2;
	TextField editMark, editStudentName, editModuleName, listStudentClass, studentNameRemoveModule, moduleNameRemoveModule, studentNoAddModule, moduleNoAddModule, studentNoAddToClass, className, rModule, rClass, rTSName, rTFName, rSSName, rSFName, sFName, sLName, sEmail, sNumber, sDOB, tName, tLName, tEmail, tNumber, tDegree, mName, cName;
	TextArea display, addDisplay, removeDisplay;
	Label student, teacher, groupClass, module;
	@Override
	
	public void start(Stage primaryStage) {
		Connection con = controller.schoolController.createConnection(); // setup conection to database
		//add
		Stage window = primaryStage;
		addStudent = new Button("addStudent");
		addTeacher = new Button("addTeacher");
		addModule = new Button("addModule");
		changeScene2 = new Button("Home");
		addStudentToClass = new Button("Add to class");
		addStudentModule = new Button("Add module to student");
		editStudentGrade = new Button("Edit Student Grade");
	    
		changeScene2.setOnAction(e -> window.setScene(scene3));// change scene
	    addStudent.setOnAction(e -> {
	    	if(controller.schoolController.validateStudent(sFName.getText(), sLName.getText(),sEmail.getText(), sNumber.getText(), sDOB.getText()))
	    		addDisplay.setText(controller.databaseQueries.insertStudent(con, new model.Student(sFName.getText(), sLName.getText(), sEmail.getText(), Integer.parseInt(sNumber.getText()), sDOB.getText())));
	    	else
	    		addDisplay.setText("Sorry invalid input please try again");
	    });
		
		addTeacher.setOnAction(e -> { // add teacher
			if(controller.schoolController.validateTeacher(tName.getText(), tLName.getText(),tEmail.getText(), tNumber.getText(), tDegree.getText())) 
				addDisplay.setText(controller.databaseQueries.insertTeacher(con, new model.Teacher(tName.getText(), tLName.getText(),tEmail.getText(), Integer.parseInt(tNumber.getText()), tDegree.getText())));
			else
	    		addDisplay.setText("Sorry invalid input please try again");
				
		});
		
		
		
		addModule.setOnAction(e -> { // add module
			if(controller.schoolController.validateModuleAndClass(mName.getText()))
				addDisplay.setText(controller.databaseQueries.insertModule(con, new model.Module(mName.getText())));
			else
	    		addDisplay.setText("Sorry invalid input please try again");
		});
		
		addStudentToClass.setOnAction(e ->{ // add student to class
			if(controller.schoolController.validateNumber(studentNoAddToClass.getText()) && controller.schoolController.validateText(className.getText()))
				addDisplay.setText(controller.databaseQueries.addStudentToClass(con, Integer.parseInt(studentNoAddToClass.getText()), className.getText()));
			else
	    		addDisplay.setText("Sorry invalid input please try again");
		});
		
		addStudentModule.setOnAction(e -> { // add module to student
			if(controller.schoolController.validateNumber(studentNoAddModule.getText())  && controller.schoolController.validateNumber(moduleNoAddModule.getText()) )
				addDisplay.setText(controller.databaseQueries.addStudentModule(con, Integer.parseInt(studentNoAddModule.getText()), Integer.parseInt(moduleNoAddModule.getText())));
			else
	    		addDisplay.setText("Sorry invalid input please try again");
						
		});
		
		editStudentGrade.setOnAction(e -> {
			if(schoolController.validateNumber(editMark.getText()) && schoolController.validateText(editStudentName.getText()) && schoolController.validateText(editModuleName.getText()))
				addDisplay.setText(controller.databaseQueries.editModuleMark(con, editStudentName.getText(), editModuleName.getText(), Integer.parseInt(editMark.getText())));
			else
	    		addDisplay.setText("Sorry invalid input please try again");
		});
		
		student = new Label("Student"); // student textfields
		
		editMark = new TextField();
		editMark.setMaxWidth(150.0);
		editMark.setPromptText("mark");
	    editStudentName = new TextField();
	    editStudentName.setMaxWidth(150.0);
	    editStudentName.setPromptText("student First name");
	    
	    editModuleName = new TextField();
	    editModuleName.setMaxWidth(150.0);
	    editModuleName.setPromptText("module name");
	    HBox editLayout = new HBox();
	    editLayout.getChildren().addAll(editMark, editStudentName, editModuleName);
		
		sFName = new TextField();
		sFName.setMaxWidth(150.0);
		sFName.setPromptText("student First name");
		sLName = new TextField();
		sLName.setMaxWidth(150.0);
		sLName.setPromptText("student last name");
		sEmail = new TextField();
		sEmail.setMaxWidth(150.0);
		sEmail.setPromptText("student email");
		sNumber = new TextField();
		sNumber.setMaxWidth(150.0);
		sNumber.setPromptText("student number");
		sDOB = new TextField();
		sDOB.setMaxWidth(150.0);
		sDOB.setPromptText("dd/mm/yyyy");
		
		studentNoAddToClass = new TextField();
		studentNoAddToClass.setMaxWidth(150.0);
		studentNoAddToClass.setPromptText("stundent Number");
		
		className = new TextField();
		className.setMaxWidth(150.0);
		className.setPromptText("class name");
		HBox toClass = new HBox();
		toClass.getChildren().addAll(studentNoAddToClass, className);
		
		
		studentNoAddModule = new TextField();
		studentNoAddModule.setMaxWidth(150.0);
		studentNoAddModule.setPromptText("studentNo");
		moduleNoAddModule = new TextField();
		moduleNoAddModule.setMaxWidth(150.0);
		moduleNoAddModule.setPromptText("moduleNo");
		
		
		
		HBox studentModule = new HBox(); // hbox to hold studentNo and moduleNo textfields
		studentModule.getChildren().addAll(studentNoAddModule, moduleNoAddModule);
		
		
		teacher = new Label("Teacher"); // teacher textfields
		
		tName = new TextField();
		tName.setPromptText("teacher name");
		tLName = new TextField();
		tLName.setPromptText("teacher last name");
		tEmail = new TextField();
		tEmail.setPromptText("teacher email");
		tNumber = new TextField();
		tNumber.setPromptText("teacher number");
		tDegree = new TextField();
		tDegree.setPromptText("teacher degree");
		
		module = new Label("Module");
		
		mName = new TextField();
		mName.setPromptText("module name");
		
		groupClass = new Label("Class");
		
		
		
		
		
		HBox sLayout = new HBox(); // student layout
		sLayout.getChildren().addAll(sFName, sLName, sEmail, sNumber, sDOB);
		
		HBox tLayout = new HBox(); // teacher
		tLayout.getChildren().addAll(tName,tLName, tEmail, tNumber, tDegree);
		
		HBox mLayout = new HBox(); //module
		mLayout.getChildren().add(mName);
		
		
		
		addDisplay = new TextArea();
		
		VBox layout = new VBox(5);
		layout.getChildren().addAll(student, sLayout, addStudent, toClass, addStudentToClass, studentModule, addStudentModule, editLayout, editStudentGrade,  teacher, tLayout, addTeacher, module, mLayout, addModule, groupClass, addDisplay, changeScene2);
		//, addStudent, teacher, tLayout, addTeacher, module, mLayout, addModule, groupClass, cLayout, addClass
		scene = new Scene(layout, 700, 700); // add scene
		
	   
		
		
		
		
		//remove
		removeStudent = new Button("removeStudent");
	    removeTeacher = new Button("removeTeacher");
	    removeClass = new Button("removeClass");
	    removeModule = new Button("removeModule");
	    changeScene = new Button("Home");
	    removeStudentModule = new Button("Remove student module");
	    
	    changeScene.setOnAction(e -> window.setScene(scene3)); // change scene
	    removeStudent.setOnAction(e -> {
	    	if(controller.schoolController.validateText(rSFName.getText()) && controller.schoolController.validateText(rSSName.getText()))
	    		removeDisplay.setText(controller.databaseQueries.removeStudent(con, rSFName.getText(), rSSName.getText()));
	    	else
	    		removeDisplay.setText("Sorry invalid input please try again");
	    });
	    removeTeacher.setOnAction(e -> { // remove teacher
	    	if(controller.schoolController.validateText(rTFName.getText()) && controller.schoolController.validateText(rTSName.getText()))
	    		removeDisplay.setText(controller.databaseQueries.deleteTeacher(con, rTFName.getText(), rTSName.getText()));
	    	else
	    		removeDisplay.setText("Sorry invalid input please try again");
	    });
	    removeClass.setOnAction(e -> { // remove class
	    	if(controller.schoolController.validateText(rClass.getText()))
	    		removeDisplay.setText(controller.databaseQueries.deleteClass(con, rClass.getText()));
	    	else
	    		removeDisplay.setText("Sorry invalid input please try again");
	    });
	    removeModule.setOnAction(e -> { // remove module
	    	if(controller.schoolController.validateModuleAndClass(rModule.getText()))
	    		removeDisplay.setText(controller.databaseQueries.deleteModule(con, rModule.getText()));
	    	else
	    		removeDisplay.setText("Sorry invalid input please try again");
	    });
	    
	    removeStudentModule.setOnAction(e -> { // remove student from module
	    	if(controller.schoolController.validateText(studentNameRemoveModule.getText()) &&  controller.schoolController.validateText(moduleNameRemoveModule.getText()))
	    		removeDisplay.setText(controller.databaseQueries.deleteStudentModule(con, studentNameRemoveModule.getText(), moduleNameRemoveModule.getText()));
	    	else
	    		removeDisplay.setText("Sorry invalid input please try again");
	    });
	    
	    
	    
	    
	     rSFName = new TextField();
	    rSFName.setPromptText("Student First Name");
	    
	     rSSName = new TextField();
	    rSSName.setPromptText("Student Second Name");
	    HBox rSLayout = new HBox();
	    rSLayout.getChildren().addAll(rSFName, rSSName);
	    
	    
	    studentNameRemoveModule = new TextField();
	    studentNameRemoveModule.setMaxWidth(150.0);
	    studentNameRemoveModule.setPromptText("student first name");
	    moduleNameRemoveModule = new TextField();
	    moduleNameRemoveModule.setMaxWidth(150.0);
	    moduleNameRemoveModule.setPromptText("module name");
		
		HBox removeStudentModuleLayout = new HBox(); // hbox for student name and module name for removing student module
		removeStudentModuleLayout.getChildren().addAll(studentNameRemoveModule, moduleNameRemoveModule);
	    
	    
	    
	    
	    
	    
	    
	    
	     rTFName = new TextField();
	     rTFName.setMaxWidth(150.0);
	    rTFName.setPromptText("Teacher First Name");
	    
	     rTSName = new TextField();
	     rTSName.setMaxWidth(150.0);
	    rTSName.setPromptText("Teacher Second Name");
	    HBox rTLayout = new HBox();
	    rTLayout.getChildren().addAll(rTFName, rTSName);
	    
	     rClass = new TextField();
	     rClass.setMaxWidth(150.0);
	    rClass.setPromptText("Class Name");
	    
	     rModule = new TextField();
	     rModule.setMaxWidth(150.0);
	    rModule.setPromptText("Module Name");
	    
	    removeDisplay = new TextArea();
	    
	    VBox layout2 = new VBox(5);
	    layout2.getChildren().addAll(rSLayout, removeStudent, rTLayout, removeTeacher, removeStudentModuleLayout, removeStudentModule,  rModule, removeModule, rClass, removeClass, removeDisplay, changeScene);
	    scene2 = new Scene(layout2, 700, 700);
		
	   
		
		
		
		
		//home
		add = new Button("Add");
		remove = new Button("Remove");
		listStudents = new Button("List Students");
		listTeachers = new Button("List Teachers");
		
		add.setOnAction(e -> window.setScene(scene)); // change scenes
		remove.setOnAction(e -> window.setScene(scene2));
		listStudents.setOnAction(e -> {
			if(controller.schoolController.validateModuleAndClass(listStudentClass.getText()))
				display.setText(controller.databaseQueries.listStudents(con, listStudentClass.getText()));
			else
				display.setText("Sorry invalid input please try again");
		});
		listTeachers.setOnAction(e -> display.setText(controller.databaseQueries.listTeachers(con)));
		
		listStudentClass = new TextField();
		listStudentClass.setMaxWidth(150.0);
		listStudentClass.setPromptText("Class name");
		display = new TextArea();
		
		HBox listStudentsLayout = new HBox();
		listStudentsLayout.getChildren().addAll(listStudents, listStudentClass);
		
		VBox homeDisplay = new VBox(5);
		homeDisplay.getChildren().addAll(add, remove, listStudentsLayout, listTeachers, display);
		scene3 = new Scene(homeDisplay, 500, 500);
		
		window.setScene(scene3);
		window.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
