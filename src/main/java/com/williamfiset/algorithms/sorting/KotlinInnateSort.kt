package com.williamfiset.algorithms.sorting

import kotlin.jvm.JvmStatic

class KotlinInnateSort : InplaceSort {
    override fun sort(values: IntArray) {
        innateSort(values)
    }

    companion object {
        private fun innateSort(ar: IntArray) {
            ar.sort()
        }

        @JvmStatic
        fun main(args: Array<String>) {
            val sorter: InplaceSort = InsertionSort()
            val array = intArrayOf(10, 4, 6, 8, 13, 2, 3)
            sorter.sort(array)
            println(array.contentToString())
        }
    }
}