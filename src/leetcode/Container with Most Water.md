You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.
***
This question embodies a greedy strategy, we will store a `max` variable which will store the current maximum and once we find that something is constraining us (a height) then we will change it to get a new height. As we want to cover all bases regarding the width of our container, we will use two pointers `L` and `R` which will be at each ends of the given array and change according to the values of the other pointer.

We will change the pointers if the other pointer is greater than the current one, this is greedy as we are minimising our constraints in hopes to find a better one, but as we do this we are constantly updating `max` depending on our two pointers.

The formula to calculate the area of the container depends on the minimum height as the maximum height is disregarded as the water wouldn't be able to overflow, and since we have two pointers `R` and `L` then the width is going to be `R - L`, meaning the formula is: `Math.min(height[L], height[R]) * (R - L)`:

```js
var maxArea = function(heights) {
	let max = 0;
	let L = 0;
	let R = heights.length - 1;
	for(let i = 0; i < heights.length; i++ ) {
		max = Math.max(max, (Math.min(heights[L], heights[R] * (R - L))));
		if(heights[L] < heights[R]) {
			L++; 
		} else {
			R--;
		}
	}
	
	return max;
}
```


