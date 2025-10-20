You are given an array of non-overlapping intervals intervals where intervals`[i] = [start_i, end_i]` represents the start and the end time of the `i`th interval. intervals is initially sorted in ascending order by `start_i`.

You are given another interval `newInterval = [start, end].`

Insert `newInterval` into intervals such that intervals is still sorted in ascending order by `start_i` and also intervals still does not have any overlapping intervals. You may merge the overlapping intervals if needed.

Return intervals after adding `newInterval`.

Note: Intervals are non-overlapping if they have no common point. For example, `[1,2]` and `[3,4]` are non-overlapping, but `[1,2]` and `[2,3]` are overlapping.
***
This question is pretty difficult since we will need realise that we need to sort the given array by making the intervals sort by start time, the reason for this is because if we scan our sorted array and have two intervals that have no overlap then we can be sure that the intervals ahead will also have no overlap, allowing us to work with another merged interval.

We will maintain an array `merged` which will be our result array, if we find the head of the array `merged` does not overlap with a given interval `intervals[i]` (sorted) then we will push this interval into our `merged` array, meaning the next iteration will be working with this recently pushed interval to look for more merged intervals as there is no more for the previous interval. 

Given two intervals, where one of them is the head of the `merged` array and the other is the current interval at `intervals[i]`, if we assign the `latest` interval as `merged[merged.length - 1]` and the `current` interval as `interval[i]` the method to find if they overlap is to check if `current1[0] <= latest[1]`. This is essentially saying that if the `latest` interval ends after the starting interval of `current` then they will overlap. If this is true then we need to change the `latest[1]` value because it could grow as the new interval it merged with could end later then the current end interval for `latest` and we want the maximum as we need to see as a merged interval end time will depend on the maximum of the two end times of the original intervals, we can represent this by doing `latest[1] = Math.max(latest[1], current[1])`

If they do not overlap, then we need to push this `current` interval into our `merged` array as we have a new interval that can be checked against:

```js

interval(intervals, newInterval) {
	intervals.push(newInterval);
	intervals = intervals.sort((a,b) => a[0] - b[0]);
	merged = [intervals[0]]l
	for(let i = 1; i < intervals.length; i++) {
		const current = intervals[0];
		const latest = merged[merged.length - 1];
		if(current[0] <= latest[1]) {[
			latest[1] = Math.max(latest[1], current[1]);	
		} else {
			merged.push(current);
		}
	}
	
	return merged;
}
```

We initially make `merged` store the first element of `intervals` that has been sorted so we have something to compare with and this is the starting interval anyway.