package app.sethtec.examencrudind

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.sethtec.examencrudind.databinding.ItemProductoBinding

// clase usada para poder mostrar los productos en el recycler view

class ProductorAdapter (
    private val productos: List<Producto>,
    private val onEditar: (Producto, Int) -> Unit,
    private val onEliminar: (Int) -> Unit
    ) : RecyclerView.Adapter<ProductorAdapter.ProductoViewHolder>()
    {

        inner class ProductoViewHolder(val binding: ItemProductoBinding) :
            RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
            val binding =
                ItemProductoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ProductoViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
            val producto = productos[position]
            holder.binding.tvNombre.text = producto.nombre
            holder.binding.tvPrecio.text = "Precio: $${producto.precio}"
            holder.binding.tvDescripcion.text = producto.descripcion

            holder.binding.btnEditar.setOnClickListener {
                onEditar(producto, position)
            }
            holder.binding.btnEliminar.setOnClickListener {
                onEliminar(position)
            }
        }

        override fun getItemCount() = productos.size
    }
