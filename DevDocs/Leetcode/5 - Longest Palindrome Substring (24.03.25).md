Given a string `s`, return _the longest_ _palindromic_ _substring_ in `s`.
***
Initially I thought a sliding window could of been done here, but after some thinking it won't be effective as the condition for the sliding window is if a string `s` is a palindrome which is expensive to check for every substring encountered by the window.

Instead (after looking at some hints), a better solution would be to start with a `char` in the given string and use that as the center and we grow this to a string to make it become a potential palindrome if the two outer `char` values are the same.

