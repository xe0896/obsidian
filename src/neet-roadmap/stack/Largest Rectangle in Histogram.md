You are given an array of integers heights where `heights[i]` represents the height of a bar. The width of each bar is `1`.

Return the area of the largest rectangle that can be formed among the bars.

Note: This chart is known as a histogram.
***
This question is very hard and the only way you can really get this right is if you know that it is a stack problem, to see why we need a stack is because an ideal input would be a monotonic `heights` array:

![[Pasted image 20251025131606.png]]

Given that we start at the highest element, if we was to calculate the maximum area from that perspective then it would just be the bar itself since there is no other bar ahead of it, hence why it is shaded. The other elements have at least one bar next to it that is higher then itself, this means that we must also the them as well when calculating the area from that bar's perspective, we will use the height of the current bar as that is guaranteed to be the lowest while also maximising the area. 

We will reduce the stack representing the diagram above automatically, while we try to calculate the max area using the main logic which doesn't have the property of having a monotonic stack.

Considering some possibilities will be useful for this problem as there are a finite amount of possibilities: 
![[Pasted image 20251025132631.png]]

The possibilities of A and C are fine since they are monotonic, however B is not fine since it is violating the monotonic principle, this means that we need to remove an element to make it monotonic, the problem is now, which one? The larger element is being bounded and since we want a monotonic stack, we can keep on removing elements that are larger then the smaller element until we satisfy the monotonic condition. While we are removing elements we should be updating our maximum area by using a global var `maxArea`, this will allow us to not lose any elements that could contribute to a maximum area later on.

When we calculate the area, we need to find out what is our width and length of our rectangle, the length is will be what element is currently being popped since it is greater then our current element that found the existence of this inconsistency meaning it will represent the maximum height for that area. The width is a bit confusing to understand: when we have a current element that will be `i` from a for-loop, we can find out the difference between `i` and the index of the top of the stack and do `-1`. The reason why this works is because we want to calculate the area from `i` and the index of the element that is violating the monotonic condition so since we want to remove it we should calculate the area, the `-1` is there because if we look at smaller examples we need `-1` due to 0-indexing. 

Calculating the width will require some careful thinking, since we want to find the index stored at the top of the stack, if that doesn't exist (since we recently popped) we should adjust the `left` bound of the width to be `-1`, this was found by looking at smaller examples and to make the logic work it needs to be `-1` if there is nothing in the stack.

After we found out that `current` is now greater/equal to the value at the top of our stack, then we are enforcing the monotonic condition so we can push this to our stack to compare for the next values.

The logic mentioned so far is:

```js
largestRectangleArea(heights) {
	const stack = [];
	let maxArea = 0;
	
	for(let i = 0; i < heights.length; i++) {
		const current = heights[i];
		while(stack.length && heights[stack[stack.length - 1]] > current) {
			let popped = stack.pop();
			let height = heights[popped];
			let left;
			if(stack.length) {
				left = stack[stack.length - 1];
			} else {
				left = -1;
			}
			let width = i - left - 1;
			maxArea = Math.max(maxArea, height * width);
		}
		stack.push(i);
	}
}
```

This implementation will work for `heights` that do not have any monotonic properties, which is rarely the case so we need to compute the areas using the left-over stack.

The first diagram will be what the array is now, and computing the maximum rectangle area for that is much easier since we can just start at the end of the stack and then create longer and longer rectangles whose heights are the current height in `heights` which are decreasing. 

One hard thing to see here is that the stack is storing indices at certain points of `heights`, as we could get something like `[1,4,6]` which are all indices in `heights`, but we are guaranteed to know that the length will begin from the current index from the stack to the end of the array, this is kinda hard to see a diagram can help:

![[Pasted image 20251025135444.png]]

The stack stores indices, it is important to remember this: when for `i = 6` the reason why this is in this stack is because every element above it was greater then it, this means that we can create a long rectangle from `6` to `heights.length`, this is true for `i = 4` and `i = 1`, we keep on updating `maxArea` incase it is the largest rectangle, which is likely:

```js
largestRectangleArea(heights) {
	const stack = [];
	let maxArea = 0;
	
	for(let i = 0; i < heights.length; i++) {
		const current = heights[i];
		while(stack.length && heights[stack[stack.length - 1]] > current) {
			let popped = stack.pop();
			let height = heights[popped];
			let left;
			if(stack.length) {
				left = stack[stack.length - 1];
			} else {
				left = -1;
			}
			let width = i - left - 1;
			maxArea = Math.max(maxArea, height * width);
		}
		stack.push(i);
	}
	
	while(stack.length) {
		let popped = stack.pop();
		let height = heights[popped];
		let left;
		
		if(stack.length) {
			left = stack[stack.length - 1];
		} else {
			left = -1;
		}
		let width = heights.length - left - 1;
		maxArea = Math.max(maxArea, height * width);
	}
	
	return maxArea;
}
```





