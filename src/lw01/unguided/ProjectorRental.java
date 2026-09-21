package lw01.unguided;

public class ProjectorRental extends Rental {
    public ProjectorRental(String id, int days){
        super(id, days);
    }

    @Override 
    public int calculateCharge(){
        int hariz = getDays();
        if(hariz <= 3){
            return hariz*60000;
        }else{
            return 3*60000 + (hariz - 3)*45000 + 20000;
        }
    }

    public String label(){
        return "Projector";
    }
}
