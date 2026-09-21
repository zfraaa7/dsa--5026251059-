package lw01.unguided;

public abstract class Rental implements Chargeable{
    private String id;
    private int days;

    protected Rental(String id, int days){
        if(days < 1){
            throw new IllegalArgumentException("Pages must be at least 1");
        }

        this.id = id;
        this.days = days;
    }

    public String getId(){
        return id;
    }

    public int getDays(){
        return days;
    }

    public abstract int calculateCharge();

    public int calculateCharge(int units){
        if(units < 1){
            throw new IllegalArgumentException("Pages must be at least 1");
        }

        return units * calculateCharge();
    }

    public String label(){
        return "Rental";
    }

    public String summary(){
        return getId() + " | " + label() + " | " + calculateCharge();
    }
} 
