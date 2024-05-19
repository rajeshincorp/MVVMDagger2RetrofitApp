package sindri.lab.mvvmdagger2retrofitapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import sindri.lab.mvvmdagger2retrofitapp.viewmodel.StartingViewModel
import sindri.lab.mvvmdagger2retrofitapp.viewmodel.StartingViewModelFactory
import javax.inject.Inject

class StartingActivity : AppCompatActivity() {

    lateinit var startingViewModel: StartingViewModel

    @Inject
    lateinit var startingViewModelFactory: StartingViewModelFactory

    private val products: TextView
        get() = findViewById(R.id.products)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_starting)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        (application as FakerApplication).component.inject(this)

        startingViewModel = ViewModelProvider(this, startingViewModelFactory).get(StartingViewModel::class.java)

        startingViewModel.productsLiveData.observe(this,{
            products.text = it.joinToString { x -> x.title + "\n\n" }
        })
    }
}