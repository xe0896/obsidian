There are `n` cars traveling to the same destination on a one-lane highway.

You are given two arrays of integers `position` and `speed`, both of length `n`.

`position[i]` is the position of the `i`th car (in miles)
`speed[i]` is the speed of the `i`th car (in miles per hour)
The destination is at position `target` miles.

A car can not pass another car ahead of it. It can only catch up to another car and then drive at the same speed as the car ahead of it.

A car fleet is a non-empty set of cars driving at the same position and same speed. A single car is also considered a car fleet.

If a car catches up to a car fleet the moment the fleet reaches the destination, then the car is considered to be part of the fleet.

Return the number of different car fleets that will arrive at the destination.
***
This question is like all medium problems is trivial only if we understand a certain concept about the question, and that concept is using the `time = (target-position[i])/speed[i]` as we can use this to see if two cars will be conflicting with each other and create a car fleet.

The first thing we should do is sort the array in descending order to make the car closest to the `target` to be at the start, the reason we do this is because the first car fleet will be starting here as if it was a very slow car then it would cause the car behind it to conflict and create a car fleet which then would make the car behind that car to cause a conflict to make an even bigger car fleet and so on, to do this we can use `sort` and our function callback would be `b.pos - a.pos`.

To make our lives easier, we will merge our `position` and `speed` array into an array called `full` by creating an object at index `i` that represents `{position[i], speed[i]}` (arrays would be better as we could use `.map`).

```js
carFleet(target, position, speed) {
	const full = [];
	for(let i = 0; i < position.length; i++) {
		full.push({position[i], speed[i]});
	}
	full.sort((a,b) => b.pos - a.pos);
}
```

The data structure we could use to complete this is a stack, as the logic works like this: We will initially push the time `t` it takes for the car that is the closest to the `target` (`full[0]`) so that we can compare it with the rest as the logic will need a starting value to start. For the rest of the values, we will calculate `t` and compare it with the top of the stack and if the time stored at the top of the stack is `>=` to the latest `t` then that means they would merge as the current car is going faster than the one ahead of it so they would create a fleet so we can `continue` to skip this iteration as we want to stick with the value that is the start of this car fleet as that is dedicating the rest of the destination time `t`, if the latest `t` is larger than the time stored at the top of the stack then that means it will take to long to merge with the fleet ahead of it as they have reached their destination, this means that we have a new potential fleet and should push `t` to the stack to compare it with the cars at the lower positions and repeat this process, we can return `stack.length` as that would be storing the car fleet count.

```js
carFleet(target, position, speed) {
	const full = [];
	for(let i = 0; i < position.length; i++) {
		full.push({position[i], speed[i]});
	}
	full.sort((a,b) => b.pos - a.pos);
	const stack = [];
	full.push((target - pos[0])/spd[0]);
	for(let i = 1; i < full.length; i++) {
		const t = (target-pos[i])/spd[i];
		if(stack[stack.length - 1] >= t) {
			continue;
		} else {
			stack.push(t);
		}
	}
	
	return stack.length;
}
```




