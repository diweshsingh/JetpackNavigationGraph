package info.spreadcode.jetpacknavigationgraph.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import info.spreadcode.jetpacknavigationgraph.VerticalSpacingItemDecorator
import info.spreadcode.jetpacknavigationgraph.*
import kotlinx.android.synthetic.main.activity_navigation_graph_example.*
import kotlinx.android.synthetic.main.fragment_add_to_cart.*
import java.util.ArrayList

/**
 * AddToCartFragment is responsible to show all the items and user can add those items to cart
 * User can also checkout the items clicking on cart button
 * User can also navigate to setting page using setting button on toolbar
 *
 */
class AddToCartFragment : Fragment(),
    onItemClick, View.OnClickListener {

    private lateinit var toolbarAddToCartImageView: AppCompatImageView
    private lateinit var badgeTextView: TextView
    private var fruitList: ArrayList<Fruit> = ArrayList()
    private lateinit var addToCartAdapter: AddToCartAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_to_cart, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // Set ToolBar Item to listener
        setToolBarItemListener()

        // Get Fruit List Data
        getFakeFruitList()

        // set Data to RecyclerView
        initRecyclerView()
    }

    override fun onAddOrRemoveListener() {

        badgeTextView.text = addToCartAdapter.getSelectedItemCount().toString()
        toolbarAddToCartImageView.isEnabled = addToCartAdapter.getSelectedItemCount() > 0

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            // Setting Button
            R.id.toolbar_setting_imageView -> {
                val navController =
                    Navigation.findNavController(
                        requireActivity(),
                        R.id.nav_host_fragment
                    )

                navController.navigate(
                    R.id.action_addToCartFragment_to_settingFragment
                )

            }

            // Add to cart Button
            R.id.toolbar_add_to_cart_imageView -> {

                val bundle = Bundle()
                bundle.putSerializable("selectedItemMap", getSelectedValueInHashMap())

                val navController =
                    Navigation.findNavController(
                        requireActivity(),
                        R.id.nav_host_fragment
                    )

                navController.navigate(
                    R.id.action_addToCartFragment_to_reviewOrderFragment, bundle
                )

            }

        }
    }


    /**
     * This method will attach all the item of toolbar to the listener
     *
     */
    private fun setToolBarItemListener() {
        val navigationGraphExampleActivity: NavigationGraphExampleActivity =
            requireActivity() as NavigationGraphExampleActivity

        badgeTextView = navigationGraphExampleActivity.toolbar_cart_badge_textView
        toolbarAddToCartImageView = navigationGraphExampleActivity.toolbar_add_to_cart_imageView

        navigationGraphExampleActivity.toolbar_add_to_cart_imageView.setOnClickListener(this)
        navigationGraphExampleActivity.toolbar_setting_imageView.setOnClickListener(this)
    }

    /**
     * This method will get fake fruit list
     *
     */
    private fun getFakeFruitList() {

        if (fruitList.isNullOrEmpty()) {
            fruitList =
                FakeListGenerator.getFakeFruitsList()
        }
    }

    /**
     * This method will create adapter and set to the recyclerview
     *
     */
    private fun initRecyclerView() {

        addToCartAdapter =
            AddToCartAdapter(
                fruitList,
                this,
                false
            )

        val itemDecorator = VerticalSpacingItemDecorator(5)
        fragment_add_to_cart_recyclerView.addItemDecoration(itemDecorator)
        fragment_add_to_cart_recyclerView.adapter = addToCartAdapter
        fragment_add_to_cart_recyclerView.layoutManager = LinearLayoutManager(activity)

    }

    /**
     * This method will create HashMap of selected Items
     *
     * @return HashMap of Selected Items
     */

    private fun getSelectedValueInHashMap(): HashMap<Int, Int> {

        val selectedItemMap: HashMap<Int, Int> = HashMap()

        for (index in 0..fruitList.size - 1) {
            if (fruitList[index].totalItem != 0) {
                selectedItemMap[index] = fruitList[index].totalItem
            }

        }
        return selectedItemMap
    }


}
