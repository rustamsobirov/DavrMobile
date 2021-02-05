package me.ruyeo.davrmobile.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import me.ruyeo.davrmobile.R
import me.ruyeo.davrmobile.databinding.RecyclerItemBinding
import me.ruyeo.davrmobile.model.Operations

class OperationsAdapter(private var context: Context?, private var mCategories: List<Operations>) :
        RecyclerView.Adapter<OperationsAdapter.CategoryViewHolder>() {
    private lateinit var onCategoryClickListener: OnCategoryClickListener

    inner class CategoryViewHolder(val binding: RecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind() {

            binding.txtName.text = mCategories[adapterPosition].name
            binding.txtSubname.text = mCategories[adapterPosition].subName
            Picasso.get().load(mCategories[adapterPosition].icon).error(R.drawable.ic_e_bike_line_1).into(binding.rvIcon)
            binding.txtRvMoney.text = mCategories[adapterPosition].money
            binding.layoutCategoryItem.setOnClickListener {
                onCategoryClickListener.onClick(
                        adapterPosition
                )
            }
        }

    }

    interface OnCategoryClickListener {
        fun onClick(position: Int)
    }

    fun setOnCategoryClickListener(listener: OnCategoryClickListener) {
        this.onCategoryClickListener = listener
    }


    override fun getItemCount(): Int {
        return mCategories.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val v = LayoutInflater.from(parent.context)
        val listBinding = RecyclerItemBinding.inflate(v,parent,false)
        return CategoryViewHolder(listBinding)
    }
}
