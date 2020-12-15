package com.williamfiset.algorithms.sorting

import kotlin.jvm.JvmStatic


class FunctionalQuickSort : InplaceSort {
    override fun sort(values: IntArray) {
        var newArray = quickSort(values)
        for (i in 0 .. values.size){
            values[i] = newArray[i]
        }
    }

    companion object {
        private fun quickSort(ar: IntArray): IntArray {
            if (ar == null) {
                return ar}

            else if (ar.size < 2){
                return ar
            }

            else{
               val pivot = ar[0]
                val (smaller, greater) = ar.partition { it <= pivot}
                return quickSort(smaller.toIntArray()) + pivot + quickSort(greater.toIntArray())
            }

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


