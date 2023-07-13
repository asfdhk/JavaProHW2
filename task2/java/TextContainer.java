import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface SaveTo{
    String path();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Saver {
}
@SaveTo( path = "file.txt")
public class TextContainer {
    String text = "cxvf";

    @Saver
    public void save() {
        try (FileWriter writer = new FileWriter(getSavePath())) {
            writer.write(text);
            System.out.println("Text saved to file: " + getSavePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getSavePath() {
        SaveTo saveToAnnotation = TextContainer.class.getAnnotation(SaveTo.class);
        return saveToAnnotation.path();
    }

}
