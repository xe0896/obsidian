You are given an array of non-negative integers height which represent an elevation map. Each value height[i] represents the height of a bar, which has a width of 1.

Return the maximum area of water that can be trapped between the bars:
![[Pasted image 20250928160842.png]]
***
This question was pretty difficult but rewarding, there are two efficient `O(n)` solutions but one of them has a space complexity of `O(1)` which will be explained at the end, we will start with explaining with the `O(n)` space complexity one.

Both solutions rely on a certain formula that we can use to calculate the amount of trapped area at a given index `i`, we can see that in order to trap some water, it will need two boundaries which we can denote `L` for the left boundary and `R` for the right boundary. 

We can also see that `height[i]` will affect the amount of water we can trap as if it was high but not as high as the two boundaries, it will decrease the amount of water trapped meaning we must consider `height[i]` into our formula somehow. 

If we look at our boundaries, we can see that the water stops at the lowest boundary which we can denote as `min(L,R)`, this means that since we can find the height of the water and since we also need to consider the boundary that is not as high as the boundaries but decreasing the water trapped `height[i]`, we can calculate the water trapped at `i` as `min(L,R) - height[i]`. 

These pointers we created `L,R` must also represent maximum boundaries relative to `i` that are left `L` and right `R`, this means that we need to also figure out what are the maximum boundaries relative to `i`. 

This is where the two solutions change and how one solution can use constant space, but lets focus on the `O(n)` space complexity which would obviously include an array. 

Given that we want to find the maximum boundaries relative to`i`, we can create two arrays `MaxLeft` and `MaxRight` which can both iterate the given array and populate these arrays, lets start with `MaxLeft` which is just the reverse of `MaxRight`.

Before we populate, we must initialise our array and since we want our index `i` to be aligned with our `height` array, instead of using `.push` and populating like that, we will just initialise the `MaxLeft` array with length `height.length` and then assign our values by doing `MaxLeft[i] = ...` in the loop.

```js
trap(height) {
	const Max_Left = Array.from({ length: height });
}
```

When thinking about populating this array, the previous calculation can be used to determine the current calculation as if the previous maximum `L` boundary is greater then our current potential maximum `L` boundary, we can assign it to `MaxLeft[i]` as there will be trapped water at this index. Given that we are using previous indexes and starting at the start of the array, we should define `MaxLeft[0]` to make sure `MaxLeft[i-1]` is not out of bounds and ensuring we start our loop at `i=1`:

```js
MaxLeft[0] = height[0];
for(let i = 1; i < height.length; i++) {
	MaxLeft[i] = Math.max(MaxLeft[i-1], height[i]);
}
```

We also need to do the reverse for `MaxRight`:
```js
MaxRight[height.length - 1] = height[height.length - 1];
for(let i = height.length - 2; i >= 0; i--) {
	MaxRight[i] = Math.max(MaxRight[i+1], height[i]);
}
```
Note that we are going right to left in this loop so we must look at the `i+1` boundary.

Now that we have our arrays, we can simply use the formula we earlier constructed: `min(maxLeft[i], maxRight[i]) - height[i]` to find the trapped water, and accumulate this in a `sum` variable:

```js
let sum = 0;
for(let i = 0; i < height.length; i++) {
	sum += Math.min(MaxLeft[i], MaxRight[i]) - height[i];
}
```

Leading to the following `O(n)` space complexity answer, with some tweaks:
```js
trap(height) {
	let L = 0;
	let R = height.length - 1;
	const MaxRight = Array.from({ length: R + 1 });
	const MaxLeft = Array.from( {length: R + 1 });
	
	MaxLeft[0] = height[0];
	MaxRight[R] = height[R];
	
	for(let i = 1; i < R + 1; i++) {
		MaxLeft[i] = Math.max(MaxLeft[i-1], height[i]);
	}
	for(let i = R - 1; i >= 0; i--) {
		MaxRight[i] = Math.max(MaxRight[i+1], height[i]);
	}
	let sum = 0;
	for(let i = 0; i < R + 1; i++) {
		sum += Math.min(MaxRight[i], MaxLeft[i]) - height[i];
	}
	return sum;
}
```
### O(1) Space Complexity
The space complexity is much more subtle but not as clear, the main idea here is to move pointers `L` and `R` which start at each ends of our array and takes a greedy approach on comparing our values on our pointers and adjusting the pointer that has a smaller boundary, we can denote these actual values as `leftMax` and `rightMax`.

When we find that `leftMax < rightMax`, we can safely move `L` one up as it could have has some water we can calculate, or we could stumble across a new boundary which we must update `leftMax` and then calculate the area as `0` as if the current index `L` is a boundary then there is no water, this logic can be represented as:
```js
if(leftMax < rightMax) {
	L = L + 1;
	leftMax = Math.max(leftMax, height[L]);
	sum += leftMax - height[L];
}
```

We can see that if `L++` is a boundary then `leftMax = height[L]` which would do `sum+= height[L] - height[L]` which would be `0`. 

Doing the reverse for the `R` pointer is the exact same structure, just different indexing leading to the complete solution:
```js
trap(height) {
	let L = 0;
	let R = height.length - 1;
	let sum = 0;
	let leftMax = height[L];
	let rightMax = height[R];
	
	while(L < R) {
		if(leftMax < rightMax) {
			L = L + 1;
			leftMax = Math.max(leftMax, height[L]);
			sum += leftMax - height[L];
		} else {
			R = R - 1;
			rightMax = Math.max(rightMax, height[R]);
			sum += rightMax - height[R];
		}
	}
	
	return sum;
}
```

