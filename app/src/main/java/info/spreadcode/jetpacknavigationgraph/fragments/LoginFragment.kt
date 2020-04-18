package info.spreadcode.jetpacknavigationgraph.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import info.spreadcode.jetpacknavigationgraph.NavigationGraphExampleActivity
import info.spreadcode.jetpacknavigationgraph.R
import kotlinx.android.synthetic.main.fragment_login.*

/**
 *
 * LoginFragment - Demonstrate the simple login feature.
 */
class LoginFragment : Fragment(), View.OnClickListener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment'

        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListeners()
    }


    /**
     * Set the view to listeners
     */
    private fun setListeners() {

        fragment_login_button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {

            R.id.fragment_login_button -> {

                if(!checkUsernameAndPasswordValue()){
                    startAddToCartFragment()
                }
            }
        }
    }

    /**
     * This method will check if username or password field is empty or not
     *
     * @return True if empty otherwise false
     */
    private fun checkUsernameAndPasswordValue(): Boolean {

        if (fragment_login_username_editText.text!!.isEmpty()) {
            Toast.makeText(context, "Username/Password is empty", Toast.LENGTH_SHORT).show()
            return true
        }
        return false
    }

    /**
     * This method will navigate LoginFragment to AddToCart Fragment
     *
     */
    private fun startAddToCartFragment() {

        val navController =
            Navigation.findNavController(
                requireActivity(),
                R.id.nav_host_fragment
            )

        navController.navigate(
            R.id.action_loginFragment_to_addToCartFragment
        )
    }

}
