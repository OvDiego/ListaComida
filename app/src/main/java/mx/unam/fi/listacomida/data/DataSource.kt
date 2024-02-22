package mx.unam.fi.listacomida.data

import mx.unam.fi.listacomida.R
import mx.unam.fi.listacomida.model.Platillo

class DataSource {
    fun loadPlatillos(): List<Platillo> {
        return listOf(
            Platillo(R.string.desayuno, R.string.desayuno_precio, R.string.desayuno_eslogan, R.drawable.desayuno),
            Platillo(R.string.hamburger, R.string.hamburger_precio, R.string.hamburger_eslogan, R.drawable.hamburger),
            Platillo(R.string.pizza, R.string.pizza_precio, R.string.pizza_eslogan, R.drawable.pizza),
            Platillo(R.string.postre, R.string.postre_precio, R.string.postre_eslogan, R.drawable.postre),
            Platillo(R.string.pozole, R.string.pozole_precio, R.string.pozole_eslogan, R.drawable.pozole),
            Platillo(R.string.tacos, R.string.tacos_precio, R.string.tacos_eslogan, R.drawable.tacos)
        )
    }
}
