package info.spreadcode.jetpacknavigationgraph

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_navigation_graph_example.*

class NavigationGraphExampleActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_graph_example)
        setNavController()

        setToolBar(getString(R.string.login_fragment_title),
            showToolBar = false,
            hideOtherToolBarItem = true
        )

    }

    /**
     * This method will set the nav controller.
     */
    private fun setNavController() {

        navController =
            Navigation.findNavController(this, R.id.nav_host_fragment)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->

            Log.d("NAV", "Label : " + destination.label)

            when (destination.label.toString()) {

                // Login Fragment
                getString(R.string.login_fragment_title) -> {
                    setToolBar(
                        destination.label.toString(),
                        showToolBar = false,
                        hideOtherToolBarItem = true
                    )
                }

                // Fruits
                getString(R.string.fragment_add_to_cart_title) -> {
                    setToolBar(
                        destination.label.toString(),
                        showToolBar = true,
                        hideOtherToolBarItem = false
                    )
                }

                // Review Order Fragment
                getString(R.string.fragment_review_order_title) -> {
                    setToolBar(
                        destination.label.toString(),
                        showToolBar = true,
                        hideOtherToolBarItem = true
                    )
                }
                // Setting Fragment

                getString(R.string.fragment_setting_title) -> {
                    setToolBar(
                        destination.label.toString(),
                        showToolBar = true,
                        hideOtherToolBarItem = true
                    )
                }
            }
        }
    }


    /**
     * This method is used to set the custom toolbar
     *
     * @param toolBarTitleText  This is used for tool bar title and it could not be null
     * @param showToolBar  This is used for show the toolbar, passing true will show the toolbar and false will hide the toolbar
     * @param hideOtherToolBarItem If you want to show the toolbar but hide the other items than toolbar title pass the true otherwise false.
     */
    private fun setToolBar(
        toolBarTitleText: String,
        showToolBar: Boolean,
        hideOtherToolBarItem: Boolean
    ) {
        setSupportActionBar(activity_navigation_graph_example_toolbar)

        if (showToolBar) {
            activity_navigation_graph_example_toolbar.visibility = View.VISIBLE
        } else {
            activity_navigation_graph_example_toolbar.visibility = View.GONE
        }

        if (hideOtherToolBarItem) {
            toolbar_cart_badge_textView.visibility = View.GONE
            toolbar_add_to_cart_imageView.visibility = View.GONE
            toolbar_setting_imageView.visibility = View.GONE
        } else {
            toolbar_cart_badge_textView.visibility = View.VISIBLE
            toolbar_add_to_cart_imageView.visibility = View.VISIBLE
            toolbar_setting_imageView.visibility = View.VISIBLE
        }

        toolbar_title_textView.text = toolBarTitleText

    }


}
