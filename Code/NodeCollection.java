

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NodeCollection {

private static ArrayList<Node> nodes;

//Sets corresponding attributes to a node and makes it.
Node mapFields(String nodeData){

    String[] stringArray = nodeData.split(",");
    Node n = new Node();

    n.setCurrentNodeID(Integer.parseInt(stringArray[0]));
    n.setOptionOneID(Integer.parseInt(stringArray[1]));
    n.setOptionTwoID(Integer.parseInt(stringArray[2]));
    n.setDescription(stringArray[3]);
    n.setOptionOneText(stringArray[4]);
    n.setOptionTwoText(stringArray[5]);

    n.setOptionOneHasRequirement(Boolean.parseBoolean(stringArray[6]));
    n.setOptionTwoHasRequirement(Boolean.parseBoolean(stringArray[7]));

    n.setOptionOneCoolnessRequirement(Float.parseFloat(stringArray[8]));

    n.setOptionTwoCoolnessRequirement(Float.parseFloat(stringArray[10]));

    n.setCoolnessGained(Float.parseFloat(stringArray[12]));
    
    return n;

}

//Runs the node collection and makes a collection of the nodes to be mapped.
public NodeCollection() throws FileNotFoundException{

    java.io.File nodeDatabase = new java.io.File("Code/NodeDatabase.csv");
    Scanner fileRef = new Scanner(nodeDatabase);

    nodes = new ArrayList<Node>(); //Initialises the needed classes to make all nodes.
    Node node;
        
    while(fileRef.hasNextLine()){ //Keeps the node making process going until the file has no more lines.

        String nodeData = fileRef.nextLine();
        node = mapFields(nodeData);
        nodes.add(node);

    }

    fileRef.close();

}

//Returns all the nodes from the new array list.
public ArrayList<Node> arrayList(){return nodes;}

//Method to retrieve a specific node needed.
public Node get(int index){return nodes.get(index);}

//Locate a node by its actual id.
public Node locateNodeBy(int nodeID) {

    for (Node n : nodes) {
        if (nodeID == n.getCurrentNodeID()) {

            return n;

        }
    }

    return new Node();
}

//To string display method to
public String toString(){

    String str = "";

    for(Node n: nodes){

        str += n.toString() + "\n";
        
    }
    return str;
}

}
