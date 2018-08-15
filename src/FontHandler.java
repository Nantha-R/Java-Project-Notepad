import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Label;

public class FontHandler {
    Actions actions;
    FontContents fontContents;
    private String family, colorStyle;
    private double size;
    private FontWeight weight;
    private FontPosture posture;

    FontHandler (){}

    FontHandler(Actions actions)
    {
        this.actions = actions;
    }

    public void display()
    {
        fontContents = new FontContents(this);
        fontContents.initializeGridPaneContents();
        fontContents.initializeEvents();
        fontContents.initializeWindow();
    }

    public void setFontContents()
    {
        family = fontContents.getFamily();
        size = fontContents.getSize();
        String style = fontContents.getStyle();
        String color = fontContents.getColor();

        weight = FontWeight.NORMAL;
        posture = FontPosture.REGULAR;

        if(style.equals("Bold") || style.equals("Bold Italic"))
            weight = FontWeight.BOLD;
        if(style.equals("Italic") || style.equals("Bold Italic"))
            posture = FontPosture.ITALIC;

        colorStyle = "-fx-text-fill:" + color;
    }

    public void previewFont(Label previewText)
    {
        setFontContents();
        previewText.setFont(Font.font(family,weight,posture,size));
        previewText.setStyle(colorStyle);
    }

    public void addFont(TextArea textArea)
    {
        setFontContents();
        textArea.setFont(Font.font(family,weight,posture,size));
        textArea.setStyle(colorStyle);
    }
}
