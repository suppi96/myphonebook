package sheridan.supritha.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.layout.Layout
import com.google.android.material.textview.MaterialTextView
import sheridan.supritha.models.Contact

class ContactAdapter (private val contacts: List<Contact>, private val onItemClick: (Contact) -> Unit) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

        class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val nameView: MaterialTextView = view.findViewById(R.id.contact_name)
            val primaryPhoneView: MaterialTextView = view.findViewById(R.id.primary_phone)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_item, parent, false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
            val contact = contacts[position]
            holder.nameView.text = contact.name
            holder.primaryPhoneView.text = contact.numbers.firstOrNull() ?: "No phone number!"
            holder.itemView.setOnClickListener{ onItemClick(contact) }
    }

    override fun getItemCount(): Int = contacts.size
}