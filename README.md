# 📱 Examen_CRUD_ind

`Examen_CRUD_ind` es una aplicación Android sencilla que demuestra las operaciones básicas de un CRUD (**Crear, Leer, Actualizar, Borrar**) para gestionar una lista de productos.  
Los productos se almacenan en memoria y se muestran en un `RecyclerView`.

---

## 📑 Tabla de Contenidos

- [✨ Características](#-características)
- [🚀 Uso](#-uso)
- [🛠️ Tecnologías Utilizadas](#-tecnologías-utilizadas)
- [⚙️ Instalación](#-instalación)
- [📂 Estructura del Código (MainActivity.kt)](#-estructura-del-código-mainactivitykt)

---

## ✨ Características

✅ **Crear Productos:** Añadir nuevos productos con nombre, precio y descripción.  
✅ **Leer Productos:** Visualización de los productos en un `RecyclerView`.  
✅ **Actualizar Productos:** Editar información existente de productos.  
✅ **Eliminar Productos:** Borrar productos de la lista.  
✅ **Validación de Campos:** Verificación de campos vacíos y formatos numéricos válidos antes de crear o actualizar productos.

---

## 🚀 Uso

### ➕ Agregar un Producto
1. Ingresa nombre, precio y descripción.
2. Presiona el botón **"Agregar"**.
3. El producto se añadirá a la lista si los campos son válidos.

### ✏️ Editar un Producto
1. Pulsa el botón **Editar** del producto en la lista.
2. Los datos se cargarán en los campos de texto.
3. Modifica la información y pulsa **"Actualizar"**.

### 🗑️ Eliminar un Producto
1. Pulsa el botón **Eliminar** del producto deseado.
2. El producto se removerá de la lista.

---

## 🛠️ Tecnologías Utilizadas

- **Lenguaje:** Kotlin 🧠  
- **IDE:** Android Studio 🧩  
- **Build System:** Gradle ⚙️  

### 📦 Android Jetpack Components:
- `AppCompatActivity`
- `RecyclerView`
- `LinearLayoutManager`
- `ViewBinding` (`ActivityMainBinding`)

---

## ⚙️ Instalación

1. 🔁 **Clona el repositorio:**

```bash
git clone https://github.com/thony-1702/Examen-Metodos-CRUD.git
