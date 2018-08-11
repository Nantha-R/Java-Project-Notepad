public class FontHandler {
    FontContents fontContents;

    public void display()
    {
        fontContents = new FontContents();
        fontContents.initializeGridPaneContents();
        fontContents.initializeWindow();
    }
}
