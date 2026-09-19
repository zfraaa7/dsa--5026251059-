public abstract class PrintJob implements Chargeable{
    private String id;
    private int pages;

    public PrintJob(String id, int pages){
        if(pages < 1){
            throw new IllegalArgumentException("Pages must be at least 1");
        }

        this.id = id;
        this.pages = pages;
    }

    public String getId(){
        return id;
    }

    public int getPages(){
        return pages;
    }

    @Override
    public abstract int calculateCharge();

    public int calculateCharge(int copies){
        if(copies < 1){
            throw new IllegalArgumentException("Copies must be at least 1");
        }
        
        return copies*calculateCharge();
    }

    public String label(){
        return "Print";
    }

    public String summary(){
        return this.id + " | " + label() + " | " + calculateCharge();
    }
}