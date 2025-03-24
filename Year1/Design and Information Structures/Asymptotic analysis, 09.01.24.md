
**How do we evaluate the running time of an algorithm?**

- The running time of the algorithm typically grows with the input size
- The average case time is often difficult to determine as it depends on the input

When evaluating the running time of an algorithm we focus on the worst-case running time as it is easier to analyze and crucial to applications such as games, finance and robotics

One approach can be done by taking experiments,

1) Write a program implementing the algorithm
2) Run the program with inputs of varying size and composition, not in the time needed
3) Plot the results

![[Pasted image 20240109121905.png]]

However this approach has limitations, for example it is necessary to implement the algorithm which may be difficult in same cases. In order to compare two algorithms the same hardware and software environments must be used to make a fair comparison on whether or not it is bad or not. 

Another approach can be done theoretically, this uses a high-level description of the algorithm without the implementation of the algorithm. This approach characterizes running time as a function of the input size, n. 

This allows us to evaluate the speed of an algorithm without considering the hardware/software environment. 

**How to calculate the running time of an algorithm?**

Given a problem and an algorithm for solving it:

- Denote the size $n$ to be the size of the input
- Compute $T(n)$ to be the number of basic/primitive operations performed by the algorithm
- The running time of the algorithm is equal to the complexity of $f(n)$

**Different notations**

'Big O' Notation: $O(n)$
'Big Omega' Notation: $\ohm(n)$
'Big Theta' Notation: $\theta(n)$

**How to perform asymptotic analysis?**

We find the worst-case number of primitive operations executed as a function of the input size and we express this function with 'Big O' notation.
 
Since constant factors and lower-order terms (low degree) are eventually dropped and we disregard them in primitive operations.

For example if an algorithm has a complexity of $n$ and another algorithm has a complexity of $n + 1$, both of these algorithm have the same complexity as we focus on the higher degree terms allowing us to drop the value $1$. 

We do this because if we assume $n$ is very large then the $+ 1$ from the second algorithm doesn't contribute the complexity as much, meaning we can drop $1$. 

**More on Big O Notation**

$O(g(n)) = \{f(n):$ there exists two constants $c > 0$ and $n_{0} \geq 0$, such that $f(n) \leq cg(n)$ for all $n \geq n_{0} \}$ 

In simple terms, $f(n)$ is bounded from above by $g(n)$

![[Pasted image 20240109124708.png]]

**Big Omega Notation**

$f(n) = \ohm(g(n)) \iff \exists c, n_{0} > 0, \forall n \geq n_{0}, 0 \leq cg(n) \leq f(n)$ 

In simple terms, $f(n)$ is bounded from below by $g(n)$

![[Pasted image 20240109124958.png]]

**Big Theta Notation**

$f(n) = \Theta(g(n)) \iff \exists c_{1} \land c_{2}, n_{0}..$ 

**An example of this**

Let $f(n) = 3n^{n} + 17$
Some lower bound functions: $1, n, nlog(n)$ 
Some upper bound functions: $n^{2}, n^{3}$ 
$n^{2}$ is an exact bound, e.g: 

**How to determine the growth of two functions**

Two functions $g(n)$ and $f(n)$, to calculate which one of these functions has the greatest growth we do:
$lim_{n \rightarrow \infty} \frac{f(n)}{g(n)}$

There are 4 possibilities:

Zero: which means that $f(n) = O(g(n))$ 
$c \neq 0:$ which means that $f(n) = \theta (g(n))$
$\infty:$ which means that $g(n) = O(f(n))$
The limit oscillates: no relation

Or we could compare the $log$ of $g(n)$ and $f(n)$.



