package lxc.com.example.helloworld.model;

public class Fruit {
    private int fruitId;
    private String fruitName;

    @Override
    public String toString() {
        return "Fruit{" +
                "fruitId=" + fruitId +
                ", fruitName='" + fruitName + '\'' +
                '}';
    }

    public int getFruitId() {
        return fruitId;
    }

    public void setFruitId(int fruitId) {
        this.fruitId = fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public Fruit( String fruitName,int fruitId) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
    }
}
