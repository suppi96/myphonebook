package sheridan.supritha.models

data class Contact (
    var name: String,
    var numbers: MutableList<String>,
    val image: Int = R.drawable.default_contfact_image
)