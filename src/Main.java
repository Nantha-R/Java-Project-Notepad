import javafx.application.Application;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class Main extends Application{
    private Stage window;
    private MenuBar menuBar;

    public void initializeGUI()
    {
        Contents contents = new Contents();
        contents.initializeMenuItems();
        contents.initializeEvents();
        menuBar = contents.initializeMenuBars();
        window.setTitle("Notepad");
        window.setScene(contents.initializeScene());
    }

    public void start(Stage window) throws Exception
    {
        this.window = window;
        initializeGUI();
        window.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
