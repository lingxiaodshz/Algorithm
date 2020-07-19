package leetcode

/*
912. 排序数组
给你一个整数数组 nums，请你将该数组升序排列。
示例 1：
输入：nums = [5,2,3,1]
输出：[1,2,3,5]
示例 2：
输入：nums = [5,1,1,2,0,0]
输出：[0,0,1,1,2,5]
提示：
1 <= nums.length <= 50000
-50000 <= nums[i] <= 50000
 */

fun sortArray(nums: IntArray): IntArray {
    return nums
}

fun selectSort(nums: IntArray) {
    var len = nums.size
    var index = 0
    for (i in 0 until len) {
        index = 0
        for (j in 0 until len - i) {
            if (nums[j] > nums[index]) {
                index = j
            }
        }
        swap(nums, index, len - i - 1)
    }
}

fun bubbleSort(nums: IntArray) {
    var len = nums.size
    for (i in 0 until len) {
        for (j in 0 until len - i - 1) {
            if (nums[j] > nums[j + 1]) {
                swap(nums, j, j + 1)
            }
        }
    }
}

fun shellSort(nums: IntArray) {
    var len = nums.size
    var gap = len / 2
    while (gap > 0) {
        for (i in 0 until len - gap step gap) {
            if (nums[i] > nums[i + gap]) {
                var index = i + gap
                while (index - gap >= 0 && nums[index] < nums[index - gap]) {
                    swap(nums, index, index - gap)
                    index -= gap
                }
            }
        }
        gap /= 2
    }
}

fun insert(nums: IntArray) {
    var len = nums.size
    var index: Int = 0
    for (i in 1 until len) {
        index = i
        while (index - 1 >= 0 && nums[index] <= nums[index - 1]) {
            swap(nums, index, index - 1)
        }
    }
}

fun fastSort(nums: IntArray, l: Int, r: Int) {
    if (l >= r) {
        return;
    }
    var left = l
    var right = r
    var temp = nums[l]
    while (left < right) {
        while (left < right && temp < nums[right]) {
            right--
        }
        if (left < right && temp >= nums[right]) {
            nums[left] = nums[right]
        }
        while (left < right && temp > nums[left]) {
            left++
        }
        if (left < right && temp <= nums[left]) {
            nums[right] = nums[left]
        }
    }
    nums[left] = temp
    fastSort(nums, l, left - 1)
    fastSort(nums, left + 1, r)
}

fun heapSort(nums: IntArray) {
    var len = nums.size
    for (i in len / 2 - 1 downTo 0) {
        buildHeap(nums, i, len)
    }
    for (i in len - 1 downTo 0) {
        swap(nums, 0, i)
        buildHeap(nums, 0, i)
    }
}

fun buildHeap(nums: IntArray, i: Int, len: Int) {
    var k = i
    var j = 2 * k + 1
    while (j < len) {
        if (j + 1 < len && nums[j + 1] > nums[j]) {
            j++
        }
        if (nums[k] > nums[j]) {
            swap(nums, k, j)
            k = j
        } else {
            break
        }
        j = 2*k+1
    }
}

fun swap(nums: IntArray, i: Int, j: Int) {
    var temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
}