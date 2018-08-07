import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Actions{

    Contents contents;
    Actions() {}

    Actions(Contents content)
    {
        contents = content;
    }

    public void createNewFile()
    {
        File currentFile = contents.getCurrentFile();
        if(currentFile != null)
        {
            contents.setCurrentFile(null);
            contents.setTextArea("");
            contents.setTitle("Untitled - Notepad");
        }
    }

    public void openFile()
    {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Text Files","*.java","*.txt");
        fileChooser.getExtensionFilters().add(filter);
        File file = fileChooser.showOpenDialog(contents.getWindow());

        if(file != null)
        {
            try
            {
                StringBuilder fileContents = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String text;
                while((text = bufferedReader.readLine()) != null)
                    fileContents.append(text);
                contents.setTextArea(fileContents.toString());
                contents.setCurrentFile(file);
                contents.setTitle(file.getName());
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
                System.exit(1);
            }
        }
    }

    public void saveFile()
    {

    }

    public void saveAsFile()
    {

    }

    public void print()
    {

    }

    public void pageSetup()
    {

    }

    public void exitFile()
    {

    }

    public void copy()
    {

    }

    public void paste()
    {

    }

    public void selectAll()
    {

    }

    public void wordWrap()
    {

    }

    public void font()
    {

    }

}
