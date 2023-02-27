package com.bignerdranch.android.criminalintent

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.criminalintent.databinding.ListItemCrimeBinding
import com.bignerdranch.android.criminalintent.databinding.ListItemSeriousCrimeBinding

private const val normal_crime : Int = 0
private const val serious_crime : Int = 1

class CrimeHolder(
    private val binding: ListItemCrimeBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(crime: Crime) {
        binding.crimeTitle.text = crime.title
        binding.crimeDate.text = crime.date.toString()

        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "${crime.title} clicked",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

class CrimeListAdapter(
    private val crimes: List<Crime>
) : RecyclerView.Adapter<CrimeHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int
    ): CrimeHolder {
//        if (viewType == normal_crime) {
            val inflator = LayoutInflater.from(parent.context)
            val binding = ListItemCrimeBinding.inflate(inflator, parent, false)
            return CrimeHolder(binding)
//        }
//        else {
//            val inflator = LayoutInflater.from(parent.context)
//            val binding = ListItemSeriousCrimeBinding.inflate(inflator, parent, false)
//            return CrimeSeriousHolder(binding)
//        }
    }

    override fun getItemCount() = crimes.size

    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
        val crime = crimes[position]
        holder.bind(crime)
        }

    override fun getItemViewType(position: Int): Int {
        return if (crimes[position].requiresPolice) {
            serious_crime
        } else {
            normal_crime
        }
    }
}
