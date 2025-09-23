Given an integer array `nums` and an integer `k`, return the `k` most frequent elements within the array.

The test cases are generated such that the answer is always **unique**.

You may return the output in **any order**.
***
This problem was very fun to do and also very challenging due to my lack of JavaScript skills, for my implementation and intuition, it required some features that JavaScript offers such as `Array.from` and `...`  which is rarely used by me.

Logic boils down to this, we will create a `Map` which will count the frequency of value of `nums` and store it as a `Key, Value` pair where `Key` is the value in `nums` and `Value` is the frequency, this is can be simply done using `.set`, `.get,` and `.has` functions offered by `Map`:
```js
topKFrequent(nums, k) {
	const map = new Map();
	
	for(let i = 0; i < nums.length; i++) {
		if(map.has(nums[i])) {
			map.set(nums[i], map.get(nums[i]) + 1);
		} else {
			map.set(nums[i], 1);
		}
	}
}
```
Now that we have our `Map` we must now want the top `k` frequencies in our `Map`, and to do this we will be using bucket sort. The reason why we will be using bucket sort is because we are working with frequencies here, and we already have that information from our `Map`.

We now have to create our `buckets` array which will be storing each element of our array but will have its index based on its frequency, we will also have to make sure we make every element an array as we can have two elements that have the same frequency. To make an array of this nature we will be using `Array.from` which will have a length of `n+1` as if we had an array of one number repeated `n` times then it would have a frequency of `n` meaning `buckets[n]` would be undefined if we set it to the naive answer of `n`. 

`Array.from` can also make every element as an array to mitigate our two elements having the same frequency problem, to do this we can pass an arrow function that defines each element to be an **distinct** empty array `[]`
```js
const buckets = Array.from({length: n + 1}, () => []);
```

To populate our `buckets` array we should not iterate over `nums` as we will get repeated values as if the number `2` occurred three times in the array then we will get `[2,2,2]` with a frequency index of `3` when it should be just `[2]` with a frequency index of `3`.
```js
for(const [num, freq] of map) {
	buckets[freq].push(num);
}
```

Now, all that is left is to iterate our `buckets` array backwards and stop until `i >= 0` meaning there is no elements to iterate over or if `topK.length < k` where `topK` would be storing our top `k` frequent elements:
```js
for(let i = nums.length; i >= 0 && topK.length < k; i--) {
	topK.push(...buckets[i]);
}
```
The reason for the `...buckets[i]` is because we do not want to just do `buckets[i]` as that will make `topK` store arrays for some cases where we have two elements have the same frequency, by using `...` we will spread out the array to act as if it were individual elements being pushed into the array.

Final thingy:
```js
class Solution {
  /**
   * @param {number[]} nums
   * @param {number} k
   * @return {number[]}
   */
  topKFrequent(nums, k) {
    const map = new Map();
    for (let i = 0; i < nums.length; i++) {
      if (map.has(nums[i])) {
        map.set(nums[i], map.get(nums[i]) + 1);
      } else {
        map.set(nums[i], 1);
      }
    }

    const bucket = Array.from({ length: nums.length + 1 }, () => []);
    for (const [num, freq] of map) {
      bucket[freq].push(num);
    }

    const topK = [];
    for (let i = nums.length; i >= 0 && topK.length < k; i--) {
      if (bucket[i].length) {
        topK.push(...bucket[i]);
      }
    }
    return topK;
  }
}
```
