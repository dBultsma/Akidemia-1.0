import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

//	Sound newSound = new Sound("../resources/example.mp3");
//	newSound.play();

public class Sound{
	MediaPlayer mediaPlayer;

	public sound(String path){
		mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource(path).toExternalForm()));
		this.mediaPlayer.setOnEndOfMedia(() -> this.mediaPlayer.stop());
	}

	public void play(){
		this.mediaPlayer.stop();
		this.mediaPlayer.play();
	}

}