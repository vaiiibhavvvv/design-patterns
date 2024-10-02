package src.designpatterns.builder;

class House{
    private String foundation;
    private String roof;
    private String structure;
    private boolean hasGarage;
    private boolean hasGarden;

    private House(HouseBuilder builder){
           // this.foundation = builder.foundation;
            this.foundation = builder.foundation;
            this.structure = builder.structure;
            this.roof = builder.roof;
            this.hasGarage = builder.hasGarage;
            this.hasGarden = builder.hasGarden;
    }

@Override
public String toString(){
    return "House with foundation" + foundation + ", structure: " + structure + ", roof" + roof + ", has garage" + hasGarage + ", has garden" + hasGarden;
}

// The builder class
public static class HouseBuilder {
    
    private String foundation;
    private String structure;
    private String roof;
    private boolean hasGarden;
    private boolean hasGarage;


    //Requried attributes

    public HouseBuilder(String foundation, String structure,String roof){
        this.foundation = foundation;
        this.structure = structure;
        this.roof = roof;
    }

    // Optional attribute
    public HouseBuilder setGarage(boolean hasGarage){
        this.hasGarage = hasGarage;
        return this;
    }

    public HouseBuilder setGarden(boolean hasGarden){
        this.hasGarden = hasGarden;
        return this;
    }

    public House build(){
        return new House(this);
    }

}

}

public class Builde {
    public static void main(String[] args) {
        // Using builder to construct a house with a garage and garden
        House houseWithGarageAndGarden = new House.HouseBuilder("Concrete", "Brick", "Tile")
                .setGarage(true)
                .setGarden(true)
                .build();
        
        // Using builder to construct a simple house without garage and garden
        House simpleHouse = new House.HouseBuilder("Concrete", "Wood", "Metal")
                .build();

        System.out.println(houseWithGarageAndGarden);
        System.out.println(simpleHouse);
    }
}