import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Contents extends Actions{

    private MenuItem newFile,open,save,saveAs,pageSetup,print,exit,copy,paste,selectAll,wordWrap,font;
    private MenuBar menuBar;

    public Scene initializeScene()
    {
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);

        VBox verticalBox = new VBox();
        verticalBox.setPadding(new Insets(20,20,20,20));
        verticalBox.getChildren().addAll(menuBar, textArea);

        return new Scene(verticalBox,500,500);
    }

    public void initializeEvents()
    {
        newFile.setOnAction(e->createNewFile());
        open.setOnAction(e->openFile());
        save.setOnAction(e->saveFile());
        saveAs.setOnAction(e->saveAsFile());
        pageSetup.setOnAction(e->pageSetup());
        print.setOnAction(e->print());
        exit.setOnAction(e->exitFile());
        copy.setOnAction(e->copy());
        paste.setOnAction(e->paste());
        selectAll.setOnAction(e->selectAll());
        wordWrap.setOnAction(e->wordWrap());
        font.setOnAction(e->font());
    }

    public MenuBar initializeMenuBars()
    {
        Menu fileMenu,editMenu,formatMenu;
        fileMenu = new javafx.scene.control.Menu("FILE");
        editMenu = new javafx.scene.control.Menu("EDIT");
        formatMenu = new javafx.scene.control.Menu("FORMAT");

        fileMenu.getItems().addAll(newFile,open,save,saveAs,pageSetup,print,exit);
        editMenu.getItems().addAll(copy,paste,selectAll);
        formatMenu.getItems().addAll(wordWrap,font);

        menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,editMenu,formatMenu);
        return menuBar;
    }

    public void initializeMenuItems()
    {
        newFile = new MenuItem("New file");
        open = new MenuItem("Open");
        save = new MenuItem("Save");
        saveAs = new MenuItem("Saveas");
        pageSetup = new MenuItem("Page setup");
        print = new MenuItem("Print");
        exit = new MenuItem("Edit");
        copy = new MenuItem("Copy");
        paste = new MenuItem("Paste");
        selectAll = new MenuItem("Select all");
        wordWrap = new MenuItem("Word wrap");
        font = new MenuItem("Font");
    }
}
