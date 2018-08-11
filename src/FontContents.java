import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.awt.GraphicsEnvironment;
import java.util.*;

public class FontContents {
    private Stage window;
    private ComboBox<String> family, style, size, color;
    private Button preview, ok;
    private Label previewText;

    public HashMap<String,String[]> getDefaultComboBoxes()
    {
        HashMap<String, String[]> data = new HashMap<>();
        String[] families= GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        String[] styles = new String[]{"Plain","Bold","Italic","Bold Italic"};
        String[] sizes = {"10","20","30","40","50"};
        String[] colors = {"red","orange","blue","green","yellow"};
        data.put("families",families);
        data.put("styles",styles);
        data.put("sizes",sizes);
        data.put("colors",colors);
        return data;
    }

    public void initializeGridPaneContents()
    {
        // Initialize first row of display items.
        family = new ComboBox<>();
        style = new ComboBox<>();
        size = new ComboBox<>();
        color = new ComboBox<>();

        family.setPrefWidth(100);
        style.setPrefWidth(100);
        size.setPrefWidth(100);
        color.setPrefWidth(100);

        HashMap<String, String[]> data = getDefaultComboBoxes();
        family.getItems().addAll(data.get("families"));
        style.getItems().addAll(data.get("styles"));
        size.getItems().addAll(data.get("sizes"));
        color.getItems().addAll(data.get("colors"));

        family.setPromptText("FAMILY");
        style.setPromptText("STYLE");
        size.setPromptText("SIZE");
        color.setPromptText("COLOR");

        // Initialize second row of display items.
        preview = new Button("Preview");
        preview.setPrefWidth(100);

        ok = new Button("Ok");
        ok.setPrefWidth(100);

        previewText = new Label("Preview Text !!!");
        previewText.setPrefWidth(200);
    }

    public void initializeWindow()
    {
        window = new Stage();
        window.setTitle("FORMAT MENU");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setScene(initializeScene());
        window.showAndWait();
    }

    public Scene initializeScene()
    {
        GridPane.setConstraints(family,0,0);
        GridPane.setConstraints(style,1,0);
        GridPane.setConstraints(size,2,0);
        GridPane.setConstraints(color,3,0);
        GridPane.setConstraints(preview,0,1);
        GridPane.setConstraints(ok,1,1);
        GridPane.setConstraints(previewText,2,1,2,1);

        GridPane gridPane = new GridPane();
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.getChildren().addAll(family,style,size,color,preview,ok,previewText);

        Scene scene = new Scene(gridPane);
        return scene;
    }
}
