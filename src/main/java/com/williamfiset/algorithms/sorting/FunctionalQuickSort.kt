package com.williamfiset.algorithms.sorting

import kotlin.jvm.JvmStatic

class KotlinQuickSort : InplaceSort {
    override fun sort(values: IntArray) {
        quickSort(values)
    }

    companion object {
        private fun quickSort(ar: IntArray?, low: Int, high: Int) {


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