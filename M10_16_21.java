package M10;


/*
 * Program name: M10_16_21.java
 * Author: Gabriel Dennett
 * Date: 04/08/20
 * Purpose: Display multiple payments
 * */


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.media.*;


public class M10_16_21 extends Application{
	
	Pane pane = new Pane();
	TextField timer = new TextField();
	private static String media_url =  "http://www.hochmuth.com/mp3/Beethoven_12_Variation.mp3";
	
	@Override
	public void start(Stage mainStage) {
		Media media = new Media(media_url);
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		//MediaView mediaview = new MediaView(mediaPlayer);
		
		
		
		EventHandler<ActionEvent> eventHandler = e -> {
			int secondsLeft = Integer.parseInt(timer.getText());
			if(secondsLeft > 0) {
				secondsLeft--;
				String time = Integer.toString(secondsLeft);
				timer.setText(time);
			}
			
			if(secondsLeft == 0) {
			mediaPlayer.play();
			}
		};
		
		Timeline animation = new Timeline(
				new KeyFrame(Duration.millis(1000), eventHandler));
		
		
		timer.setOnAction(e -> {
			animation.setCycleCount(Timeline.INDEFINITE);
			animation.play();
		});
		
		
		
		pane.getChildren().addAll(timer);
		Scene scene = new Scene(pane);
		mainStage.setTitle("Timer");
		mainStage.setScene(scene);
		mainStage.show();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
