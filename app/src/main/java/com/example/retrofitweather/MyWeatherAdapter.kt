package com.example.retrofitweather

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitweather.model.WeatherData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout.view.*


class MyWeatherAdapter(
    private val context: Context,
    private val weatherList: MutableList<WeatherData>
) :
    RecyclerView.Adapter<MyWeatherAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.image_movie
        val txt_name: TextView = itemView.txt_name
        val txt_team: TextView = itemView.txt_team
        val txt_createdby: TextView = itemView.txt_createdby

        fun bind(listItem: WeatherData) {
            image.setOnClickListener {
                Toast.makeText(it.context, "нажал на ${itemView.image_movie}", Toast.LENGTH_SHORT)
                    .show()
            }
            itemView.setOnClickListener {
                Toast.makeText(it.context, "нажал на ${itemView.txt_name.text}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = weatherList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = weatherList[position]
        holder.bind(listItem)

        Picasso.get().load(weatherList[position].code).into(holder.image)

        holder.txt_name.text = weatherList[position].name
        holder.txt_team.text = weatherList[position].code.toString()
        holder.txt_createdby.text = weatherList[position].weather.toString()
    }


}