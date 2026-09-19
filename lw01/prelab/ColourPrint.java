public class ColourPrint extends PrintJob{
    public ColourPrint(String id, int pages){
        super(id, pages);
    }

    @Override
    public int calculateCharge(){
        return (10*1500) + ((getPages()%10)*1000) + 2000;
    }
    public String label(){
        return "Colour";
    }
}