package app.sethtec.examencrudind

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import app.sethtec.examencrudind.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val productos = mutableListOf<Producto>()
    private lateinit var adapter: ProductorAdapter
    private var idCounter = 1
    private var editando = false
    private var indiceEditando = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecycler()

        binding.btnAgregar.setOnClickListener {
            if (validarCampos()) {
                if (editando) actualizarProducto() else crearProducto()
            }
        }
    }

    private fun initRecycler() {
        adapter = ProductorAdapter(
            productos,
            onEditar = { producto, index -> cargarProductoParaEditar(producto, index) },
            onEliminar = { index -> eliminarProducto(index) }
        )
        binding.rvProductos.layoutManager = LinearLayoutManager(this)
        binding.rvProductos.adapter = adapter
    }

    private fun validarCampos(): Boolean {
        var valido = true
        val nombre = binding.etNombre.text.toString()
        val precioStr = binding.etPrecio.text.toString()
        val descripcion = binding.etDescripcion.text.toString()

        if (nombre.isEmpty()) {
            binding.etNombre.error = "Nombre requerido"
            valido = false
        }
        if (precioStr.isEmpty() || precioStr.toDoubleOrNull() == null) {
            binding.etPrecio.error = "Precio requerido y debe ser un número válido"
            valido = false
        }
        if (descripcion.isEmpty()) {
            binding.etDescripcion.error = "Descripción requerida"
            valido = false
        }
        return valido
    }

    private fun crearProducto() {
        val nombre = binding.etNombre.text.toString()
        val precio = binding.etPrecio.text.toString().toDoubleOrNull()
        val descripcion = binding.etDescripcion.text.toString()
        val producto =
            Producto(idCounter++, nombre, precio!!, descripcion) // El precio ya fue validado
        productos.add(producto)
        adapter.notifyItemInserted(productos.size - 1)
        limpiarCampos()
    }

    private fun cargarProductoParaEditar(producto: Producto, index: Int) {
        binding.etNombre.setText(producto.nombre)
        binding.etPrecio.setText(producto.precio.toString())
        binding.etDescripcion.setText(producto.descripcion)
        binding.btnAgregar.text = "Actualizar"
        editando = true
        indiceEditando = index
    }

    private fun actualizarProducto() {
        val nombre = binding.etNombre.text.toString()
        val precio = binding.etPrecio.text.toString().toDoubleOrNull()
        val descripcion = binding.etDescripcion.text.toString()

        val productoActualizado = productos[indiceEditando].copy(
            nombre = nombre,
            precio = precio!!,
            descripcion = descripcion
        ) // El precio ya fue validado
        productos[indiceEditando] = productoActualizado
        adapter.notifyItemChanged(indiceEditando)
        limpiarCampos()
        binding.btnAgregar.text = "Agregar"
        editando = false
        indiceEditando = -1
    }

    private fun eliminarProducto(index: Int) {
        productos.removeAt(index)
        adapter.notifyItemRemoved(index)
    }

    private fun limpiarCampos() {
        binding.etNombre.text.clear()
        binding.etPrecio.text.clear()
        binding.etDescripcion.text.clear()
        binding.etNombre.error = null
        binding.etPrecio.error = null
        binding.etDescripcion.error = null
    }
}