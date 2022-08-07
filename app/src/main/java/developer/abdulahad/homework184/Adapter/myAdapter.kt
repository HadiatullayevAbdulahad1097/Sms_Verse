package developer.abdulahad.homework184.Adapter

import developer.abdulahad.homework184.Models.Sher
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import developer.abdulahad.homework184.Models.SherListObject
import developer.abdulahad.homework184.R
import developer.abdulahad.homework184.databinding.DialogViewBinding
import developer.abdulahad.homework184.objektlar.PutInt
import kotlinx.android.synthetic.main.dialog_view.view.*
import kotlinx.android.synthetic.main.item_rv.view.*


class SherAdapter(var sherList: List<Sher>, var onMyItemClickListener: OnMyItemClickListener)
    : RecyclerView.Adapter<SherAdapter.MyViewHolder>(){
    inner class MyViewHolder(var itemView: View): RecyclerView.ViewHolder(itemView){

        fun onBind(position: Int){
            itemView.txt_sher_nomi.text = sherList[position].name
            itemView.txt_sher_matni.text = sherList[position].matni
            if (sherList[position].like){
                itemView.image_rv_saqlanganlar.setImageResource(R.drawable.ic_sher_saqlanganda)
            }else {
                itemView.image_rv_saqlanganlar.setImageResource(R.drawable.ic_saqlanganlar)
            }
            itemView.setOnClickListener{
                onMyItemClickListener.onMyItemClck(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        val myViewHolder = MyViewHolder(itemView)
        return myViewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return sherList.size
    }

    interface OnMyItemClickListener{
        fun onMyItemClck(position: Int)
    }
}