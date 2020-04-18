package info.spreadcode.jetpacknavigationgraph.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import info.spreadcode.jetpacknavigationgraph.VerticalSpacingItemDecorator
import info.spreadcode.jetpacknavigationgraph.*
import kotlinx.android.synthetic.main.fragment_review_order.*
import java.util.ArrayList

/**
 * ReviewOrderFragment is responsible to show selected items of carts in details and option to place the order.
 *
 */
class ReviewOrderFragment : Fragment(),
    onItemClick {

    private lateinit var addToCartAdapter: AddToCartAdapter
    private lateinit var selectedItemMap: HashMap<Int, Int>
    private lateinit var selectedFruitList: ArrayList<Fruit>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = arguments

        selectedItemMap =
            bundle!!.getSerializable("selectedItemMap") as HashMap<Int, Int>


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_review_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        selectedFruitList =
            FakeListGenerator.getSelectedFruitList(
                selectedItemMap
            )

        initRecyclerView()

        updateTotalAmountInButton()
    }

    override fun onAddOrRemoveListener() {

    }

    /**
     * This method will update the total amount in button text
     *
     */
    private fun updateTotalAmountInButton() {
        fragment_review_order_place_the_order_button.text=getString(R.string.place_order_pay_rs)+addToCartAdapter.getTotalAmount()
    }

    /**
     * This method will create adapter and set to the recyclerview
     *
     */
    private fun initRecyclerView() {

        addToCartAdapter =
            AddToCartAdapter(
                selectedFruitList,
                this,
                true
            )

        val itemDecorator = VerticalSpacingItemDecorator(5)
        fragment_review_order_recyclerView.addItemDecoration(itemDecorator)
        fragment_review_order_recyclerView.adapter = addToCartAdapter
        fragment_review_order_recyclerView.layoutManager = LinearLayoutManager(activity)

    }




}
