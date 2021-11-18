package lxc.com.example.helloworld.constants;

import java.util.ArrayList;
import java.util.List;

import lxc.com.example.helloworld.R;
import lxc.com.example.helloworld.model.Fruit;

public class FruitConstants {
    public static List<Fruit> getfList(){
      List<Fruit> fList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Fruit apple = new Fruit("Apple", R.drawable.apple);
            fList.add(apple);
            Fruit banana = new Fruit("Banana", R.drawable.banana);
            fList.add(banana);
            Fruit watermelon = new Fruit("WatermelonWatermelonWatermelonWatermelonWatermelon", R.drawable.lemon);
            fList.add(watermelon);
            Fruit pear = new Fruit("Pear", R.drawable.pear);
            fList.add(pear);
            Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry);
            fList.add(strawberry);
        }
        return fList;
    };
}
