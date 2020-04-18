package info.spreadcode.jetpacknavigationgraph

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_add_to_cart_layout.view.*


class AddToCartViewHolder(
    itemView: View,
    var onItemClick: onItemClick,
   var isDisabled: Boolean
) : RecyclerView.ViewHolder(itemView) {


    private val itemImageView = itemView.item_imageView
    private val itemName = itemView.item_name_textView
    private val itemPrice = itemView.item_price_textView
    private val totalItemSelected = itemView.item_count_textView


    fun bind(fruit: Fruit) {

        itemImageView.setImageResource(fruit.itemResourceId)
        itemName.text = fruit.itemName
        itemPrice.text = "Rs. ${fruit.itemPrice} / Kg"

        totalItemSelected.text = fruit.totalItem.toString()

        itemView.item_add_to_cart_imageView.setOnClickListener {

            if (!isDisabled){
                fruit.totalItem = fruit.totalItem + 1
                totalItemSelected.text = fruit.totalItem.toString()
                onItemClick.onAddOrRemoveListener()
            }


        }

        itemView.item_remove_from_cart_imageView.setOnClickListener {

            if (!isDisabled && fruit.totalItem != 0) {
                fruit.totalItem = fruit.totalItem - 1
                totalItemSelected.text = fruit.totalItem.toString()
                onItemClick.onAddOrRemoveListener()
            }

        }

    }


}