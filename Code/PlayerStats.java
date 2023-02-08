public class PlayerStats {

    public float coolness;

    public void playerStats(float coolness, float time){

        this.coolness = coolness;

    }

//Getters, setters and adders for points.
////////////////////////////////////////////////////////////////////////////////////////////////////////
    public float getCoolnessPoints(){return coolness;}
    public void setCoolnessPoints(float coolness){this.coolness = coolness;}
    public void addCoolnessPoints(float points){this.coolness = this.coolness + points;}
////////////////////////////////////////////////////////////////////////////////////////////////////////

//Method to check if player has required stats to travel to a node with requirements.
    public boolean hasStats(float coolness, float requiredCoolness){

        Boolean hasStats = false;

        if(coolness >= requiredCoolness){hasStats = true;}

        return hasStats;
        
    }

    public String toString(){

        return "Coolness: " + coolness;

    }

    public void resetStats(){

        this.setCoolnessPoints(0);

    }
    
}
