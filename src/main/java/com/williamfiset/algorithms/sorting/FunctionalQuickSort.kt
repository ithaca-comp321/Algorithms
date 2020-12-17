package com.williamfiset.algorithms.sorting


class FunctionalQuickSort : InplaceSort {
    override fun sort(values: IntArray) {
        val sortedValues = quickSort(values)
        System.arraycopy(sortedValues, 0, values, 0, values.size)
    }

    companion object {
        private fun quickSort(ar: IntArray): IntArray {
            return if (ar.size < 2) {
                ar
            } else {
                val pivot = ar[0]
                val (smaller, greater) = ar.partition { it <= pivot }
                quickSort(smaller.toIntArray()) + pivot + quickSort(greater.toIntArray())
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


