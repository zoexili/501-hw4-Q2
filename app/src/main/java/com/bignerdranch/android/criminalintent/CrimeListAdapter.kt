package com.bignerdranch.android.criminalintent

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
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
                "${crime.title} It's a normal case! ",
                Toast.LENGTH_SHORT
            ).show()
        }
//        binding.root.setOnClickListener {
//            Toast.makeText(
//                binding.root.context,
//                "${crime.title} clicked",
//                Toast.LENGTH_SHORT
//            ).show()
//        }

    }
}

class SeriousCrimeHolder(
    private val binding: ListItemSeriousCrimeBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(crime: Crime) {
        binding.crimeTitle.text = crime.title
        binding.crimeDate.text = crime.date.toString()

        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "${crime.title} It's a serious case! ",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.callPoliceButton.visibility = if (!crime.requiresPolice) {
            View.GONE
        } else {
            View.VISIBLE
        }
    }
}
class CrimeListAdapter(
    private val crimes: List<Crime>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        if (viewType == normal_crime) {
        val inflator = LayoutInflater.from(parent.context)
        val binding = ListItemCrimeBinding.inflate(inflator, parent, false)
        return CrimeHolder(binding)
        }
        else {
            val inflator = LayoutInflater.from(parent.context)
            val binding = ListItemSeriousCrimeBinding.inflate(inflator, parent, false)
            return SeriousCrimeHolder(binding)
        }
    }

    override fun getItemCount() = crimes.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val crime = crimes[position]
        when (getItemViewType(position)) {
            serious_crime -> {
                val seriousHolder = holder as SeriousCrimeHolder
                seriousHolder.bind(crime)
            }
            else -> {
                val normalHolder = holder as CrimeHolder
                normalHolder.bind(crime)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (crimes[position].requiresPolice) {
            serious_crime
        } else {
            normal_crime
        }
    }
}
