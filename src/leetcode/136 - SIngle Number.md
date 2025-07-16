Given a **non-empty** array of integers `nums`, every element appears _twice_ except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.
***
This question has a trivial solution which is simply just maintaining a set that stores the first occurrence of an integer and whenever we find the same integer again we remove this element from our set and repeat this process until we eventually have only one element which has no pair. This doesn't satisfy the question requirements as it states we should only use constant extra space, but we are maintaining a list of potential `n` elements at the worst case:
```java
public int singleNumber(int[] nums) {
	Set<Integer> set = new HashSet<>();
	for(int i = 0; i < nums.length; i++) {
		if(set.contains(nums[i])) {
			set.remove(nums[i]);
		} else {
			set.add(nums[i]);
		}
	}
	return set.iterator().next();
}
```
The reason why we have highlighted this solution is because the better solution that only requires constant space requires logic completely different to the normal approach. We use the property of XOR having `a XOR a = 0` and `a XOR 0 = a` which is also commutative and associative so the order doesn't matter, if we have a variable `result` which will be collecting `nums[i]` by using the XOR operation against `result`: `result = result ^ nums[i]`, we will keep on filtering out our pairs and leave our single number to be the stored in `result` as once we find a match the XOR operation returns `0` which then will eventually be reduced to the single number.
```java
public int singleNumber(int[] nums) {
	int result = 0;
	for(int i = 0; i < nums.length; i++) {
		result = result ^ nums[i];
	}
	return result;
}
```