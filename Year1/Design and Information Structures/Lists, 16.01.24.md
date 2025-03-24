
**Cost of list manipulation**

The functions $get(i)$ and $set(i,e)$ are easy to implement as we just need to access $A[i]$, meaning it is $O(1)$

The function $add(i,e)$ will mean we have to make room for $e$, the worst case scenario will be when $i = 0$ which causes us to shift the whole list to the right and if the elements in the list is $n$, then the worst case scenario is $O(n)$

The function $remove(i)$ behaves similar to $add(i,e)$ but we must shift to the left and assuming that $i= 0$, then the worst case scenario is $O(n)$ 

**Space performance question**

Given a list $L$ of size $N$ elements with $n$ elements, we can say that the space required by $L$ is $\Theta (N)$ as an array will store a fixed number of items meaning $N$ will not vary and since the Big Theta notation is for when the scenario is constant then we use Big Theta as $N$ is fixed. 

We do not consider $n$ as that will refer to time rather then space 

**Reminders**

On $n$ push operations in an array, if we replace the array $k$ by doing $k = \frac{n}{c}$ then since $c$ is a constant then we can conclude that $k = O(n)$ 

**Comparing two strategies**

Let's say we want to create a dynamic array which means that if we do an $add$ operation on a full array we will replace the array with a new larger one. There are two methods for this:

1) Incremental strategy: increase the size by constant $c$
2) Doubling strategy: double the size

We can create a function $T(n)$ which denotes the total time required to perform a series of $n$ push operations. 

Let's assume we have an empty list represented by a growable array of size $1$. 

We call amortized time of a push operation the average time taken by a push operation over the series of operations, i.e: $\frac{T(n)}{n}$.

Using our reminder section above we see that $k = O(n)$, we will use this later.

Let's start with the array of size $1$ and we add a constant $c$ to increase the size of the array by $c$ by making a new array with size $c + 1$. 

![[Pasted image 20240117162901.png]]

The diagram above is wrong, imagine the line went like: $1 \rightarrow c + 1 \rightarrow 2c + 1 ... n$ 

We can see that the total time $T(n)$ of a series of $n$ push instructions is proportional to:

$n + c + 2c + 3c + 4c + ... + kc =$ 
$n + c(1 + 2 + 3 + 4 + ... k) =$ 
$n + \frac{ck(k+1)}{2}$ 

Since $c$ is a constant, $T(n)$ is $O(n + k^{2})$ meaning $O(n^{2}$), we then can calculate the amortized time which is $O(n)$ 

For the doubling strategy we can infer that we replace the array $k = log_{2}(n)$ times:

![[Pasted image 20240117164301.png]]

The total time $T(n)$ of a series of $n$ push operations is proportional to:

$n + 1 + 2 + 4 + 8 ... + 2^{k} =$ 
$n + 2^{k+1} - 1 =$ 
$n + 2(2^{log_{2}(n)}) - 1$ 
$3n - 1$ 

$T(n) = O(n)$ 
The amortized time is $O(1)$, meaning the doubling strategy is better 