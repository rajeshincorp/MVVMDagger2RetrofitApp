package sindri.lab.mvvmdagger2retrofitapp.model

data class Product(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)