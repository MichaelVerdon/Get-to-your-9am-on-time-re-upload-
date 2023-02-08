
import java.io.FileNotFoundException;

public class TestForm {

    public static void main(String[] args) throws FileNotFoundException {
        
        NodeMap map = new NodeMap();
        if(map.currentNode() == null) { return;}

        Form f = new Form(map);

    }
}
