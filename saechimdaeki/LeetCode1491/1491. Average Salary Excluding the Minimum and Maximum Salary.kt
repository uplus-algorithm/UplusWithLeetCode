package LeetCode1491

class Solution {
    fun average(salary: IntArray): Double {
        return (salary.sum().toDouble()-(salary.max()!!.toDouble()+salary.min()!!.toDouble()))/(salary.size-2)
    }
}