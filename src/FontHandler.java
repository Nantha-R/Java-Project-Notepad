import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class FontHandler {
    FontContents fontContents;

    public void display()
    {
        fontContents = new FontContents(this);
        fontContents.initializeGridPaneContents();
        fontContents.initializeEvents();
        fontContents.initializeWindow();
        System.out.println("dsvdv");
    }

    public void previewFont()
    {
        String family = fontContents.getFamily();
        double size = fontContents.getSize();
        String style = fontContents.getStyle();
        String color = fontContents.getColor();

        FontWeight weight = FontWeight.NORMAL;
        FontPosture posture = FontPosture.REGULAR;
        if(style.equals("Bold") || style.equals("Bold Italic"))
            weight = FontWeight.BOLD;
        if(style.equals("Italic") || style.equals("Bold Italic"))
            posture = FontPosture.ITALIC;

        fontContents.previewText.setFont(Font.font(family,weight,posture,size));

        String colorStyle = "-fx-text-fill:" + color;
        fontContents.previewText.setStyle(colorStyle);
    }
}
