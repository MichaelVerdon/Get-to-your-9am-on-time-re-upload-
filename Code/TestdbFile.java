
import java.io.FileNotFoundException;

public class TestdbFile {

static NodeCollection nodeCollection;
public static void main(String[] args) throws FileNotFoundException {

    try {

        nodeCollection = new NodeCollection();

    } catch (

            FileNotFoundException e) {
         print(e.getMessage());
        return;
        
    }

    print(nodeCollection.toString());
}

public static void print(String  info){System.out.println(info);}
    
}
