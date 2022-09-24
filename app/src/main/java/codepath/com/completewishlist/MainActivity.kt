package codepath.com.completewishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import codepath.com.completewishlist.model.itemData
import codepath.com.completewishlist.view.itemAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var addButton:FloatingActionButton
    private lateinit var recycler:RecyclerView
    private lateinit var itemList:ArrayList<itemData>
    private lateinit var itemAdapter: itemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addButton = findViewById(R.id.addingButton)
        recycler = findViewById(R.id.mRecycler)

        itemList = ArrayList()
        itemAdapter = itemAdapter(this,itemList)

        recycler.layoutManager=LinearLayoutManager(this)
        recycler.adapter=itemAdapter

        addButton.setOnClickListener{addItem()}

    }

    private fun addItem() {
        val inftr = LayoutInflater.from(this)
        val v = inftr.inflate(R.layout.background,null)

        val itemName = v.findViewById<EditText>(R.id.editItemName)
        val website = v.findViewById<EditText>(R.id.editWebsite)
        val price = v.findViewById<EditText>(R.id.editPrice)
        val addDialog = AlertDialog.Builder(this)

        addDialog.setView(v)
        addDialog.setPositiveButton("Add"){
                dialog,_->
            val name = itemName.text.toString()
            val web = website.text.toString()
            val itemPrice = price.text.toString()
            itemList.add(itemData("Name:$name","Web:$web","Price:$itemPrice"))
            itemAdapter.notifyDataSetChanged()
            Toast.makeText(this,"Added Wished Item",Toast.LENGTH_SHORT).show()

            dialog.dismiss()
        }
        addDialog.setNegativeButton("Cancel"){
            dialog,_->
            dialog.dismiss()
            Toast.makeText(this,"Cancel",Toast.LENGTH_SHORT).show()
        }
        addDialog.create()
        addDialog.show()
    }
}