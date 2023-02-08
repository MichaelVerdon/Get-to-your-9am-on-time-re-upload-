

import java.io.FileNotFoundException;

public class NodeMap {

private Node head;
private Node currentNode;

//Initiates node collection and then maps it with exception handling.
public NodeMap()  {
    
    NodeCollection nodeCollection;   //scope: constructor only, part of process, no requirement to keep;
    
    try {
        nodeCollection = new NodeCollection();
        head = nodeCollection.get(0);

    } catch (FileNotFoundException e) {

        e.printStackTrace();
        return;

    }
    
    buildMap(nodeCollection);
    currentNode = head;

}

//Returns current node.
public Node currentNode() {return currentNode;}

//Allow for looping when it reaches the end.
public void decisionOne(){
    currentNode = currentNode.getOptionOneNode();
}

//Handles the decision making.
public void decision(int decision) {
    
    switch (decision) {

        case 1:
            currentNode = currentNode.getOptionOneNode();
            break;
        case 2:
            currentNode = currentNode.getOptionTwoNode();
            break;

     }

}

//Goes through each node and maps it to both options.
private void buildMap(NodeCollection NodeCollection){

    if(NodeCollection == null){return; }

    for(Node source : NodeCollection.arrayList()){

        int optionOneID = source.getOptionOneID();
        int optionTwoID = source.getOptionTwoID();
        Node optionOneNode = NodeCollection.locateNodeBy(optionOneID);
        Node optionTwoNode = NodeCollection.locateNodeBy(optionTwoID);
        source.setOptionOneNode(optionOneNode);
        source.setOptionTwoNode(optionTwoNode);
        
    }

}

//Both path methods to allow going to each node.
public String optionOnePath(){

    Node node = head;
    String string = "Option 1\n";

    while(node != null) {

        string += node.toString() + "\n";
        node = node.getOptionOneNode();
        if (node.getCurrentNodeID() == 0) {node = null;}

    }

    return string;
    
}

public Boolean canPassOptionOne(NodeMap nm, PlayerStats playerStats){

    boolean canPassOptionOne = true;

    if(nm.currentNode().optionOneHasRequirement() == true){

        canPassOptionOne = playerStats.hasStats(playerStats.coolness,
         nm.currentNode().getOptionOneCoolnessRequirement());

    }

    return canPassOptionOne;

}

public Boolean canPassOptionTwo(NodeMap nm, PlayerStats playerStats){

    boolean canPassOptionTwo = true;

    if(nm.currentNode().optionTwoHasRequirement() == true){

        canPassOptionTwo = playerStats.hasStats(playerStats.coolness,
         nm.currentNode().getOptionTwoCoolnessRequirement());

    }

    return canPassOptionTwo;

}

public String optionTwoPath(){

    Node node = head;
    String string = "Option 2\n";

    while(node != null) {

        string += node.toString() + "\n";
        node = node.getOptionTwoNode();
        if (node.getCurrentNodeID() == 0) {node = null;}

    }

    return string;
}

}
