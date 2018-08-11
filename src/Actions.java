import javafx.scene.control.*;
import javafx.stage.FileChooser;
import java.io.*;

public class Actions{

    public Contents contents;
    public FileChooser fileChooser;

    Actions() {}

    Actions(Contents content)
    {
        contents = content;
        setFileChooser();
    }

    public void setFileChooser()
    {
        fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("TEXT FILES", "*.txt","*.java");
        fileChooser.getExtensionFilters().add(filter);
    }

    public void setContents(String text,String title,File file)
    {
        contents.setTextArea(text);
        contents.setTitle(title);
        contents.setCurrentFile(file);
        contents.setCurrentFileContents(text);
    }

    public void sleepSomeTime()
    {
        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e) {}
    }
    public void savePromptAlert()
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"DO U WANT TO SAVE YOUR WORK");
        alert.setTitle("SAVE");
        alert.showAndWait().ifPresent(response->{
            if(response == ButtonType.OK)
                saveAsFile();
                sleepSomeTime();
        });
    }
    public void saveUnsavedWork()
    {
        File currentFile = contents.getCurrentFile();
        if(currentFile == null)
        {
            if (contents.getTextArea() != null && !contents.getTextArea().isEmpty())
            {
                savePromptAlert();
            }
        }
        else
        {
            if(! contents.getTextArea().equals(contents.getCurrentFileContents()))
            {
                savePromptAlert();
            }
        }
    }

    public void createNewFile()
    {
        saveUnsavedWork();
        setContents("","Untitled - Notepad",null);
    }

    public void openFile()
    {
        saveUnsavedWork();
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
                setContents(fileContents.toString(),file.getName(),file);
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
            contents.setCurrentFileContents(fileContents);
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
                if (!fileContents.equals(contents.getCurrentFileContents()))
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
            contents.setTitle(file.getName());
            contents.setCurrentFile(file);
            contents.setCurrentFileContents(contents.getTextArea());
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
        contents.terminateApplication();
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
