/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package missionariesandcannibalsai;

/**
 *
 * @author I-TECH
 */
public class VectorOp {
    int missionaries,cannibals,boat,missionariesAcross,cannibalsAcross,boatAcross;
    public VectorOp(int missionaries,int cannibals,int boat,
            int missionariesAcross,int cannibalsAcross,int boatAcross){
        this.missionaries = missionaries;
        this.cannibals = cannibals;
        this.boat = boat;
        this.missionariesAcross = missionariesAcross;
        this.cannibalsAcross = cannibalsAcross;
        this.boatAcross = boatAcross;
    }
    
    public boolean isValid(){
        if((this.missionaries >= this.cannibals)&&(this.missionaries >=0 && this.cannibals >=0)
                &&(this.missionaries <= 3 && this.cannibals <= 3)
                &&(this.missionariesAcross >= this.cannibalsAcross) && this.boat >=0 && this.boat <= 1){
            if(this.missionaries == 3 && this.cannibals == 3)
                return false;
            return true;
        }
        else{
            if((this.missionaries >=0 && this.cannibals >=0)
                &&(this.missionaries <= 3 && this.cannibals <= 3)
                    && this.boat >=0 && this.boat <= 1){
                if(this.missionariesAcross == 0)
                    return true;
                if(this.missionaries == 0)
                    return true;
            }
            return false;
        }
    }
    
    public boolean isGoal(){
        if(this.missionaries == 0 && this.cannibals == 0 && this.boat == 0 
                && this.missionariesAcross == 3 && this.cannibalsAcross == 3 && this.boatAcross == 1)
            return true;
        else
            return false;
    }
    
    public void addVec(VectorOp action){
        missionaries += action.missionaries;
        cannibals += action.cannibals;
        boat += action.boat;
        missionariesAcross -= action.missionaries;
        cannibalsAcross -= action.cannibals;
        boatAcross -= action.boat;
    }
    
    public void subVec(VectorOp action){
        missionaries -= action.missionaries;
        cannibals -= action.cannibals;
        boat -= action.boat;
        missionariesAcross += action.missionaries;
        cannibalsAcross += action.cannibals;
        boatAcross += action.boat;
    }
    
    public int getMissionaries(){return this.missionaries;}
    
    public int getCannibals(){return this.cannibals;}
    
    public int getBoat(){return this.boat;}
    
    public int getMissionariesAcross(){return this.missionariesAcross;}
    
    public int getCannibalsAcross(){return this.cannibalsAcross;}
    
    public int getBoatAcross(){return this.boatAcross;}
    
    @Override
    public String toString() {
        return this.missionaries+""+this.cannibals+""+this.boat+""
                +this.missionariesAcross+""+this.cannibalsAcross+""+this.boatAcross+"";
    }
}
