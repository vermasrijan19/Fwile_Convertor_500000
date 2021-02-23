package sample;

import io.github.biezhi.webp.WebpIO;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Main extends Application {

    Label filename =new Label();
    Button browse=new Button("Select file");
    FileChooser fileChooser = new FileChooser();
    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        browse.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                try {
                    file(primaryStage);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }});
//        Scene scene=new Scene(root, 300, 275);
        FlowPane flowPane=new FlowPane();
        primaryStage.setTitle("Fwile Conwertor  5000w");
        flowPane.getChildren()
                .add(browse);
        flowPane.getChildren()
                .add(filename);
        Scene scene =new Scene(flowPane, 300,200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void file(Stage primaryStage) throws IOException {
        fileChooser.setTitle("Open Resource File");
        File file=fileChooser.showOpenDialog(primaryStage);
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        String path=file.getAbsolutePath();
        String dir=file.getPath();
        String name1="";
        if(dir.contains("."))
        {
            for(int i=0;i<dir.length();i++)
            {
                if (dir.charAt(i) !='.')
                {
                    name1+=dir.charAt(i);

                }
                else{
                    break;
                }
            }
        }
        System.out.println(name1);
        System.out.println(dir);
        System.out.println(path);

//        BufferedImage img = ImageIO.read(new File(path));
//        ImageIO.write(img, "jpg", new File("image.jpg"));
        String dest = name1+".png";
        WebpIO.create().toNormalImage(path, dest);

//        WebpIO.create().toWEBP("hello.png", "hello.webp");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
