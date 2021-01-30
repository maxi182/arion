

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar


abstract class BaseFragment : Fragment() {
    val TAG = this.javaClass.simpleName
    protected var mMainFragmentView: View? = null
    var contentProgressBar: ProgressBar? = null
        private set

    protected abstract val layoutResource: Int

    /**
     * Sets up view references. Called in the [Fragment.onActivityCreated]
     */
    protected abstract fun setupFragment(savedInstanceState: Bundle?)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mMainFragmentView = inflater.inflate(layoutResource, container, false)

        return mMainFragmentView
    }

    protected fun showSnackBar(root: View?, message: String?) {
        val snackbar = Snackbar.make(root!!, message!!, Snackbar.LENGTH_LONG)
        snackbar.show()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupFragment(savedInstanceState)
    }


    fun showToast(message: String) {
        Log.i(TAG, message)
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }





}