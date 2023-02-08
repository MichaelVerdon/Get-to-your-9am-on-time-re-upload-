

public class NodeTest {

public static void main(String[] args){

    String line0 = "1,2,4, You awaken from a strange dream and you look at your phone and realize the time is 8.30am. It is a bleak grey monday morning and you have a 9am. You think to yourself 'I better get to my 9am on time.' as a wave of anxiety hits., Get up and ready to go, Pursue the Dream,false,false,0,0,0,0,0,0";
    String line1 = "2,3,5, You are by the front door., Smoke cigarette in backyard, Head outside,false,false,0,0,0,0,0,0";
    String line2 = "4,0,0, (Ending 1) You fall asleep, Restart,-,false,false,0,0,0,0,0,0";
    String line3 = "3,4,5, The nicotine strikes you with a headrush and you begin to feel a little too comfortable. (+0.5 coolness -1 time points), Put your head back, Fight the urges,false,false,0,0,0,0,0.5,-1";

    Node n0 = new Node();
    mapNode(n0, line0);
    Node n1 = new Node();
    mapNode(n1, line1);
    Node n2 = new Node();
    mapNode(n2, line2);
    Node n3 = new Node();
    mapNode(n3, line3);

    n0.setOptionOneNode(n1);
    n0.setOptionTwoNode(n2);

    print(n0.toString());
    print(n0.getOptionOneNode().toString());
    print(n0.getOptionTwoNode().toString());
    print(n3.toString());

    
}

public static void mapNode(Node n, String line){

    String[] stringArray = line.split(",");

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


}

public static void print(String info){System.out.println(info);}
    
}
