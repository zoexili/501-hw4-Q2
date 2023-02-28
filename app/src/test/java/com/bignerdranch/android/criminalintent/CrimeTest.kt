package com.bignerdranch.android.criminalintent

import org.junit.Assert
import org.junit.Test
import java.util.*

class CrimeTest {

    @Test
    fun testCrimeProperties() {
        val id = UUID.randomUUID()
        val title = "Test"
        val date = Date()
        val isSolved = false
        val requiresPolice = true

        val crime = Crime(id, title, date, isSolved, requiresPolice)

        Assert.assertEquals(id, crime.id)
        Assert.assertEquals(title, crime.title)
        Assert.assertEquals(date, crime.date)
        Assert.assertEquals(isSolved, crime.isSolved)
        Assert.assertEquals(requiresPolice, crime.requiresPolice)
    }

}