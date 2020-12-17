package com.williamfiset.algorithms.sorting

import java.util.*

class KotlinFunctionalMergeSort : InplaceSort {
    override fun sort(values: IntArray) {
        val sortedValues = mergesort(Arrays.stream(values).spliterator())
        val i = intArrayOf(0)
        sortedValues.forEachRemaining { x: Int? -> values[i[0]++] = x!! }
    }

    companion object {
        fun mergesort(spl: Spliterator<Int?>): Spliterator<Int?> {
            if (spl.hasCharacteristics(Spliterator.SORTED)) return spl
            if (spl.estimateSize() <= 1) return spl
            val spliterator1 = spl.trySplit() //left half of spl

            // Split array into two parts and recursively sort them
            val left = mergesort(spliterator1)
            val right = mergesort(spl)

            // Combine the two arrays into one larger array
            return merge(left, right)
        }

        // Merge two sorted arrays into a larger sorted array
        private fun merge(left: Spliterator<Int?>, right: Spliterator<Int?>): Spliterator<Int?> {
            val intList = LinkedList<Int?>()
            var next: Int
            val nextLeft = arrayOfNulls<Int>(1)
            val nextRight = arrayOfNulls<Int>(1)
            var nextLeftNotNull = left.tryAdvance { x: Int? -> nextLeft[0] = x }
            var nextRightNotNull = right.tryAdvance { x: Int? -> nextRight[0] = x }
            while (nextLeftNotNull && nextRightNotNull) {
                if (nextLeft[0]!! < nextRight[0]!!) {
                    next = nextLeft[0]!!
                    nextLeftNotNull = left.tryAdvance { x: Int? -> nextLeft[0] = x }
                } else {
                    next = nextRight[0]!!
                    nextRightNotNull = right.tryAdvance { x: Int? -> nextRight[0] = x }
                }
                intList.add(next)
            }
            if (nextLeftNotNull) {
                intList.add(nextLeft[0])
                left.forEachRemaining { e: Int? -> intList.add(e) }
            } else {
                intList.add(nextRight[0])
                right.forEachRemaining { e: Int? -> intList.add(e) }
            }
            return intList.spliterator()
        }

        @JvmStatic
        fun main(args: Array<String>) {
            val list = listOf(6, 4, 7, 1, 2, 67, 5)
            val spliterator1 = list.spliterator()
            val sorted = mergesort(spliterator1)
            sorted.forEachRemaining { x: Int? -> println(x) }
        }
    }
}