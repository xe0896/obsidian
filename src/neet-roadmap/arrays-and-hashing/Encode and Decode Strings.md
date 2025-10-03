Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.
***
This question was a bit strange at first but is simple once you realise a clever trick we can do. The main problem here is that if we had an array of strings, then we need some type of method that could be used to break it down to the input. 

We couldn't use something like `.split` to make a border for each string in the array and then do `.join` to remove the border and get our array of strings back as the string themselves could have a substring that is equal to the border. 

Instead, we can use the lengths of the strings to our advantage as we already know it from our `encode` function and give this information to our `decode` function allowing us to `decode` easily. 

But another problem arises with this method which is that if we had a number inside our string in `decode` then it could be confused as the length of this part of the string, this means that we need to hardcode a character alongside with the length so that we know that this length is part of our `encode` and not the actual string.

The reason why this works is because the first occurrence of this character that we will hardcode will always be first, since we have that guarantee then we can use this to grab the length of this part of the string and re-create the string by using a pointer `j` that would be traversing our string in `decode` and stop until we reach the end of our length we got from `encode`. 

Since we need our length to be relative to a pointer, we can make this relative to `i` which would be our main pointer meaning we would need to stop until `i + length + 1`. 

This may seem a bit hard to understand but in code it should be more clear, so lets start with the easy bit, the `encode` function: all we need to do is just grab each string of the given array and append a hardcoded character, such as `#` and its length alongside with it which would be representing this current string, we will store these two values at the start of each element so that we can iterate from the start:
```js
encode(strs) {
	output = "";
	for(let i = 0; i < strs.length; i++) {
		output = output + strs[i].length.toString().concat("#") + strs[i];
	}
	return output;
}
```

We should talk about why it is important to store these values at the start so that we can iterate from the start, the reason for this is because when we start our `decode`, we will be starting at the start of the given string, meaning if we have added our two hardcoded values at the start then we will receive this information instantly, and then once we adjust our pointers such that length is used from `encode` to jump to the next string, we can then now start again but with another set of values from `encode` for the next string and keep on going, this creates a chain that we can keep on relying on to create our array back.

Another problem, when storing our length for each string in our array, we may have a length that is two digits like `12` meaning we can't just rely on a specific index to hold our value, but rather all indexes after our for loop of our last element until we reach `#`, this would ensure that we are collecting all valid lengths. This could be hard to wrap your head around so one way to think of this is: if we could only traverse going forward in our array then how do we ensure we collect the correct lengths, it should be more clear once you understand the importance of our `#`.

We can use the `isNaN(Number(strs[i]))` trick to see if our current element is a number or not and would stop at `#` and then using our length which we can label with `num`:
```js
while(i < str.length) {
    let strNum = "";
    while(!isNaN(Number(str[i]))) {
	    strNum = strNum.concat(str[i]);
        i++;
    }
```

Now, we can iterate using a new pointer `j` which would be used to point to the actual string characters and append this to a valid string called `validStr` which in the end would be appended to our answer array `arr`. The for loop body of collecting our string characters could be confusing so lets break this down:
```js
for(j = i + 1; j < i + num + 1; j++)
```
When we was collecting the lengths, we had to eventually violate our `while` loop meaning our `i` is not pointing to a number representing our length, but our hardcoded `#` and since we want to collect our string characters starting at the first string character then we do not want `#` but whatever is beyond `#`, so we do `j = i + 1`. The condition for this for loop is when the character ends and since we are relative to `i`, we need to do `i + num` which would point to the last element and since we still want to process the last element we do `+1` which should point to the length of the next element, allowing us to do this cycle over and over since we started with us starting with the length. 

We also need to ensure we update our `i` pointer to our `j` pointer and some other trivial stuff:
```js
decode(str) {
    let arr = [];
    let i = 0;
    while(i < str.length) {
        let strNum = "";
        while(!isNaN(Number(str[i]))) {
            strNum = strNum.concat(str[i]);
            i++;
        }
        let num = Number(strNum);
        let validStr = "";
        let j;
        for(j = i + 1; j < i + num + 1; j++) {
            validStr = validStr + str[j];
        }
        arr.push(validStr);
        i = j;
    }
   return arr;
}
```





