package test.Exam;

public class Predator extends Animal{

    private String favoritePray;

    public Predator(String name, String color, int numOfLegs, int lifeExpectancy, String favoritePray) {
        super(name, color, numOfLegs, lifeExpectancy);
        this.favoritePray = favoritePray;
    }

    public String getFavoritePray() {
        return favoritePray;
    }

    public void setFavoritePray(String favoritePray) {
        this.favoritePray = favoritePray;
    }

    @Override
    public String toString() {
        return "Predator Animal: {" +
                "name='" + getName() + '\'' +
                ", color='" + getColor() + '\'' +
                ", numOfLegs=" + getNumOfLegs() +
                ", lifeExpectancy='" + getLifeExpectancy() + '\'' +
                ", favoriteVegetable='" + getFavoritePray() + '\'' +
                '}' + '\'';
    }
}
