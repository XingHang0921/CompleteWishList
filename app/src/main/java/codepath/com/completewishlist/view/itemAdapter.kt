package codepath.com.completewishlist.view

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import codepath.com.completewishlist.R
import codepath.com.completewishlist.model.itemData

class itemAdapter(val context: Context,val itemList: ArrayList<itemData>):RecyclerView.Adapter<itemAdapter.itemViewHolder>()
{
    inner class itemViewHolder(val v: View): RecyclerView.ViewHolder(v){
        val viewName = v.findViewById<TextView>(R.id.mItemName)
        val viewWeb = v.findViewById<TextView>(R.id.mWebsite)
        val viewPrice = v.findViewById<TextView>(R.id.mPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder
    {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.item_list,parent,false)
        return itemViewHolder(v)
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int)
    {
        val newList = itemList[position]
        holder.viewName.text = newList.itemName
        holder.viewWeb.text = newList.price
        holder.viewPrice.text = newList.website


    }

    override fun getItemCount(): Int
    {
        return itemList.size
    }
}