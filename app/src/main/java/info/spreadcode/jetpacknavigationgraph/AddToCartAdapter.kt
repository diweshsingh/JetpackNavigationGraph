package info.spreadcode.jetpacknavigationgraph

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class AddToCartAdapter(
    var fruitsList: ArrayList<Fruit>,
    var onItemClick: onItemClick,
    var isDisabled: Boolean
) :
    RecyclerView.Adapter<AddToCartViewHolder>() {


    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): AddToCartViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_add_to_cart_layout, viewGroup, false)

        return AddToCartViewHolder(
            view, onItemClick, isDisabled
        )
    }

    override fun getItemCount(): Int {
        return fruitsList.size ?: 0
    }

    override fun onBindViewHolder(holder: AddToCartViewHolder, position: Int) {

        holder.bind(fruitsList[position])

    }

    /**
     * This method will return the total count of Selected Fruit Item
     */
    fun getSelectedItemCount(): Int {
        var count = 0
        for (fruit in fruitsList) {
            count += fruit.totalItem
        }
        return count
    }

    /**
     * This method will return total amount of the selected items.
     */
    fun getTotalAmount(): Double {
        var totalAmount = 0.0
        for (fruit in fruitsList) {
            if (fruit.totalItem != 0) {
                totalAmount += fruit.itemPrice * fruit.totalItem
            }
        }
        return totalAmount
    }


}