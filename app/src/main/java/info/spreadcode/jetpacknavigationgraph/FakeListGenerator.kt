package info.spreadcode.jetpacknavigationgraph

import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by Diwesh Singh on 1/4/2020.
 * This class is responsible to generate fake list of fruits.
 */


object FakeListGenerator {


    /**
     * This method will return the fake fruit list.
     *
     * @return ArrayList of fruits
     */
    fun getFakeFruitsList(): ArrayList<Fruit> {
        val fruitList: ArrayList<Fruit> = ArrayList()

        fruitList.add(Fruit("Mango", 50.0, 0, R.drawable.mango))
        fruitList.add(Fruit("Banana", 40.0, 0, R.drawable.banana))
        fruitList.add(Fruit("Apple", 100.0, 0, R.drawable.apple))
        fruitList.add(Fruit("Pomegranate", 120.0, 0, R.drawable.pomegranate))
        fruitList.add(Fruit("Black Grapes", 90.0, 0, R.drawable.black_grapes))
        fruitList.add(Fruit("Strawberry", 100.0, 0, R.drawable.strawberry))
        fruitList.add(Fruit("Orange", 150.0, 0, R.drawable.orange))
        fruitList.add(Fruit("Kiwi", 250.0, 0, R.drawable.kiwi))
        fruitList.add(Fruit("Avocado", 350.0, 0, R.drawable.avocado))
        fruitList.add(Fruit("Watermelon", 100.0, 0, R.drawable.watermelon))

        return fruitList

    }

    /**
     * This method will only return the selected fruit list from all fake fruit list.d
     *
     * @param selectedItemMap - It should not be empty or null
     * @return Filtered List of Fruits
     */
    fun getSelectedFruitList(selectedItemMap: HashMap<Int, Int>): ArrayList<Fruit> {

        val fakeFruitsList = getFakeFruitsList()
        val selectedFruitList: ArrayList<Fruit> = ArrayList()

        for (item in selectedItemMap) {
            val fruit = fakeFruitsList[item.key]
            fruit.totalItem = item.value
            selectedFruitList.add(fruit)
        }

        return selectedFruitList
    }


}