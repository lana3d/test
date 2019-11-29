package test.Exam;

public class Vegetarian extends Animal{

    private String favoriteVegetable;



    public Vegetarian(String name, String color, int numOfLegs, int lifeExpectancy, String favoriteVegetable) {
        super(name, color, numOfLegs, lifeExpectancy);
        this.favoriteVegetable = favoriteVegetable;
    }


    public String getFavoriteVegetable() {
        return favoriteVegetable;
    }

    public void setFavoriteVegetable(String favoriteVegetable) {
        this.favoriteVegetable = favoriteVegetable;
    }

    @Override
    public String toString() {
        return "Vegetarian Animal: {" +
                "name='" + getName() + '\'' +
                ", color='" + getColor() + '\'' +
                ", numOfLegs=" + getNumOfLegs() +
                ", lifeExpectancy='" + getLifeExpectancy() + '\'' +
                ", favoriteVegetable='" + getFavoriteVegetable() + '\'' +
                '}'+ '\'';
    }
}
