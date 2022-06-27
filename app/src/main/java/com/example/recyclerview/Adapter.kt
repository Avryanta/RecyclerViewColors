package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.RviewItemBinding

class Adapter(private val context: Context, private val colorList: ArrayList<ColorData>, private val onClickListener: ColorOnClickListener): RecyclerView.Adapter<Adapter.ViewHolder>() {

    // Класс, описывающий заполнение элемента списка
    class ViewHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = RviewItemBinding.bind(item)
        fun bind(color: ColorData) = with(binding){
            imageView.setImageResource(color.colorHex)
            textView.text = color.colorName
        }
    }

    // Создает элемент ViewHolder - экземпляр класса ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rview_item, parent, false)
        return ViewHolder(view)
    }

    // Заполняет созданный элемент данными
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val tag = colorList[position]
        holder.bind(colorList[position])
        holder.itemView.setOnClickListener{
            onClickListener.OnClicked(tag.colorName)
        }
    }

    // Возвращает длину списка
    override fun getItemCount(): Int {
        return colorList.size
    }
}