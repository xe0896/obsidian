Given two strings `ransomNote` and `magazine`, return `true` _if_ `ransomNote` _can be constructed by using the letters from_ `magazine` _and_ `false` _otherwise_.

Each letter in `magazine` can only be used once in `ransomNote`.
***
This question can be answered using a hash map by first iterating over the `ransomNote` and storing the frequency of the characters that occur in it and then iterating over `magazine` and using the hash map as a supply depending on the demand from the `magazine`, then lastly checking to see the hash map has any characters left, if it does then we return `false`, else `true`. 

Since we need to make the hash map act as a sort of frequency table then we cannot assume the existence of a key when given a character, so we can use `map.getOrDefault(key , 0)` which will return `0` if `key` doesn't exist, which will make it easier when building up our hash map from `ransomNote` and also iterating over the hash map when checking it against `magazine`. 

When iterating over the hash map at the end to check to see if there are any extra characters, we cannot index it like a normal array using an iterator `i=0`, so we can use `values()` and assign it to a variable `val` and check if `val > 0`:
```java
public boolean canConstruct(String ransomNote, String magazine) {
	Map<Character, Integer> map = new HashMap<>();
	for(int i = 0; i < ransomNote.length(); i++) {
		map.put(ransomNote.charAt(i), map.getOrDefault(ransomNote.charAt(i), 0) + 1);)
	}
	for(int i = 0; i < magazine.length(); i++) {
		int val = map.getOrDefault(magazine.charAt(i), 0);
		if(val != 0) {
			map.put(magazine.charAt(i), --val);
		}
	}
	for(int val : map.values()) {
		if(val > 0) {
			return false;
		}
	}
	return true;
}
```