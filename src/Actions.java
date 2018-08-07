import javafx.stage.FileChooser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Actions{

    public Contents contents;
    public FileChooser fileChooser;

    Actions() {}

    Actions(Contents content)
    {
        contents = content;
        setFileChooser();
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
    public void setFileChooser()
    {
        fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("TEXT FILES", "*.txt","*.java");
        fileChooser.getExtensionFilters().add(filter);
    }

    public void openFile()
    {
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

    public void writeFile(File file,String fileContents)
    {
        try
        {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(fileContents);
            fileWriter.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void saveFile()
    {
        File file = contents.getCurrentFile();
        if(file != null)
        {
            try
            {
                String fileContents = contents.getTextArea();
                writeFile(file,fileContents);
            }
            catch(Exception e)
            {
                e.printStackTrace();
                System.exit(1);
            }
        }
        else
        {
            saveAsFile();
        }
    }

    public void saveAsFile()
    {
        File file = fileChooser.showSaveDialog(contents.getWindow());
        if(file != null)
        {
            String fileContents = contents.getTextArea();
            writeFile(file, fileContents);
            contents.setTitle(file.getName());
            contents.setCurrentFile(file);
        }
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
