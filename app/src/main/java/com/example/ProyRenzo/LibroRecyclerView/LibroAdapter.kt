package com.example.ProyRenzo.LibroRecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ProyRenzo.R

class LibroAdapter (private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<LibroAdapter.ViewHolder>() {

    class ViewHolder(ItemView :View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = ItemView.findViewById(R.id.img_libro)
        val tituloPrincipal: TextView = ItemView.findViewById(R.id.lbl_nombre_libre)
        val descripcionSecundaria: TextView = ItemView.findViewById(R.id.lbl_descripcion_libro)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_libro, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemViewModel = mList[position]

        holder.imageView.setImageResource(itemViewModel.image)
        holder.tituloPrincipal.text = itemViewModel.titulo
        holder.descripcionSecundaria.text = itemViewModel.descripcion

    }

}






















